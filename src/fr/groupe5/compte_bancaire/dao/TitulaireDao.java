package fr.groupe5.compte_bancaire.dao;

import java.util.List;

import fr.groupe5.compte_bancaire.entity.Titulaire;

// l'interface Dao permet d'inscrire les méthodes qu'on va implémenter dans le DaoImpl. ça permet de donner une visibilté aux méthides.

public interface TitulaireDao {
	
	public void insert(Titulaire titulaire);
	
	public List<Titulaire> getAll();
	
	public Titulaire getById(int id);
	
	public void update(Titulaire titulaire);
	
	public void delete(Titulaire titulaire);
	

	
	

}
