package Sermina.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
//
//    @RequestMapping(value = "/newTheLoai", method = RequestMethod.GET)
//    public ModelAndView newTheLoai(ModelAndView model) {
//        TheLoai theLoai = new TheLoai();
//        model.addObject("theLoai", theLoai);
//        model.setViewName("TheLoaiForm");
//        return model;
//    }
// 
//    @RequestMapping(value = "/saveTheLoai", method = RequestMethod.POST)
//    public ModelAndView saveEmployee(@ModelAttribute TheLoai theLoai) {
//        if (theLoai.getId() == 0) { 
//            theLoaiService.addTheLoai(theLoai);
//        } else {
//        	theLoaiService.updateTheLoai(theLoai);
//        }
//        return new ModelAndView("redirect:/");
//    }
//    
//    @RequestMapping(value = "/deleteTheLoai", method = RequestMethod.GET)
//    public ModelAndView deleteTheLoai(HttpServletRequest request) {
//        int ID = Integer.parseInt(request.getParameter("id"));
//        theLoaiService.deleteTheLoai(ID);
//        return new ModelAndView("redirect:/");
//    }
//    
//
//    @RequestMapping(value = "/editTheLoai", method = RequestMethod.GET)
//    public ModelAndView editTheLoai(HttpServletRequest request) {
//        int ID = Integer.parseInt(request.getParameter("id"));
//        TheLoai theLoai = theLoaiService.getTheLoai(ID);
//        ModelAndView model = new ModelAndView("EmployeeForm");
//        model.addObject("theLoai", theLoai);
// 
//        return model;
//    }
}
