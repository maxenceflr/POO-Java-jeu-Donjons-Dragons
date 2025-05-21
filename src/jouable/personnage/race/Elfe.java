package jouable.personnage.race;

import stats.CaracteristiquesBase;

public class Elfe implements race {
    private CaracteristiquesBase m_caracteristiques;

    public Elfe(CaracteristiquesBase caracteristique) {
        caracteristique.setDexterite(caracteristique.getDexterite() + 6); // ✅ +6 en dextérité
        this.m_caracteristiques = caracteristique;
    }

    public Elfe() {
        this.m_caracteristiques = new CaracteristiquesBase(0, 6, 0, 0, 0); // force, dex, init, vit, pvmax
        this.m_caracteristiques.setCurrentPv(m_caracteristiques.getPvMax());
    }

    @Override
    public String toString() {
        return "Elfe {" +
                "Force=" + m_caracteristiques.getForce() +
                ", Dextérité=" + m_caracteristiques.getDexterite() +
                ", Initiative=" + m_caracteristiques.getInitiative() +
                ", Vitesse=" + m_caracteristiques.getVitesse() +
                ", PV Max=" + m_caracteristiques.getPvMax() +
                ", PV Actuels=" + m_caracteristiques.getCurrentPv() +
                '}';
    }
}
