package allumettes;

public class SujetJeu implements Jeu{
    
    public static final int nbreInitial = 13;
    
    private int allumettesRestantes ;
    
    public SujetJeu(){
        this.allumettesRestantes=nbreInitial;
    }
    public SujetJeu( int nbreAllumettes ){
        this.allumettesRestantes=nbreAllumettes;
    }
    @Override
    public int getNombreAllumettes() {
        return this.allumettesRestantes;

    }
    @Override
    public void retirer (int nbPrises) throws CoupInvalideException{
        if (nbPrises> allumettesRestantes){
            throw new CoupInvalideException( nbPrises , "(> " + this.getNombreAllumettes() + ")" );
        }
        else if ( nbPrises < 1 ){
            throw new CoupInvalideException( nbPrises , "(< 1)" );
        }
        else if ( nbPrises > PRISE_MAX ){
            throw new CoupInvalideException( nbPrises , "(> " + PRISE_MAX + ")" );
        }
        this.allumettesRestantes = this.allumettesRestantes - nbPrises;

    }


}
