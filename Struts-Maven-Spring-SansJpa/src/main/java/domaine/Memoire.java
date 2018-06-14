package domaine;



public class Memoire {


	private int id;

	
	private double memoire;


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
