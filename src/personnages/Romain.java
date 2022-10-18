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
		
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++ ;
		afficherInfo("s'équipe avec un " + equipement);
	}
	
	public void sEquiper(Equipement equipement) {
		
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
	
//	public void recevoirCoup(int forceCoup) {
//		if (force <= 0) throw new AssertionError("la force d'un Romain est positive");
//		int forceAssert = force;
//		force -= forceCoup;
//		if (force >= forceAssert) throw new AssertionError("la force d’un Romain n'a pas diminué");
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		if (force < 0) throw new AssertionError("La force du Romain est négative");
//		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
//		assert force < oldForce;
		if (force >= oldForce) throw new AssertionError("La force est supérieur ou égale à la force antérieure");
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup > resistanceEquipement) forceCoup -= resistanceEquipement;
		else forceCoup = 0;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("minus", 1);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	
}