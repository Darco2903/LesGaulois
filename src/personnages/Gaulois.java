package personnages;

public class Gaulois {
	public static String nom;
	private static int force;
	private int effetPotion = 1;
	
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

	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	
	public static void main(String[] args) {
		//Gaulois asterix = new Gaulois(nom = "Astérix", force = 8);
		//asterix.boirePotion(6);
		//Romain minus = new Romain(nom = "Minus", force = 6);
		//System.out.println(asterix);
		//asterix.prendreParole();
		//asterix.parler("Bonjour à tous");
		//asterix.frapper(minus);
	}
};