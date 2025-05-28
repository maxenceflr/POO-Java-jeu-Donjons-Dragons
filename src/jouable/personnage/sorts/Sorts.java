package jouable.personnage.sorts;

import jouable.Jouable;
import jouable.personnage.Personnage;

import java.util.List;

public interface Sorts {

    public String toString();
    public void utiliser(Personnage lanceur, List<Jouable> cibles);
}
