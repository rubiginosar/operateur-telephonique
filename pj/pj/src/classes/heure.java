package classes;

import java.util.Scanner;

public class heure {
	//attributs
	    private int heure; 
		private int minute; 
		private int seconde;

	//constructors
		public heure(int heure, int minute, int seconde) {
			super();
			this.heure = heure;
			this.minute = minute;
			this.seconde = seconde;
		}

		public heure() {}

		//methods
		//method qui sert a remplir un objet du type heure
		heure remplir() {
			Scanner s = new Scanner(System.in);
			System.out.println("heure:");
			this.heure = s.nextInt();
			System.out.println("minute:");
			this.minute = s.nextInt();
			System.out.println("seconde:");
			this.seconde = s.nextInt();
			return this;
		}

		//method toString redefinie
		@Override
		public String toString() {
			return "heure:" + heure + ":" + minute + ":" + seconde ;
		}
		 void afficher() {
			 System.out.println(this.toString());
		 }
		 
		 //method qui calcule la duree entre 2 heures
		 heure duree ( heure h ) {
			 this.heure = h.heure - this.heure;
			 this.minute = h.minute - this.minute;
			 this.seconde = h.seconde - this.seconde;
			 return this;
		 }
		 
		 //method qui transfert une heure a une duree
		 int to_duree() {
			return this.heure*60 + this.minute;
		 }
		 
		//method qui transfert une duree a une heure
		 heure to_heure(int a) {
			 heure h = new heure();
			 h.setHeure(a/60);
			 a= a%60;
			 h.setMinute(a);
			 h.setSeconde(0);
			 return h;
		 }

		 //setters and getters
		public int getHeure() {
			return heure;
		}

		public void setHeure(int heure) {
			this.heure = heure;
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		public int getSeconde() {
			return seconde;
		}

		public void setSeconde(int seconde) {
			this.seconde = seconde;
		}
		

	}

