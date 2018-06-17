package Sermina.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Sermina.dao.NhaXuatBanJpa;
import Sermina.dao.SachDAOJpa;
import Sermina.dao.TonKhoDAO;
import Sermina.dto.*;
import Sermina.model.NhaXuatBan;
import Sermina.service.HoaDonXuatService;
import Sermina.service.TonKhoService;

@Controller
public class TonKhoController {
	
	@Autowired
	private HoaDonXuatService hdx;
	
	@Autowired
	private SachDAOJpa sachJpa;
	
	@Autowired
	private NhaXuatBanJpa nxbJps;
	
	@Autowired
	private TonKhoService tonkoService;
	
	@RequestMapping(value="/tonkho")
	public ModelAndView TonKho(ModelAndView model)
	{
		model.setViewName("ListTonKho");
		return model;
	}
	
	@RequestMapping(value="/tonkhoJson")
	@ResponseBody
	public ResponseEntity<List<SachTonKho>> SachTonKho()
	{
		List<GetSachForNewHDX> sachtonkhos = hdx.SachConTonKhoDeXuatNew();
		List<SachTonKho> result = new ArrayList<SachTonKho>();
		for (GetSachForNewHDX getSachForNewHDX : sachtonkhos) {
			
			SachTonKho sachtonkho = new SachTonKho();
			
			sachtonkho.setId(getSachForNewHDX.getIdSach());
			sachtonkho.setTenSach(getSachForNewHDX.getTenSach());
			sachtonkho.setSoLuong(getSachForNewHDX.getSoLuong());
			NhaXuatBan nxb = nxbJps.findOne(tonkoService.GetTenNhaXuatBanSach(getSachForNewHDX.getIdSach()));
			sachtonkho.setNhaXuatBan(nxb.getTenNhaXuatBan());
			
			result.add(sachtonkho);
			
		}
		
		return new ResponseEntity<List<SachTonKho>>(result,HttpStatus.OK);
	}
	

}
