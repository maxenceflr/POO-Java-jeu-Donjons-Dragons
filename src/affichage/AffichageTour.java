package affichage;

import donjon.Donjon;
import donjon.Position;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Inventaire;
import jouable.personnage.Personnage;
import jouable.personnage.race.Elfe;
import jouable.personnage.race.Halfelin;
import jouable.personnage.race.Humain;
import jouable.personnage.race.Nain;
import objet.Equipement;
import partie.Tour;

import java.util.List;
import java.util.Scanner;

import static affichage.AffichageDonjon.afficherDonjon;

public class AffichageTour {

    public static boolean afficherTourMonstre(Donjon donj,int numDonjon, Tour t, Monstre m,List<Jouable> lj)
    {
        afficherEnteteDonjon(numDonjon,t.getNumTour(),m);/*le 1 sera remplacer par get numDonjon*/
        afficherLesJouable(lj,m);
        afficherDonjon(donj);
        afficherRecapMonstre(m);
        return afficherActionsMonstre(m, donj,t.getActionRestante());



    }
    public static boolean afficherTourPersonage(Donjon donj,int numDonjon,Tour t, Personnage p,List<Jouable> lj)
    {
        afficherEnteteDonjon(numDonjon,t.getNumTour(),p);/*le 1 sera remplacer par get numDonjon*/
        afficherLesJouable(lj,p);
        afficherDonjon(donj);
        afficherRecapPersonnage(p);
        return afficherActionsPersonnage(p, donj,t.getActionRestante());

    }
    public static void afficherEnteteDonjon(int numDonjon,int numTour, Jouable j) {
        System.out.println("********************************************************************************");
        System.out.println("Donjon " + numDonjon + ":");
        System.out.println("                          " + j.toString() + "             ");
        System.out.println("********************************************************************************");
        System.out.println("Tour " + numTour+ ":");
    }
    public static void afficherLesJouable(List<Jouable> listeJouables, Jouable j) {
        for (Jouable jo : listeJouables) {
            String prefixe = (jo.equals(j)) ? "-> " : "   ";
            String statut;

            if (jo instanceof Personnage) {
                Personnage p=(Personnage) jo;
                statut = String.format("%s (%s %s, %d/%d)", p.getNom(), p.getRace(), p.getClasse(), p.getCurrentPv(), p.getPvMax());
            } else if (jo instanceof Monstre) {
                Monstre m=(Monstre) jo;
                statut = String.format("%s (%d/%d)", m.getNom(), m.getCurrentPv(), m.getPvMax());
            } else {
                statut = jo.toString(); // fallback si ce n’est ni un personnage ni un monstre
            }

            System.out.println(prefixe + statut);
        }
    }

    public static void afficherRecapPersonnage(Personnage p)
    {
        System.out.println(p.getNom());
        System.out.println("\tVie: "+p.getCurrentPv()+"/"+p.getPvMax());
        System.out.println("\tArmure: "+p.getStringArmure());//plutot qu'utiliser tostring sur get arrmure car verifie que armure existe
        System.out.println("\tArme: "+p.getStringArme());
        System.out.println("\tInventaire:"+p.getInventaire());
        System.out.println("\tForce:"+p.getForce());
        System.out.println("\tDexterité: "+p.getDexterite());
        System.out.println("\tVitesse: "+p.getVitesse());

    }
    public static void afficherRecapMonstre(Monstre m)
    {
        System.out.println(m.getNom());
        System.out.println("\tVie: "+m.getCurrentPv()+"/"+m.getPvMax());
        System.out.println("\tArmure: "+m.getStringArmure());
        System.out.println("\tForce:"+m.getForce());
        System.out.println("\tDexterité: "+m.getDexterite());
        System.out.println("\tVitesse: "+m.getVitesse());

    }
    public static boolean afficherActionsPersonnage(Personnage p,Donjon donj,int actionRestante) {
        Scanner scanner = new Scanner(System.in);
        boolean commandeValide=true;
        while (true) {
            System.out.println("\nIl vous reste "+actionRestante+" action restante:");
            System.out.println("- laisser le maître du jeu commenter l'action précédente (mj <texte>)");
            System.out.println("- commenter action précédente (com <texte>)");
            System.out.println("- attaquer (att <Case>)");
            System.out.println("- se déplacer (dep <Case>)");
            System.out.println("- s'équiper (equ <numero equipement>)");
            System.out.println("- ramasser equipement(ram)");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String commande = parts[0];
            String argument = parts.length > 1 ? parts[1] : "";



            switch (commande) {
                case "mj":
                    System.out.println("[MJ] " + argument);
                    break;

                case "com":
                    System.out.println(p.getNom() + " commente : " + argument);
                    break;

                case "att":
                    // Ici tu devras parser une case (ex: "B3") et appeler une méthode comme p.attaquer(case)

                    System.out.println(p.getNom() + " attaque la case " + argument);
                    Position position_attaque = Position.getPositionFromCode(argument);
                    p.attaquer(position_attaque, donj);
                    // Exemple : p.attaquer(parseCase(argument));
                    break;

                case "dep":
                    System.out.println(p.getNom() + " se déplace vers la case " + argument);
                    Position position_deplacement = Position.getPositionFromCode(argument);
                    donj.getPositionsJouables().deplacerJouable(p, position_deplacement, donj);
                    break;

                case "equ":
                    try {
                        int numero = Integer.parseInt(argument) - 1;
                        Inventaire inventairePerso = p.getInventaire();

                        if (inventairePerso != null && numero >= 0 && numero < inventairePerso.getInventaire().size()) {
                            Equipement o = inventairePerso.getInventaire().get(numero);
                            if (o != null)
                            {
                                p.equiper(o);
                            } else {
                                System.out.println("Aucun objet à cet emplacement.");
                            }
                        }
                        else
                        {
                            System.out.println("Indice d'inventaire invalide ou inventaire vide.");
                        }
                        break;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Numéro d'équipement invalide.");
                    }
                    System.out.println(p.getNom() + " équipe l'element numero " + argument + "de l'inventaire");
                    break;

                case "ram":
                    Position position_joueur = donj.getPositionFromJouable(p);

                    if(donj.getPositionsEquipement().containsEquipement(position_joueur))
                    {
                        p.ramasser(position_joueur, donj);
                    }
                    else
                    {
                        System.out.println("Aucun équipement à ramasser !");
                    }

                    System.out.println(p.getNom() + "Vous ramassez un objet");
                    break;


                default:
                    System.out.println("Commande inconnue. Veuillez réessayer.");
                    commandeValide=false;
            }
            return commandeValide;
        }

    }
    public static boolean afficherActionsMonstre(Monstre m, Donjon donj,int actionRestante) {
        Scanner scanner = new Scanner(System.in);
        boolean commandeValide=true;
        while (true) {
            System.out.println("\nIl vous reste "+actionRestante+" action restante:");
            System.out.println("- le maître du jeu commente l'action précédente (mj <texte>)");
            System.out.println("- attaquer (att <Case>)");
            System.out.println("- se déplacer (dep <Case>)");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String commande = parts[0];
            String argument = parts.length > 1 ? parts[1] : "";

            switch (commande) {
                case "mj":
                    System.out.println("[MJ] " + argument);
                    break;


                case "att":
                    // Ici tu devras parser une case (ex: "B3") et appeler une méthode comme p.attaquer(case)
                    System.out.println(m.getNom() + " attaque la case " + argument);
                    Position position_attaque = Position.getPositionFromCode(argument);
                    m.attaquer(position_attaque, donj);
                    // Exemple : p.attaquer(parseCase(argument));
                    break;

                case "dep":
                    System.out.println(m.getNom() + " se déplace vers la case " + argument);
                    Position position_deplacement = Position.getPositionFromCode(argument);
                    donj.getPositionsJouables().deplacerJouable(m, position_deplacement, donj);
                    break;

                default:
                    System.out.println("Commande inconnue. Veuillez réessayer.");
                    commandeValide=false;
            }
            return commandeValide;
        }

    }
    public static void afficherPerdue(Personnage p)
    {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        String asciiArt ="                     "+p.getNom()+" est                                " +
                        "                             :                        \n" +
                        "                            t#,                       \n" +
                        "                           ;##W.   j.                 \n" +
                        "             ..       :   :#L:WE   EW,       GEEEEEEEL\n" +
                        "            ,W,     .Et  .KG  ,#D  E##j      ,;;L#K;;.\n" +
                        "           t##,    ,W#t  EE    ;#f E###D.       t#E   \n" +
                        "          L###,   j###t f#.     t#iE#jG#W;      t#E   \n" +
                        "        .E#j##,  G#fE#t :#G     GK E#t t##f     t#E   \n" +
                        "       ;WW; ##,:K#i E#t  ;#L   LW. E#t  :K#E:   t#E   \n" +
                        "      j#E.  ##f#W,  E#t   t#f f#:  E#KDDDD###i  t#E   \n" +
                        "    .D#L    ###K:   E#t    f#D#;   E#f,t#Wi,,,  t#E   \n" +
                        "   :K#t     ##D.    E#t     G#t    E#t  ;#W:    t#E   \n" +
                        "   ...      #G      ..       t     DWi   ,KK:    fE  \n" +
                        "            j                                     :  \n";

        System.out.println(ANSI_RED + asciiArt + ANSI_RESET);
    }
    public static void afficherGagneé()
    {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        String asciiArt =
                "                                                                                                    \n" +
                        "                                                                                                    \n" +
                        "                                                                 L.                     ,;        ,;\n" +
                        "          .Gt                       .Gt                       .GtEW:        ,ft       f#i       f#i \n" +
                        "         j#W:            ..        j#W:            ..        j#W:E##;       t#E     .E#t      .E#t  \n" +
                        "       ;K#f             ;W,      ;K#f             ;W,      ;K#f  E###t      t#E    i#W,      i#W,   \n" +
                        "     .G#D.             j##,    .G#D.             j##,    .G#D.   E#fE#f     t#E   L#D.      L#D.    \n" +
                        "    j#K;              G###,   j#K;              G###,   j#K;     E#t D#G    t#E :K#Wfff;  :K#Wfff;  \n" +
                        "  ,K#f   ,GD;       :E####, ,K#f   ,GD;       :E####, ,K#f   ,GD;E#t  f#E.  t#E i##WLLLLt i##WLLLLt \n" +
                        "   j#Wi   E#t      ;W#DG##,  j#Wi   E#t      ;W#DG##,  j#Wi   E#tE#t   t#K: t#E  .E#L      .E#L     \n" +
                        "    .G#D: E#t     j###DW##,   .G#D: E#t     j###DW##,   .G#D: E#tE#t    ;#W,t#E    f#E:      f#E:   \n" +
                        "      ,K#fK#t    G##i,,G##,     ,K#fK#t    G##i,,G##,     ,K#fK#tE#t     :K#D#E     ,WW;      ,WW;  \n" +
                        "        j###t  :K#K:   L##,       j###t  :K#K:   L##,       j###tE#t      .E##E      .D#;      .D#; \n" +
                        "         .G#t ;##D.    L##,        .G#t ;##D.    L##,        .G#t..         G#E        tt        tt\n" +
                        "           ;; ,,,      .,,           ;; ,,,      .,,           ;;            fE                     \n" +
                        "                                                                              ,                     \n";

        System.out.println(asciiArt);
    }
}
