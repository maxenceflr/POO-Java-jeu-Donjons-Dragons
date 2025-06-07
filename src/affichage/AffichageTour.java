package affichage;

import donjon.Donjon;
import donjon.Position;
import jouable.ActionResult;
import jouable.AttackResult;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Inventaire;
import jouable.personnage.Personnage;
import objet.Equipement;
import partie.Tour;

import java.util.List;
import java.util.Scanner;

import static affichage.AffichageDonjon.afficherDonjon;
import static jouable.ActionResult.*;

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
        System.out.println("\t"+m.getStringArmure());
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
            System.out.println("- attaquer (att <Case>)(ex: att D14)");
            System.out.println("- se déplacer (dep <Case>)(ex: dep B47");
            System.out.println("- s'équiper (equ <numero equipement>)");
            System.out.println("- ramasser équipement(ram)");

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
                    System.out.println(p.getNom() + " attaque la case " + argument);
                    System.out.println("Appuyez sur Entrée pour lancer les dés d'attaques");
                    scanner.nextLine();
                    Position position_attaque = Position.getPositionFromCode(argument);
                    AttackResult result = p.attaquer(position_attaque, donj); // ← Récupère le résultat

                    System.out.println("Jet d'attaque : " + result.getJetAttaque());

                    switch (result.getStatus()) {
                        case SUCCESS :
                        {
                            System.out.println("Attaque réussie !");
                            System.out.println("Dégâts infligés : " + result.getDegats());
                            break;
                        }
                        case FAILURE :
                            System.out.println("L'attaque a échoué, l'adversaire a esquivé ou l'armure a tout bloqué.");
                            break;
                        case NO_WEAPON :
                            System.out.println("Tu n'as pas d'arme équipée !");
                            break;
                        case OUT_OF_REACH :
                            System.out.println("La cible est hors de portée !");
                            break;
                    }
                    break;
                case "dep" :

                    System.out.println(p.getNom() + " tente de se déplacer vers la case " + argument);
                    Position position_deplacement = Position.getPositionFromCode(argument);
                    ActionResult resultdep = donj.getPositionsJouables().deplacerJouable(p, position_deplacement, donj);

                    switch (resultdep) {
                        case SUCCESS :
                            System.out.println(p.getNom() + " s'est déplacé avec succès.");
                            break;
                        case OUT_OF_REACH :
                            System.out.println("Case trop éloignée pour se déplacer.");
                            break;
                        case OBSTACLE :
                            System.out.println("Impossible : il y a un obstacle.");
                            break;
                        case OCCUPIED_POSITION :
                            System.out.println("Cette case est déjà occupée.");
                            break;
                    }
                    break;


                case "equ":
                    int numerot = Integer.parseInt(argument) - 1;
                    Inventaire inventairePerso = p.getInventaire();

                    if (inventairePerso != null && numerot >= 0 && numerot < inventairePerso.getInventaire().size()) {
                        Equipement o = inventairePerso.getInventaire().get(numerot);
                        if (o != null) {
                            switch (p.equiper(o)) {
                                case SUCCESS:
                                    System.out.println(p.getNom() + " équipe " + o.getNomEquipement() + " depuis l'inventaire");
                                    break;
                                case NO_ITEM:
                                    System.out.println("Aucun objet à cet emplacement.");
                                    break;


                            }
                        }
                    }
                    break;

                case "ram":
                    Position position_joueur = donj.getPositionFromJouable(p);

                    switch (p.ramasser(position_joueur, donj))
                    {
                        case SUCCESS :
                            System.out.println(p.getNom() + "Vous ramassez un objet");
                            break;
                        case NO_ITEM:
                            System.out.println("Aucun équipement à ramasser !");
                            break;
                    }
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
            System.out.println("- attaquer (att <Case>)(ex: att D14)");
            System.out.println("- se déplacer (dep <Case>)(ex: dep B47)");

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
                    System.out.println(m.getNom() + " attaque la case " + argument);
                    System.out.println("Appuyez sur Entrée pour lancer les dés d'attaques");
                    scanner.nextLine();
                    Position position_attaque = Position.getPositionFromCode(argument);
                    AttackResult result = m.attaquer(position_attaque, donj); // ← Récupère le résultat

                    System.out.println("Jet d'attaque : " + result.getJetAttaque());

                    switch (result.getStatus()) {
                        case SUCCESS :
                        {
                            System.out.println("Attaque réussie !");
                            System.out.println("Dégâts infligés : " + result.getDegats());
                            break;
                        }
                        case FAILURE :
                            System.out.println("L'attaque a échoué, l'adversaire a esquivé ou l'armure a tout bloqué.");
                            break;
                        case OUT_OF_REACH :
                            System.out.println("La cible est hors de portée !");
                            break;
                    }
                    break;

                case "dep" :

                    System.out.println(m.getNom() + " tente de se déplacer vers la case " + argument);
                    Position position_deplacement = Position.getPositionFromCode(argument);
                    ActionResult resultdep = donj.getPositionsJouables().deplacerJouable(m, position_deplacement, donj);

                    switch (resultdep) {
                        case SUCCESS :
                            System.out.println(m.getNom() + " s'est déplacé avec succès.");
                            break;
                        case OUT_OF_REACH :
                            System.out.println("Case trop éloignée pour se déplacer.");
                            break;
                        case OBSTACLE :
                            System.out.println("Impossible : il y a un obstacle.");
                            break;
                        case OCCUPIED_POSITION :
                            System.out.println("Cette case est déjà occupée.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Commande inconnue. Veuillez réessayer.");
                    commandeValide=false;
                    break;
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
    public static void afficherGagnee()
    {


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

    public static void afficherGenerique(char c, int tempo) {
        System.out.print(c);
        System.out.flush();
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

