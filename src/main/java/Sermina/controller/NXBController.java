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

import Sermina.model.NhaXuatBan;
import Sermina.service.NXBService;

@Controller
public class NXBController {
	
	@Autowired
    private NXBService nxbService;
	
	  @RequestMapping(value = "/vanhongha")
	  public String hi() {
	    return "hello";
	  }
	
    @RequestMapping(value = "/NXB")
    public ModelAndView listNXB(ModelAndView model) throws IOException {
        List<NhaXuatBan> listNXB = nxbService.getAllNXB();
        model.addObject("listNXB", listNXB);
        model.setViewName("NXBForm");
        return model;
    }    
    
    @RequestMapping(value="/listNXBJson", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NhaXuatBan>> listNXBJson()
    {
    	List<NhaXuatBan> listNXB = nxbService.getAllNXB();
    	Collections.reverse(listNXB);
    	return new ResponseEntity<List<NhaXuatBan>>(listNXB, HttpStatus.OK);
    }

    @RequestMapping(value = "/newNXB", method = RequestMethod.GET)
    public ModelAndView newNXB(ModelAndView model) {
        NhaXuatBan NXB = new NhaXuatBan();
        model.addObject("NXB", NXB);
        model.setViewName("ThemNXBForm");
        return model;
    }
 
    @RequestMapping(value = "/saveNXB", method = RequestMethod.POST)
    public ModelAndView saveNXB(@ModelAttribute NhaXuatBan NXB) {
        if (NXB.getId() == 0) { 
            nxbService.addNXB(NXB);
        } else {
        	nxbService.updateNXB(NXB);
        }
        return new ModelAndView("redirect:/NXB");
    }
    
    @RequestMapping(value = "/deleteNXB", method = RequestMethod.GET)
    public ModelAndView deleteNXB(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        nxbService.deleteNXB(ID);
        return new ModelAndView("redirect:/NXB");
    }
    

    @RequestMapping(value = "/editNXB", method = RequestMethod.GET)
    public ModelAndView editNXB(HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("id"));
        NhaXuatBan NXB = nxbService.getNXB(ID);
        ModelAndView model = new ModelAndView("ThemNXBForm");
        model.addObject("NXB", NXB);
        
        return model;
    }
}
