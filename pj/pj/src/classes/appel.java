package classes;

import java.util.Scanner;

public class appel {
	//attributs
	private date d= new date();
	private heure h= new heure();
	private int duree;
	private int duree_cumule;
	
	
	//constructors
	public appel(int j, int m, int a , int h, int min, int sec, int duree) {
		this.d = new date(j,m,a);
		this.h = new heure(h, min ,sec);
		this.duree= duree;
	}
	
	public appel() {}
	
	//methods
	//method remplir qui sert a remplir un objet de type appel
appel remplir() {
	 this.d = d.remplir();
	this.h = h.remplir();
	Scanner s = new Scanner (System.in);
	System.out.println("duree de l'appel");
     this.duree =s.nextInt();
	return this;
}
    //sert a calculer la duree cumulee des appels
	Integer duree_cumule (heure hb) {
		this.duree_cumule= this.duree + this.h.duree(hb).to_duree();
		System.out.println("duree cumule= "+ this.duree_cumule + " minutes");
		return this.duree_cumule;
	}

	//method toString redefinie
	@Override
	public String toString() {
		return " le: \t" + d + "\n a: \t " + h + "\n duree \t:" + duree + " minutes" ;
	}
	
	 void afficher() {
		 System.out.println(this.toString());
	 }

	 //setters and getters
	public date getD() {
		return d;
	}

	public void setD(date d) {
		this.d = d;
	}

	public heure getH() {
		return h;
	}

	public void setH(heure h) {
		this.h = h;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getDuree_cumule() {
		return duree_cumule;
	}

	public void setDuree_cumule(int duree_cumule) {
		this.duree_cumule = duree_cumule;
	}
	 
	 
}
