package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPersonTabKjedet {
	public static void main(String[] args) {
		
		OrdnetListeADT<Person> listeKjedet= new KjedetOrdnetListe<Person>();
		OrdnetListeADT<Person> listeTabell = new TabellOrdnetListe<Person>();
		
		Scanner in = new Scanner(System.in);
		String fornavn, etternavn, svar;
		
		int fødselår;
		
		do {
			System.out.println("Oppgi fornavn: ");
			fornavn = in.next();
			
			System.out.println("Oppgi etternavn: ");
			etternavn = in.next();
			
			System.out.println("Oppgi fødselår: ");
			fødselår = in.nextInt();
			
			listeKjedet.leggTil(new Person(fornavn, etternavn, fødselår));
			listeTabell.leggTil(new Person(fornavn, etternavn, fødselår));
			
			System.out.println("Oppgi flere navn [J/N]?:");
	        svar = in.next();
			
		} while (svar.equals("j")|| svar.equals("J"));
		
		 	System.out.println("\n\nNavnelisten i kjedet ordning:");

	        while(!listeKjedet.erTom())
	              System.out.println(listeKjedet.fjernFoerste() + " ");
	        
	        System.out.println("\n\nNavnelisten i tabell ordning:");

	        while(!listeTabell.erTom())
	              System.out.println(listeTabell.fjernFoerste() + " ");
	}

}
