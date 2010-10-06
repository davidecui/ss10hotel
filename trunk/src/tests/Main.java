package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.*;




public class Main {
	
	
	
	public int Npiani;
	public int Ntypes;
	public ArrayList<ArrayList<ArrayList<Camera>>> libere;
	public ArrayList<ArrayList<ArrayList<Camera>>> occupate;
	
	Struttura struttura;
	
	
	public Main ( ) {
		
		this.struttura = new Struttura();
		
		ParametriStruttura params = new ParametriStruttura();
		params.setNumeroPiani(7);
		params.setNumeroSingolePerPiano(20);
		params.setNumeroDoppiePerPiano(20);
		params.setNumeroSuitePerPiano(20);
		this.struttura.initialize(params);
		
		Camera camera = null;
		
		Date checkin = null;
		Date checkout = null;
		
		try
		{
			camera = struttura.getListaCamere().get(0);
			
			for(int i=10;i<15;i++) {
				checkin = (Date) new SimpleDateFormat("dd/mm/yyyy").parse(i+"/10/2010");
				checkout = (Date) new SimpleDateFormat("dd/mm/yyyy").parse((i+1)+"/10/2010");
				struttura.getListaPrenotazioni().add(new Prenotazione(checkin,checkout,camera));
			}
			
			checkin = (Date) new SimpleDateFormat("dd/mm/yyyy").parse("10/10/2010");
			checkout = (Date) new SimpleDateFormat("dd/mm/yyyy").parse("15/10/2010");
			
			VerificaDisponibilitaService service = new VerificaDisponibilitaService(struttura);
			RisultatoRicerca result = service.verificaDisponibilita(checkin,checkout);
			
			System.out.print("             ");
			
			for(int j=0;j<struttura.getTipiCamera().size();j++) {
				System.out.print(struttura.getTipiCamera().get(j)+"    ");
			}
			
			System.out.println();
			
			for(int i=0;i<struttura.getNumeroPiani();i++) {
				System.out.print("PIANO "+i+"  ");
				for(int j=0;j<struttura.getTipiCamera().size();j++) {
					System.out.print("    "+result.getListaLibere().get(i).get(j).size()+" ("+result.getListaOccupate().get(i).get(j).size()+")");
				}
				System.out.println();
			}
			
			
		}
		catch (ParseException e) { e.printStackTrace(); }
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		Main a = new Main();
	}

}
