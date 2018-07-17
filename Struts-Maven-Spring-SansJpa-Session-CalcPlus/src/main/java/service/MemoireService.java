package service;



import org.springframework.beans.factory.annotation.Autowired;

import dao.MemoireDao;
import domaine.Memoire;

public class MemoireService {

	@Autowired
	MemoireDao memoireDao;

	// methode d'enregistrement sous les 2 types
	public boolean memoriser(Memoire refMemoire) {
		refMemoire.setId(1);
		boolean memorise = this.memoireDao.memoriser(refMemoire);
		return memorise;
	}

	// methode d'affichage
	public Memoire afficherMemoire() {
		Memoire refMemoire = this.memoireDao.lire();
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
	
	//methode d'effacement (remise a zero)
	public boolean effacer() {
		Memoire zero = new Memoire(0,"0 (memoire effacee)");
		zero.setId(1);
		boolean efface = memoireDao.memoriser(zero);
		return efface;
	}
}
