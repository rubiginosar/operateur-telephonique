package classes;

import java.util.Scanner;

//la classe date est caracterise par un jour, mois et une annee.
public class date {
	//attributs
	private int jour; 
	private int mois; 
	private int annee;
	public date(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	
	//constructors
	public date() {}
	
	//methods
	//method pour remplir un objet de type date
	public date remplir() {
		Scanner s = new Scanner(System.in);
		System.out.println("jour: ");
		this.jour = s.nextInt();
		System.out.println("mois: ");
		this.mois = s.nextInt();
		System.out.println("annee: ");
		this.annee = s.nextInt();
		return this;
	}
	
	//method toString redefinie
	@Override
	public String toString() {
		return  + jour + "/" + mois + "/" + annee;
	}
	
	void afficher() {
		 System.out.println(this.toString());
	 }
	
	//method qui retourne la date limite d'un abonnement a partir de sa date de debut 
	//on a choisi 9 3 comme la duree de type forfaitaire et n'importe quelle entier pour le type libre, le type prepaye n'est
	//pas concerne
	public date date_limite( int a) {
		date date_fin = new date();
		if (a == 3) {
			date_fin.setJour(this.getJour()); // la dite limitee recoie le meme jour que la date de debut
		switch(this.getMois()) {
		case 1: date_fin.setMois(4); date_fin.setAnnee(this.getAnnee()); break; 
		case 2: date_fin.setMois(5); date_fin.setAnnee(this.getAnnee()) ;break;
		case 3: date_fin.setMois(6); date_fin.setAnnee(this.getAnnee()); break;
		case 4: date_fin.setMois(7);date_fin.setAnnee(this.getAnnee()); break;
		case 5: date_fin.setMois(8);date_fin.setAnnee(this.getAnnee()); break;
		case 6: date_fin.setMois(9);date_fin.setAnnee(this.getAnnee()); break;
		case 7: date_fin.setMois(10);date_fin.setAnnee(this.getAnnee()); break;
		case 8: date_fin.setMois(11);date_fin.setAnnee(this.getAnnee()) ;break;
		case 9: date_fin.setMois(12);date_fin.setAnnee(this.getAnnee()); break;
		case 10: date_fin.setMois(1);date_fin.setAnnee(this.getAnnee()+1); break;// on augemente l'annee par 1 pour les 3 dernier mois
		case 11: date_fin.setMois(2);date_fin.setAnnee(this.getAnnee()+1); break;
		case 12: date_fin.setMois(3);date_fin.setAnnee(this.getAnnee()+1); break;
		}} else {
			date_fin.setJour(this.getJour());
			switch(this.getMois()) {
			case 1: date_fin.setMois(2);date_fin.setAnnee(this.getAnnee()); break; 
			case 2: date_fin.setMois(3);date_fin.setAnnee(this.getAnnee()); break;
			case 3: date_fin.setMois(4);date_fin.setAnnee(this.getAnnee()); break;
			case 4: date_fin.setMois(5);date_fin.setAnnee(this.getAnnee()); break;
			case 5: date_fin.setMois(6);date_fin.setAnnee(this.getAnnee()); break;
			case 6: date_fin.setMois(7);date_fin.setAnnee(this.getAnnee()); break;
			case 7: date_fin.setMois(8);date_fin.setAnnee(this.getAnnee()); break;
			case 8: date_fin.setMois(9);date_fin.setAnnee(this.getAnnee()); break;
			case 9: date_fin.setMois(10);date_fin.setAnnee(this.getAnnee()); break;
			case 10: date_fin.setMois(11);date_fin.setAnnee(this.getAnnee()); break;
			case 11: date_fin.setMois(12);date_fin.setAnnee(this.getAnnee()); break;
			case 12: date_fin.setMois(1);date_fin.setAnnee(this.getAnnee()+1); break;
			}
		}
		
		return date_fin;
		
		
	}
	
	//method qui compare une date a une autre, retourne -1 si inferieur, 0 si egale et 1 si superieur
	public int compareTo(date d)
	{
		 if(this.annee<d.annee)
		 {return -1 ;}
		 if(this.annee>d.annee)
		 {return 1 ;}
		 
		 
		 if(this.mois<d.mois)
		 	{return -1;}
		 if(this.mois>d.mois)
			{return 1 ;} 
			 
		 if(this.jour<d.jour)
		 {return -1 ;}
		 if(this.jour>d.jour)
		 {return 1 ;}
			 
			 
		 return 0;

	}
	
	//setters and getters
	
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
}
