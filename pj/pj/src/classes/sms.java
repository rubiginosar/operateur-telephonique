package classes;

import java.util.Scanner;

public class sms {
	//attributs
	private numero num_ex= new numero();
    private numero num_dest= new numero();
    private date d_envoi = new date();
    private heure h = new heure();
    enum statut{ envoye, reçu, echec;}
    private statut stat;
    private String texte; 
    
    //constructors
    public sms() {}

	public sms(String s1, String s2, int j , int m, int a, int hr, int min, int sec, statut stat, String texte) {
		super();
		this.num_ex = new numero(s1);
		this.num_dest = new numero(s2);
		this.d_envoi = new date(j, m , a);
		this.h = new heure (hr, min, sec);
		this.stat = stat;
		this.texte = texte;
	}
	
	//methods
	//method qui sert a remplir un objet du type sms
    sms remplir(){
    	 System.out.println("expediteur");
    	 this.num_ex.remplir();
    	 System.out.println("desinataire");
    	 this.num_dest.remplir();
    	 this.d_envoi.remplir();
    	 this.h.remplir();
    	 System.out.println("statut");
    	 Scanner s = new Scanner(System.in);
    	 this.stat = null;
 		switch (s.nextLine())
 		{
 			case "envoye" : this.stat= stat.valueOf("envoye"); break;
 			case "reçu" : this.stat= stat.valueOf("reçu"); break;
 			case "echec" : this.stat =stat.valueOf("echec"); break;
 			default : this.stat =stat.valueOf("echec"); break;
 		}
 		System.out.println("message:");
 		this.texte= s.nextLine();
    	 return this;
     }

    //method toString redefinie
	@Override
	public String toString() {
		return " from: \t" + num_ex + "\n to: \t " + num_dest + "\n" + texte + "\n" + stat + "\n" + d_envoi + "\n" + h; 
	}
	
	void afficher() {
		System.out.println(this.toString());
	}

	//setters and getters
	
	public numero getNum_ex() {
		return num_ex;
	}

	public void setNum_ex(numero num_ex) {
		this.num_ex = num_ex;
	}

	public numero getNum_dest() {
		return num_dest;
	}

	public void setNum_dest(numero num_dest) {
		this.num_dest = num_dest;
	}

	public date getD_envoi() {
		return d_envoi;
	}

	public void setD_envoi(date d_envoi) {
		this.d_envoi = d_envoi;
	}

	public heure getH() {
		return h;
	}

	public void setH(heure h) {
		this.h = h;
	}

	public statut getStat() {
		return stat;
	}

	public void setStat(statut stat) {
		this.stat = stat;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
}
