package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Struttura {

	public static final String SINGOLA = "Singola";
	public static final String DOPPIA = "Doppia";
	public static final String SUITE = "Suite";
	
	public static final double P_PRENOTAZIONE = 0.2;
	public static final int DURATA_MAX_PRENOTAZIONE = 10;
	
	private ArrayList<String> TIPI_CAMERA;
	

	private int numeroPiani;
	
	private int numeroSingolePerPiano;
	
	private int numeroDoppiePerPiano;
	
	private int numeroSuitePerPiano;
	
	private List<Camera> listaCamere;
	
	private List<Prenotazione> listaPrenotazioni;

	public Struttura() {
		TIPI_CAMERA = new ArrayList<String>();
		TIPI_CAMERA.add(SINGOLA);
		TIPI_CAMERA.add(DOPPIA);
		TIPI_CAMERA.add(SUITE);
		
		numeroPiani = 0;
		numeroSingolePerPiano = 0;
		numeroDoppiePerPiano = 0;
		numeroSuitePerPiano = 0;
		listaCamere = new ArrayList<Camera>();
		listaPrenotazioni = new ArrayList<Prenotazione>();
	}

	public void initialize(ParametriStruttura params) {
		ArrayList<Camera> lista;

		numeroPiani = params.getNumeroPiani();
		numeroSingolePerPiano = params.getNumeroSingolePerPiano();
		numeroDoppiePerPiano = params.getNumeroDoppiePerPiano();
		numeroSuitePerPiano = params.getNumeroSuitePerPiano();

		lista = new ArrayList<Camera>( numeroPiani * (numeroSingolePerPiano + numeroDoppiePerPiano + numeroSuitePerPiano) );
		for (int piano = 1; piano <= numeroPiani; ++piano) {
			int numCamera = 1;

			for (int i = 1; i <= numeroSingolePerPiano; ++i) {
				lista.add(new Camera(piano*100 + numCamera, SINGOLA, piano));
				++numCamera;
			}

			for (int i = 1; i <= numeroDoppiePerPiano; ++i) {
				lista.add(new Camera(piano*100 + numCamera, DOPPIA, piano));
				++numCamera;
			}

			for (int i = 1; i <= numeroSuitePerPiano; ++i) {
				lista.add(new Camera(piano*100 + numCamera, SUITE, piano));
				++numCamera;
			}
		}

		listaCamere = lista;
		listaPrenotazioni.clear();
	}
	
	public void generaPrenotazioni() {
		generaPrenotazioni(null);
	}

	
	
	public void addPrenotazione(Prenotazione pren)
	{
		this.getListaPrenotazioni().add(pren);
	}

	public void generaPrenotazioni(Integer seed) {
		
		GregorianCalendar oggi = null;
		GregorianCalendar dataFine = null;
		GregorianCalendar finePrenotazione = null;
		int durata = 0; // durata in giorni della prenotazione
		Prenotazione prenotazione = null;
		Random random = null;
		
		if(seed != null){
			random = new Random(seed);
		}else{
			random = new Random();
		}
		
		for(Camera camera: listaCamere){
			
			 oggi = new GregorianCalendar();
			 dataFine = (GregorianCalendar)oggi.clone(); 
			 dataFine.add(Calendar.YEAR, 1);
			
			while(oggi.compareTo(dataFine) <= 0){
				
				if(random.nextDouble() < P_PRENOTAZIONE) {
					
					durata = 1 + random.nextInt(DURATA_MAX_PRENOTAZIONE);
					finePrenotazione = (GregorianCalendar)oggi.clone();
					finePrenotazione.add(Calendar.DAY_OF_MONTH, durata);
					prenotazione = new Prenotazione(oggi.getTime(), finePrenotazione.getTime(), camera);
					listaPrenotazioni.add(prenotazione);
					oggi.add(Calendar.DAY_OF_MONTH, durata+1);
				}else{
					
					oggi.add(Calendar.DAY_OF_MONTH, 1);
				}	
			}
		}
	}
	

	public int getNumeroPiani() {
		return numeroPiani;
	}

	public int getNumeroSingolePerPiano() {
		return numeroSingolePerPiano;
	}

	public int getNumeroDoppiePerPiano() {
		return numeroDoppiePerPiano;
	}

	public int getNumeroSuitePerPiano() {
		return numeroSuitePerPiano;
	}

	public List<Camera> getListaCamere() {
		return listaCamere;
	}

	public List<Prenotazione> getListaPrenotazioni() {
		return listaPrenotazioni;
	}
	
	public ArrayList<String> getTipiCamera() {
		return this.TIPI_CAMERA;
	}
	
}
