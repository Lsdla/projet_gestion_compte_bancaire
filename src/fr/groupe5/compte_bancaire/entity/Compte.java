package fr.groupe5.compte_bancaire.entity;

public class Compte {

	private int numerocompte;
	private String codetypecompte;
	private int codetitulaire;
	private float soldecompte;
	
	
	public int getNumerocompte() {
		return numerocompte;
	}
	public void setNumerocompte(int numerocompte) {
		this.numerocompte = numerocompte;
	}
	public String getCodetypecompte() {
		return codetypecompte;
	}
	public void setCodetypecompte(String codetypecompte) {
		this.codetypecompte = codetypecompte;
	}
	public int getCodetitulaire() {
		return codetitulaire;
	}
	public void setCodetitulaire(int codetitulaire) {
		this.codetitulaire = codetitulaire;
	}
	public float getSoldecompte() {
		return soldecompte;
	}
	public void setSoldecompte(float soldecompte) {
		this.soldecompte = soldecompte;
	}
	
	
	@Override
	public String toString() {
		return "Compte [numerocompte = " + numerocompte + ", codetypecompte = " + codetypecompte + ", codetitulaire = "
				+ codetitulaire + ", soldecompte = " + soldecompte + "]";
	}
	
	
	
	
}
