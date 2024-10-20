package allumettes;

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Joueur {
    
    private Strategie strategieJoueur;
    private String nom; 

    public String getNom() {
        return this.nom;
    }
    public Strategie getStrategie(){
        return this.strategieJoueur;
    }
    public Joueur(String nom, Strategie strategie){
        this.nom = nom;
        this.strategieJoueur = strategie;
    }
    
    public  int getPrise(Jeu jeu) {
        
        return this.strategieJoueur.getPrise(jeu);
    }

}
	
