package classes;

import java.util.Scanner;
import classes.client.typec;
import classes.libre.etat_f;
import classes.point_vente.type;
import java.util.Vector;

import classes.adresse.ville;
import classes.carte_recharge.etat;
//le programme principale
public class pj_prog {
	static operateur op;
	//
	static Vector<bonus> b = new Vector<bonus>();
	static Vector<numero> nb = new Vector<numero>();
	static Vector<numero> rappel = new Vector<numero>();
	static Vector<libre> facture = new Vector<libre>();
	static Vector<appel> ap = new Vector<appel>();
	static Vector<sms> sms= new Vector<sms>();
	//
	public static void m() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Ajouter un point de vente \n ");
		System.out.println("2- Modifier un point de vente \n ");
		System.out.println("3- Supprimer un point de vente \n ");
		System.out.println("4- Changer un pourcentage pour une wilaya \n ");
		System.out.println("5- Afficher l'oprateur \n ");
		System.out.println("6- Quitter \n");
		switch(s.nextInt()) {
		case 1: op.ajouter_pv();m();break;
		case 2: System.out.println("vueillez saisir le numero de point de vente que vous voullez modifier");
		numero n = new numero().remplir();
			op.modifier_pv(n);
			m();
			break;
		case 3: System.out.println("vueillez saisir le numero de point de vente que vous voullez supprimer");
		numero n1 = new numero().remplir();
		     op.supprimer_pv(n1);
		     m();break;
		case 4: System.out.println("vueillez saisir le numero de point de vente et la wilaya");
		numero n2 = new numero().remplir();
		System.out.println("wilaya:");
		wilaya w = wilaya.valueOf(s.next());
		op.changer_pc(w);
		m();
		break;
		case 5: op.afficher();
		m();
		break;
		case 6:
			break;
		}
		Menu();
		
		
	}
	
	public static void m1() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Ajouter numéro \n ");
		System.out.println("2- Modifier numéro (modifier adresse, débloquer) \n ");
		System.out.println("3- Supprimer numéro \n ");
		System.out.println("4- Afficher la collection des clients par type d’abonnement \n ");
		System.out.println("5- Bloquer un numero \n ");
		System.out.println("6- Afficher la liste des numeros bloquees \n ");
		System.out.println("7- La liste des clients par wilaya \n ");
		System.out.println("8- Recherche d’un numéro donné et afficher ses informations \n ");
		System.out.println("9- Effectuer une appel \n ");
		System.out.println("10- Envoye un SMS \n ");
		System.out.println("11- Recherche d’un numéro donné et afficher les appels entrants et sortants et les durées cumulées\n ");
		System.out.println("12- Recherche d’un numéro donné et afficher les SMS \n ");
		System.out.println("13- Quitter");
		switch(s.nextInt()) {
		case 1: op.ajouter_cl();
		m1();break;
		case 2: 
			System.out.println("vueillez saisir le numero que vous voullez modifier");
			numero n = new numero().remplir();
			op.modifier_num(n);
			m1(); break;
			
		case 3:System.out.println("vueillez saisir le numero que vous voullez supprimer");
	    numero n1 = new numero().remplir();
	    op.supprimer_num(n1);
	   m1(); break;
	case 4: op.collection();
	m1();
	break;
	case 5: System.out.println("vueillez saisir le numero que vous voullez bloquer");
    numero n2 = new numero().remplir();
    op.bloquer(n2);
    m1();
    break;
	case 6: op.liste_bloc();
	m1();
	break;
	case 7: op.wilaya();
	m1();
	break;
	case 8: System.out.println("vueillez saisir le numero que vous voullez rechercher");
    numero n3 = new numero().remplir();
		op.rechercher_num(n3);
		m1();
		break;
	case 9:System.out.println("vueillez saisir un numero pour faire l'operation");
    numero n4 = new numero().remplir();
    op.appel(n4);
    m1();
    break;
	case 10: System.out.println("vueillez saisir un numero pour faire l'operation");
    numero n5 = new numero().remplir();
    op.sms(n5);
    m1();
    break;
	case 11:System.out.println("vueillez saisir un numero pour faire l'operation");
    numero n6 = new numero().remplir();
    op.appels(n6);
    m1();
    break;
	case 12: System.out.println("vueillez saisir un numero pour faire l'operation");
    numero n7 = new numero().remplir();
    op.messages(n7);
    m1();
    break;
	case 13: break;
    }
			Menu();
	}
	
	public static void m2() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Etablir facture pour un numéro donné \n");
		System.out.println("2- Afficher tous les numéros arrivés à échéance de paiement \n");
		System.out.println("3- Toutes les factures en instance de paiement \n");
		System.out.println("4- Relancer les numéros pour les rechargements/ paiements \n ");
		System.out.println("5- Quitter");
		switch(s.nextInt()) {
		case 1: System.out.println("vueillez saisir le numero");
	    numero n2 = new numero().remplir();
	    op.facture(n2);
	    m2();
	    break;
		case 2: op.echeance(new date().remplir());
		m2();
			break;
		case 3: op.facture();
		m2();
		break;
		case 4: op.relancer(new date().remplir());
		m2();
		break;
		case 5: break;}
		Menu();
	}
	
	public static void m3() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Affecter bonus à des clients \n");
		System.out.println("2- Afficher les clients ayant bénéficié de bonus \n");
		System.out.println("3- Quitter \n");
		switch(s.nextInt()) {
		case 1: System.out.println("vueillez saisir le numero");
	    numero n3 = new numero().remplir();
			op.bonus(n3);
			m3();
			break;
		case 2: op.beneficier();
		m3();
		break;
		case 3: break;
		}
		Menu();
	}
	
	public static void Menu() throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Remplissage automatique des données \n ");
		System.out.println("2- Gestion de l’opérateur \n");
		System.out.println("3- Gestion des clients (numéros) \n");
		System.out.println("4- Gestion des factures \n");
		System.out.println("5- Gestion des bonus \n");
		System.out.println("6- Quitter");
		switch(s.nextInt()) {
		case 1: //op.remplir()
			point_vente p = new point_vente("babez phone",type.principale, 12, "bab ezzouar", ville.Alger, "0512345678");
			point_vente p1 = new point_vente("setif phone",type.secondaire, 12, "kharta", ville.Setif, "0512345679");
			point_vente p2 = new point_vente("wahran phone",type.principale, 12, "eddarb", ville.Oran, "0512345677");
			point_vente p3 = new point_vente("bona phone",type.secondaire, 12, "seraidi", ville.Annaba, "0512345676");
			point_vente p4 = new point_vente("sahara phone",type.principale, 12, "ouargla", ville.Ouargla, "0512345675");
			point_vente p5 = new point_vente("constatine phone",type.secondaire, 12, "certa", ville.Constantine, "0512345674");
			carte_recharge cr = new  carte_recharge("12345678901234", 12, 3, 2022, 100, etat.active);
			carte_recharge cr1 = new  carte_recharge("098765432109876", 31, 5, 2022, 200, etat.active);
			abonnement ab = new libre(200, 12 , 3, 2022 , ap, sms, 0,etat_f.non_paye);
			abonnement ab1 = new forfaitaire(200, 12 , 3, 2022 , ap, sms, 0, 100);
			abonnement ab2 = new prepaye(200, 12 , 3, 2022 , ap, sms, 0, cr, 200);
			abonnement ab3 = new libre(200, 31 , 5, 2022 , ap, sms, 0, etat_f.non_paye);
			abonnement ab4 = new forfaitaire(200, 31 , 5, 2022 , ap, sms, 0, 100);
			abonnement ab5 = new prepaye(200, 31 , 5, 2022 , ap, sms, 0, cr1, 200);
			abonnement ab6 = new forfaitaire(200, 1 , 6, 2022 , ap, sms, 0, 100);
			abonnement ab7 = new libre(200, 1 , 6, 2022 , ap, sms, 0,etat_f.non_paye);
			client c = new  client("0520190001", ab, typec.libre, "1", 12 , 3 , 2022, "BOUSSAI", "MOHAMED","BOUSSAI@gmail.com", 1, "rue1", ville.Alger, 0,  nb, rappel, facture);
			client c1 = new  client("0520190002", ab1, typec.forfaitaire, "2", 12 , 3 , 2022, "BRAHIMI", "SOUAD","BRAHIMI@gmail.com", 2, "rue2", ville.Setif, 0,  nb, rappel, facture);
			client c2 = new  client("0520190003", ab2, typec.prepaye, "3", 12 , 3 , 2022, "LAMA", "SAID","LAMA@gmail.com", 3, "rue3", ville.Oran, 0,  nb, rappel, facture);
			client c3 = new  client("0520000001", ab3, typec.libre, "4", 31 , 5 , 2022, "HAROUNI ", "AMINE","HAROUNI @gmail.com", 3, "rue4", ville.Annaba, 0,  nb, rappel, facture);
			client c4 = new  client("0519990011", ab4, typec.forfaitaire, "5", 31 , 5 , 2022, "FATHI", "OMAR","FATHI@gmail.com", 3, "rue5", ville.Ouargla, 0,  nb, rappel, facture);
			client c5= new  client("0519980078", ab5, typec.prepaye, "6", 31 , 5 , 2022, "BOUZIDANE", "FARAH","BOUZIDANE@gmail.com", 3, "rue6", ville.Constantine, 0,  nb, rappel, facture);
			client c6= new  client("0520170015", ab6, typec.forfaitaire, "7", 1 , 6 , 2022, "ARABI", "ZOUBIDA","ARABI@gmail.com", 3, "rue7", ville.Alger, 0,  nb, rappel, facture);
			client c7= new  client("0520190002", ab6, typec.libre, "8", 1 , 6 , 2022, "CHAID", "LAMIA","CHAID@gmail.com", 3, "rue8", ville.Alger, 0,  nb, rappel, facture);
			op = new operateur("ooredoo" , p, c);
			op.ajouter(p1, c1);
			op.ajouter(p2, c2);
			op.ajouter(p3, c3);
			op.ajouter(p4, c4);
			op.ajouter(p5, c5);
			op.ajouter(p, c6);
			op.ajouter(p, c7);
			
		;Menu();break;
		case 2: m();break;
		case 3: m1();break;
		case 4:m2(); break;
		case 5:m3(); break;
		case 6: break;
		}
		
	}
	
	
	
	public static void main (String [] args) throws Exception {
	Menu();
	}

}
