package model;

import java.util.ArrayList;
import java.util.Date;




public class RisultatoRicerca {
	
	
	private ArrayList<ArrayList<ArrayList<Camera>>> listaLibere;
	private ArrayList<ArrayList<ArrayList<Camera>>> listaOccupate;
	private Date dataInizio;
	private Date dataFine;
	
	
	public RisultatoRicerca ( Struttura struttura ) {
		this(struttura,null,null);
	}
	
	
	public RisultatoRicerca ( Struttura struttura , Date dataInizio , Date dataFine ) {
		
		this.setDataInizio(dataInizio);
		this.setDataFine(dataFine);
		
		/*
		 * Gli ArrayList hanno la seguente gerarchia:
		 * primo livello: piano
		 * secondo livello: tipologia
		 * terzo livello: camera
		 */
		listaLibere = new ArrayList<ArrayList<ArrayList<Camera>>>(struttura.getNumeroPiani());
		listaOccupate = new ArrayList<ArrayList<ArrayList<Camera>>>(struttura.getNumeroPiani());
		
		// Allocazione strutture dati.
		for(int i=0;i<struttura.getNumeroPiani();i++) {
			listaLibere.add ( i , new ArrayList<ArrayList<Camera>>(struttura.getTipiCamera().size()) );
			listaOccupate.add ( i , new ArrayList<ArrayList<Camera>>(struttura.getTipiCamera().size()) );
			for(int j=0;j<struttura.getTipiCamera().size();j++) {
				listaLibere.get(i).add ( j , new ArrayList<Camera>() );
				listaOccupate.get(i).add ( j , new ArrayList<Camera>() );
			}
		}
		
		
	}
	
	
	
	public ArrayList<ArrayList<ArrayList<Camera>>> getListaLibere() {
		return listaLibere;
	}
	
	public void setListaLibere(ArrayList<ArrayList<ArrayList<Camera>>> listaLibere) {
		this.listaLibere = listaLibere;
	}
	
	public ArrayList<ArrayList<ArrayList<Camera>>> getListaOccupate() {
		return listaOccupate;
	}

	public void setListaOccupate(
			ArrayList<ArrayList<ArrayList<Camera>>> listaOccupate) {
		this.listaOccupate = listaOccupate;
	}


	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}


	public Date getDataInizio() {
		return dataInizio;
	}


	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}


	public Date getDataFine() {
		return dataFine;
	}


	
	
	
	
}
