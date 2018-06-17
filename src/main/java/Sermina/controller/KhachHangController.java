package Sermina.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Sermina.model.KhachHang;
import Sermina.service.KhachHangService;

@Controller
public class KhachHangController {

	
	@Autowired
    private KhachHangService khachHangService;
 
    @RequestMapping(value = "/KhachHang")
    public ModelAndView listKhachHang(ModelAndView model) throws IOException {
        List<KhachHang> listKhachHang = khachHangService.getAllKhachHang();
        model.addObject("listKhachHang", listKhachHang);
        model.setViewName("KhachHangForm");
        return model;
    }
    
    
    @RequestMapping(value="/listKhachHangJson")
    @ResponseBody
    public ResponseEntity<List<KhachHang>> listKhachHangJson()
    {
    	 List<KhachHang> listKhachHang = khachHangService.getAllKhachHang();
    	 Collections.reverse(listKhachHang);
    	 
    	 return new ResponseEntity<List<KhachHang>>(listKhachHang, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/newKhachHang", method = RequestMethod.GET)
    public ModelAndView newKhachHang(ModelAndView model) {
        KhachHang KhachHang = new KhachHang();
        model.addObject("KhachHang", KhachHang);
        model.setViewName("ThemKhachHangForm");
        return model;
    }
 
    @RequestMapping(value = "/saveKhachHang", method = RequestMethod.POST)
    public ModelAndView saveKhachHang(@ModelAttribute KhachHang KhachHang) {
        if (KhachHang.getId() == 0) { // if KhachHang id is 0 then creating the
            // KhachHang other updating the KhachHang
        	khachHangService.addKhachHang(KhachHang);
        } else {
        	khachHangService.updateKhachHang(KhachHang);
        }
        return new ModelAndView("redirect:/KhachHang");
    }
 
    @RequestMapping(value = "/deleteKhachHang", method = RequestMethod.GET)
    public ModelAndView deleteKhachHang(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        khachHangService.deleteKhachHang(ID);
        return new ModelAndView("redirect:/KhachHang");
    }
 
    @RequestMapping(value = "/editKhachHang", method = RequestMethod.GET)
    public ModelAndView editKhachHang(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = khachHangService.getKhachHang(ID);
        ModelAndView model = new ModelAndView("ThemKhachHangForm");
        model.addObject("KhachHang", KhachHang);
 
        return model;
    }
    
    @RequestMapping(value = "/chitietKhachHang", method = RequestMethod.GET)
    public ModelAndView chitietKhachHang(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        KhachHang KhachHang = khachHangService.getKhachHang(ID);
        ModelAndView model = new ModelAndView("ChiTietKhachHang");
        model.addObject("KhachHang", KhachHang);
 
        return model;
    }

}
