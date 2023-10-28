package classes;

import java.util.Scanner;
import java.util.Vector;

import classes.carte_recharge.etat;

public class prepaye extends abonnement{
	//attributs
	private carte_recharge cr = new carte_recharge();
	private float solde;
	private Integer dc;

	//constructors
	public prepaye() {}
	public prepaye(float solde1, int j , int m , int a , Vector<classes.appel> ap, Vector<classes.sms> sms,
			int duree_cumulee,carte_recharge cr, float solde) {
		super(solde1, j , m , a , ap , sms, duree_cumulee);
		this.cr = cr;
		this.solde = solde;
	}

	//methods
	//method qui sert a remplir un objet du type prepaye
	prepaye remplir () {
		super.remplir();
		Scanner s = new Scanner(System.in);
		this.cr = cr.remplir();
		this.solde= cr.getMontant();
		super.setSolde(this.solde);
		return this;
	}
	
	//method qui sert a recharger une carte en ajoutant le montant ou solde initial et d'enregistrer la date d'activation de la carte
	void recharge () {
		date d = new date();
		super.setDate_deb(d.remplir());
		cr= new carte_recharge().remplir();
		solde = solde+ cr.getMontant();
		super.setSolde(solde);
		cr.setE(etat.active);
	}

	//method toString redefinie
	@Override
	public String toString() {
		return "prepaye [ solde=" + solde + "DZD ,date  d'activation=" + super.getDate_deb() + "]";
	}

	void afficher() {
		System.out.println(this.toString());
	}
	
	//method qui sert a effectuer un appel apres la verification si le solde est nul ou pas
	@Override
	void appel() throws Exception {
		 Scanner s = new Scanner(System.in);
			System.out.println("1- appel sortant 2- appel entrant");
			switch(s.nextInt()) {
			case 1:
				emis e = new emis().remplir();
				if (e.montant_appel() <= this.solde) {
				super.getAp().add(e); 
				this.solde = this.solde - e.montant_appel();
				this.dc= e.duree_cumule(e.getH());
				super.setDuree_cumulee(dc+this.dc);
			}  else throw new Exception(" Solde insuffisant");
			break;
			case 2 : reçu r = new reçu();
				super.getAp().add(r.remplir());
				this.dc= r.duree_cumule(r.getH());
				super.setDuree_cumulee(dc+this.dc);
				break;
			}
	}
	
	//method qui sert a envoyer un message apres verification du solde
	@Override
	void sms() throws Exception {
		sms sm = new sms().remplir();
		if ( this.solde >= 5) {
			super.getSms().add(sm); 
			this.solde = this.solde - 5;
		}  else throw new Exception(" Solde insuffisant");
	}
	
	//setters and getters 
	public carte_recharge getCr() {
		return cr;
	}
	public void setCr(carte_recharge cr) {
		this.cr = cr;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public Integer getDc() {
		return dc;
	}
	public void setDc(Integer dc) {
		this.dc = dc;
	}
	
}
