package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Equipement;
import personnages.Musee;

public class Scenario {
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 8);
		Romain minus = new Romain("Minus", 6);
//		Romain m1 = new Romain("Mus", 2);
//		Romain m2 = new Romain("Mis", 1);
//		Romain m3 = new Romain("Mas", 1);
		
		panoramix.parler("Je vais aller préparer une petite potion");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
//		m1.sEquiper(Equipement.CASQUE);
//		m2.sEquiper(Equipement.BOUCLIER);
//		m3.sEquiper(Equipement.CASQUE);
//		m3.sEquiper(Equipement.BOUCLIER);
//		minus.parler("UN GAU... UN GAUGAU...");
//		while (minus.getForce() > 0) {
//			asterix.frapper(minus);
//		}
//		while (m1.getForce() > 0) {
//			asterix.frapper(m1);
//		}
//		while (m3.getForce() > 0) {
//			asterix.frapper(m3);
//		}
//		while (m2.getForce() > 0) {
//			asterix.frapper(m2);
//		}
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);
//		musee.extraireInstructionsCaml();
	}

}
