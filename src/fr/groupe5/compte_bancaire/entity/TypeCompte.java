package fr.groupe5.compte_bancaire.entity;

public class TypeCompte {
	
	// dans le cas de variable identiques d'une classe à une autre et dans le même package, est ce qu'il faut les déclarer à chaque fois 

	
		private String codetypecompte; 
		private String intitulecompte;
		
		
		public String getCodetypecompte() {
			return codetypecompte;
		}
		public void setCodetypecompte(String codetypecompte) {
			this.codetypecompte = codetypecompte;
		}
		public String getIntitulecompte() {
			return intitulecompte;
		}
		public void setIntitulecompte(String intitulecompte) {
			this.intitulecompte = intitulecompte;
		}
		
		
		@Override
		public String toString() {
			return "TypeCompte [codetypecompte = " + codetypecompte + ", intitulecompte = " + intitulecompte + "]";
		}
}
