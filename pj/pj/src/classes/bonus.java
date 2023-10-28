package classes;

import java.util.Scanner;

public class bonus {
	//attributs
	enum categorie{  nombre_heures (2), nombre_SMS (30), solde_additionnel (200) , no_bonus(0);
	    private int bonus ; 
		private categorie () {}
		private categorie (int bonus) {
			this.bonus = bonus;
		}		
		}
	private categorie cat ;
	private date d_limite = new date();

	//constructors
	public bonus() {}
	public bonus(categorie cat, int j , int m, int a) {
		super();
		this.cat = cat;
		this.d_limite = new date(j, m, a);
	
	}

	//methods
	//method pour remplir un objet de type bonus
	bonus remplir(){
		 Scanner s = new Scanner(System.in);
		 System.out.println("categorie (1)nombre_heures; (2)nombre_SMS ; (3)solde_additionnel");
    	 this.cat = null;
 		switch (s.nextInt())
 		{
 			case 1 : this.cat= cat.valueOf("nombre_heures"); break;
 			case 2: this.cat= cat.valueOf("nombre_SMS"); break;
 			case 3 : this.cat =cat.valueOf("solde_additionnel"); break;
 			default : this.cat =cat.valueOf("no_bonus"); break;
 		}

 		System.out.println("date limite de validite:");
 		this.d_limite.remplir();
		return this;
	}

	//method toString redefinie
	@Override
	public String toString() {
		return " bonus: \t" + "\n categorie: \t" + cat + "\n valide jusqu'a : \t " + d_limite ;
	}

	void afficher()  {
		System.out.println(this.toString());
	}
	
	//method qui rendre la date de repris d'un bonus
	void repris (date d) {
		if( this.d_limite.toString().equals(d.toString()) ) 
		this.setCat(cat.no_bonus);
	}
	//method qui sert a diminuer le nombre de bonus a chaque consomation
	void consomation() {
		if (this.cat.bonus != 0 )
			this.cat.bonus= this.cat.bonus - 1;
	}


	//setters and getters
	public categorie getCat() {
		return cat;
	}


	public void setCat(categorie cat) {
		this.cat = cat;
	}


	public date getD_limite() {
		return d_limite;
	}


	public void setD_limite(date d_limite) {
		this.d_limite = d_limite;
	}
	

}
