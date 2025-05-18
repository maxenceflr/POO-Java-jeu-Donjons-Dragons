package jouable.personnage.race;

import stats.CaracteristiquesBase;

public class Nain implements race {
    private CaracteristiquesBase m_caracteristiques;

    public Nain(CaracteristiquesBase caracteristique) {
        caracteristique.setForce(caracteristique.getForce() + 6); // ✅ +6 en force
        this.m_caracteristiques = caracteristique;
    }

    public Nain() {
        this.m_caracteristiques = new CaracteristiquesBase(6, 0, 0, 0, 0); // force, dex, init, vit, pvmax
        this.m_caracteristiques.setCurrentPv(m_caracteristiques.getPvMax());
    }

    @Override
    public String toString() {
        return "Nain {" +
                "Force=" + m_caracteristiques.getForce() +
                ", Dextérité=" + m_caracteristiques.getDexterite() +
                ", Initiative=" + m_caracteristiques.getInitiative() +
                ", Vitesse=" + m_caracteristiques.getVitesse() +
                ", PV Max=" + m_caracteristiques.getPvMax() +
                ", PV Actuels=" + m_caracteristiques.getCurrentPv() +
                '}';
    }
}
