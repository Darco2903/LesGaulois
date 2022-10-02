package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {
	static String nom;
	static int force;
	static int effetPotionMax;
	static int effetPotionMin;
	
	public static void main(String[] args) {
		Druide panoramix = new Druide(nom = "Panoramix", effetPotionMin = 5, effetPotionMax = 10);
		Gaulois asterix = new Gaulois(nom = "Astérix", force = 8);
		Gaulois obelix = new Gaulois(nom = "Obélix", force = 8);
		Romain minus = new Romain(nom = "Minus", force = 6);
		
		panoramix.parler("Je vais aller préparer une petite potion");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		while (minus.getForce() > 0) {
			asterix.frapper(minus);
		}
	}

};
