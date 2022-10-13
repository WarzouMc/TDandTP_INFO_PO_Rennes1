package fr.warzou.tp_1;

public class Exo1 {

    public static int compteMal(int n) {
        int compteur = 0;
        for (int i = 0; i < n ; i++) {
            compteur += (i + 1);
        }
        return compteur ;
    }

    public static void main(String [] args) {
        System.out.println("Hello world");
        int n = 5;
        int resultat = compteMal ( n ) ;
        System . out . println ( " La somme des " + n + " premiers entiers est : "
                + resultat + " ? " ) ;
    }
}
