package model;

public class Camera {
	private int numero;
	private String tipologia;
	private int piano;
	
	public Camera(int numero, String tipologia, int piano) {
		this.numero = numero;
		this.tipologia = tipologia;
		this.piano = piano;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

}
