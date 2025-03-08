package h25.msd.poo2.client;

// import h25.msd.poo2.menu.Dessert;
// import h25.msd.poo2.menu.Entree;
// import h25.msd.poo2.menu.RepasPrincipal;
import h25.msd.poo2.menu.MenuItem;

public class Commande {
    //// private Object[] items = new Object[10]; // max de 10 pour simplifier le tp
    private MenuItem[] items = new MenuItem[10]; // max de 10 pour simplifier le tp
    private Client client;
    private int nombreItems = 0;

    private double fraisLivraison = 5.0;

    public Commande(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    // public boolean ajouteItem(Object item) {

    // for (int i = 0; i < items.length; i++) {
    // items[i] = item;

    public boolean ajouteItem(MenuItem item) {
        if (nombreItems < items.length) {
            items[nombreItems] = item;
            nombreItems++;
            return true;
        }
        return false;
    }

    public double calculeMontantBrut() {
        double montant = 0;

        // // cout de la commande (Entree / Plat Principal / Dessert)
        //// for (int i = 0; i < items.length; i++) {

        for (int i = 0; i < nombreItems; i++) {
            if (items[i] != null) {
                montant += items[i].getPrix();
                // // Object item = items[i];
                // // if (item instanceof Entree) {
                // // Entree entree = (Entree) item;
                // // montant += entree.getPrix();
                // // } else if (item instanceof RepasPrincipal) {
                // // RepasPrincipal repasPrincipal = (RepasPrincipal) item;
                // // montant += repasPrincipal.getPrix();
                // // } else if (item instanceof Dessert) {
                // // Dessert dessert = (Dessert) item;
                // // montant += dessert.getPrix();
                // // }
            }
        }

        return montant;
    }

    public double calculeRabais(double montantTotal) {
        // // rabais produits

        // // rabais client enregistré

        //// return -1;
        double rabaisTotal = 0;

        for (int i = 0; i < nombreItems; i++) {
            if (items[i] != null) {
                rabaisTotal += items[i].calculeRabais(montantTotal);
            }
        }

        return rabaisTotal;
    }

    private double factureMontantFinal() {

        // place le montant dans le compte du client

        // retire la facture de la liste

        return -1;
    }

}
