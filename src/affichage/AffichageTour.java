package affichage;

import donjon.Donjon;
import donjon.Position;
import donjon.PositionsJouables;
import jouable.ActionResult;
import jouable.AttackResult;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Inventaire;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Classe;
import jouable.personnage.sorts.ArmeMagique;
import jouable.personnage.sorts.BoogieWoogie;
import jouable.personnage.sorts.Guerison;
import jouable.personnage.sorts.Sorts;
import objet.Equipement;
import objet.arme.Arme;
import partie.De;
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
            String prefixe;
            if(j==jo)
            {
                prefixe=" ->";
            }
            else
            {
                prefixe="   ";
            }
            String statut;

            if (jo instanceof Personnage) {
                Personnage p=(Personnage) jo;
                statut = String.format("%s %s (%s %s, %d/%d)",p.getSymbole(), p.getNom(), p.getRace(), p.getClasse(), p.getCurrentPv(), p.getPvMax());
            } else if (jo instanceof Monstre) {
                Monstre m=(Monstre) jo;
                statut = String.format("%s %s (%d/%d)", m.getSymbole(),m.getNom(), m.getCurrentPv(), m.getPvMax());
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
            System.out.println("\nIl vous reste " + actionRestante + " action restante:");
            System.out.println("- laisser le maître du jeu commenter l'action précédente (mj <texte>)");
            System.out.println("- commenter action précédente (com <texte>)");
            System.out.println("- attaquer (att <Case>)(ex: att D14)");
            System.out.println("- se déplacer (dep <Case>)(ex: dep B47");
            System.out.println("- s'équiper (equ <numero equipement>)");
            if(!p.getClasse().getSort().isEmpty()) {
                System.out.println("- lancer un sort(sor)");
            }
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
                        case SUCCESS: {
                            System.out.println("Attaque réussie !");
                            Jouable j = donj.getJouableFromPosition(position_attaque);
                            System.out.println(j.getNom() + " subit " + result.getDegats() + " degats");
                            break;
                        }
                        case FAILURE:
                            System.out.println("L'attaque a échoué, l'adversaire a esquivé ou l'armure a tout bloqué.");
                            break;
                        case NO_WEAPON:
                            System.out.println("Tu n'as pas d'arme équipée !");
                            break;
                        case OUT_OF_REACH:
                            System.out.println("La cible est hors de portée !");
                            break;
                    }
                    break;
                case "dep":
                    while (!argument.matches("^[A-Z][0-9]+$")) {
                        System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12) :");
                        argument = scanner.nextLine().trim().toUpperCase();
                    }

                    System.out.println(p.getNom() + " tente de se déplacer vers la case " + argument);
                    Position position_deplacement = Position.getPositionFromCode(argument);
                    ActionResult resultdep = donj.getPositionsJouables().deplacerJouable(p, position_deplacement, donj);

                    switch (resultdep) {
                        case SUCCESS:
                            System.out.println(p.getNom() + " s'est déplacé avec succès.");
                            break;
                        case OUT_OF_REACH:
                            System.out.println("Case trop éloignée pour se déplacer.");
                            break;
                        case OBSTACLE:
                            System.out.println("Impossible : il y a un obstacle.");
                            break;
                        case OCCUPIED_POSITION:
                            System.out.println("Cette case est déjà occupée.");
                            break;
                    }
                    break;


                case "equ":
                    Inventaire inventairePerso = p.getInventaire();
                    int numerot = -1;

                    while (true) {
                        if (inventairePerso == null)
                        {
                            System.out.println("Impossible, Inventaire vide");
                        }
                        else
                        {
                            if (argument.matches("\\d+")) {
                                numerot = Integer.parseInt(argument) - 1;

                                if (numerot >= 0 && numerot < inventairePerso.getInventaire().size()) {
                                    Equipement o = inventairePerso.getInventaire().get(numerot);

                                    if (o != null) {
                                        switch (p.equiper(o)) {
                                            case SUCCESS:
                                                System.out.println(p.getNom() + " équipe " + o.getNomEquipement() + " depuis l'inventaire");
                                                break;
                                            case NO_ITEM:
                                                System.out.println("Impossible d'équiper cet objet.");
                                                break;
                                        }
                                    } else {
                                        System.out.println("Aucun équipement à cet index.");
                                    }
                                    break;
                                } else {
                                    System.out.println("Numéro invalide. Aucun équipement à cet index.");
                                }
                            } else {
                                System.out.println("Entrée invalide. Veuillez entrer un numéro d'équipement que vous possédez :");
                            }

                            System.out.println("Entrez le numéro d'un équipement à équiper :");
                            argument = scanner.nextLine().trim();
                        }

                    }
                    break;

                case "sor":
                {
                    afficherSorts(p,donj);
                    break;
                }

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
                            Jouable j= donj.getJouableFromPosition(position_attaque);
                            System.out.println(j.getNom()+" subit " + result.getDegats()+" degats");
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
                    while (!argument.matches("^[A-Z][0-9]+$")) {
                        System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12) :");
                        argument = scanner.nextLine().trim().toUpperCase();
                    }

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
    public static void afficherSorts(Personnage p,Donjon donj)
    {
        Classe classe = p.getClasse();
        List<Sorts> listeSorts=classe.getSort();
        if(listeSorts.size()==1)
        {
            affichageGuerison(donj);
        }
        else {
            System.out.println("\nLequel de ces sort voulez-vous lancer?");
            for (int i = 0; i < listeSorts.size(); i++) {
                System.out.println("-" + (i + 1) + " Lancer " + listeSorts.get(i).toString());
            }
            Scanner scanner = new Scanner(System.in);
            int choix = -1;

            while (choix < 1 || choix > listeSorts.size()) {
                System.out.print("Entrez un nombre entre 1 et " + listeSorts.size() + " : ");
                if (scanner.hasNextInt()) {
                    choix = scanner.nextInt();
                } else {
                    scanner.next(); // consomme l'entrée invalide
                    System.out.println("Veuillez entrer un nombre valide !");
                }
            }
            switch (choix) {
                case 1:
                    affichageGuerison(donj);
                    break;
                case 2:
                    affichageArmeMagique(donj);
                    break;
                case 3:
                    affichageBoogieWoogie(donj);
                    break;
            }
        }

    }
    public static void affichageBoogieWoogie(Donjon donj)
    {
        Jouable j1 = null;
        Jouable j2 = null;
        Position pos1 = null;
        Position pos2 = null;
        Scanner scanner = new Scanner(System.in);

        while (j1 == null) {
            System.out.println("Entrez la case de l'un des jouable que vous souhaitez téléporter (ex: D12) :");
            String argument = scanner.nextLine().trim().toUpperCase();

            // Vérifie le format
            if (!argument.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                continue;
            }

            pos1 = Position.getPositionFromCode(argument);
            j1 = donj.getJouableFromPosition(pos1);

            if (j1 == null) {
                System.out.println("Aucun jouable à cette position. Veuillez en saisir une autre.");
            }

        }
        while (j2 == null) {
            System.out.println("Entrez la case de l'un des jouable que vous souhaitez téléporter (ex: D12) :");
            String argument = scanner.nextLine().trim().toUpperCase();

            // Vérifie le format
            if (!argument.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                continue;
            }

            pos1 = Position.getPositionFromCode(argument);
            j2 = donj.getJouableFromPosition(pos1);

            if (j2 == null) {
                System.out.println("Aucun jouable à cette position. Veuillez en saisir une autre.");
            }

        }
        BoogieWoogie BW = new BoogieWoogie();
        BW.lancerSort(j1,j2,donj);
        System.out.println("\nBoogieWoogie\n");
    }
    public static void affichageArmeMagique(Donjon donj)
    {
        Scanner scanner = new Scanner(System.in);
        boolean sortLance = false;

        while (!sortLance) {
            Jouable j = null;
            Position pos = null;

            while (j == null) {
                System.out.println("Entrez la case du personnage auquel vous souhaitez améliorer une arme (ex: D12) :");
                String argument = scanner.nextLine().trim().toUpperCase();

                // Vérifie le format
                if (!argument.matches("^[A-Z][0-9]+$")) {
                    System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                    continue;
                }

                pos = Position.getPositionFromCode(argument);
                j = donj.getJouableFromPosition(pos);

                if (j == null) {
                    System.out.println("Aucun joueur à cette position. Veuillez en saisir une autre.");
                } else if (!(j instanceof Personnage)) {
                    System.out.println("Ce n’est pas un personnage. Veuillez sélectionner un personnage.");
                    j = null; // recommence
                }
            }

            // Si on est ici, on a un personnage valide
            Personnage p = (Personnage) j;
            Inventaire inventairePerso = p.getInventaire();

            System.out.println("Vous avez sélectionné " + p.getNom());
            if(p.aUneArme())//on verifier si il a une arme ou non car une fois l'arme porté elle disparait de l'inventaire
            {
                int indicemax = inventairePerso.getNbEquipement()+1;
                System.out.println("Voici son inventaire :\n" + inventairePerso+"["+indicemax+"]"+p.getArme().get().getNomEquipement());
                System.out.println("Veuillez saisir l'indice de l'arme que vous souhaitez améliorer :");

                if (scanner.hasNextInt()) {
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // consomme le retour à la ligne


                    if (indice > 0 && indice <= indicemax-1) {
                        Equipement e = inventairePerso.getEquipement(indice - 1); // -1 car affichage 1-based

                        if (e instanceof Arme) {
                            Arme arme = (Arme) e;
                            ArmeMagique a = new ArmeMagique();
                            if(a.lancerSort(p,arme)==SUCCESS) {
                                sortLance = true; // sort lancé avec succès, on quitte la boucle
                                System.out.println("\nL'arme"+arme.toString()+ " de "+p.getNom()+" à maintenant une benediction critique de niveau "+arme.getBonusAttaque()+"\n");
                            }
                        } else {
                            System.out.println("L'équipement sélectionné n’est pas une arme.");
                        }
                    }
                    else if(indice==indicemax)//si c'est l'arme qu'il est en train de porté
                    {
                        Arme arme = p.getArme().get();
                        ArmeMagique a = new ArmeMagique();
                        if(a.lancerSort(p,arme)==SUCCESS) {
                            sortLance = true; // sort lancé avec succès, on quitte la boucle
                            System.out.println("\nL'arme"+arme.toString()+ " de "+p.getNom()+" à maintenant une benediction critique de niveau "+arme.getBonusAttaque()+"\n");
                        }

                    }
                    else {
                        System.out.println("Indice invalide. Entrez un nombre entre 1 et " + indicemax + ".");
                    }
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                    scanner.nextLine(); // consomme l'entrée incorrecte
                }
            }
            else {//dans le cas ou il ne porte pas d'arme
                int indicemax = inventairePerso.getNbEquipement();
                System.out.println("Voici son inventaire :\n" + inventairePerso);

                System.out.println("Veuillez saisir l'indice de l'arme que vous souhaitez améliorer :");

                if (scanner.hasNextInt()) {
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // consomme le retour à la ligne


                    if (indice > 0 && indice <= indicemax) {
                        Equipement e = inventairePerso.getEquipement(indice - 1); // -1 car affichage 1-based

                        if (e instanceof Arme) {
                            Arme arme = (Arme) e;
                            ArmeMagique a = new ArmeMagique();
                            if(a.lancerSort(p,arme)==SUCCESS) {
                                sortLance = true; // sort lancé avec succès, on quitte la boucle
                                System.out.println("\nL'arme"+arme.toString()+ " de "+p.getNom()+" à maintenant une benediction critique de niveau "+arme.getBonusAttaque()+"\n");
                            }
                        } else {
                            System.out.println("L'équipement sélectionné n’est pas une arme.");
                        }
                    } else {
                        System.out.println("Indice invalide. Entrez un nombre entre 1 et " + indicemax + ".");
                    }
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                    scanner.nextLine(); // consomme l'entrée incorrecte
                }
            }
        }

    }
    public static void affichageGuerison(Donjon donj)
    {
        Scanner scanner = new Scanner(System.in);
        Jouable j = null;
        Position positionASoigner = null;


        while (j == null) {
            System.out.println("Entrez la case du personnage que vous souhaitez soigner (ex: D12) :");
            String argument = scanner.nextLine().trim().toUpperCase();

            // Vérifie le format
            if (!argument.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                continue;
            }


            positionASoigner = Position.getPositionFromCode(argument);
            j = donj.getJouableFromPosition(positionASoigner);
            if (j == null) {
                System.out.println("Aucun joueur à cette position. Veuillez en saisir une autre.");
            }
            else {
                if (j instanceof Personnage)
                {
                    Personnage personnageASoigner =(Personnage) j;
                    System.out.println("Vous avez sélectionner "+personnageASoigner.getNom());
                    De de =new De(1,10);
                    int pvSoigne=de.jeter();
                    afficherDe(pvSoigne);
                    Guerison g =new Guerison();
                    g.lancerSort(personnageASoigner,pvSoigne);
                    System.out.println("\n"+personnageASoigner.getNom()+ " à récuperer "+pvSoigne+" PV \n");

                }
                else {
                    System.out.println("Vous avez sélectionner un monstre");

                }
            }

        }

    }
    public static int choixActionMj()
    {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nQu'est-ce que le Maître du jeu souhaite faire ?");
            System.out.println("1. Déplacer un monstre ou un personnage");
            System.out.println("2. Faire un jet de dés pour infliger des dégâts");
            System.out.println("3. Ajouter un obstacle dans le donjon");
            System.out.println("4. Ne rien faire");

            String input = scanner.nextLine().trim();

            try {
                int choix = Integer.parseInt(input);

                if (choix >= 1 && choix <= 4) {
                    return choix;
                } else {
                    System.out.println("Veuillez entrer un chiffre entre 1 et 4.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erreur : vous devez entrer un chiffre.");
            }
        }
    }
    public static void choixCaseDeplacementMj(Donjon donj)
    {
        Scanner scanner = new Scanner(System.in);
        Jouable j = null;
        Position position_depart = null;

        // Demander la case de départ (où il y a un jouable)
        while (j == null) {
            System.out.println("Entrez la case du jouable que vous souhaitez déplacer (ex: D12) :");
            String argument = scanner.nextLine().trim().toUpperCase();

            // Vérifie le format
            if (!argument.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                continue;
            }

            // Récupère la position et le jouable
            position_depart = Position.getPositionFromCode(argument);
            j = donj.getJouableFromPosition(position_depart);
            if (j == null) {
                System.out.println("Aucun joueur ni monstre à cette position. Veuillez en saisir une autre.");
            }
        }

        ActionResult result=null;
        do {
            // Demander la case d’arrivée
            System.out.println("Entrez la case sur laquelle vous souhaitez déplacer le jouable (ex: D12) :");
            String argument2 = scanner.nextLine().trim().toUpperCase();

            if (!argument2.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");
                continue;
            }

            Position position_arrivee = Position.getPositionFromCode(argument2);
            PositionsJouables posJouables = donj.getPositionsJouables();
            result = posJouables.deplacementMj(j, position_arrivee, donj);

            // Gérer les résultats
            switch (result) {
                case SUCCESS:
                    System.out.println(j.getNom() + " s'est déplacé avec succès vers " + argument2 + ".");
                    break;
                case OCCUPIED_POSITION:
                    System.out.println("Cette case est déjà occupée. Essayez une autre case.");
                    break;
                case ITEM:
                    System.out.println("Impossible : un objet bloque cette case.");
                    break;
                case OBSTACLE:
                    System.out.println("Impossible : un obstacle bloque cette case.");
                    break;
                default:
                    System.out.println("Erreur inattendue.");
                    break;
            }

        } while (result != ActionResult.SUCCESS);
    }
    public static void choixAttaqueDuMj(Donjon donj)
    {
        Scanner scanner = new Scanner(System.in);
        Jouable j = null;
        Position position = null;

        while (j == null) {
            System.out.println("Entrez la case du jouable que vous souhaitez attaquer (ex: D12) :");
            String argument = scanner.nextLine().trim().toUpperCase();


            if (!argument.matches("^[A-Z][0-9]+$")) {
                System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");

            }
            else {

                // Récupère la position
                position= Position.getPositionFromCode(argument);

                // Vérifie qu’un jouable est bien présent
                j = donj.getJouableFromPosition(position);
                if (j == null) {
                    System.out.println("Aucun joueur ni monstre à cette position. Veuillez en saisir une autre.");
                }
            }
        }
        int nombreDes = 0;
        int nombreFaces = 0;


        while (true) {
            System.out.print("Entrez le nombre de dés à lancer : ");
            String input = scanner.nextLine().trim();
            try {
                nombreDes = Integer.parseInt(input);
                if (nombreDes <= 0) {
                    System.out.println("Veuillez entrer un entier positif.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre entier valide.");
            }
        }


        while (true) {
            System.out.print("Entrez le nombre de faces de chaque dé : ");
            String input = scanner.nextLine().trim();
            try {
                nombreFaces = Integer.parseInt(input);
                if (nombreFaces <= 0) {
                    System.out.println("Veuillez entrer un entier positif.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre entier valide.");
            }
        }
        De de =new De(nombreDes,nombreFaces);

        System.out.println("Lancement de " + nombreDes + " dé(s) à " + nombreFaces + " faces chacun.");
        int degat=donj.getPositionsJouables().attaqueDuMj(j,de);
        System.out.println(/*j.getNom()+*/" subit "+degat+" dégat");//creer un get nom de jouable
    }
    public static void ajouterObstacleMj(Donjon donj)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la case surlaquelle vous souhaité posé un obstacle (ex: D12) :");
        String argument = scanner.nextLine().trim().toUpperCase();


        if (!argument.matches("^[A-Z][0-9]+$")) {
            System.out.println("Format invalide. Veuillez entrer une case au format Lettre+Chiffre (ex: D12).");

        }
        else {
            Position position= Position.getPositionFromCode(argument);
            switch (donj.ajoutObstacleMj(position))
            {
                case OCCUPIED_POSITION:
                    System.out.println("il y a une erreur, cette case est occupée par un jouable");
                    break;
                case ITEM:
                    System.out.println("il y a une erreur, cette case est occupée par un item");
                    break;
                case OBSTACLE:
                    System.out.println("il y a une erreur, cette case est deja un obstacle");
                    break;
                case SUCCESS:
                    System.out.println("Obstacle ajouter a la position "+argument);
                    break;
                default:
                    System.out.println("probleme ajout obstacle MJ");
            }
        }
    }
    public static void afficherDe(int somme)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apuyer sur entrer pour lancer les dés");
        scanner.nextLine();
        scanner.nextLine();
        System.out.println("Résultat du lancer est de " + somme);

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

