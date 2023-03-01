package no.hvl.dat102.listeklient;

import java.util.Comparator;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstrukt�rer

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	public int compareTo(Person denAndrePersonen) {
		int result = -1;
		Person p2 = (Person) denAndrePersonen;
		
		if(this.foedselsaar == p2.foedselsaar) {
			
			result = this.etternavn.compareTo(p2.etternavn);
			
			if(result == 0) {
				
				result = this.fornavn.compareTo(p2.fornavn);
			}
		} else if (this.foedselsaar > p2.foedselsaar){
			result = 1;
		}
		return result;

	}

}// class