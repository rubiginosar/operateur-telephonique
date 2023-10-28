package classes;



public class re�u extends appel{
	//attributs
	private numero appelant = new numero();

	//constructors
	public re�u(int j, int m, int a, int h, int min, int sec, int duree, numero appelant) {
		super(j, m, a, h, min, sec, duree);
		this.appelant = appelant;
	}

	public re�u() {}

	//methods
	//method qui sert a remplir un objet du type re�u
	re�u remplir() {
		this.appelant = appelant.remplir();
		super.remplir();
		return this ;
	}

	//method toSring redefinie
	@Override
	public String toString() {
		return "un appel re�u" + "\n appelant= " + appelant + "\n" + super.toString();
	}
	
	void afficher() {
		System.out.println(this.toString());

	}
	
	//setters and getters

	public numero getAppelant() {
		return appelant;
	}

	public void setAppelant(numero appelant) {
		this.appelant = appelant;
	}
	
	
	
}
