package dao;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import domaine.Memoire;

@Named
@SessionScoped
public class MemoireDao implements Serializable{

	private static final long serialVersionUID = 1L;

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