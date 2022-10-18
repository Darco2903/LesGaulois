package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String texte = "let musee = [";
		
		for (int i=0 ; i<nbTrophee ; i++) {
			Trophee tr = trophees[i];
			texte += "\n	\"" + tr.donnerNom() + "\", \"" + tr.getEquipement() + "\";";
		}
		texte += "\n]";
		return texte;
	}
}
