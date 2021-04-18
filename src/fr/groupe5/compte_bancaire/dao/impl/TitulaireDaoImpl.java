package fr.groupe5.compte_bancaire.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.groupe5.compte_bancaire.config.DataBaseConnection;
import fr.groupe5.compte_bancaire.dao.TitulaireDao;
import fr.groupe5.compte_bancaire.entity.Titulaire;




public class TitulaireDaoImpl implements TitulaireDao {
	
	private Connection connection;

	public TitulaireDaoImpl() {
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
	public void insert(Titulaire titulaire) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement instruction = this.connection.prepareStatement("insert into titulaire (prenomtitulaire, nomtitulaire, adressetitulaire, codepostaltitulaire) VALUES (?, ?, ?, ?)");
			// comme on a mis l'id en auto-incremente l'instruction number one n'est nécessaire.
			// Attention au moment de décommenter l'instruction number one; il faut changer les numéros. 
			
			//instruction.setInt(1, titulaire.getCodetitulaire());
			instruction.setString(1, titulaire.getPrenomtitulaire());
			instruction.setString(2, titulaire.getNomtitulaire());
			instruction.setString(3, titulaire.getAdressetitulaire());
			instruction.setInt(4, titulaire.getCodepostaltitulaire());
			
			instruction.execute();
			instruction.close();
			//connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Titulaire> getAll() {
		// TODO Auto-generated method stub
		
		List<Titulaire>  titulaires = new ArrayList<Titulaire>();
		String requete	= "SELECT * FROM titulaire ORDER BY codetitulaire";
		
		try {
			ResultSet resultat = this.connection.createStatement().executeQuery(requete);
			while(resultat.next()){
				
				Titulaire titulaire = new Titulaire();
				
				titulaire.setCodetitulaire(resultat.getInt("codetitulaire"));
				titulaire.setPrenomtitulaire(resultat.getString("prenomtitulaire"));
				titulaire.setNomtitulaire(resultat.getString("nomtitulaire"));
				titulaire.setAdressetitulaire(resultat.getString("adressetitulaire"));
				titulaire.setCodepostaltitulaire(resultat.getInt("codepostaltitulaire"));
				titulaires.add(titulaire);
				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titulaires;
	}

	@Override
	public Titulaire getById(int id) {
		// TODO Auto-generated method stub
		
		Titulaire titulaire2 = new Titulaire();
		try {
			PreparedStatement instruction;
			instruction = this.connection.prepareStatement("SELECT * FROM titulaire WHERE codetitulaire = ?");
			instruction.setInt(1, id);
			ResultSet resultat = instruction.executeQuery();
			
			if(resultat.next()) {				
				titulaire2.setCodetitulaire(resultat.getInt("codetitulaire"));
				titulaire2.setPrenomtitulaire(resultat.getString("prenomtitulaire"));
				titulaire2.setNomtitulaire(resultat.getString("nomtitulaire"));
				titulaire2.setAdressetitulaire(resultat.getString("adressetitulaire"));
				titulaire2.setCodepostaltitulaire(resultat.getInt("codepostaltitulaire"));
				
				instruction.execute();
				instruction.close();
			//	connection.close(); faut t il rajouter ces trois lignes ici ou pas??? a voir avec phillipe ou denis. 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return titulaire2;
	}

	@Override
	public void update(Titulaire titulaire) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement instruction = this.connection.prepareStatement("update titulaire set prenomtitulaire = ?, nomtitulaire = ?, adressetitulaire = ?, codepostaltitulaire = ? where codetitulaire = ?");
			
			
			
			instruction.setString(1, titulaire.getPrenomtitulaire());
			instruction.setString(2, titulaire.getNomtitulaire());
			instruction.setString(3, titulaire.getAdressetitulaire());
			instruction.setInt(4, titulaire.getCodepostaltitulaire());
			instruction.setInt(5, titulaire.getCodetitulaire());
			
			instruction.execute();
			instruction.close();
			//connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Titulaire titulaire) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement instruction = this.connection.prepareStatement("delete from titulaire where codetitulaire = ?");
			
			// cette instruction permet de récuperer avec le getCodetitulaire le codetitulaire pour 
			// pouvoir le faire fonctionner dans l'application avec le setCodetitulaire.
			
			instruction.setInt(1, titulaire.getCodetitulaire());
			
			instruction.execute();
			instruction.close();
			//connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
