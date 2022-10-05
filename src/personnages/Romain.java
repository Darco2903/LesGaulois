package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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
	
	private void afficherInfo(String text) {
		System.out.println("Le soldat " + nom + " " + text);
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
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++ ;
		afficherInfo("s'équipe avec un " + equipement);
	}
	
	private void sEquiper(Equipement equipement) {
		
		switch (nbEquipement) {
			case 2: 
				afficherInfo("est déjà bien protégé !");
				break;
				
			case 1:
				if (equipements[0] != equipement) ajouterEquipement(equipement);
				else afficherInfo("possède déjà un " + equipement + " !");
				break;
			
			case 0:
				ajouterEquipement(equipement);
				break;
				
			default:
				throw new IllegalArgumentException("Erreur nombre équipement: " + nbEquipement);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("minus", 1);
		//System.out.println(Equipement.BOUCLIER);
		//System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		}
};