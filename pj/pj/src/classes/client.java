package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import classes.adresse.ville;
import classes.numero.etat;;

public class client {
	//attributs
	private numero num = new numero();
	private abonnement ab;
	private String num_contrat;
	private date date_contrat = new date();;
	private String nom, prenom, email;
	private adresse ad = new adresse();
	private int n ;
	private Vector<bonus> b = new Vector<bonus>();
	enum typec {libre,  forfaitaire, prepaye;}
	private typec t ;
	private Vector<numero> nb = new Vector<numero>();
	private Vector<numero> rappel = new Vector<numero>();
	private Vector<libre> facture = new Vector<libre>();

	//constructor
	public client() {}
	
	
	public client(String s, abonnement ab,typec t,  String num_contrat, int j , int m , int a, String nom, String prenom,
			String email, int nr, String nomr, ville v, int n, Vector<numero> nb2, Vector<numero> rappel,
			Vector<libre> facture) {
		super();
		this.num = new numero(s);
		this.ab = ab;
		this.t= t;
		this.num_contrat = num_contrat;
		this.date_contrat = new date(j,m,a);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.ad = new adresse(nr, nomr, v);
		this.n = n;
		this.b = b;
		this.nb = nb2;
		this.rappel = rappel;
		this.facture = facture;
	}


	//method remplir qui sert a remplir un objet de type client
	client remplir()  {
		Scanner s = new Scanner(System.in);
		this.num.remplir();
		System.out.println("veuillez choisir un type d'abonnement :1- libre,2-  forfaitaire,3- prepaye "); 
		switch(s.nextInt()) {
		case  1 :this.ab = new libre().remplir(); this.t = t.valueOf("libre") ; break;
		case 2 :this.ab= new forfaitaire().remplir(); this.t = t.valueOf("forfaitaire") ;  break;
		case 3: this.ab= new prepaye().remplir(); this.t = t.valueOf("prepaye") ; break;
		default : this.remplir();break;
		}
		System.out.println("darte de contrat: \t");
		this.date_contrat.remplir();
		System.out.println("numero de contrat: \t");
		this.num_contrat = s.next();
		System.out.println("nom :\t");
		this.nom = s.next();
		System.out.println("prenom :\t");
		this.prenom = s.next();
		s.nextLine();
		System.out.println("email:\t");
		this.email = s.nextLine();
		this.ad.remplir();
		return this;
	}
	
	
	void afficher() {
		System.out.println(this.toString());
	}
	//method toString redefinie
	@Override
	public String toString() {
		return "\n \t client: \n numero =" + num + "\n abonnemnet= " + ab.toString() + "\n num_contrat=" + num_contrat + "\n date_contrat=" + date_contrat
				+ "\n nom=" + nom + "\n prenom=" + prenom + "\n email=" + email + "\n adresse=" + ad  + "\n bonus=" + n ;
	}
	
	//method appel qui sert a afficher "solde insuffisant" si le client n'a pas un solde insuffisant pour effectuer un appel 
	//sortant selon le type d'abonnement de client
	void appel() throws Exception {
		this.ab.appel();
	}
	//method appel qui sert a afficher "solde insuffisant" si le client n'a pas un solde insuffisant pour envoyer un message 
	//le type d'abonnement de client
	void sms() throws Exception {
		this.ab.sms();
	}
	
	//method qui sert a effecter un bonus a un client 
	void bonus() {
		//on utilise un vector pour sauvegarder tous les bounus effecter a un client 
		bonus b = new bonus().remplir();
		this.b.add(b);
		n = n+1;
		
	}
	
	//method qui sert a modifier l'adresse ou debloquer un numero 
	client modifier() {
		System.out.println(" 1- modifier l'adresse \n 2- debloquer le nemuro");
		Scanner s = new Scanner(System.in);
		switch(s.nextInt()) {
		case 1 :this.ad = this.ad.remplir(); break;
		case 2: this.num.setE(etat.non_bloque);break;
		}
		return this;
	}
		
	 //method qui bloque un client et enregistre la date et le motif du blockage
	 void bloque(date d) {
		 date d1 = d;
		 this.num.bloque();
	 }
	 
	 //method qui sert a envoyer un message pour informer un client pour recharger/payer sa facture
	 void rappel(date d){
		 if (this.echeance(d)) {
			 System.out.println("Cher client " + this.getNum().getS() + ", vous devez payer votre facture ou recharger votre abonnement" );
		 }
	 }	
	 
	 //method pour sauvegarder tous appels entrant ou sortant et leur duree cumulee dans un vector 
	 void appels() {
		 Iterator<appel> i = this.ab.getAp().iterator();
		 while(i.hasNext()) {
			 System.out.println(i.next() + "\n" );
		 }
		 this.ab.getDuree_cumulee();
	 }
	 
	//method pour sauvegarder toutes les sms dans un vector 
	 void messages() {
		 Iterator<sms> i2 = this.ab.getSms().iterator();
		 while(i2.hasNext()) {
			 System.out.println(i2.next() + "\n" );
		 }
	 }
	 
	//method pour sauvegarder toutes les bonus dans un vector 
	 void bonuses() {
		 Iterator<bonus> i3 = this.b.iterator();
		 while(i3.hasNext()) {
			 System.out.println(i3.next() + "\n");
		 }
	 }
	 
	 //method pour etablir une facture a numero donnee de type libre
	 void facture () {
			 if (this.t.equals(typec.libre)) {
			((libre) this.getAb()).facture();
			facture.add((libre) (this.ab));}}
			

	 //method pour verifier si un numero a arrive a une echeance du paiement ou non selon le type d'abonnement
	 boolean echeance (date d){
try {
		if (this.t== t.libre && ((libre) this.ab).est_payee() == false && d.compareTo(this.ab.getDate_deb().date_limite(0)) >= 0) 
			return true; 
		else if (this.t == t.forfaitaire && d.compareTo(this.ab.getDate_deb().date_limite(3)) >= 0)
			return true; 
		  return false;
}
catch (Exception e) {
	return false;
}
	 }

	 //method pour payer une facture etablie a un numero de type libre
	 void paiement() {
		 ((libre)ab).payer();
	 }
	 
	 //setters and getters
	public numero getNum() {
		return num;
	}
	public void setNum(numero num) {
		this.num = num;
	}
	public abonnement getAb() {
		return ab;
	}
	public void setAb(abonnement ab) {
		this.ab = ab;
	}
	public String getNum_contrat() {
		return num_contrat;
	}
	public void setNum_contrat(String num_contrat) {
		this.num_contrat = num_contrat;
	}
	public date getDate_contrat() {
		return date_contrat;
	}
	public void setDate_contrat(date date_contrat) {
		this.date_contrat = date_contrat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public adresse getAd() {
		return ad;
	}
	public void setAd(adresse ad) {
		this.ad = ad;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Vector<bonus> getB() {
		return b;
	}
	public void setB(Vector<bonus> b) {
		this.b = b;
	}
	public typec getT() {
		return t;
	}
	public void setT(typec t) {
		this.t = t;
	}
	
	public Vector<numero> getRappel() {
		return rappel;
	}
	public void setRappel(Vector<numero> rappel) {
		this.rappel = rappel;
	}
	public Vector<libre> getFacture() {
		return facture;
	}
	public void setFacture(Vector<libre> facture) {
		this.facture = facture;
	}


	public Vector<numero> getNb() {
		return nb;
	}


	public void setNb(Vector<numero> nb) {
		this.nb = nb;
	}


	 
}
