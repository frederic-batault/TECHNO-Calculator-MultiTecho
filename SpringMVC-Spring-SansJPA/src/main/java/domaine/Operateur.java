package domaine;

public class Operateur {

	private int code;
	private String symbole;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSymbole() {
		return symbole;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public Operateur(int code, String symbole) {
		super();
		this.code = code;
		this.symbole = symbole;
	}
	public Operateur() {
		super();
	}
	
	
}
