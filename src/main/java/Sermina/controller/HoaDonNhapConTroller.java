package Sermina.controller;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.GenerationType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Sermina.dao.GetDataForFinHoaDonNhapSachForEdit;
import Sermina.dao.HoaDonNhapDAOJpa;
import Sermina.dao.HoaDonNhapSachDAOJpa;
import Sermina.dao.SachDAOJpa;
import Sermina.dto.GatDataSachOfNXB;
import Sermina.dto.GetDataForDataGridNewSach;
import Sermina.dto.GetInsertHoaDonNhap;
import Sermina.dto.GetInsertSach;
import Sermina.model.HoaDonNhap;
import Sermina.model.HoaDonNhap_Sach;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.service.NXBService;
import Sermina.service.SachService;

@Controller
public class HoaDonNhapConTroller {
	
	
	@Autowired
	private HoaDonNhapDAOJpa hdnResponsitory;
	@Autowired
	private HoaDonNhapSachDAOJpa hdnSResponsitory;
	
	@Autowired
	private SachDAOJpa sachResponsitory;
	
	
	
	@Autowired
	private NXBService nxbService;
	@Autowired
	private SachService sachService;
	
	@RequestMapping(value="/hoadonnhap/home")
	public String HomePage()
	{
		return "ListHoaDonNhap";
	}
	
	
	@RequestMapping(value="/listhoadonnhap", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HoaDonNhap>> listHoaDonNhap ()
	{
		List<HoaDonNhap> listHdn = (List<HoaDonNhap>)hdnResponsitory.findAll();
		
		Collections.reverse(listHdn);
		
		return new ResponseEntity<List<HoaDonNhap>>(listHdn, HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonnhap/newHoaDonNhap")
	public ModelAndView NewHoaDonNhap(ModelAndView model)
	{
		HoaDonNhap hdn = new HoaDonNhap();
		
		model.addObject("hoadonnhap",hdn);
		model.setViewName("formHoaDonNhap");
		return model;
	}
	
	@RequestMapping(value="/hoadonnhap/loadNhaXuatBan",method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<NhaXuatBan>> lodNhaXuatBan()
	{
		return new ResponseEntity<List<NhaXuatBan>>(nxbService.getAllNXB(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonnhap/loadSachOfNhaXuatBan", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<GatDataSachOfNXB>> loadSachOfNhaXuatBan(HttpServletRequest request) throws NoSuchFieldException, SecurityException
	{
		String name = request.getParameter("name");
		int nxb = sachService.FinNXBWithName(name).getId();
		
		List ls = sachService.findSachWothIdNXB(nxb);
		
		List<GatDataSachOfNXB> result = new ArrayList<GatDataSachOfNXB>();
		
		for(int i=0; i< ls.size();i++)
		{
			GatDataSachOfNXB datasachnxb = new GatDataSachOfNXB();
			Object[] k =	(Object[]) ls.get(i);
			String n = Arrays.toString(k);
			String sub = n.substring(1, n.length()-1);
			String[] lisSub= sub.split(",");
			datasachnxb.setId(Integer.parseInt(lisSub[0].trim()));
			datasachnxb.setTensach(lisSub[1].trim());
			datasachnxb.setGianhap(Long.parseLong(lisSub[2].trim()));
			datasachnxb.setTheloai(lisSub[3].trim());
			result.add(datasachnxb);
			@SuppressWarnings("unused")
			int m=0;
			
		}
		
		return new ResponseEntity<List<GatDataSachOfNXB>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonnhap/saveHoaDonNhap", method= RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Void> saveHoaDonNhap(@RequestBody GetInsertHoaDonNhap  myJsonString)
	{
		NhaXuatBan nxb = sachService.FinNXBWithName(myJsonString.getTenNhaXuatBan());
		HoaDonNhap hdn = new HoaDonNhap();
		hdn.setNgayNhap(new Date());
		hdn.setNhaxuatban(nxb);
		
		Long tongtien= new Long(0);
		
	 int lenght = myJsonString.getListResultObject().size();
	 List<HoaDonNhap_Sach> listHDNS = new ArrayList<HoaDonNhap_Sach>();
	 for(int i=0;i<lenght;i++)
	 {
		 Sach sach = sachResponsitory.findOne(myJsonString.getListResultObject().get(i).getIdSach());
		 tongtien += sach.getGiaNhap()*myJsonString.getListResultObject().get(i).getSolong();
	 
	 }
	 hdn.setTongTien(tongtien);
	 HoaDonNhap hdnsave = hdnResponsitory.save(hdn);
	 
	 
	 for(int i=0; i< lenght;i++)
	 {
		 HoaDonNhap_Sach hdn_sach = new HoaDonNhap_Sach();
		 hdn_sach.setSoLuong(myJsonString.getListResultObject().get(i).getSolong());
		 Sach sach = sachResponsitory.findOne(myJsonString.getListResultObject().get(i).getIdSach());
		 hdn_sach.setSach(sach);
		 hdn_sach.setHoadonnhap(hdnsave);
		 
		 hdnSResponsitory.save(hdn_sach);
	 }
	 
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/hoadonnhap/delete", method=RequestMethod.GET)
	public String deleteHoaDonNhap(HttpServletRequest request)
	{
		hdnResponsitory.delete(Integer.parseInt(request.getParameter("id")));
		
		return "ListHoaDonNhap";
		
	}
	
	
	@RequestMapping(value="/hoadonnhap/edit", method=RequestMethod.GET)
	public ModelAndView editHoaDonNhap(ModelAndView model, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDonNhap hdn = hdnResponsitory.findOne(id);
		model.addObject("hoadonnhap",hdn);
		model.setViewName("formHoaDonNhap");
		return model;
	}
	
	@RequestMapping(value="hoadonnhap/loadNhaXuatBanForEdit", method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> loadNhaXuatBanForEdit(HttpServletRequest request)
	{
		HoaDonNhap hdn = hdnResponsitory.findOne(Integer.parseInt(request.getParameter("id")));
		
		
		return new ResponseEntity<String>(hdn.getNhaxuatban().getTenNhaXuatBan(), HttpStatus.OK);
	}
	
	@RequestMapping(value="hoadonnhap/LoadHoaDonNhapSachForEdit", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<GetDataForFinHoaDonNhapSachForEdit>> LoadHoaDonNhapSachForEdit(HttpServletRequest request)
	{
		//day la truong hop lay id sach trong hoadonsach_id
		List<GetDataForFinHoaDonNhapSachForEdit> hoadonnhapsach = sachService.finHoaDonNhapSachForEdit(Integer.parseInt(request.getParameter("id")));
		return new  ResponseEntity<List<GetDataForFinHoaDonNhapSachForEdit>>(hoadonnhapsach,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/hoadonnhap/editHoaDonNhap", method=RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Void> editHoaDonNhap(@RequestBody GetInsertHoaDonNhap  myJsonString) {
		
		int idHdn = myJsonString.getIdHoaDonNhap();
		
		
		HoaDonNhap hdn = hdnResponsitory.findOne(idHdn);
		hdn.setNgayNhap(new Date());
		
		NhaXuatBan nxb = sachService.FinNXBWithName(myJsonString.getTenNhaXuatBan());
		
		hdn.setNhaxuatban(nxb);
		
		Long tongtien= new Long(0);
		
		 int lenght = myJsonString.getListResultObject().size();
		 List<HoaDonNhap_Sach> listHDNS = new ArrayList<HoaDonNhap_Sach>();
		 for(int i=0;i<lenght;i++)
		 {
			 Sach sach = sachResponsitory.findOne(myJsonString.getListResultObject().get(i).getIdSach());
			 tongtien += sach.getGiaNhap()*myJsonString.getListResultObject().get(i).getSolong();
		 
		 }
		 hdn.setTongTien(tongtien);
		 hdnResponsitory.save(hdn);
		 
		 sachService.DeleteHoaDonNhapSachWithIdHDn(idHdn);
		 
		 for(int i=0; i< lenght;i++)
		 {
			 HoaDonNhap_Sach hdn_sach = new HoaDonNhap_Sach();
			 hdn_sach.setSoLuong(myJsonString.getListResultObject().get(i).getSolong());
			 Sach sach = sachResponsitory.findOne(myJsonString.getListResultObject().get(i).getIdSach());
			 hdn_sach.setSach(sach);
			 hdn_sach.setHoadonnhap(hdn);
			 
			 hdnSResponsitory.save(hdn_sach);
		 }
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
	
	
	

}
