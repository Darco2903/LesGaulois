package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nbTrophees++) {
			trophees[nbTrophees] = tropheesBataille[i];
		}
	}
	

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees == 0) return;
		String texte = "Je donne au musée tous mes trophées :"; 
		for (int i=0; i < nbTrophees; i++) {
			Equipement trophee = trophees[i];
			musee.donnerTrophees(this, trophee);
			texte += "\n- " + trophee;
		}
		
		parler(texte);
	}
	
}