package Sermina.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Sermina.model.Employee;
import Sermina.model.TacGia;
import Sermina.service.TacGiaService;

@Controller
public class TacGiaController {
	
	@Autowired
	private TacGiaService tacgiaService;
	
	@RequestMapping(value="/listTacGia")
	public ModelAndView listTacGia(ModelAndView model)
	{
		tacgiaService.getAllTacGia();
		model.addObject("listTacGia", tacgiaService.getAllTacGia());
		model.setViewName("listTacGia");
		return model;
	}
	
	@RequestMapping(value="/listTacGiaJson", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TacGia>> listTacGiaJson()
	{
		List<TacGia> ls =tacgiaService.getAllTacGia();
		Collections.reverse(ls);
		
		return new ResponseEntity<List<TacGia>>(ls, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/newTacGia", method = RequestMethod.GET)
    public ModelAndView newTacGia(ModelAndView model) {
        TacGia tacgia = new TacGia();
        model.addObject("tacgia", tacgia);
        model.setViewName("TacGiaForm");
        return model;
    }
	
	@RequestMapping(value="/saveTacGia", method = RequestMethod.POST)
	public ModelAndView saveTacGia(@ModelAttribute TacGia tacgia)
	{
		if(tacgia.getId() == 0)
		{
			tacgiaService.addTacGia(tacgia);
		}
		else
		{
		tacgiaService.updateTacGia(tacgia);
		}
		
		return new ModelAndView("redirect:/listTacGia");
		
	}
	
	@RequestMapping(value="/editTacGia", method = RequestMethod.GET)
	public ModelAndView editTacGia(HttpServletRequest request  )
	{
		int TacGiaId = Integer.parseInt(request.getParameter("id"));
        TacGia tacgia = tacgiaService.getTacGia(TacGiaId);
        ModelAndView model = new ModelAndView("TacGiaForm");
        model.addObject("tacgia", tacgia);
 
        return model;
		
	}
	
	@RequestMapping(value="deleteTacGia", method = RequestMethod.GET)
	public ModelAndView deleteTacGia(HttpServletRequest request)
	{
		int TacGiaId = Integer.parseInt(request.getParameter("id"));
		
		tacgiaService.deleteTacGia(TacGiaId);
		
		return new ModelAndView("redirect:/listTacGia");
	}

}
