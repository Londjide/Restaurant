package h25.msd.poo2.client;

import h25.msd.poo2.menu.Dessert;
import h25.msd.poo2.menu.Entree;
import h25.msd.poo2.menu.RepasPrincipal;

public class Commande {
    private Object[] items = new Object[10]; // max de 10 pour simplifier le tp
    private Client client;

    private double fraisLivraison = 5.0;

    public Commande(Client client) {
        this.client = client;

    }

    public Client getClient() {
        return client;
    }

    public boolean ajouteItem(Object item) {

        for (int i = 0; i < items.length; i++) {
            items[i] = item;
        }

        return false;
    }

    public double calculeMontantBrut() {

        double montant = 0;

        // cout de la commande (Entree / Plat Principal / Dessert)
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                Object item = items[i];
                if (item instanceof Entree) {
                    Entree entree = (Entree) item;
                    montant += entree.getPrix();
                } else if (item instanceof RepasPrincipal) {
                    RepasPrincipal repasPrincipal = (RepasPrincipal) item;
                    montant += repasPrincipal.getPrix();
                } else if (item instanceof Dessert) {
                    Dessert dessert = (Dessert) item;
                    montant += dessert.getPrix();
                }
            }
        }

        // frais de livraison et pourboire
        // montant += fraisLivraison;
        // Commande commande = new Commande(client);
        // commande.getClient().ajouteCommande(montant);

        return montant;
    }

    public double calculeRabais(double montantTotal) {
        // rabais produits

        // rabais client enregistré

        return -1;
    }

    private double factureMontantFinal() {

        // place le montant dans le compte du client

        // retire la facture de la liste

        return -1;
    }

}
