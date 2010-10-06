package tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import service.VerificaDisponibilitaService;
import service.search.RisultatoRicerca;
import service.search.RisultatoRicercaPiano;

import model.Camera;
import model.ParametriStruttura;
import model.Prenotazione;
import model.Struttura;
import junit.framework.TestCase;

public class TestVerificaDisponibilitaService extends TestCase{

	private Struttura struttura;
	private VerificaDisponibilitaService verificaDisponibilitaService;
	private GregorianCalendar calendar1;
	private GregorianCalendar calendar2;
	private GregorianCalendar calendar3;
	private GregorianCalendar calendar4;

	@Override
	protected void setUp() throws Exception {

		struttura = new Struttura();
		verificaDisponibilitaService = new VerificaDisponibilitaService();
		ParametriStruttura parametriStruttura = new ParametriStruttura();

		parametriStruttura.setNumeroPiani(2);
		parametriStruttura.setNumeroSingolePerPiano(2);
		parametriStruttura.setNumeroDoppiePerPiano(2);
		parametriStruttura.setNumeroSuitePerPiano(1);

		struttura.initialize(parametriStruttura);
		calendar1 = new GregorianCalendar(2010, Calendar.NOVEMBER, 11);
		calendar2 = new GregorianCalendar(2010, Calendar.NOVEMBER, 15);
		calendar3 = new GregorianCalendar(2010, Calendar.SEPTEMBER, 1);
		calendar4 = new GregorianCalendar(2010, Calendar.SEPTEMBER, 5);




		List<Camera> listaCamere = struttura.getListaCamere();
		for (Camera camera : listaCamere) {
			if(Struttura.SINGOLA.equals(camera.getTipologia()) || Struttura.SUITE.equals(camera.getTipologia()))
			{
				struttura.getListaPrenotazioni().add(new Prenotazione(calendar1.getTime(), calendar2.getTime(), camera));
			}
			else if(Struttura.DOPPIA.equals(camera.getTipologia()))
			{
				struttura.getListaPrenotazioni().add(new Prenotazione(calendar3.getTime(), calendar4.getTime(), camera));
			}

		}


	}

	@Test
	public void testPrenotazioniOttobreTutteLibere()
	{
		System.out.println("testPrenotazioniOttobreTutteLibere");
		Calendar inizioOttobre = new GregorianCalendar(2010, Calendar.OCTOBER, 1);
		Calendar fineOttobre = new GregorianCalendar(2010, Calendar.OCTOBER, 30);
		RisultatoRicerca risultatoRicerca = verificaDisponibilitaService.verificaDisponibilita(inizioOttobre.getTime(), fineOttobre.getTime(), struttura);
		List<RisultatoRicercaPiano> risultatoPiano = risultatoRicerca.getRisultatoPiani();
		for (RisultatoRicercaPiano risultatoRicercaPiano : risultatoPiano) {

			assertEquals(2, risultatoRicercaPiano.getSingoleLibere());
			assertEquals(2, risultatoRicercaPiano.getDoppieLibere());
			assertEquals(1, risultatoRicercaPiano.getSuiteLibere());
			assertEquals(0, risultatoRicercaPiano.getSingoleOccupate());
			assertEquals(0, risultatoRicercaPiano.getSuiteOccupate());
			assertEquals(0, risultatoRicercaPiano.getDoppieOccupate());

		}
		System.out.println("PASSED");
	}
	
	@Test
	public void testPrenotazioniOttobrePrenotazioneSingola()
	{
		System.out.println("testPrenotazioniOttobrePrenotazioneSingola");
		Calendar inizioOttobre = new GregorianCalendar(2010, Calendar.OCTOBER, 1);
		Calendar fineOttobre = new GregorianCalendar(2010, Calendar.OCTOBER, 30);
		Calendar inizioPrenotazione = new GregorianCalendar(2010, Calendar.OCTOBER, 1);
		Calendar finePrenotazione = new GregorianCalendar(2010, Calendar.OCTOBER, 5);

		struttura.addPrenotazione(new Prenotazione(inizioPrenotazione.getTime(), finePrenotazione.getTime(), struttura.getListaCamere().get(0)));
	    System.out.println("Prenotata la camera " + struttura.getListaCamere().get(0).getTipologia() + " numero "+ struttura.getListaCamere().get(0).getNumero() );
		
		RisultatoRicerca risultatoRicerca = verificaDisponibilitaService.verificaDisponibilita(inizioOttobre.getTime(), fineOttobre.getTime(), struttura);
		List<RisultatoRicercaPiano> risultatoPiano = risultatoRicerca.getRisultatoPiani();
		for (RisultatoRicercaPiano risultatoRicercaPiano : risultatoPiano) {
			if(risultatoRicercaPiano.getNumeroPiano() == 1)
			{
				assertEquals(1, risultatoRicercaPiano.getSingoleOccupate());
				assertEquals(1, risultatoRicercaPiano.getSingoleLibere());
				assertEquals(2, risultatoRicercaPiano.getDoppieLibere());
				assertEquals(1, risultatoRicercaPiano.getSuiteLibere());
				assertEquals(0, risultatoRicercaPiano.getSuiteOccupate());
				assertEquals(0, risultatoRicercaPiano.getDoppieOccupate());
			}
		}
	    System.out.println("PASSED");
	}

	@Test
	public void testPrenotazioneSettembre()
	{
		System.out.println("testPrenotazioneSettembre");
		Calendar inizioSettembre = new GregorianCalendar(2010, Calendar.SEPTEMBER, 1);
		Calendar fineSettembre = new GregorianCalendar(2010, Calendar.SEPTEMBER, 5);
		RisultatoRicerca risultatoRicerca = verificaDisponibilitaService.verificaDisponibilita(inizioSettembre.getTime(), fineSettembre.getTime(), struttura);
		List<RisultatoRicercaPiano> risultatoPiano = risultatoRicerca.getRisultatoPiani();
		for (RisultatoRicercaPiano risultatoRicercaPiano : risultatoPiano) {

			assertEquals(0, risultatoRicercaPiano.getSingoleOccupate());
			assertEquals(2, risultatoRicercaPiano.getSingoleLibere());
			assertEquals(0, risultatoRicercaPiano.getDoppieLibere());
			assertEquals(1, risultatoRicercaPiano.getSuiteLibere());
			assertEquals(0, risultatoRicercaPiano.getSuiteOccupate());
			assertEquals(2, risultatoRicercaPiano.getDoppieOccupate());

		}

	}

	   @Test
	    public void testPrenotazioneOttobre()
	    {
	        System.out.println("testPrenotazioneOttobreMultiPrenotazione");
	        Calendar inizioRicerca = new GregorianCalendar(2010, Calendar.OCTOBER, 11);
	        Calendar fineRicerca = new GregorianCalendar(2010, Calendar.OCTOBER, 21);
	        
	        struttura.addPrenotazione(new Prenotazione(new GregorianCalendar(2010, Calendar.OCTOBER, 12).getTime(), new GregorianCalendar(2010, Calendar.OCTOBER, 13).getTime(), struttura.getListaCamere().get(0)));
	        System.out.println("Prenotata la camera " + struttura.getListaCamere().get(0).getTipologia() + " numero "+ struttura.getListaCamere().get(0).getNumero() );
	        
            struttura.addPrenotazione(new Prenotazione(new GregorianCalendar(2010, Calendar.OCTOBER, 14).getTime(), new GregorianCalendar(2010, Calendar.OCTOBER, 15).getTime(), struttura.getListaCamere().get(0)));
	        System.out.println("Prenotata la camera " + struttura.getListaCamere().get(0).getTipologia() + " numero "+ struttura.getListaCamere().get(0).getNumero() );
	        
            struttura.addPrenotazione(new Prenotazione(new GregorianCalendar(2010, Calendar.OCTOBER, 16).getTime(), new GregorianCalendar(2010, Calendar.OCTOBER, 17).getTime(), struttura.getListaCamere().get(0)));
	        System.out.println("Prenotata la camera " + struttura.getListaCamere().get(0).getTipologia() + " numero "+ struttura.getListaCamere().get(0).getNumero() );
	        
	        RisultatoRicerca risultatoRicerca = verificaDisponibilitaService.verificaDisponibilita(inizioRicerca.getTime(), fineRicerca.getTime(), struttura);
	        List<RisultatoRicercaPiano> risultatoPiano = risultatoRicerca.getRisultatoPiani();
	        for (RisultatoRicercaPiano risultatoRicercaPiano : risultatoPiano) {
	            if (risultatoRicercaPiano.getNumeroPiano() == 1) {
	            assertEquals(1, risultatoRicercaPiano.getSingoleOccupate());
	            assertEquals(1, risultatoRicercaPiano.getSingoleLibere());
	            assertEquals(0, risultatoRicercaPiano.getDoppieLibere());
	            assertEquals(1, risultatoRicercaPiano.getSuiteLibere());
	            assertEquals(0, risultatoRicercaPiano.getSuiteOccupate());
	            assertEquals(2, risultatoRicercaPiano.getDoppieOccupate());
	            }
	        }

	    }

}
