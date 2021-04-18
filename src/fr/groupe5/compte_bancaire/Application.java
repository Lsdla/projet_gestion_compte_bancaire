package fr.groupe5.compte_bancaire;




import fr.groupe5.compte_bancaire.dao.OperationsDao;
import fr.groupe5.compte_bancaire.dao.TitulaireDao;
import fr.groupe5.compte_bancaire.dao.impl.OperationsDaoImpl;
import fr.groupe5.compte_bancaire.dao.impl.TitulaireDaoImpl;
import fr.groupe5.compte_bancaire.entity.Operations;
import fr.groupe5.compte_bancaire.entity.Titulaire;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TitulaireDao TitulaireDto = new TitulaireDaoImpl();
		
		Titulaire titulaire1 = new Titulaire();
		
		//*********************************  application de la méthode insrt ******************************
		
		titulaire1.setPrenomtitulaire("bamba");
		titulaire1.setNomtitulaire("kharrat");
		titulaire1.setAdressetitulaire("13 Rue Sevran Montfermeille");
		titulaire1.setCodepostaltitulaire(93290);
		
//		ligne suivante à decommenter pour faire fonctionner la requête à appliquer à l'objet titulaire1.
		
//		TitulaireDto.insert(titulaire1);
		
		//*********************************  application de la méthode update ******************************
		
		titulaire1.setPrenomtitulaire("James");
		titulaire1.setNomtitulaire("Wafi");
		titulaire1.setAdressetitulaire("19 Bd Amazon Montfermeille");
		titulaire1.setCodepostaltitulaire(75008);
		titulaire1.setCodetitulaire(11);
		
//		ligne suivante à decommenter pour faire fonctionner la requête à appliquer à l'objet titulaire1.
		
//		TitulaireDto.update(titulaire1);
		
		//*********************************  application de la méthode delete ******************************
		
		
		// ligne suivante à decommenter pour faire fonctionner la requête à appliquer à l'objet titulaire1.
		
//		titulaire1.setCodetitulaire(11);
		
//		TitulaireDto.delete(titulaire1);
		
		//*********************************  application de la méthode getById ******************************
		
		System.out.println("\n\n======================== Liste des titulaires ==========================\n");
		
		for (Titulaire titulaire : TitulaireDto.getAll()) {	System.out.println(titulaire);	}
		
		
		System.out.println("\n\n====================== Un Titulaire ============================\n");
		
		System.out.println("\nTitulaire du compte : ");
		
		// pour une meilleure lecture du code il vaut mieux stocker dans une variable 
		
		Titulaire titulaire2 = TitulaireDto.getById(10);
				
		System.out.println(titulaire2);
		
		//======================================================= table opération ==============================================
		
		
		OperationsDao OperationsDto = new OperationsDaoImpl();
		
		Operations operation1 = new Operations();
		
		//*********************************  application de la méthode Insert à la table operations ******************************
		
		operation1.setNumerocompte(10007);
		operation1.setLibelleoperation("VIREMENT");
		operation1.setMontant(90.70f);
		operation1.setTypeoperation("V");
		
		// ligne suivante à decommenter pour faire fonctionner la requête à appliquer à l'objet titulaire1.
		
//		 OperationsDto.insert(operation1);
		
		//*********************************  application de la méthode Update à la table operations ******************************
		

		operation1.setLibelleoperation("Dépôt");
		operation1.setMontant(900.70f);
		operation1.setTypeoperation("D");
		operation1.setNumerooperation(11);
		
		// ligne suivante à decommenter pour faire fonctionner la requête à appliquer à l'objet titulaire1.
		
//		OperationsDto.update(operation1);
		
		System.out.println("\n\n======================== Liste des opérations ==========================\n");
		
		for (Operations operation : OperationsDto.getAll(10007)) {	System.out.println(operation);	}

	}

}
