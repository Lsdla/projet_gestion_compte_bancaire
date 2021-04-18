package fr.groupe5.compte_bancaire.entity;

public class Titulaire {
	
	private int codetitulaire;
	private String prenomtitulaire;
	private String nomtitulaire; 
	private String adressetitulaire; 
	private int codepostaltitulaire;
	
	
	public int getCodetitulaire() {
		return codetitulaire;
	}
	public void setCodetitulaire(int codetitulaire) {
		this.codetitulaire = codetitulaire;
	}
	public String getPrenomtitulaire() {
		return prenomtitulaire;
	}
	public void setPrenomtitulaire(String prenomtitulaire) {
		this.prenomtitulaire = prenomtitulaire;
	}
	public String getNomtitulaire() {
		return nomtitulaire;
	}
	public void setNomtitulaire(String nomtitulaire) {
		this.nomtitulaire = nomtitulaire;
	}
	public String getAdressetitulaire() {
		return adressetitulaire;
	}
	public void setAdressetitulaire(String adressetitulaire) {
		this.adressetitulaire = adressetitulaire;
	}
	public int getCodepostaltitulaire() {
		return codepostaltitulaire;
	}
	public void setCodepostaltitulaire(int codepostaltitulaire) {
		this.codepostaltitulaire = codepostaltitulaire;
	}
	
	
	@Override
	public String toString() {
		String str =  "Identifiant = " + codetitulaire+"\n"; 
		    str	+= "Prénom = " + prenomtitulaire + ", Nom = " + nomtitulaire+"\n";
		    str	+= "Adresse = " + adressetitulaire + ", Code Postal = " + codepostaltitulaire + ".\n";

		return str; 
	}
	
	
	
}
