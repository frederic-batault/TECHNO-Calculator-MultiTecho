package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domaine.CalculDomaine;
import domaine.Memoire;
import service.CalculService;
import service.MemoireService;

@Controller
public class IndexController {

	@Autowired
	private CalculService calculservice;

	private CalculDomaine calculDomaine;

	private Memoire memoireDomaine;

	public CalculDomaine getCalculDomaine() {
		return calculDomaine;
	}

	public void setCalculDomaine(CalculDomaine calculDomaine) {
		this.calculDomaine = calculDomaine;
	}

	public Memoire getMemoireDomaine() {
		return memoireDomaine;
	}

	public void setMemoireDomaine(Memoire memoireDomaine) {
		this.memoireDomaine = memoireDomaine;
	}

	public IndexController(CalculService calculservice, MemoireService memoireservice, CalculDomaine calculDomaine,
			Memoire memoireDomaine) {
		super();
		this.calculservice = calculservice;
		this.calculDomaine = calculDomaine;
		this.memoireDomaine = memoireDomaine;
	}

	public IndexController() {
		super();
	}



	

	@PostMapping("/calculatrice")
	public ModelAndView calculer(@ModelAttribute CalculDomaine calculAller) {
		CalculDomaine calculRetour = this.calculservice.choixOperateur(calculAller);
		this.calculDomaine = calculRetour;
		ModelAndView mavCalc = new ModelAndView("calculatrice");
		mavCalc.addObject(calculRetour);
		return mavCalc;
	}

	
}
