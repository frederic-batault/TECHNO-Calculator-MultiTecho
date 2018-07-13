package domaine;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Memoire")
public class Memoire {

	@Id
	@Column(name="id", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic
	private double memoire;

	@Basic
	private String memoireTexte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMemoire() {
		return memoire;
	}

	public void setMemoire(double memoire) {
		this.memoire = memoire;
	}

	public String getMemoireTexte() {
		return memoireTexte;
	}

	public void setMemoireTexte(String memoireTexte) {
		this.memoireTexte = memoireTexte;
	}

	public Memoire(double memoire, String memoireTexte) {
		super();
		this.memoire = memoire;
		this.memoireTexte = memoireTexte;
	}

	public Memoire() {
		super();
	}

}
