package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import domaine.Memoire;
import repository.IMemoireRepository;

public class MemoireService {

	@Autowired
	IMemoireRepository memoireDao;

	// methode d'enregistrement sous les 2 types
	public boolean memoriser(Memoire refMemoire) {
		refMemoire.setId(1);
		Memoire memorise = this.memoireDao.save(refMemoire);
		if (memorise == null) {
			return false;
		} else {
			return true;
		}

	}

	// methode d'affichage
	public Memoire afficherMemoire() {
		Optional <Memoire> Opt = this.memoireDao.findById(1);
		Memoire refMemoire = Opt.get();
		double resultat1 = refMemoire.getMemoire();
		String resultatTexte = refMemoire.getMemoireTexte();
		double resultatDouble;
		if (resultatTexte.equals("erreur : division par zero")) {
			resultatDouble = 0;
		} else {
			resultatDouble = resultat1;
		}
		Memoire refmemoire2 = new Memoire(resultatDouble, resultatTexte);
		return refmemoire2;
	}
}
