package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domaine.Memoire;

public class MemoireDao {

	

	// methode d'enregistrement en base du resultat (double)
	public boolean memoriser(Memoire refMemoire) {
		return true;
	}
	
	//methode pour lire la valeur en memoire
	public Memoire lire() {
		Memoire mem = new Memoire(42, "42");
		return mem;
	}

}