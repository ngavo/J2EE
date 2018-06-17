package Sermina.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Sermina.dao.HoaDonNhapSachDAOJpa;
import Sermina.dao.HoaDonXuatDAOJpa;
import Sermina.dao.HoaDonXuatSachJpa;
import Sermina.dao.KhachHangDAOJpa;
import Sermina.dao.SachDAOJpa;
import Sermina.dto.GetHoaDonXuatChiTietDto;
import Sermina.dto.GetInsetHoaDonXuat;
import Sermina.dto.GetSachChoChiTietHoaDonXuat;
import Sermina.dto.GetSachForNewHDX;
import Sermina.dto.GetSachKhacHangDaMua;
import Sermina.model.HoaDonXuat;
import Sermina.model.HoaDonXuat_Sach;
import Sermina.model.KhachHang;
import Sermina.model.Sach;
import Sermina.service.HoaDonXuatService;
import Sermina.service.KhachHangService;

@Controller
public class HoaDonXuatController {
	
	
	@Autowired
	private HoaDonXuatDAOJpa hoadonxuatJpa;
	
	@Autowired
	private KhachHangDAOJpa khachhangJpa;
	
	@Autowired
	private HoaDonXuatService hdxService;
	
	@Autowired
	private KhachHangService khachhangService;
	
	@Autowired
	private SachDAOJpa sachjpa;
	
	@Autowired
	private HoaDonXuatSachJpa hdxSachJpa;
	
	@RequestMapping(value="/hoadonxuat/home", method=RequestMethod.GET)
	public String HomeHoaDonXuat()
	{
		return "ListHoaDonXuat";
	}
	
	@RequestMapping(value="/hoadonxuat/newhoadonxuat", method=RequestMethod.GET)
	public ModelAndView NewHoaDonXuat(ModelAndView model)
	{
		HoaDonXuat hdx = new HoaDonXuat();
		model.addObject("hoadonxuat", hdx);
		model.setViewName("formHoaDonXuat");
		return model;
		
	}
	
	@RequestMapping(value="/listhoadonxuat", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HoaDonXuat>> listHoaDonXuat()
	{
		List<HoaDonXuat> result = (List<HoaDonXuat>)hoadonxuatJpa.findAll();
		Collections.reverse(result);
		return new ResponseEntity<List<HoaDonXuat>>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/hoadonxuat/loadkhachhangnew", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<KhachHang>> loadkhachhangnew()
	{
		
		return new ResponseEntity<List<KhachHang>>((List<KhachHang>)khachhangJpa.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonxuat/loadsachfornew",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<GetSachForNewHDX>> LoadSachForNew()
	{
		return new ResponseEntity<List<GetSachForNewHDX>>(hdxService.SachConTonKhoDeXuatNew(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonxuat/insertSach",method= RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Void> InsertHoaDonXuat(@RequestBody GetInsetHoaDonXuat myJsonData )
	{
		KhachHang khachhang = khachhangService.findKhachHangWithName(myJsonData.getTenKhachHang());
		HoaDonXuat hdx = new HoaDonXuat();
		hdx.setNgayBan(new Date());
		hdx.setKhachhang(khachhang);
		
		Long tongtien= new Long(0);
		int lenght = myJsonData.getListSachInsetHdx().size();
		
		for(int i=0;i<lenght;i++)
		{
			tongtien+=myJsonData.getListSachInsetHdx().get(i).getGiaBan()*myJsonData.getListSachInsetHdx().get(i).getSoLuongXuat();
		}
		
		hdx.setTongTien(tongtien);
		
		HoaDonXuat hdxluu = hoadonxuatJpa.save(hdx);
		
		for(int i=0;i<lenght;i++)
		{
			HoaDonXuat_Sach hdxSach = new HoaDonXuat_Sach();
			hdxSach.setSoLuong(myJsonData.getListSachInsetHdx().get(i).getSoLuongXuat());
			hdxSach.setHoadonxuat(hdxluu);
			
			Sach sach = sachjpa.findOne(myJsonData.getListSachInsetHdx().get(i).getIdSach());
			
			hdxSach.setSach(sach);
			
			hdxSachJpa.save(hdxSach);
			
		}
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonxuat/editSach",method= RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Void> editHoaDonXuat(@RequestBody GetInsetHoaDonXuat myJsonData, HttpServletRequest request)
	{
		int idhdx = Integer.parseInt(request.getParameter("id"));
		KhachHang khachhang = khachhangService.findKhachHangWithName(myJsonData.getTenKhachHang());
		HoaDonXuat hdx = hoadonxuatJpa.findOne(idhdx);
		hdx.setNgayBan(new Date());
		hdx.setKhachhang(khachhang);
		
		Long tongtien= new Long(0);
		int lenght = myJsonData.getListSachInsetHdx().size();
		
		for(int i=0;i<lenght;i++)
		{
			tongtien+=myJsonData.getListSachInsetHdx().get(i).getGiaBan()*myJsonData.getListSachInsetHdx().get(i).getSoLuongXuat();
		}
		
		hdx.setTongTien(tongtien);
		
		HoaDonXuat hdxluu = hoadonxuatJpa.save(hdx);
		
		hdxService.DeleteHoaDonXuatSach(idhdx);
		
		for(int i=0;i<lenght;i++)
		{
			HoaDonXuat_Sach hdxSach = new HoaDonXuat_Sach();
			hdxSach.setSoLuong(myJsonData.getListSachInsetHdx().get(i).getSoLuongXuat());
			hdxSach.setHoadonxuat(hdxluu);
			
			Sach sach = sachjpa.findOne(myJsonData.getListSachInsetHdx().get(i).getIdSach());
			
			hdxSach.setSach(sach);
			
			hdxSachJpa.save(hdxSach);
			
		}
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/hoadonxuat/edit", method=RequestMethod.GET)
	public ModelAndView editHoaDonXuat(ModelAndView model,HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDonXuat hdx = hoadonxuatJpa.findOne(id);
		
		model.addObject("hoadonxuat", hdx);
		model.setViewName("formHoaDonXuat");
		return model;
	}
	
	@RequestMapping(value="/hoadonxuat/loadkhachhangedit", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> getKhachHangForEdit(HttpServletRequest request)
	{
		HoaDonXuat hdx = hoadonxuatJpa.findOne(Integer.parseInt(request.getParameter("id")));
		return new ResponseEntity<String>(hdx.getKhachhang().getHoTen(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonxuat/getsachkhachhangdamua", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<GetSachKhacHangDaMua>> getSachKhachHangDaMua(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return new ResponseEntity<List<GetSachKhacHangDaMua>>(hdxService.SachKhachHangDaMua(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/hoadonxuat/delete", method=RequestMethod.GET)
	public String deleteHoaDonXuat(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		hoadonxuatJpa.delete(id);
		return "ListHoaDonXuat";
	}
	
	
	@RequestMapping(value="/hoadonxuat/chitiet", method=RequestMethod.GET)
	public ModelAndView chitietHoaDonXuat(ModelAndView model,HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDonXuat hdx = hoadonxuatJpa.findOne(id);
		
		GetHoaDonXuatChiTietDto result = new GetHoaDonXuatChiTietDto();
		
		result.setTenKhachHang(hdx.getKhachhang().getHoTen());
		result.setNgayBan(hdx.getNgayBan());
		result.setTongTien(hdx.getTongTien());
		
		List<GetSachKhacHangDaMua> sachs = hdxService.SachKhachHangDaMua(id);
		
		List<GetSachChoChiTietHoaDonXuat> getSachChiTiet = new ArrayList<GetSachChoChiTietHoaDonXuat>();
		for (GetSachKhacHangDaMua getSachKhacHangDaMua : sachs) {
			Sach sc = sachjpa.findOne(getSachKhacHangDaMua.getIdSach());
			GetSachChoChiTietHoaDonXuat sct = new GetSachChoChiTietHoaDonXuat();
			sct.setTenSach(sc.getTenSach());
			sct.setSoLuong(getSachKhacHangDaMua.getSoLuong());
			getSachChiTiet.add(sct);
		}
		result.setGetSach(getSachChiTiet);
		model.addObject("hoadonxuat", result);
		
		model.setViewName("ChiTietHoaDonXuat");
		return model;
	}
	


}
