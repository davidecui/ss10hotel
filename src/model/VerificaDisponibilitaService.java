package model;

import java.util.ArrayList;
import java.util.Date;




public class VerificaDisponibilitaService {
	
	
	private Struttura struttura = null;
	
	
	
	
	public VerificaDisponibilitaService ( Struttura struttura ) {
		this.struttura = struttura;
	}
	
	
	public int lookUp ( String tipologia ) {
		for(int i=0;i<this.struttura.getTipiCamera().size();i++) {
			if(this.struttura.getTipiCamera().get(i).equalsIgnoreCase(tipologia)) return i;
		}
		return -1;
	}
	
	
	
	
	public RisultatoRicerca verificaDisponibilita ( Date dataInizio , Date dataFine ) {
		
		ArrayList<Prenotazione> listaPrenotazioniAll = (ArrayList<Prenotazione>) this.struttura.getListaPrenotazioni();
		ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
		ArrayList<Camera> listaCamere = (ArrayList<Camera>) this.struttura.getListaCamere();
		RisultatoRicerca result = new RisultatoRicerca(this.struttura,dataInizio,dataFine);
		Camera currCamera;
		boolean booked = false;
		
		// Ricerca preventiva di tutte le prenotazioni coinvolte.
		for(int j=0;j<listaPrenotazioniAll.size();j++) {
			if ( dataInizio.before(listaPrenotazioniAll.get(j).getFinePrenotazione()) &&
				 dataFine.after(listaPrenotazioniAll.get(j).getInizioPrenotazione()) )
			{ listaPrenotazioni.add(listaPrenotazioniAll.get(j)); }
		}
		
		for(int i=0;i<listaCamere.size();i++) {
			currCamera = listaCamere.get(i);
			booked = false;
			int j = 0;
			while(j<listaPrenotazioni.size()) {
				Prenotazione p = listaPrenotazioni.get(j);
				//### bisogna aggiungere anche la coincidenza delle date estremali
				if(p.getCamera().getNumero()==currCamera.getNumero()) {
					booked = true;
					listaPrenotazioni.remove(j);
					break; }
				j++;
			}
			
			if(booked==false) {
				result.getListaLibere().get(currCamera.getPiano()-1).get(this.lookUp(currCamera.getTipologia())).add(currCamera);
			}
			else {
				result.getListaOccupate().get(currCamera.getPiano()-1).get(this.lookUp(currCamera.getTipologia())).add(currCamera);
			}
		}
		
		return result;
	}
	
	
	
	
}
