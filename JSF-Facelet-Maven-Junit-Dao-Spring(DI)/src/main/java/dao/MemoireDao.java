package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domaine.Memoire;

public class MemoireDao {

	// methode de chargement du driver et de connexion à la base
	public Connection connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion a la base de donnee
			String url = "jdbc:mysql://localhost:3306/calculatrice";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Probleme chargement du driver !");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("Probleme de connexion a la base de donnee !");
			e.printStackTrace();
			return null;
		}
	}

	// methode d'enregistrement en base du resultat (double)
	public boolean memoriser(Memoire refMemoire) {
		boolean retour;
		try {
			Connection connexion = connect();
			Statement stmt = connexion.createStatement();

			// si l'enregistrement n'existe pas, on en cree un, sinon, on modifie le premier
			String sql1 = "select count(id) from Memoire;";
			ResultSet set = stmt.executeQuery(sql1);
			set.next();
			int taille = set.getInt("count(id)");

			String sql2;
			if (taille == 0) {
				sql2 = "INSERT INTO `Memoire`(id,resultat,resultatTexte) VALUES (1,'" + refMemoire.getMemoire() + "', '"
						+ refMemoire.getMemoireTexte() + "');";

			} else {
				sql2 = "UPDATE `Memoire` SET `resultat` = '" + refMemoire.getMemoire() + "', `resultatTexte` = '"
						+ refMemoire.getMemoireTexte() + "' WHERE `id` = 1";
			}
			int nb = stmt.executeUpdate(sql2);

			if (nb == 1) {
				retour = true;
			} else {
				retour = false;
			}
			return retour;
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'enregistrement");
			e.printStackTrace();
			return false;
		}
	}
	
	//methode pour lire la valeur en memoire
	public Memoire lire() {
		try {
			Connection connexion = connect();
			Statement stmt =connexion.createStatement();
			String sql = "SELECT  * FROM `Memoire` WHERE id = 1";
			ResultSet result = stmt.executeQuery(sql);
			result.next();
			Memoire refMemoire = new Memoire(result.getDouble("resultat"),result.getString("resultatTexte"));
			return refMemoire;
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation de la valeur memorisee");
			e.printStackTrace();
			return null;
		}
	}

}