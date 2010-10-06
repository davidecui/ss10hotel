package model;

import java.util.Date;

public class Prenotazione {
	private Date inizioPrenotazione;
	private Date finePrenotazione;
	private Camera camera;

	public Prenotazione(Date inizioPrenotazione, Date finePrenotazione,
			Camera camera) {
		this.inizioPrenotazione = inizioPrenotazione;
		this.finePrenotazione = finePrenotazione;
		this.camera = camera;
	}

	public Date getInizioPrenotazione() {
		return inizioPrenotazione;
	}
	public void setInizioPrenotazione(Date inizioPrenotazione) {
		this.inizioPrenotazione = inizioPrenotazione;
	}
	public Date getFinePrenotazione() {
		return finePrenotazione;
	}
	public void setFinePrenotazione(Date finePrenotazione) {
		this.finePrenotazione = finePrenotazione;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public String toString(){

		return "numeroCamera: " + camera.getNumero() + " inizio: " + inizioPrenotazione + " fine: " + finePrenotazione;
	}
}
