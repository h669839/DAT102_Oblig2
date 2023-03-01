package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.Parentessjekker;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetParentesSjekker<T> extends KjedetStabel<T> implements Parentessjekker {
	
	private KjedetStabel parantes;
	public KjedetParentesSjekker() {
		parantes = new KjedetStabel();
	}
	

	@Override
	public boolean erVenstreparentes(char p) {
		boolean funnet = false;
		if(erTom()) {
			throw new EmptyCollectionException("Parentessjekk");
		}
		if(peek().equals(p)) {
			funnet = true;
		}
		return funnet;
	}

	@Override
	public boolean erHogreparentes(char p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erParentes(char p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
