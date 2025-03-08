package h25.msd.poo2;

import h25.msd.poo2.client.Client;
import h25.msd.poo2.client.Commande;
import h25.msd.poo2.menu.MenuItem;

public class Restaurant {
    public final static double TAUX_TAXE = 0.15;

    //// private Commande[] commandes = new Commande[10]; // max 10 comandes à la
    //// fois

    private Commande[] commandes = new Commande[10]; // max 10 commandes à la fois

    //// public boolean commande(Object[] items, Client client) { // msd vous pouvez
    //// changer cette signature

    public boolean commande(MenuItem[] items, Client client) {
        for (int i = 0; i < commandes.length; i++) {
            if (commandes[i] == null) {
                // Créer une commande
                // // Commande commandees = new Commande(client);
                Commande nouvelleCommande = new Commande(client);

                // Ajouter les items
                // // for (Object item : items) {
                // // // Vous devrez adapter cette partie selon le type réel de vos items
                // // commandees.ajouteItem(item);
                for (MenuItem item : items) {
                    nouvelleCommande.ajouteItem(item);
                }

                // Ajouter la commande dans le tableau
                // // commandes[i] = commandees;
                commandes[i] = nouvelleCommande;

                return true;
            }
        }
        return false;
    }

    public void livreCommande() {
        // extraire les commandes, calculer les montants et les porter au compte du
        // client.

        for (int i = 0; i < commandes.length; i++) {
            Commande commande = commandes[i];

            if (commande != null) {
                double calculeMontantBrut = commande.calculeMontantBrut();
                double calculeRabais = commande.calculeRabais(calculeMontantBrut);
                double calculeTaxes = (calculeMontantBrut - calculeRabais) * TAUX_TAXE;
                double montantFacture = calculeMontantBrut - calculeRabais + calculeTaxes;

                // ajoute le montant de facture au compte du client
                Client client = commande.getClient();
                client.ajouteCommande(montantFacture);
                // // client.getMontantAchat();
                System.out.println("Le montant de la facture est de " + montantFacture);

                commandes[i] = null;
            }
        }
    }
}
