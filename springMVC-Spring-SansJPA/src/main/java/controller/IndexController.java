package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domaine.CalculDomaine;
import domaine.Memoire;
import domaine.Message;
import service.CalculService;
import service.MemoireService;

@Controller
public class IndexController {

	@Autowired
	private CalculService calculService;

	@Autowired
	private MemoireService memoireService;
	
	private CalculDomaine calculDomaine;

	private Memoire memoireDomaine;
	
	private Message messageMem;

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

	public CalculService getCalculService() {
		return calculService;
	}

	public void setCalculservice(CalculService calculService) {
		this.calculService = calculService;
	}

	public Message getMessageMem() {
		return messageMem;
	}

	public void setMessageMem(Message messageMem) {
		this.messageMem = messageMem;
	}



	public IndexController(CalculDomaine calculDomaine, Memoire memoireDomaine,	Message messageMem) {
		super();
		this.calculDomaine = calculDomaine;
		this.memoireDomaine = memoireDomaine;
		this.messageMem = messageMem;
	}

	public IndexController() {
		super();
	}

	@RequestMapping(path = "/calculatrice", method = RequestMethod.GET)
	public ModelAndView start() {
		this.messageMem = new Message("Bienvenue");
		this.calculDomaine = new CalculDomaine(0,1,0,0,"0");
		ModelAndView mavStart = new ModelAndView("calculatrice");
		mavStart.addObject(this.messageMem);
		mavStart.addObject(this.calculDomaine);
		return mavStart;
	}

	

	@PostMapping("/calc")
	public ModelAndView calculer(@RequestParam double nombre1, @RequestParam int operateur, @RequestParam double nombre2) {
		CalculDomaine calculIn = new CalculDomaine(nombre1,operateur,nombre2,0,"0");
		this.calculDomaine = calculIn;
		CalculDomaine calculRetour = this.calculService.choixOperateur(calculIn);
		this.calculDomaine = calculRetour;
		ModelAndView mavCalc = new ModelAndView("calculatrice");
		mavCalc.addObject(calculRetour);
		return mavCalc;
	}
	
	
	
	@PostMapping("/mem")
	public ModelAndView memoriser() {
		this.memoireDomaine = new Memoire(this.calculDomaine.getResultat(),this.calculDomaine.getResultatTexte());
		this.memoireService.memoriser(this.memoireDomaine);
		this.messageMem.setMessage("memorise : "+this.memoireDomaine.getMemoireTexte());
		ModelAndView mavMem = new ModelAndView("calculatrice");
		mavMem.addObject(this.messageMem);
		mavMem.addObject(this.memoireDomaine);
		return mavMem;
	}
	
	

	@GetMapping("/aff")
	public ModelAndView afficher() {
		this.memoireDomaine = this.memoireService.afficherMemoire();
		this.messageMem.setMessage("recupere : "+this.memoireDomaine.getMemoireTexte());
		ModelAndView mavAff = new ModelAndView("calculatrice");
		mavAff.addObject(this.messageMem);
		mavAff.addObject(this.memoireDomaine);
		return mavAff;
	}
}
