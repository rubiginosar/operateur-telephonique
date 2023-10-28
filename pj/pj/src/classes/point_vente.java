package classes;

import java.util.Scanner;

import classes.adresse.ville;
import classes.numero.etat;

public class point_vente {
	//attributs
	private String nom;
	enum type{principale, secondaire};
	private type t;
	private adresse ad = new adresse();
	private numero num = new numero();
	
	//constructors
	public point_vente() {}

	public point_vente(String nom, type type, int i, String st, ville v, String s) {
		this.nom = nom;
		this.t = type;
		this.ad = new adresse(i, st, v);
		this.num = new numero (s);
	}
	
	//methods 
	//method qui sert a remplir un objet du type point de vente 
	point_vente remplir (){
		Scanner s = new Scanner(System.in);
		System.out.println("vueillez saisir vos informations:\n");
		System.out.println("nom d'agence:");
		this.nom= s.next();
	     System.out.println("veuillez choisir un type: 1- principale 2-secondaire");
	     s.nextLine();
	     this.t = null;
	switch (s.nextInt())
	{
		case 1 : this.t = type.valueOf("principale"); break;
		case 2 : this.t = type.valueOf("secondaire"); break;
		default :this.t = type.valueOf("secondaire"); break;
	}
		System.out.println("adresse:");
		this.ad= ad.remplir();
		System.out.println("numero du telepone:");
		this.num= num.remplir();
         return this;
	}

	
	//method qui sert a modifier l'adresse ou le numero ou le type d'un point de vente
	void modifier( )
	{	
		System.out.println(" 1- modifier l'adresse \n 2- changer le type  \n 3- changer le numero");
		Scanner s = new Scanner(System.in);
		switch(s.nextInt()) {
		case 1 :this.ad = this.ad.remplir(); break;
		case 2: System.out.println("veuillez choisir un type: 1- principale 2-secondaire");
		this.t = null;
		switch (s.nextInt())
		{
			case 1 : this.t = type.valueOf("principale"); break;
			case 2 : this.t = type.valueOf("secondaire"); break;
			default :this.t = type.valueOf("secondaire"); break;
		}break;
		case 3: this.num = num.remplir();break;
		}
		
	}
	
	//method toString redefinie
	public String toString() {
		return "\n \t point de vente: " + "\n nom d'agence= \t" + nom + "\n type= \t" + t + "\n adresse= \t" + ad + "\n numero de telephone= \t" + num ;
	}
	
	void afficher() {
		 System.out.println(this.toString());
	 }
	
	//setters un getters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public type getT() {
		return t;
	}
	public void setT(type t) {
		this.t = t;
	}
	public adresse getAd() {
		return ad;
	}
	public void setAd(adresse ad) {
		this.ad = ad;
	}
	public numero getNum() {
		return num;
	}
	public void setNum(numero num) {
		this.num = num;
	}
	
	
}
