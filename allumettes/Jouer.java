package allumettes;

import javax.naming.ConfigurationException;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {
	



	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments( args  );
		    int PremierArgument = verifierConfiant(args);
			JouerMain( args , PremierArgument);
		}

		


		catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}

	}
	/**fonction qui crée un joueur à partir du nom et de la strategie recupérées dans la ligne de commande . */
	public static Joueur CreationJoueur( String nom , Strategie strategie ){
		return new Joueur( nom , strategie );
	}

	/**methode qui retourne la position du premier arguement . */
	private static int verifierConfiant(String[] args) {
	
		if (args[0].equals("-confiant")){	
			return 1;
		}else {
			return 0;
		}
	}


    /** methode principale qui permet de lancer le jeu . */
	private static void JouerMain( String[] args , int PremierArgument ) throws ConfigurationException{

		int secondArgument = PremierArgument + 1;
		SujetJeu jeuMain = new SujetJeu();
		String[] J1 = MethodeSplit( args, PremierArgument ) ;
		String[] J2 = MethodeSplit( args, secondArgument ) ;
		
		Joueur joueur1 = CreationJoueur( J1[ 0 ] , ObtenirStrategie( J1[ 1 ] , J1[ 0 ] ));
		Joueur joueur2 = CreationJoueur( J2[ 0 ] , ObtenirStrategie( J2[ 1 ] , J2[ 0 ] ));

		Arbitre arbitreJeu = new Arbitre(joueur1, joueur2);
		arbitreJeu.setConfiant(PremierArgument);
		arbitreJeu.arbitrer(jeuMain);
	}


	private static void verifierNombreArguments(String[] args ) throws ConfigurationException {
		final int nbJoueurs = 2;
		if ( args.length  < nbJoueurs ) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs +1 ) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}
	
	/** Recuperer le type de strategie entrée en argument . */
	public static Strategie ObtenirStrategie(String strategieString, String Joueur ) throws ConfigurationException{

		if (strategieString.equals("humain")){
			return new StrategieHumain(Joueur);
		}
		else if (strategieString.equals("naif")){
			return new StrategieNaif();
		}
		else if (strategieString.equals("expert")){
			return new StrategieExpert();
		}
		else if (strategieString.equals("rapide")){
			return new StrategieRapide();
		
		}
		else if (strategieString.equals("tricheur")){
			return new StrategieTricheur();
		}else{
		 throw new ConfigurationException(" strategie non valide !");}
	
	}
    /** methode pour diviser les arguments de la ligne de commande en 2.
     *la partie avant @ est le nom du joueur.
     *la partie après @ est la strategie du joueur.
     *si @ n'existe pas ou si l'une des parties est vide on throw ConfigurationException.
     */
	public static String[] MethodeSplit(String[] args , int indiceArgument ) throws ConfigurationException{
		String[] resultat = args[ indiceArgument ].split("@") ;
	    if (resultat.length != 2 || resultat[0].length() == 0) {
        throw new ConfigurationException("Le format n'est pas respecté");
        } else {
            return resultat;
        }

	}
}
