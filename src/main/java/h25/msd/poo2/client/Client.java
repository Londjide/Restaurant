package h25.msd.poo2.client;

public class Client {
    private String nom;
    private double montantAchat;

    public Client(String nom) {
        this.nom = nom;
        this.montantAchat = 0.0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMontantAchat() {
        return montantAchat;
    }


    public void ajouteCommande(double montant) {
        montantAchat += montant;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", montantAchat=" + montantAchat +
                '}';
    }
}
