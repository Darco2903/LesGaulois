package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		if (force <= 0) throw new AssertionError("la force d’un Romain est toujours positive");
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		if (force <= 0) throw new AssertionError("la force d'un Romain est positive");
		int forceAssert = force;
		force -= forceCoup;
		if (force >= forceAssert) throw new AssertionError("la force d’un Romain n'a pas diminué");
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("minus", 1);
	}
};