package service;

import javax.enterprise.context.SessionScoped;

import domaine.Memoire;

@SessionScoped
public interface IMemoireService {

	public boolean memoriser(Memoire refMemoire);
	
	public Memoire afficherMemoire();
}
