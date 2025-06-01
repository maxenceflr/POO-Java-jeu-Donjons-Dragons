package objet.arme.armedeguerre;

public class Rapiere extends ArmeDeGuerre
{
    public Rapiere()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Rapière";
    }

    @Override
    public String toString() {
        return "Rapière : " + super.toString();
    }
}
