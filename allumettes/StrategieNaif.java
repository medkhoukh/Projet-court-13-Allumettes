package allumettes;

import java.util.Random;

public class StrategieNaif implements Strategie {
    @Override
    public int getPrise(Jeu jeu){
        if ( jeu.getNombreAllumettes() > 2 ){
            return new Random().nextInt( Jeu.PRISE_MAX ) + 1;
    }
        else if (jeu.getNombreAllumettes()==2){
            return new Random().nextInt( Jeu.PRISE_MAX );
        }
        return 1;
}
}