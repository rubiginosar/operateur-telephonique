package classes;

import java.util.Scanner;
public class adresse {
	//attributs
	private int numrue;
	private String nomrue;
	enum ville { Alger , Oran ,Constantine, Setif, Annaba, Ouargla;}
	private ville ville;
	
	//constructors
	public adresse(int numrue, String nomrue, ville ville) {
		this.numrue= numrue;
		this.nomrue= nomrue;
		this.ville= ville;
	}
	
	public adresse () {};
	
	//Methods
	//method pour remplir un objet de type adresse
	adresse remplir() {
		Scanner s = new Scanner(System.in);
		System.out.println("vueillez saisir votre adresse:\n");
		System.out.println("numero de rue:");
		this.numrue = s.nextInt();
		System.out.println("nom de la rue:");
		this.nomrue = s.next();
		s.nextLine();
		System.out.println("wilaya:");
		this.ville = null;
		switch (s.nextLine())
		{
			case "Alger" : this.ville = ville.valueOf("Alger"); break;
			case "Oran" : this.ville = ville.valueOf("Oran"); break;
			case "Constantine" : this.ville =ville.valueOf("Constantine"); break;
			case "Setif" : this.ville =ville.valueOf("Setif"); break;
			case "Annaba" : this.ville =ville.valueOf("Annaba"); break;
			case "Ouargla" : this.ville =ville.valueOf("Ouargla"); break;
			default :this.ville = ville.valueOf("Alger"); break;

		}
		return this ;
	}
	
	//method toString redefinie
    public  String toString() {
    	 return  numrue + ", rue " + nomrue + ", wilaya " +ville;
		
	}
	
    void afficher() {
    	System.out.println(this.toString());
    }

   //setters and getters
	public int getNumrue() {
		return numrue;
	}

	public void setNumrue(int numrue) {
		this.numrue = numrue;
	}

	public String getNomrue() {
		return nomrue;
	}

	public void setNomrue(String nomrue) {
		this.nomrue = nomrue;
	}

	public ville getVille() {
		return ville;
	}

	public void setVille(ville ville) {
		this.ville = ville;
	}
    
    
}
