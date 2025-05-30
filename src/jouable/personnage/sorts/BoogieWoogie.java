package jouable.personnage.sorts;

import donjon.Donjon;
import donjon.Position;
import jouable.Jouable;
import jouable.personnage.Personnage;

import java.util.List;

public class BoogieWoogie implements Sorts
{

    public void utiliser(Jouable cible1, Jouable cible2, Donjon donjon)
    {
        Position pos_cible1 = new Position(donjon.getPositionFromJouable(cible1));
        Position pos_cible2 = new Position(donjon.getPositionFromJouable(cible2));

        donjon.getPositionsJouables().deplacerJouable(cible1, pos_cible2);
        donjon.getPositionsJouables().deplacerJouable(cible2, pos_cible1);
    }
}
