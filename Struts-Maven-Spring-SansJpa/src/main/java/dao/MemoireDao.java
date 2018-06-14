package dao;

import domaine.Memoire;

public class MemoireDao {

	// methode d'enregistrement en base du resultat
	public boolean memoriser(Memoire refMemoire) {
		return true;
	}

	// methode pour lire la valeur en memoire
	public Memoire lire() {
		Memoire mem = new Memoire(42, "42");
		return mem;
	}

}