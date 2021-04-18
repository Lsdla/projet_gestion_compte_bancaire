package fr.groupe5.compte_bancaire.dao;

import java.util.List;

import fr.groupe5.compte_bancaire.entity.Operations;



public interface OperationsDao {
	
	
public void insert(Operations operation);
	
	public List<Operations> getAll(int numerocompte);
	
	public Operations getById(int id);
	
	public void update(Operations operation);
	
	public void delete(Operations operation);
	

}
