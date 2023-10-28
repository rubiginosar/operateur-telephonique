package classes;

import java.util.Scanner;
import java.util.Vector;

public class libre extends abonnement{
	//attributs
	private final int duree = 2;
	private int nbr_appel;
	private float montant_app;
	private int nbr_sms;
	private float montant_sms;
	private int dc;
	enum etat_f { paye, non_paye;}
	private etat_f e;

	//constructor
	public libre() {}
	
	
	public libre(float solde, int j , int m , int a , Vector<classes.appel> ap, Vector<classes.sms> sms,
			int duree_cumulee, etat_f e) {
		super(solde, j , m , a , ap , sms, duree_cumulee);
		this.e= e;
	}


	//methods
	//method qui sert a remplir un objet du type libre
	libre remplir() {
		super.remplir();
		this.nbr_appel= this.getNbr_appel();
        this.nbr_sms= this.getNbr_sms();
		this.montant_app= this.getMontant_app();
        this.montant_sms = this.getMontant_sms();
        this.e = e.valueOf("non_paye");
		return this;
	}
	
	//method qui calcule le montant
	float montant() {
		return this.getMontant_app()+ this.getMontant_sms() +500 ;
	}
	//method qui calcule la tva (19% du montant de appels+ sms+ prix fixe)
	float tva() {
		return(this.montant()*19)/100;
	}
	
	//method qui calcule le montant de la facture
	float montant_facture() {
		return (this.montant()+ this.tva());
	}
	
	//method toString redefinie
	public String toString() {
		return "libre \n" + " nombre d'appels=" + this.nbr_appel + "\n nombre de sms=" + this.nbr_sms + "\n montant facture=" + this.montant_facture() +"DZD" + "\n etat:"+ e;
	}
	
	//method qui affiche la facture
	void facture() {
		System.out.println(this.toString());
	}
	
	//method qui sert a payer une facture
	void payer() {
		this.setE(e.paye);
		this.facture();
	}
	
	//method qui verifie si la facture est payee ou non
	boolean est_payee() {
		if (this.getE().equals(e.non_paye ) || this.getE().equals(null))
			return false;
		else return true;
	}
	
	//method qui sert a effectuer un appel ou recevoir un appel et calculer la duree cumulee de chaque appel
    //et calcule le nombre des appels
	@Override
	void appel() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- appel sortant 2- appel entrant");
		switch(s.nextInt()) {
		case 1:
			emis e = new emis().remplir();
			this.nbr_appel = this.nbr_appel + 1;
			this.montant_app = this.montant_app + e.montant_appel();
			super.getAp().add(e);
			this.dc= e.duree_cumule(e.getH());
			super.setDuree_cumulee(dc+this.dc);
		    break;
		case 2 : reçu r = new reçu();
			super.getAp().add(r.remplir());
			this.dc= r.duree_cumule(r.getH());
			super.setDuree_cumulee(dc+this.dc);
			break;
		}
		
	}

	//method qui sert a envoyer un messsage et calculer le nombre des sms envoyes
	@Override
	void sms() throws Exception {
		sms sm = new sms().remplir();
		this.nbr_sms = this.nbr_sms + 1;
		this.montant_sms = this.montant_sms + 5;
		super.getSms().add(sm);
		
	}
	
	//setters and getters
	public int getNbr_appel() {
		return nbr_appel;
	}
	public void setNbr_appel(int nbr_appel) {
		this.nbr_appel = nbr_appel;
	}
	public float getMontant_app() {
		return montant_app;
	}
	public void setMontant_app(float montant_app) {
		this.montant_app = montant_app;
	}
	public int getNbr_sms() {
		return nbr_sms;
	}
	public void setNbr_sms(int nbr_sms) {
		this.nbr_sms = nbr_sms;
	}
	public float getMontant_sms() {
		return montant_sms;
	}
	public void setMontant_sms(float montant_sms) {
		this.montant_sms = montant_sms;
	}
	public int getDc() {
		return dc;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public etat_f getE() {
		return e;
	}
	public void setE(etat_f e) {
		this.e = e;
	}
	public int getDuree() {
		return duree;
	}
	
}