package jouable.personnage.sorts;

import donjon.Donjon;
import donjon.Position;
import jouable.ActionResult;
import jouable.Jouable;
import jouable.personnage.Personnage;

import java.util.List;

import static jouable.ActionResult.SUCCESS;

public class BoogieWoogie implements Sorts
{
    @Override
    public String toString(){
        return "Boogie Woogie";
    }

    public ActionResult lancerSort(Jouable cible1, Jouable cible2, Donjon donjon)
    {
        Position pos_cible1 = new Position(donjon.getPositionFromJouable(cible1));
        Position pos_cible2 = new Position(donjon.getPositionFromJouable(cible2));

        donjon.getPositionsJouables().ajouterJouable(cible1, pos_cible2);
        donjon.getPositionsJouables().ajouterJouable(cible2, pos_cible1);

        return SUCCESS;
    }
}
