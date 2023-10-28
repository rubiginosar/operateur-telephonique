package classes;

import java.util.Scanner;
import java.util.Vector;

public abstract class abonnement {
	//attributs
	private float solde;
	private date date_deb = new date();
	private Vector <appel> ap = new Vector <appel> ();
	private Vector <sms> sms = new Vector <sms>();
	private int duree_cumulee;
	
	//constructor
	public abonnement() {} 
	
	public abonnement(float solde, int j , int m , int a , Vector<classes.appel> ap, Vector<classes.sms> sms,
			int duree_cumulee) {
		super();
		this.solde = solde;
		this.date_deb = new date (j,m,a);
		this.ap = ap;
		this.sms = sms;
		this.duree_cumulee = duree_cumulee;
	}

	//methods
	
	//method remplir pour remplir un objet de type abonnement
	abonnement remplir() {
		System.out.println("la date de debut d'abonnement: ");
		this.date_deb.remplir();
		return this;
	}
	//method toString redefinie
	@Override
	public String toString() {
		return "abonnement [solde=" + solde + ", date_deb=" + date_deb + "]";
	}
	void afficher() {
		System.out.println(this.toString());
	}
	//abstract methods parce que on va definie les codes dans les classes filles
	abstract void appel() throws Exception;
	abstract void sms() throws Exception;
	
	//setters and getters
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public date getDate_deb() {
		return date_deb;
	}
	public void setDate_deb(date date_deb) {
		this.date_deb = date_deb;
	}
	public Vector<appel> getAp() {
		return ap;
	}
	public void setAp(Vector<appel> ap) {
		this.ap = ap;
	}
	public Vector<sms> getSms() {
		return sms;
	}
	public void setSms(Vector<sms> sms) {
		this.sms = sms;
	}
	public int getDuree_cumulee() {
		return duree_cumulee;
	}
	public void setDuree_cumulee(int duree_cumulee) {
		this.duree_cumulee = duree_cumulee;
	}
	

}
