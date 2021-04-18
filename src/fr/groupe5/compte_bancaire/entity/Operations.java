package fr.groupe5.compte_bancaire.entity;

import java.sql.Date;

public class Operations {

	
	private int numerooperation;
	private int numerocompte;
	private java.sql.Date dateoperation;  // utiliser le type "java.sql.Date" pour se connecter avec la BDD.
	private String libelleoperation;
	private float montant;
	private String typeoperation;
	
	
	public Operations() {
		super();
		// TODO Auto-generated constructor stub 
		
		// sert à mettre une date réelle pour chaque opération 
		
		this.dateoperation = new Date(System.currentTimeMillis());
		
	}
	
	
	public int getNumerooperation() {
		return numerooperation;
	}
	public void setNumerooperation(int numerooperation) {
		this.numerooperation = numerooperation;
	}
	public int getNumerocompte() {
		return numerocompte;
	}
	public void setNumerocompte(int numerocompte) {
		this.numerocompte = numerocompte;
	}
	
	public Date getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	
	public String getLibelleoperation() {
		return libelleoperation;
	}
	public void setLibelleoperation(String libelleoperation) {
		this.libelleoperation = libelleoperation;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getTypeoperation() {
		return typeoperation;
	}
	public void setTypeoperation(String typeoperation) {
		this.typeoperation = typeoperation;
	}
	
	
	@Override
	public String toString() {
		return "Operations numerooperation = " + numerooperation + ", numerocompte = " + numerocompte
				+ ", dateoperation = " + dateoperation + ", libelleoperation = " + libelleoperation + ", montant = " + montant
				+ ", typeoperation = " + typeoperation + "]";
	}
	
	
	
	
}
