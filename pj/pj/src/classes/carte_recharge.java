package classes;

import java.util.Scanner;

public class carte_recharge {
	//attributs
	private String num_serie = "^[0-9]{14}$";
	private date validite = new date();
	private float montant; 
    public enum etat { active, non_active;}
    private etat e;
    
    //constructors
    public carte_recharge(String num_serie, int jour, int mois, int annee, float montant, etat e) {
		this.num_serie= num_serie;
		this.validite= new date(jour, mois, annee);
		this.montant= montant;
		this.e= e; 
	}
  
	public carte_recharge() {};
	
//methods 
	//method qui sert a remplir un objet de type carte_recharge
	public carte_recharge remplir() {
		Scanner s = new Scanner(System.in);
		System.out.println("numero de serie sur 14 caracteres:\t");
		this.num_serie= s.next();
		this.validite= validite.remplir();
		System.out.println("montant:\t");
		this.montant= s.nextFloat();
		s.nextLine();
		System.out.println("etat:");
		this.e = null;
		switch (s.nextLine())
		{
			case "active" : this.e = e.valueOf("active"); break;
			case "non_active" : this.e = e.valueOf("non_active"); break;
			default :this.e = e.valueOf("non_active"); break;
		}
		return this;
	}

	//method toString redefinie
	public String toString () {
		return " numero de serie:\t" + num_serie + "\n date de validite:\t" + validite.toString() + "\n montant : \t" + montant +"DZD" + "\n etat: \t" + e;	}
	
	void afficher() {
    	System.out.println(this.toString());
    }

	//setters and getters
	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public date getValidite() {
		return validite;
	}

	public void setValidite(date validite) {
		this.validite = validite;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public etat getE() {
		return e;
	}

	public void setE(etat e) {
		this.e = e;
	}

	
}
