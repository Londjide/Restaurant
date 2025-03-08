package h25.msd.poo2.menu;

public interface MenuItem {
    String getNom();

    double getPrix();

    double calculeRabais(double montantTotal);
}