package allumettes;

public class StrategieExpert implements Strategie {

    @Override
    public int getPrise(Jeu jeu) {
        int prise;
    
        if (jeu.getNombreAllumettes() == 1) {
            prise = 1;
        } else {
            int allumettes = (jeu.getNombreAllumettes() - 1) % (Jeu.PRISE_MAX + 1) + 1;
            if (allumettes == 1) {
                prise = 0;
            } else {
                prise = allumettes - 1;
            }
        }
    
        return prise;
    }
}