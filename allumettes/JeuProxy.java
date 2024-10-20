package allumettes;

public class JeuProxy implements Jeu {

    private Jeu jeuReel;

    public JeuProxy(Jeu jeu) {
        this.jeuReel = jeu;
    }

    @Override
    public int getNombreAllumettes() {
        return jeuReel.getNombreAllumettes();
    }

    @Override
    public void retirer(int nbPrises) {
        throw new OperationInterditeException();
    }
}