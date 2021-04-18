package fr.groupe5.compte_bancaire.dao;

import java.util.List;

import fr.groupe5.compte_bancaire.entity.Compte;


public interface CompteDao {
	
	public void insert(Compte compte);
	
	public List<Compte> getAll();
	
	public Compte getById(int id);
	
	public void update(Compte compte);
	
	public void delete(Compte compte);
	

	

}
