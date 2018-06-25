package exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domaine.Memoire;
import service.MemoireService;

@RestController
@RequestMapping("/memoire")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MemoireWS {

	@Autowired
	private MemoireService memoireService;

	@GetMapping("/get")
	public Memoire afficherWS() {
		Memoire memoire = this.memoireService.afficherMemoire();
		return memoire;
	}

	@PostMapping("/post")
	public Boolean memoriserWS(@RequestBody Memoire memoire) {
		boolean memorise = this.memoireService.memoriser(memoire);
		Boolean memoriseO = Boolean.valueOf(memorise);
		return memoriseO;
	}
}
