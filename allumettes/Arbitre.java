package allumettes;

public class Arbitre {
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean confiant;

    public Arbitre( Joueur joueur1, Joueur joueur2 ) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    public void setConfiant( int premierArgument ) {
        if (premierArgument == 1) {
            this.confiant = true;
        } else {
            this.confiant = false;
        }
    }
    public void arbitrer( Jeu jeu ) {
        boolean jeuFini = false;
        Joueur joueur = this.joueur1;

        while (!jeuFini) {
            boolean nbreValide = false;
            
            while (!nbreValide){
                try {
                    System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
                    Jeu jeuProcuration;
                    
                    //si le jeu est lancé sans l'option -confiant, on utilisera la classe JeuProxy qui détectera la triche
                    if (this.confiant==false){
                        jeuProcuration = new JeuProxy(jeu);
                    
                    //sinon on utilisera la classe Jeu basique et on ne pourra pas détecter la triche
                    }else{
                        jeuProcuration = jeu;
                    }
        
                    int nbPrises = joueur.getPrise( jeuProcuration );
                    System.out.println( joueur.getNom() + " prend " + nbPrises + (nbPrises > 1 ? " allumettes." : " allumette." ) );
                    jeu.retirer(nbPrises);
                    nbreValide = true;
                    System.out.println();
                } catch( OperationInterditeException e){
                    System.out.println( "Abandon de la partie car "+joueur.getNom()+" triche !" );
                    System.exit( 1 );
                }
                 catch (CoupInvalideException e) {
                    System.out.println( "Impossible ! Nombre invalide : "+ e.getCoup()+" "+e.getProbleme() );
                    System.out.println();
                    
                }
            }

              //changer de joueur courant
              //si le joueur courant est joueur 1, le joueur courant devient joueur 2 au tour suivant et vis verça

            if ( joueur == this.joueur1 ) {
                joueur = this.joueur2;
            } else {
                joueur = this.joueur1;
            }
 

            //si le jeu se termine, càd si le nombre d'allumettes est de 0
            //il faudra voir qui est le dernier joueur à avoir pris des allumettes
            //le dernier joueur à prendre des allumettes perd
            if ( jeu.getNombreAllumettes() == 0 ) {
                jeuFini = true;
                System.out.println();
                if ( joueur == this.joueur1 ) {
                    System.out.println( this.joueur2.getNom() + " perd !" );
                } else {
                    System.out.println( this.joueur1.getNom() + " perd !" );
                }
                System.out.println( joueur.getNom() + " gagne !" );
            }
    }
}
        }
    


