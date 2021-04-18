# projet_gestion_compte_bancaire


Travail à réaliser :

Mettre en place la base de données « banque » sous MySQL.
Écrire les classes de connexion à la base de données.
Utiliser JDBC (avec ou sans le pattern DAO).
Écrire une classe contenant les méthodes permettant les actions suivantes :
Créer, lire, modifier et supprimer un titulaire, un type de compte et un compte.
Lister des opérations pour un compte sélectionné.
Enregistrer une opération sur un compte (Dépôt ou retrait)
Remplissez vos tables avec Mockaroo ou autres pour effectuer des tests.
Mettre votre travail sur votre Git


Contexte du projet

Règles de gestion

Un Compte est associé à un et un seul Titulaire

Un **Titulaire **peut avoir plusieurs Comptes Un Compte correspond à un seul Type de compte Un Compte peut avoir aucune ou plusieurs Opérations Type de Compte (compte courant, PEL, CEL,...)

Un Titulaire est identifié par un code autoincrémenté, un prénom, un nom, une adresse et un code postal.

Un **Compte **possède un numéro unique (longueur 5) et est associé à une et un seul Type de compte, il appartient à un et un seul Titulaire. Il possède un solde qui est mis à jour après chaque opération ou virement le concernant.

Une **Opération **est associée à un Compte, elle possède un numéro d'ordre autogénéré, une date, un libellé, le montant de l'opération et le type de transaction (retrait, dépôt) représentée par un caractère + ou - ou un code au choix.

Un Type de compte est identifié par un code auto-généré et possède un intitulé.

**Bonus **: Pour ceux et/ou celles qui sont à l’aise, ajouter la fonctionnalité pour effectuer un virement bancaire d'un compte vers un autre compte en vérifiant que le solde du compte à débiter est suffisant pour effectuer la transaction.

​

Une Opération de virement d'un Compte à un autre Compte doit se faire si et seulement si le compte débiteur a un solde suffisant. Si ce n'est pas le cas, la transaction ne pourra pas se réaliser et un message d'alerte doit s'afficher. Il faut donc gérer des exceptions. (prendre l’exemple du cours)