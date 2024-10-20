package allumettes;

public class StrategieRapide implements Strategie {

    
    @Override
    public int getPrise(Jeu jeu){
        if (jeu.getNombreAllumettes() == 2) {
            return 2;
        } else if (jeu.getNombreAllumettes() == 1) {
            return 1;
        } else {
            return jeu.PRISE_MAX;
        }
    }
}
