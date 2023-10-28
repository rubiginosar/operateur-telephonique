package classes;

import java.util.Scanner;

import classes.numero.etat;

public class emis extends appel{
	//attributs
	private numero destinataire = new numero();
	enum tarif { sein (4), autre (5) , etranger (20);
		private int tarif_uni; 
		private tarif() {};
		private tarif(int tarif_uni) {
			this.tarif_uni= tarif_uni;
		}
	}
	private tarif tarif;
	private float montant;
	
	//constructors
	public emis() {}

	public emis(int j, int m, int a, int h, int min, int sec, int duree, numero destinataire, classes.emis.tarif tarif,
			float montant) {
		super(j, m, a, h, min, sec, duree);
		this.destinataire = destinataire;
		this.tarif = tarif;
		this.montant = montant;
	}

	//methods
	//method qui sert a remplir un objet de type emis
	public emis remplir() {
		this.destinataire.remplir();
		Scanner s = new Scanner(System.in);
		System.out.println("type d'appel:");
		this.tarif = null;
		switch (s.nextLine())
		{
			case "sein" :this.tarif = tarif.valueOf("sein");break;
			case "autre" : this.tarif = tarif.valueOf("autre");break;
			case "etranger" : this.tarif = tarif.valueOf("etranger"); break;
			default : System.out.println ( " vueillez saisir le type d'appele"); break;

		}
		super.remplir();
		return this;
	}
	
	//method qui calcule le monant d'un appel selon la duree et le type d'appel
	float montant_appel() {
		montant =super.getDuree() * this.getTarif().tarif_uni;
		return montant;
	}
	

	//method toString redefinie
	@Override
	public String toString() {
		return "un appel sortant" + "\n destinataire=" + destinataire + "\n" + super.toString()+ "\n montant= \t" + this.montant_appel() + "DZD";
	}
	
	void afficher() {
		 System.out.println(this.toString());
	 }

	//setters and getters 
	public numero getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(numero destinataire) {
		this.destinataire = destinataire;
	}

	public tarif getTarif() {
		return tarif;
	}
	

	public void setTarif(tarif tarif) {
		this.tarif = tarif;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	
}
