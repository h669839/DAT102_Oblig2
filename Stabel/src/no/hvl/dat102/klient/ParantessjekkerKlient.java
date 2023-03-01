package no.hvl.dat102.klient;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetStabel;
import no.hvl.dat102.tabell.TabellParentesSjekker;

public class ParantessjekkerKlient {

	public static void main(String[] args) {
		String riktig = "{[()]}";
		String feil = "[f]gr}[hgt)";
		int lengde = riktig.length();
		int lengde2 = feil.length();
		
		TabellParentesSjekker<Character> tegnStabel = new TabellParentesSjekker<Character>();
		TabellParentesSjekker<Character> tegnStabel2 = new TabellParentesSjekker<Character>();
		
		for (int i = 0; i < lengde; i++) {
			if(tegnStabel.erParentes(riktig.charAt(i))) {
				tegnStabel.push(riktig.charAt(i));
			}
		}
		System.out.println(tegnStabel);
		for (int i = 0; i < lengde2; i++) {
			if(tegnStabel2.erParentes(feil.charAt(i))) {
				tegnStabel2.push(feil.charAt(i));
			}
		}
		System.out.println(tegnStabel2);
		
		
		
		System.out.println(riktig);
		
		try {
			while (!tegnStabel.erTom()) {
				if(tegnStabel.erBalansert(riktig)) {
					System.out.println("Strengen er balansert");
				}
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
	 
	
	try {
		while (!tegnStabel2.erTom()) {
			if(tegnStabel2.erBalansert(feil)) {
				System.out.println("Strengen er balansert");
			}
		}
		System.out.println();
	} catch (EmptyCollectionException ex) {
		System.out.println(ex.getMessage());
	}
} 

	}


