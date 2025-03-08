package h25.msd.poo2.menu;

public class RepasPrincipal implements MenuItem { // implementation de la classe MenuItem
    public static final double RABAIS_POUR_SEUIL = 0.05;
    public static final double RABAIS_JOURNALIER = 0.03;

    private double prix;
    private String nom;
    private JoursSemaine joursSemaine;
    private double seuilRabais;
    private double temperature;

    public RepasPrincipal(String nom,
            double prix,
            JoursSemaine joursSemaine,
            double seuilRabais,
            double temperature) {
        this.nom = nom;
        this.prix = prix;
        this.joursSemaine = joursSemaine;
        this.seuilRabais = seuilRabais;
        this.temperature = temperature;
    }

    public double calculeRabais(double montantTotal) {

        double rabaisRepas = 0;

        // rabais météo
        rabaisRepas += temperature < 0 ? -Math.max(-30, Math.min(temperature, 0)) * prix / 100.0f : 0;

        // rabais de volume
        if (montantTotal > seuilRabais) {
            rabaisRepas += prix * RABAIS_POUR_SEUIL;
        }

        // rabais journalier
        if (joursSemaine.equals(JoursSemaine.JEUDI)
                || joursSemaine.equals(JoursSemaine.VENDREDI)) {
            rabaisRepas += prix * RABAIS_JOURNALIER;
        }
        return limiteRabais(rabaisRepas);
    }

    public double limiteRabais(double rabais) {
        return Math.min(prix, Math.max(0, rabais));
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }
}
