package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.form.SessaoForm;

@Controller
public class SessaoController {
	@Autowired
	private FilmeDao filmeDao;
	@Autowired
	private SalaDao salaDao;
	
	@RequestMapping("admin/sessao")
	public ModelAndView form(@RequestParam("salaId") Integer salaId, SessaoForm form) {
		ModelAndView modelAndView = new ModelAndView("sessao/sessao");
		
		modelAndView.addObject("sala", salaDao.findOne(salaId));
		modelAndView.addObject("filmes", filmeDao.findAll());
		modelAndView.addObject("form", form);
		
		return modelAndView;
	}
}
