package classes;

import java.util.Scanner;
import java.util.Vector;

//une classe qui extends la methode abonenment, elle est caracterisee par une duree qui constante, un montant forfait est un 
//ensemble des appels entrants et sortants en presisant ses duree cumulees
public class forfaitaire extends abonnement{
	//attributs
	   private final int duree=2;
	   private float montant_forfait;
	   private emis e = new emis();
	   private reçu r = new reçu();
	   private int dc;


	  //constructors
	public forfaitaire(float solde, int j , int m , int a , Vector<classes.appel> ap, Vector<classes.sms> sms,
			int duree_cumulee,float montant_forfait) {
		super(solde, j , m , a , ap , sms, duree_cumulee);
		this.montant_forfait = montant_forfait;
	}

	public forfaitaire() {}
	  
	//methods
	//method qui sert a remplir un objet de type forfaitaire
	forfaitaire remplir () {
		   super.remplir();
		   Scanner s = new Scanner(System.in);
			System.out.println("solde:  ");
			this.montant_forfait= s.nextInt();
			super.setSolde(this.montant_forfait);
	   return this;
	   }
	   
	//method qui retourne si un abonnement est epuise ou non
			boolean date_epuise(date d) {
				if (super.getDate_deb().date_limite(3) == d)
					return true;
				else return false;
			}
	   
		//method toString redefinie
			@Override
			public String toString() {
				return "forfaitaire [duree=" + duree + ", solde=" + montant_forfait + "DZD ,valide jusq'a:" +super.getDate_deb().date_limite(3)+"]";
			}
			
			void afficher() {
				System.out.println(this.toString());
			}
			
//method qui verifie si le montant est suiffisant pour effectuer un appel si oui on calcule la duree cumulee et on diminue 
// le solde sinon on envoie un message d'erreur
			@Override
			void appel() throws Exception {
				 Scanner s = new Scanner(System.in);
					System.out.println("1- appel sortant 2- appel entrant");
					switch(s.nextInt()) {
					case 1:
						e.remplir();
						if (e.montant_appel() <= this.montant_forfait) {
						super.getAp().add(e); 
						this.dc= e.duree_cumule(e.getH());
						super.setDuree_cumulee(dc+this.dc);
						this.montant_forfait = this.montant_forfait - e.montant_appel();
					}  else throw new Exception(" Solde insuffisant");
					break;
					case 2 : super.getAp().add(r.remplir());
					this.dc= r.duree_cumule(r.getH());
					super.setDuree_cumulee(dc+this.dc);
						break;
					}
			}

//method qui verifie si le montant est suiffisant pour envoyer un sms si oui on calcule la duree cumulee et on diminue 
// le solde sinon on envoie un message d'erreur
			@Override
			void sms() throws Exception {
				sms sm = new sms().remplir();
				if ( this.montant_forfait >= 5) {
					super.getSms().add(sm); 
					this.montant_forfait = this.montant_forfait - 5;
				}  else throw new Exception(" Solde insuffisant");
			}
			
			//setters and getters
			public float getMontant_forfait() {
				return montant_forfait;
			}

			public void setMontant_forfait(float montant_forfait) {
				this.montant_forfait = montant_forfait;
			}

			public emis getE() {
				return e;
			}

			public void setE(emis e) {
				this.e = e;
			}

			public reçu getR() {
				return r;
			}

			public void setR(reçu r) {
				this.r = r;
			}

			public int getDc() {
				return dc;
			}

			public void setDc(int dc) {
				this.dc = dc;
			}

			public int getDuree() {
				return duree;
			}

			
}
