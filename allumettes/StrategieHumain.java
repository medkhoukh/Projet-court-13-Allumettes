package allumettes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StrategieHumain implements Strategie {
    private String nomJoueur;
    private static final Scanner scanner = new Scanner(System.in);

    public StrategieHumain(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    @Override
    public int getPrise(Jeu jeu) {
        int nbrePrise = 0;
        boolean saisieValide = false;

        while (!saisieValide) {
            System.out.print(this.nomJoueur + ", combien d'allumettes ? ");
            String entree = scanner.nextLine();

            try {
                nbrePrise = Integer.parseInt(entree);
                saisieValide = true;
            } catch (NumberFormatException e) {
                if (entree.equals("triche")) {
                    try {
                        jeu.retirer(1);
                        System.out.println("[Une allumette en moins, plus que " + jeu.getNombreAllumettes() + ". Chut !]");
                    } catch (CoupInvalideException e2) {
                    }
                } else {
                    System.out.println("Vous devez donner un entier.");
                }
            }
        }

        return nbrePrise;
    }
}