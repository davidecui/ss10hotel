package service.search;

import model.Struttura;

public class RisultatoRicercaPiano {
    
    private int numeroPiano;
	
	private int singoleOccupate;
	private int singoleLibere;
	private int doppieOccupate;
	private int doppieLibere;
	private int suiteOccupate;
	private int suiteLibere;
	
	public RisultatoRicercaPiano(Struttura struttura, int i) {
        this.setNumeroPiano(i);
        this.setSingoleLibere(struttura.getNumeroSingolePerPiano());
        this.setSingoleOccupate(0);
        this.setDoppieLibere(struttura.getNumeroDoppiePerPiano());
        this.setDoppieOccupate(0);
        this.setSuiteLibere(struttura.getNumeroSuitePerPiano());
        this.setSuiteOccupate(0);
    }

    public void decrementaSingoleOccupate() {
	    this.singoleOccupate--;
	    this.singoleLibere++;
	}
	
	public void incrementaSingoleOccupate() {
		this.singoleOccupate++;
		this.singoleLibere--;
	}
	
	public void decrementaDoppieOccupate() {
		this.doppieOccupate--;
		this.doppieLibere++;
	}
	
	public void incrementaDoppieOccupate() {
		this.doppieOccupate++;
		this.doppieLibere--;
	}
	
	public void decrementaSuiteOccupate() {
		this.suiteOccupate--;
		this.suiteLibere++;
	}
	
	public void incrementaSuiteOccupate() {
		this.suiteOccupate++;
		this.suiteLibere--;
	}

    public int getSingoleOccupate() {
        return singoleOccupate;
    }

    public void setSingoleOccupate(int singoleOccupate) {
        this.singoleOccupate = singoleOccupate;
    }

    public int getSingoleLibere() {
        return singoleLibere;
    }

    public void setSingoleLibere(int singoleLibere) {
        this.singoleLibere = singoleLibere;
    }

    public int getDoppieOccupate() {
        return doppieOccupate;
    }

    public void setDoppieOccupate(int doppieOccupate) {
        this.doppieOccupate = doppieOccupate;
    }

    public int getDoppieLibere() {
        return doppieLibere;
    }

    public void setDoppieLibere(int doppieLibere) {
        this.doppieLibere = doppieLibere;
    }

    public int getSuiteOccupate() {
        return suiteOccupate;
    }

    public void setSuiteOccupate(int suiteOccupate) {
        this.suiteOccupate = suiteOccupate;
    }

    public int getSuiteLibere() {
        return suiteLibere;
    }

    public void setSuiteLibere(int suiteLibere) {
        this.suiteLibere = suiteLibere;
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public void setNumeroPiano(int numeroPiano) {
        this.numeroPiano = numeroPiano;
    }
	
}
