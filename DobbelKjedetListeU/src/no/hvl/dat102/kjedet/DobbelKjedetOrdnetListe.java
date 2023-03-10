package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		foerste = null;
		siste = null;
		antall = 0;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> forrige = null;
		DobbelNode<T> aktuell = foerste;
		while (aktuell != null && (el.compareTo(aktuell.getElement()) > 0)) {
			forrige = aktuell;
			aktuell = aktuell.getNeste();
		}
		if (antall == 0) {
			foerste = nyNode;
			siste = nyNode;
			
		} else if (forrige == null) {
			foerste = nyNode;
			nyNode.setNeste(siste);
			siste.setForrige(nyNode);
			
		} else {
			
		nyNode.setNeste(forrige.getForrige());
		forrige.getForrige().setNeste(nyNode);
		foerste = nyNode;
		}
		
		antall++;
			
		}
	

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		DobbelNode<T> aktuell = foerste;
		DobbelNode<T> resultat = null;

		while (aktuell != null && el.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		}
		if (aktuell != null) {
			if (el.equals(aktuell.getElement())) {
				resultat = aktuell;
			}
		}

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste;
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

	public void visListe() {
		DobbelNode<T> aktuell = foerste;
		while (aktuell != siste) {
			System.out.println(aktuell.getElement().toString());
		}
		if(aktuell == siste) {
			System.out.println(siste.getElement().toString());
		}

	}

}
