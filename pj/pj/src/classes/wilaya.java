package classes;

import java.util.Scanner;

import classes.adresse.ville;


public enum wilaya {
	//attributs
	 Alger (0), Oran (0) ,Canstantine(0), Setif(0), Annaba(0), Ouargla(0);
	 private int pourcentage;
	 //constructors
	 private wilaya() {}
	 private wilaya(int pourcentage) {
			this.pourcentage = pourcentage;}

	 
	 //setters and getters 
	 public int getPourcentage() {
		 return pourcentage;
		}
		public void setPourcentage(int pourcentage) {
			this.pourcentage = pourcentage;
		}
		
		//une method qui sert a effectuer un pourcentage a une wilaya
		static void remplir() {
			Scanner s = new Scanner(System.in);
			for (wilaya v : wilaya.values()) {
				System.out.println(v + ":");
				int r= s.nextInt();
				v.setPourcentage(r);
			}
		}
		
		//method d'affichage
	static void afficher() {
		for (wilaya value : wilaya.values()) {
			System.out.println(value);
			System.out.println(value.getPourcentage());
		}
	}
		
}
