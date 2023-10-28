package classes;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import classes.adresse.ville;
import classes.client.typec;

public class operateur {
	//attributs
	private String nom ;
	private wilaya v;
	private Vector<Integer> pc = new Vector<Integer>();
	private Vector <point_vente> pv = new Vector <point_vente>();
	private Vector <client> cl = new Vector <client>();
	private Vector <client> libre = new Vector <client>();
	private Vector <client> forfaitaire = new Vector <client>();
	private Vector <client> prepaye = new Vector <client>();
	private Vector <client> bloque = new Vector <client>();
	private date d = new date();
	private ArrayList <client> Alger= new ArrayList <client>();
	private ArrayList <client> Oran= new ArrayList <client>();
	private ArrayList <client> Annaba= new ArrayList <client>();
	private ArrayList <client> Setif= new ArrayList <client>();
	private ArrayList <client> Constantine= new ArrayList <client>();
	private ArrayList <client> Ouargla= new ArrayList <client>();
	//constructor
	public operateur() {}
	public operateur(String nom,point_vente pvt, client client) {
		this.nom = nom;
	     pv.add(pvt);
	    cl.add(client);
	    wilaya.remplir();
	}

	//methods
	//method qui sert a remplir un objet du type operateur
	
	void ajouter (point_vente pvt, client client) {
	     pv.add(pvt);
	    cl.add(client);
	}
	
	operateur remplir(){
		System.out.println("vueillez saisir un nom:");
		Scanner s = new Scanner(System.in);
		this.nom = s.nextLine();
		System.out.println("combien de point de vente vous voullez?");
		int l = s.nextInt();
		for (int i = 0 ; i <l; i ++) {
			point_vente p = new point_vente().remplir();
			this.pv.add(p);
		}
		System.out.println("pourcentage de couverture par wilaya:");
	    wilaya.remplir();
		System.out.println("combien de point de client vous voullez?");
		int m = s.nextInt();
		for (int i = 0 ; i <m; i ++) {
			client c = new client().remplir();
			this.cl.add(c);
		}
		return this;
		
		
	}
	//method qui sert a bloquer un certain numero 
	void bloquer(numero n) {
		//on boucle dans le vector pour trouver le numero,le bloquer et le ajouter dans 
		//le vector bloquer
		for (client c : cl) {
			if (c.getNum().equals(n)) {
				c.bloque(d);
				bloque.add(c);
			}
		}
	}
	
	//method qui affiche la liste des numeros bloquees
	void liste_bloc() {
		 Iterator<client> j = bloque.iterator();
		 while(j.hasNext()) {
			 System.out.println(j.next() + "\n" );
		 }
	}
	
	//method qui arrange les elements d'un vector client selon la wilaya dans des autres vectors puis les affiche
	//selon la wilaya
	void wilaya() {
		for( client array : cl ) {
		 switch (array.getAd().getVille().toString()) {
		 case "Alger": Alger.add(array);break;
		 case "Annaba": Annaba.add(array);break;
		 case "Oran": Oran.add(array);break;
		 case "Setif": Setif.add(array);break;
		 case "Ouargla": Ouargla.add(array);break;
		 case "Constantine": Constantine.add(array);break;
		 }
		}
		System.out.println("Alger: ");
		 Iterator<client> a = Alger.iterator();
		 while(a.hasNext()) {
			 System.out.println(a.next() + "\n" );
		 }
		 System.out.println("Annaba: ");
		 Iterator<client> a1 = Annaba.iterator();
		 while(a1.hasNext()) {
			 System.out.println(a1.next() + "\n" );
		 }
		 System.out.println("Oran: ");
		 Iterator<client> a2 = Oran.iterator();
		 while(a2.hasNext()) {
			 System.out.println(a2.next() + "\n" );
		 }
		 System.out.println("Setif: ");
		 Iterator<client> a3 = libre.iterator();
		 while(a3.hasNext()) {
			 System.out.println(a3.next() + "\n" );
		 }
		 System.out.println("Ouargla: ");
		 Iterator<client> a4 = Ouargla.iterator();
		 while(a4.hasNext()) {
			 System.out.println(a4.next() + "\n" );
		 }
		 System.out.println("Constantine: ");
		 Iterator<client> a5 = Constantine.iterator();
		 while(a5.hasNext()) {
			 System.out.println(a5.next() + "\n" );
		 }
	}
	
	//method qui cherche un numero dans un vector des clients et affiche ses infos
	void rechercher_num(numero n) {
			for( client array : cl ) {
				if ( array.getNum().equals(n) )
		            array.afficher();
		            }
	}
	
	//method qui sert a effectuer un appel
	void appel(numero n) throws Exception {
		for( client array : cl ) {
			if ( n.getS().equals( array.getNum().getS() ) )
	            array.appel();
	            }
	}
	
	//method qui sert a envoye un sms
	void sms(numero n) throws Exception {
		for( client array : cl ) {
			if ( n.getS().equals( array.getNum().getS() ) )
	            array.sms();
	            }
	}
	
	//method qui sert a afficher la liste des appels entrants et sortants d'un certain client
	void appels(numero n){
		for( client array : cl ) {
			if ( n.getS().equals( array.getNum().getS() ) )
	            array.appels();
	            }
	}
	
	//method qui sert a afficher la liste des sms d'un certain client
	void messages(numero n) {
		for( client array : cl ) {
			if ( n.getS().equals( array.getNum().getS() ) )
	            array.messages();
	            }
	}
	
	//method qui sert a ajouter un point du vente
	void ajouter_pv() {
		point_vente p = new point_vente().remplir();
		this.pv.add(p);
	}
	
	//method qui sert a supprimer un point du vente
	void supprimer_pv(numero n) {
		//on va recuperer tous les elements de vector point de vente dans un nouveau vector sauf l'element qu'on veut supprimer

		for(int i = 0; i<pv.size(); i++){
			if(pv.get(i).getNum().equals(n)){
				pv.remove(i);
				i--;
			}
		}
	}
	
	//method qui sert a ajouter un client
	void ajouter_cl() {
		client c = new client().remplir();
        this.cl.add(c);
	}
	
	//method qui sert a modifier un point de vente
	void modifier_pv(numero n) {
		for( point_vente array : pv ) {
			if(n.getS().equals( array.getNum().getS()))
	                array.modifier();
	            }
	        }
	
	//method qui sert a changer le pourcentage effectuer a une wilaya
	void changer_pc(wilaya w){
		Scanner s = new Scanner(System.in);
		//for( point_vente array : pv ) {
			//if (n.getS().equals( array.getNum().getS() ) ) {
		for (wilaya value : wilaya.values()) {
			if (value.equals(w)) {
				System.out.println(value + ":");
				value.setPourcentage(s.nextInt());
			//}
		//}		
		}
		}
	}
	
	//method qui sert a modifier un client
	void modifier_num(numero n) {
		for( client array : cl ) {
			if(  n.getS().equals( array.getNum().getS() ) )
	                array.modifier();
	            }
	        }

	//method qui sert a supprimer un client
	void supprimer_num(numero n) {
		for(int i = 0; i<cl.size(); i++){
			if(cl.get(i).getNum().equals(n)){
				cl.remove(i);
				i--;
			}
		}
	}
	
	//method qui sert a arranger les clients selon le type d'abonnement et les affichees
	void collection() {
		Vector <client> v = new Vector<client>();
		for( client array : cl ) {
			if (array.getT().equals(typec.libre))
				libre.add(array);
			else if (array.getT().equals(typec.forfaitaire))
				forfaitaire.add(array);
			else if (array.getT().equals(typec.prepaye))
				prepaye.add(array);
		}
		System.out.println("clients d'abonnement libre: ");
		 Iterator<client> i = libre.iterator();
		 while(i.hasNext()) {
			 System.out.println(i.next() + "\n" );
		 }
		 System.out.println("clients d'abonnement forfaitaire: ");
		 Iterator<client> i2 = forfaitaire.iterator();
		 while(i2.hasNext()) {
			 System.out.println(i2.next() + "\n" );
		 }
		 System.out.println("clients d'abonnement prepaye: ");
		 Iterator<client> i3 = prepaye.iterator();
		 while(i3.hasNext()) {
			 System.out.println(i3.next() + "\n" );
		 }
		
	}
	
	//method qui affiche le pourcentage selon la wilaya
	void afficher() {
		System.out.println(this.toString());
		System.out.println("pourcentage par wilaya:");
		wilaya.afficher();
	
	}
	
	//method qui sert a etablir une facture a un client
	void facture(numero n) {
		for( client array : cl ) {
			if(n.getS().equals( array.getNum().getS())) {
				array.facture();}
			
	}
	}
	
	//method qui sert a afficher les client qui ont une echeance du paiement
	void echeance(date d) {
		Vector <client> e = new Vector<client>();
		for( client array : cl ) {
			if (array.echeance(d))
				e.add(array);		
		}
		System.out.println("les clients arrivees a une echeance du paiement: ");
		 Iterator<client> i4 = e.iterator();
		 while(i4.hasNext()) {
			 System.out.println(i4.next() + "\n" );
		 }
		
	}
	
	//method qui sert a relancer les clients pour rechargements/paiements
	void relancer(date d) {
		for( client array : cl ) {
			if (array.echeance(d)) {
				array.rappel(d);
			}	
		}
	}
	
	//method qui sert a afficher toutes les factures a l'instant du paiement
	void facture() {
		for( client array : cl ) {
			try {
			array.paiement();
			System.out.println(array.getNum().getS() + "\n" );
			System.out.println("\n" );
			//System.out.println(array + "\n" );
		}catch(Exception e) {
		}
			
		}
	}
	
	//method qui sert a affecter un bonus a un client
	void bonus(numero n) {
		for( client array : cl ) {
			if (array.getNum().getS().equals(n.getS()))
				array.bonus();	
		}
		
	}
	
	//method qui sert a afficher les clients beneficies du bonus
	void beneficier() {
		Vector <client> b = new Vector<client>();
		for( client array : cl ){
			if (array.getN() > 0)
				b.add(array);
		}
		Iterator<client> i6 = b.iterator();
		 while(i6.hasNext()) {
			 System.out.println(i6.next() + "\n" );
		 }
	}
	
	void iterator() {
		Iterator<client> i7 = cl.iterator();
		 while(i7.hasNext()) {
			 System.out.println(i7.next() + "\n" );
		 }
	}
	//method toString redefinie
	@Override
	public String toString() {
		return "operateur: \n" + " nom: \t" + nom +  "\n point de ventes: \t" + pv + "\n clients: \t" + cl ;
	}
	
	//setters and getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public wilaya getV() {
		return v;
	}
	public void setV(wilaya v) {
		this.v = v;
	}
	public Vector<Integer> getPc() {
		return pc;
	}
	public void setPc(Vector<Integer> pc) {
		this.pc = pc;
	}
	public Vector<point_vente> getPv() {
		return pv;
	}
	public void setPv(Vector<point_vente> pv) {
		this.pv = pv;
	}
	public Vector<client> getCl() {
		return cl;
	}
	public void setCl(Vector<client> cl) {
		this.cl = cl;
	}

	public Vector<client> getLibre() {
		return libre;
	}

	public void setLibre(Vector<client> libre) {
		this.libre = libre;
	}

	public Vector<client> getForfaitaire() {
		return forfaitaire;
	}

	public void setForfaitaire(Vector<client> forfaitaire) {
		this.forfaitaire = forfaitaire;
	}

	public Vector<client> getPrepaye() {
		return prepaye;
	}

	public void setPrepaye(Vector<client> prepaye) {
		this.prepaye = prepaye;
	}

	public Vector<client> getBloque() {
		return bloque;
	}

	public void setBloque(Vector<client> bloque) {
		this.bloque = bloque;
	}

	public date getD() {
		return d;
	}

	public void setD(date d) {
		this.d = d;
	}

	public ArrayList<client> getAlger() {
		return Alger;
	}

	public void setAlger(ArrayList<client> alger) {
		Alger = alger;
	}

	public ArrayList<client> getOran() {
		return Oran;
	}

	public void setOran(ArrayList<client> oran) {
		Oran = oran;
	}

	public ArrayList<client> getAnnaba() {
		return Annaba;
	}

	public void setAnnaba(ArrayList<client> annaba) {
		Annaba = annaba;
	}

	public ArrayList<client> getSetif() {
		return Setif;
	}

	public void setSetif(ArrayList<client> setif) {
		Setif = setif;
	}

	public ArrayList<client> getConstantine() {
		return Constantine;
	}

	public void setConstantine(ArrayList<client> constantine) {
		Constantine = constantine;
	}

	public ArrayList<client> getOuargla() {
		return Ouargla;
	}

	public void setOuargla(ArrayList<client> ouargla) {
		Ouargla = ouargla;
	}
	
	}
