package fr.groupe5.compte_bancaire.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.groupe5.compte_bancaire.config.DataBaseConnection;
import fr.groupe5.compte_bancaire.dao.OperationsDao;
import fr.groupe5.compte_bancaire.entity.Operations;


public class OperationsDaoImpl implements OperationsDao {
	
	private Connection connection;
	
	public OperationsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			this.connection = DataBaseConnection
							.getInstance()
							.getConnection();				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	

	@Override
	public void insert(Operations operation) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement instruction = this.connection.prepareStatement("insert into operations (numerocompte, dateoperation, libelleoperation, montant, typeoperation) VALUES (?, ?, ?, ?, ?)");
			// comme on a mis l'id en auto-incremente l'instruction number one n'est nécessaire.
			// Attention au moment de décommenter l'instruction number one; il faut changer les numéros. 
			
			//instruction.setInt(1, operation.getCodeoperation());
			instruction.setInt(1, operation.getNumerocompte());
			
			instruction.setDate(2, operation.getDateoperation());
			instruction.setString(3, operation.getLibelleoperation());
			instruction.setFloat(4, operation.getMontant());
			instruction.setString(5, operation.getTypeoperation());
			
			instruction.execute();
			instruction.close();
			//connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Operations> getAll(int numerocompte) {
		// TODO Auto-generated method stub
		
		List<Operations>  operations = new ArrayList<Operations>();
		String requete	= "SELECT * FROM operations where numerocompte = ? order by dateoperation desc";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(requete);
			
			statement.setInt(1, numerocompte);
			ResultSet resultat = statement.executeQuery();		
			
			while(resultat.next()){
				
				Operations operation = new Operations();
				
				operation.setNumerooperation(resultat.getInt("numerooperation"));
				operation.setNumerocompte(resultat.getInt("numerocompte"));
				operation.setDateoperation(resultat.getDate("dateoperation"));
				operation.setMontant(resultat.getFloat("montant"));
				operation.setLibelleoperation(resultat.getString("libelleoperation"));
				operation.setTypeoperation(resultat.getString("typeoperation"));
				operations.add(operation);
				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operations;
		
	}

	@Override
	public Operations getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Operations operation) {
		// TODO Auto-generated method stub
		
		try {
			
			PreparedStatement instruction = this.connection.prepareStatement("update operations set dateoperation = ?, libelleoperation = ?, montant = ?, typeoperation = ? where numerooperation = ?");
			
			instruction.setDate(1, operation.getDateoperation());
			instruction.setString(2, operation.getLibelleoperation());
			instruction.setFloat(3, operation.getMontant());
			instruction.setString(4, operation.getTypeoperation());
			instruction.setInt(5, operation.getNumerooperation());
			
			instruction.execute();
			instruction.close();
			//connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Operations operation) {
		// TODO Auto-generated method stub
		
	}

}
