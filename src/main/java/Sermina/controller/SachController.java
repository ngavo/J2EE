package Sermina.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

import Sermina.dao.NhaXuatBanJpa;
import Sermina.dao.SachDAOJpa;
import Sermina.dao.TheLoaiJpa;
import Sermina.dto.GetChiTietSach;
import Sermina.dto.GetInsertSach;
import Sermina.dto.GetListSachDeGuiDuLieuJson;
import Sermina.dto.GetSachForHomeSach;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.model.TacGia;
import Sermina.model.TheLoai;
import Sermina.service.NXBService;
import Sermina.service.SachService;
import Sermina.service.TacGiaService;
import Sermina.service.TheLoaiService;
import Sermina.service.TonKhoService;

@Controller
public class SachController {
	
	@Autowired
	private SachService sachService;
	
	@Autowired
	private NXBService nxb;
	
	@Autowired
	private TacGiaService tgs;
	
	@Autowired
	private TheLoaiService tloaiService;
	
	@Autowired
	private TheLoaiJpa theloaiJpa;
	
	@Autowired
	private SachDAOJpa sjpa;
	
	@Autowired
	private NhaXuatBanJpa nxbJps;
	
	@Autowired
	private TonKhoService tonkoService;
	
	@RequestMapping(value="/listSach", method = RequestMethod.GET)
	public ModelAndView getListSach(ModelAndView model)
	{
		
		model.addObject("listSach", sachService.listSach());
		model.setViewName("listSach");
		return model;
		
	}
	
	@RequestMapping(value="/listSachm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<GetSachForHomeSach>> getListSachdatafgdjk()
	{
		List<GetSachForHomeSach> lstSachForHome = new ArrayList<GetSachForHomeSach>();
		
		
		return new ResponseEntity<List<GetSachForHomeSach>>(sachService.listSachHomeSach(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/listSach/dataOfSach", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	/*public ResponseEntity<List<GetListSachDeGuiDuLieuJson>> getListSachdata()
	{
		List<Sach> sachs = sachService.listSach();
		List<GetListSachDeGuiDuLieuJson> results = new ArrayList<GetListSachDeGuiDuLieuJson>();
		for (Sach sach : sachs) {
			
			GetListSachDeGuiDuLieuJson result = new GetListSachDeGuiDuLieuJson();
			result.setId(sach.getId());
			result.setTenSach(sach.getTenSach());
			result.setGiaNhap(sach.getGiaNhap());
			result.setGiaBan(sach.getGiaBan());
			results.add(result);
		}
		
		
		
		return new ResponseEntity<List<GetListSachDeGuiDuLieuJson>>(results, HttpStatus.OK);
	}*/
	public ResponseEntity<List<GetSachForHomeSach>> getListSachdata()
	{
		
		
		return new ResponseEntity<List<GetSachForHomeSach>>(sachService.listSachHomeSach(), HttpStatus.OK);
	}
	
	@RequestMapping(value="newSach", method = RequestMethod.GET)
	public ModelAndView newSach(ModelAndView model)
	{
		Sach sach = new Sach();
		model.addObject("sach",sach);
		model.setViewName("formSach");
		return model;
	}
	
	@RequestMapping(value="/listSach/NXB",produces = { MediaType.APPLICATION_JSON_VALUE},method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Set<NhaXuatBan>> getlistNXB()
	{
		Set<NhaXuatBan> nx = new HashSet<NhaXuatBan>(nxb.getAllNXB());
		return new ResponseEntity<Set<NhaXuatBan>>(nx, HttpStatus.OK);
	}
	
	@RequestMapping(value="/listSach/tacgia", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TacGia>> getListTacGia()
	{
		List<TacGia> tg = tgs.getAllTacGia();
		
		return new ResponseEntity<List<TacGia>>(tg,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/listSach/theloai", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TheLoai>> getListTheLoai()
	{
		List<TheLoai> listtloai =   tloaiService.getAllTheLoai();
		return new ResponseEntity<List<TheLoai>>(listtloai,HttpStatus.OK);
	}
	
	@RequestMapping(value="/listSach/insertSach", method= RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> InsertSach(@RequestBody GetInsertSach  myJsonString )
	{
		
		
		
		
		NhaXuatBan nxb = sachService.FinNXBWithName(myJsonString.getTenNhaXuatBan());
		
		TheLoai tl = sachService.FinTheLoaiWithName(myJsonString.getTheLoai());
		
		
		
		List<TacGia> ListTacGia = new ArrayList<TacGia>();
		List<Integer> listIdTacGia = myJsonString.getListIdTacGia();
		for (Integer idTG : listIdTacGia) {
			TacGia tg = tgs.getTacGia(idTG);
			ListTacGia.add(tg);
		}
		
		
		if(myJsonString.getIdSach()!=0)
		{
			int k = myJsonString.getIdSach();
			/*Sach s = sachService.findSach(myJsonString.getIdSach());*/
			Sach s = sjpa.findOne(myJsonString.getIdSach());
			s.setTenSach(myJsonString.getTenSach());
			s.setGiaNhap(myJsonString.getGiaNhap());
			s.setGiaBan(myJsonString.getGiaBan());
			s.setNhaxuatban(nxb);
			s.setTacgia(ListTacGia);
			s.setTheloai(tl);
			sachService.updateSach(s);
		}
		else
		{
			Sach s = new Sach();
			s.setTenSach(myJsonString.getTenSach());
			s.setGiaNhap(myJsonString.getGiaNhap());
			s.setGiaBan(myJsonString.getGiaBan());
			s.setNhaxuatban(nxb);
			s.setTacgia(ListTacGia);
			s.setTheloai(tl);
			sachService.InsertSach(s);
		}
		
		int k =23;
		int m = k;
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="deleteSach", method = RequestMethod.GET)
	public ModelAndView deleteSach(HttpServletRequest request)
	{
		int Id = Integer.parseInt(request.getParameter("id"));
		sachService.deleteSach(Id);
		return new ModelAndView("redirect:/listSach");
	}
	
	@RequestMapping(value="editSach", method = RequestMethod.GET)
	public ModelAndView editSach(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Sach sach = sachService.findSach(id);
		
		ModelAndView model = new ModelAndView("formSach");
		model.addObject("sach",sach);
		
		return model;
		
	}
	
	@RequestMapping(value="getDataNXBForEdit", method= RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getDataNXBForEdit(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Sach sach = sachService.findSach(id);
		
		String nameMXB = sach.getNhaxuatban().getTenNhaXuatBan();
		
		return new ResponseEntity<String>(nameMXB, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getDataTheLoaiForEdit", method= RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getDataTheLoaiForEdit(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Sach sach = sachService.findSach(id);
		
		String theloai = sach.getTheloai().getTenTheLoai();
		
		return new ResponseEntity<String>(theloai, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="getIdTacGiaForEdit", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Integer>> getIdTacGiaForEdit(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Sach sach = sachService.findSach(id);
		
		List<TacGia> tacgia = sach.getTacgia();
		List<Integer> idTacgia= new ArrayList<Integer>();
		for (TacGia tacGia2 : tacgia) {
			idTacgia.add(tacGia2.getId());
		}
		
		return new ResponseEntity<List<Integer>>(idTacgia, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/chiTietSach", method= RequestMethod.GET)
	@ResponseBody
	public ModelAndView  getTacGiaTest(ModelAndView model ,HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Sach sach = sachService.findSach(id);
		
		GetChiTietSach chitietsach = new GetChiTietSach();
		chitietsach.setId(sach.getId());
		chitietsach.setTenSach(sach.getTenSach());
		chitietsach.setGiaBan(sach.getGiaBan());
		chitietsach.setGiaNhap(sach.getGiaNhap());
		chitietsach.setTenTacGia(sach.getTacgia());
		NhaXuatBan nxb = nxbJps.findOne(tonkoService.GetTenNhaXuatBanSach(sach.getId()));
		chitietsach.setTenNhaXuatBan(nxb.getTenNhaXuatBan());
		TheLoai theloai = theloaiJpa.findOne(tonkoService.GetTenTheLoai(sach.getId()));
		chitietsach.setTenTheLoai(theloai.getTenTheLoai());
		
		model.addObject("getchitietsach", chitietsach);
		model.setViewName("ChiTietSach");
		
		
		return model;
	}

}
