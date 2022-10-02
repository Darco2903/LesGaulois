package personnages;

import java.util.Iterator;
import java.util.Random;

public class Druide {
	private static String nom;
	private static int effetPotionMin;
	private static int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random = new Random();
		int forcePotion = random.nextInt(effetPotionMax - effetPotionMin);
		forcePotion += effetPotionMin;
		
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force " + forcePotion);			
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.nom == "Obélix") {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		//Druide panoramix = new Druide(nom = "Panoramix", effetPotionMin = 5, effetPotionMax = 10);
		//panoramix.preparerPotion();
	}
	
}
