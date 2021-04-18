package fr.groupe5.compte_bancaire.dao;

import java.util.List;

import fr.groupe5.compte_bancaire.entity.TypeCompte;



public interface TypeCompteDao {
	
public void insert(TypeCompte typeCompte);
	
	public List<TypeCompte> getAll();
	
	public TypeCompte getById(int id);
	
	public void update(TypeCompte typeCompte);
	
	public void delete(TypeCompte typeCompte);

}
