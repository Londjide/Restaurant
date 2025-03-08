package h25.msd.poo2.menu;

public class Entree {
    public static final double RABAIS_POUR_SEUIL = 0.05;
    public static final double RABAIS_DINER = 0.02;

    private double prix;
    private String nom;
    private PeriodeJournee periodeJournee;
    private double seuilRabais;
    private double temperature;

    public Entree(
            String nom,
            double prix,
            PeriodeJournee periodeJournee,
            double seuilRabais,
            double temperature) {
        this.nom = nom;
        this.prix = prix;
        this.periodeJournee = periodeJournee;
        this.seuilRabais = seuilRabais;
        this.temperature = temperature;
    }

    public double calculeRabais(double montantTotal) {

        double rabaisEntree = 0;

        //rabais météo
        rabaisEntree = temperature < 0 ? -Math.max(-30, Math.min(temperature, 0)) * prix / 100.0f: 0;

        // rabais de volume
        if (montantTotal > seuilRabais) {
            rabaisEntree += prix * RABAIS_POUR_SEUIL;
        }

        // rabais moment du jour
        if (periodeJournee.equals(PeriodeJournee.DINER)) {
            rabaisEntree += prix * RABAIS_DINER;
        }
        return limiteRabais(rabaisEntree);
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
