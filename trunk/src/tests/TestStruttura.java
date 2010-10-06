package tests;

import org.junit.* ;

import static org.junit.Assert.* ;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import model.Camera;
import model.ParametriStruttura;
import model.Prenotazione;
import model.Struttura;

public class TestStruttura {
	private Struttura struttura;

	@Before
	public void setUp() throws Exception {
		struttura = new Struttura();
	}
	
	@Test
	public void testCostruttore() {
		assertEquals(0, struttura.getNumeroPiani());
		assertEquals(0, struttura.getNumeroSingolePerPiano());
		assertEquals(0, struttura.getNumeroDoppiePerPiano());
		assertEquals(0, struttura.getNumeroSuitePerPiano());

		assertNotNull(struttura.getListaCamere());
		assertEquals(0, struttura.getListaCamere().size());
		
		assertNotNull(struttura.getListaPrenotazioni());
		assertEquals(0, struttura.getListaPrenotazioni().size());
	}

	@Test
	public void testInitialize1() {
		ParametriStruttura params = new ParametriStruttura();
		params.setNumeroPiani(1);
		params.setNumeroSingolePerPiano(5);
		
		struttura.initialize(params);

		assertEquals(1, struttura.getNumeroPiani());
		assertEquals(5, struttura.getNumeroSingolePerPiano());
		assertEquals(0, struttura.getNumeroDoppiePerPiano());
		assertEquals(0, struttura.getNumeroSuitePerPiano());
		assertEquals(5, struttura.getListaCamere().size());
		verificaComposizioneStruttura(5, 0, 0);
	}

	@Test
	public void testInitialize2() {
		ParametriStruttura params = new ParametriStruttura();
		params.setNumeroPiani(2);
		params.setNumeroSingolePerPiano(2);
		params.setNumeroDoppiePerPiano(1);
		
		struttura.initialize(params);

		assertEquals(2, struttura.getNumeroPiani());
		assertEquals(2, struttura.getNumeroSingolePerPiano());
		assertEquals(1, struttura.getNumeroDoppiePerPiano());
		assertEquals(0, struttura.getNumeroSuitePerPiano());
		assertEquals(6, struttura.getListaCamere().size());
		verificaComposizioneStruttura(4, 2, 0);
	}

	@Test
	public void testInitialize3() {
		ParametriStruttura params = new ParametriStruttura();
		params.setNumeroPiani(2);
		params.setNumeroDoppiePerPiano(2);
		params.setNumeroSuitePerPiano(1);
		
		struttura.initialize(params);

		assertEquals(2, struttura.getNumeroPiani());
		assertEquals(0, struttura.getNumeroSingolePerPiano());
		assertEquals(2, struttura.getNumeroDoppiePerPiano());
		assertEquals(1, struttura.getNumeroSuitePerPiano());
		assertEquals(6, struttura.getListaCamere().size());
		verificaComposizioneStruttura(0, 4, 2);
	}
	
	private void verificaComposizioneStruttura(int singole, int doppie, int suite) {
		assertEquals(singole, selezionaCamerePerTipologia(Struttura.SINGOLA).size());
		assertEquals(doppie, selezionaCamerePerTipologia(Struttura.DOPPIA).size());
		assertEquals(suite, selezionaCamerePerTipologia(Struttura.SUITE).size());
	}

	private List<Camera> selezionaCamerePerTipologia(String tipologia) {
		List<Camera> result = new ArrayList<Camera>();

		for (Camera c: struttura.getListaCamere()) {
			if (c.getTipologia().equals(tipologia))
				result.add(c);
		}

		return result;
	}
	
	@Test
	public void testGeneraPrenotazioni(){
		
		ParametriStruttura params = new ParametriStruttura();
		params.setNumeroPiani(1);
		params.setNumeroSingolePerPiano(1);
		GregorianCalendar inizio = new GregorianCalendar();
		GregorianCalendar fine = new GregorianCalendar();
		int durataTotalePrenotazione = 0;
		int durataPrenotazione = 0;
		
		
		
		struttura.initialize(params);
		struttura.generaPrenotazioni();
		
		
		// durata media prenotazioni
		for(Prenotazione p: struttura.getListaPrenotazioni()){
			
			inizio.setTime(p.getInizioPrenotazione());
			fine.setTime(p.getFinePrenotazione());
			durataPrenotazione = fine.get(Calendar.DAY_OF_YEAR) - inizio.get(Calendar.DAY_OF_YEAR) ;
			
			if((fine.get(Calendar.YEAR)) == inizio.get(Calendar.YEAR)){
			durataTotalePrenotazione += durataPrenotazione;
			}else{
				durataPrenotazione = durataPrenotazione + 365;
				durataTotalePrenotazione += durataPrenotazione;
			}
			
			System.out.println(p);
			
			assertTrue(durataPrenotazione <= Struttura.DURATA_MAX_PRENOTAZIONE);
		}
		
		System.out.println("durata media prenotazione: " + ((float)durataTotalePrenotazione)/struttura.getListaPrenotazioni().size());
		System.out.println("percentuale occupazione camera: " + ((float)durataTotalePrenotazione)/365*100);
		
		assertEquals(1, struttura.getListaCamere().size());
		
		
	}
	
	
}
