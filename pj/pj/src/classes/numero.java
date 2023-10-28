package classes;

import java.util.Scanner;

public class numero {
	//attrinuts
	private String s; 
	final String strPattern = "^[0][0-9]{9}$";
	enum etat{ bloque, non_bloque} ;
	private etat e;
	private String motif;
	
	//constructors
	public numero(){};
    public numero(String s) {
    	this.s = s;
    	this.e= e.non_bloque;
    }
	public numero(String s, etat e) {
		super();
		this.s = s;
		this.e = e;
	}

	//methods
	//method qui sert a remplir un objet du type numero 
	numero remplir () {
	 Scanner s = new Scanner(System.in);
	 System.out.println("vueillez saisir un numero de telephone");
	 String number= s.next();
		    while (!number.matches(strPattern)) {
		    	System.out.println("vueillez saisir un numero de telephone");
		    	number= s.next();
		} 
		    this.s= number;
		    this.e= e.non_bloque;
		    return this;
	}
	
	//method toString redefinie
	@Override
	public String toString() {
		return s + " \t " + e;
	}
	
	void afficher() {
		 System.out.println(this.toString());
	 }
 
	//method qui sert a changer l'etat d'un numero a bloque
	void bloque() { 
		this.setE(e.bloque);
		Scanner s = new Scanner(System.in);
		 System.out.println("vueillez saisir le motif du blockage");
		 this.motif = s.nextLine();
	}

	boolean equals(numero n) {
		if (this.s.equals(n.s) ) 
			return true; 
		else return false;
				
	}
	//setters and getters
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public etat getE() {
		return e;
	}

	public void setE(etat e) {
		this.e = e;
	}

	public String getStrPattern() {
		return strPattern;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}

	
}
