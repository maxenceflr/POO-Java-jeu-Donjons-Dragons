package objet.arme.armedeguerre;

public class EpeeLongue extends ArmeDeGuerre
{
    public EpeeLongue()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Epée longue";
    }

    @Override
    public String toString() {
        return "EpeeLongue : " + super.toString();
    }
}
