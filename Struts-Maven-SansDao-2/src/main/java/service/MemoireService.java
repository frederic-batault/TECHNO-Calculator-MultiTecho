package service;

import dao.MemoireDao;
import domaine.Memoire;

public class MemoireService {
	// m�thode d'enregistrement sous les 2 types
	public boolean memoriser(Memoire refMemoire) {
		MemoireDao refMemoireDao = new MemoireDao();
		boolean retour = refMemoireDao.memoriser(refMemoire);
		if (retour == true) {
			return true;
		} else {
			return false;
		}
	}

	// m�thode d'affichage
	public Memoire afficherMemoire() {
		MemoireDao refMemoireDao = new MemoireDao();
		Memoire refMemoire = refMemoireDao.lire();
		double resultat1 = refMemoire.getMemoire();
		String resultatTexte = refMemoire.getMemoireTexte();
		double resultatDouble;
		if (resultatTexte.equals("erreur : division par z�ro")) {
			resultatDouble = 0;
		}
		else {
			resultatDouble = resultat1;
		}
		Memoire refmemoire2 = new Memoire(resultatDouble,resultatTexte);
		return refmemoire2;
	}
}
