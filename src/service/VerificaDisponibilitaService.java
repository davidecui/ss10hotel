package service;

import java.util.Date;
import java.util.List;

import service.search.RisultatoRicerca;

import model.Prenotazione;
import model.Struttura;

public class VerificaDisponibilitaService {
    
    public RisultatoRicerca verificaDisponibilita(Date dataInizio, Date dataFine, Struttura struttura){
        RisultatoRicerca risultatoRicerca = new RisultatoRicerca(struttura);
        
        List<Prenotazione> listaPrenotazioni = struttura.getListaPrenotazioni();
        
        for (Prenotazione each : listaPrenotazioni) {
            if (dataInizio.after(each.getFinePrenotazione()) || dataFine.before(each.getInizioPrenotazione())) {
                // fuori dall'intervallo
            } 
            else {
                String tipologia = each.getCamera().getTipologia();
                int piano = each.getCamera().getPiano();
                
                if (tipologia.equals(Struttura.SINGOLA)) {
                    risultatoRicerca.getRisultatoPiani().get(piano-1).incrementaSingoleOccupate();
                }
                else if (tipologia.equals(Struttura.DOPPIA)) {
                    risultatoRicerca.getRisultatoPiani().get(piano-1).incrementaDoppieOccupate();
                }
                else if (tipologia.equals(Struttura.SUITE)) {
                    risultatoRicerca.getRisultatoPiani().get(piano-1).incrementaSuiteOccupate();
                }
                
            }
        }
        return risultatoRicerca;
    }

}
