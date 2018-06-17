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

import Sermina.model.TheLoai;
import Sermina.service.TheLoaiService;

@Controller
public class TheLoaiController {
	@Autowired
    private TheLoaiService theLoaiService;
	
    @RequestMapping(value = "/theLoai")
    public ModelAndView listTheLoai(ModelAndView model) throws IOException {
        List<TheLoai> listTheLoai = theLoaiService.getAllTheLoai();
        model.addObject("listTheLoai", listTheLoai);
        model.setViewName("theLoaiForm");
        return model;
    }   
    
    @RequestMapping(value="/theloaijson", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<TheLoai>> listTheLoaiJson()
    {
    	List<TheLoai> listTheLoai = theLoaiService.getAllTheLoai();
    	Collections.reverse(listTheLoai);
    	
    	return new ResponseEntity<List<TheLoai>>(listTheLoai, HttpStatus.OK);
    }

    @RequestMapping(value = "/newTheLoai", method = RequestMethod.GET)
    public ModelAndView newTheLoai(ModelAndView model) {
        TheLoai theLoai = new TheLoai();
        model.addObject("theLoai", theLoai);
        model.setViewName("ThemTheLoaiForm");
        return model;
    }
 
    @RequestMapping(value = "/saveTheLoai", method = RequestMethod.POST)
    public ModelAndView saveTheLoai(@ModelAttribute TheLoai theLoai) {
        if (theLoai.getId() == 0) { 
            theLoaiService.addTheLoai(theLoai);
        } else {
        	theLoaiService.updateTheLoai(theLoai);
        }
        return new ModelAndView("redirect:/theLoai");
    }
    
    @RequestMapping(value = "/deleteTheLoai", method = RequestMethod.GET)
    public ModelAndView deleteTheLoai(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        theLoaiService.deleteTheLoai(ID);
        return new ModelAndView("redirect:/theLoai");
    }
    

    @RequestMapping(value = "/editTheLoai", method = RequestMethod.GET)
    public ModelAndView editTheLoai(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        TheLoai theLoai = theLoaiService.getTheLoai(ID);
        ModelAndView model = new ModelAndView("ThemTheLoaiForm");
        model.addObject("theLoai", theLoai);
        
        return model;
    }
}
