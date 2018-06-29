package dao;

import domaine.Memoire;

public interface IMemoireDao {

	public boolean memoriser(Memoire refMemoire);
	
	public Memoire lire();
}
