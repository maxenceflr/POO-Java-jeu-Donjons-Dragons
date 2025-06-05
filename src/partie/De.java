package partie;

import objet.armure.armurelourde.Harnois;

import java.util.Random;

public class De {

    private final int m_nbDes;
    private final int m_nbFaces;

    public De (int nbDes, int nbFaces)
    {
        m_nbDes = nbDes;
        m_nbFaces = nbFaces;
    }

    public De ()
    {
        this(0,0);
    }

    public int jeter(){
        Random rand = new Random();
        int somme = 0;

        for(int i = 0; i < m_nbDes; i++)
        {
            somme += 1 + rand.nextInt(m_nbFaces + 1);
        }

        return somme;
    }

    @Override
    public String toString()
    {
        return Integer.toString(m_nbDes) + "d" + Integer.toString(m_nbFaces);
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            De conversion = (De) other;
            return m_nbFaces == conversion.m_nbFaces && m_nbDes == conversion.m_nbDes;
        }
    }
}
