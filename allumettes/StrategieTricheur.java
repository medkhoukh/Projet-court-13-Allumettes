package allumettes;

import java.util.InputMismatchException;
import java.util.Scanner;


public class StrategieTricheur implements Strategie {


    public int getPrise( Jeu jeu ) {
        System.out.println("[Je triche...]");
        
        try {
            while (jeu.getNombreAllumettes() > 2) {
                jeu.retirer(1);
            }
            
        } catch (CoupInvalideException e) {
        }

        System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");

        return 1;
    }
}