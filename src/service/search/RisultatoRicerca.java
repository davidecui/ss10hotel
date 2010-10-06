package service.search;

import java.util.ArrayList;
import java.util.List;

import model.Struttura;

public class RisultatoRicerca {
	private List<RisultatoRicercaPiano> risultatoPiani;

	public RisultatoRicerca(Struttura struttura) {
	    int numeroPiani = struttura.getNumeroPiani();
	    risultatoPiani = new ArrayList<RisultatoRicercaPiano>();
	    
	    for (int i=0; i < numeroPiani; i++) {
	        RisultatoRicercaPiano risultatoRicercaPiano = new RisultatoRicercaPiano(struttura, i+1);
	        risultatoPiani.add(i, risultatoRicercaPiano);
	    }
    }

    public List<RisultatoRicercaPiano> getRisultatoPiani() {
        return risultatoPiani;
    }

    public void setRisultatoPiani(List<RisultatoRicercaPiano> risultatoPiani) {
        this.risultatoPiani = risultatoPiani;
    }

}
