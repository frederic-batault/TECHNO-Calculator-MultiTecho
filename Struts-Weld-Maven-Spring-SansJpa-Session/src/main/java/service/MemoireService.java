package service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import dao.MemoireDao;
import domaine.Memoire;

@Named
@SessionScoped
public class MemoireService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
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
}
