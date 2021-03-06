package exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domaine.CalculDomaine;
import service.CalculService;

@RestController
@RequestMapping("/calcul")
public class CalculWS {

	@Autowired
	private CalculService calculService;

	@PutMapping("/put")
	public CalculDomaine calculWS(CalculDomaine calculAller) {
		CalculDomaine calculRetour = this.calculService.choixOperateur(calculAller);
		return calculRetour;
	}

	@GetMapping("/get")
	public CalculDomaine testWS() {
		CalculDomaine calc = new CalculDomaine(1.0, 1, 2.0, 3.0, "3");
		return calc;
	}
}
