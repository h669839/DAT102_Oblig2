package no.hvl.dat102.tabell;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.lang.*;
import java.util.*;

import no.hvl.dat102.adt.Parentessjekker;
import no.hvl.dat102.exception.EmptyCollectionException;

public class TabellParentesSjekker<Character> extends TabellStabel<Character> implements Parentessjekker {

	@Override
	public boolean erVenstreparentes(char p) {
		boolean funnet = false;
		
		if(p == '(' || p == '[' || p == '{') {
			
			funnet = true;
		}
		return funnet;
	}

	@Override
	public boolean erHogreparentes(char p) {
boolean funnet = false;
		
		if(p == ')' || p == ']' || p == '}') {
			
			funnet = true;
		}
		return funnet;
	}

	@Override
	public boolean erParentes(char p) {
		boolean funnet = false;
		
		if(erVenstreparentes(p) || erHogreparentes(p)) {
			
			funnet = true;
		}


		return funnet;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		boolean par = false;
		
		if (erVenstreparentes(venstre) && erHogreparentes(hogre)) {
	
			if(venstre == '(' && hogre == ')') {
				par = true;
			}
			else if (venstre == '[' && hogre == ']') {
				par = true;
			}
			else if (venstre == '{' && hogre == '}') {
				par = true;
			}
		}
		return par;
	}

	@Override
	public boolean erBalansert(String s) {
		TabellStabel<Character> stabel = new TabellStabel<Character>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char e = charArray[i]; 
			if (e == '(' || e == '[' || e == '{') {

				stabel.push(e);
				continue;
			}
			if (stabel.erTom())
				return false;

			char sjekk;

			switch (e) {

			case ')':
				sjekk = (char) stabel.pop() ;
				if (sjekk == ']' || sjekk == '}')
					return false;
				break;
			case']':
				sjekk = (char) stabel.pop();
				if(sjekk == ')' || sjekk == '}') return false;
				break;
			case'}':
				sjekk = (char) stabel.pop();
				if(sjekk == ']' || sjekk ==')') return false;
				break;
			}

		}
		return stabel.erTom();
	}

}
