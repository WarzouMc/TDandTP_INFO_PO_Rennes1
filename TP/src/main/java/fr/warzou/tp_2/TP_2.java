package fr.warzou.tp_2;

import java.util.Arrays;

import static fr.warzou.tp_2.Sudoku.*;

public class TP_2 {
    static final int n = 3;
    int[][] plateau = new int[n * n][n * n];

    /**
     * @param m sukodu
     * @param v valeur
     * @param i ligne
     * @return v est present dans la ligne i
     */
    public static boolean presentLigne(int[][] m, int v, int i) {
        for (int j = 0; j < m[i].length; j++)
            if (m[i][j] == v) return true;
        return false;
    }

    /**
     * @param m sukodu
     * @param v valeur
     * @param i colonne
     * @return v est present dans la colonne i
     */
    public static boolean presentColonne(int[][] m, int v, int i ) {
        for (int j = 0; j < m[i].length; j++)
            if (m[j][i] == v) return true;
        return false;
    }

    /**
     * @param m sudoku
     * @param v value
     * @param i ligne
     * @param j colonne
     * @return v est present dans la region contenant le point (i ; j)
     */
    public static boolean estPresentRegion(int[][] m, int v, int i, int j) {
        int[] region = region(i, j);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (m[region[0] + x][region[1] + y] == v) return true;
            }
        }
        return false;
    }

    /**
     * @param m le sudoku
     * @param i une ligne
     * @param j une colonne
     * @return un tableau contenant (l'<code>index + 1</code> est possible au point (i ; j)
     */
    public static boolean[] lesPossiblesEn(int[][] m, int i, int j) {
        boolean[] array = new boolean[n * n];
        for (int k = 0; k < array.length; k++) array[k] = estPossible(m, i, j, k + 1);
        return array;
    }

    /**
     * @param m un sudoku
     * @param i une ligne
     * @param j une colonne
     * @return -1 si il y a plusieurs possibilitees au point (i ; j) sinon la seul possibilitee en ce point
     */
    public static int toutSeul(int[][] m, int i, int j ) {
        boolean[] possible = lesPossiblesEn(m, i, j);
        int valeurPossible = 0;
        for (int k = 0; k < possible.length; k++) {
            if (possible[k] && valeurPossible == 0) valeurPossible = k + 1;
            else if (possible[k] && valeurPossible != 0) return -1;
        }
        return valeurPossible;
    }

    /**
     * @param grille sudoku en clair
     */
    private static void essais(String grille) {
        int [][] m = aPartirDe(grille);
        System.out.println("Problème \n\n" + enClair(m));
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] != 0)
                    continue;

                int value;
                if ((value = toutSeul(m, i, j)) != -1)
                    m[i][j] = value;
            }
        }
        System.out.println("Il se peut qu' on ait avancé \n\n" + enClair(m));
    }

    /**
     * @param m un sudoku
     * @param i une ligne
     * @param j une colonne
     * @param value une valeur
     * @return <code>value</code> est plaçable au point (i ; j)
     */
    private static boolean estPossible(int[][] m, int i, int j, int value) {
        return !presentLigne(m, value, i) && !presentColonne(m, value, j) && !estPresentRegion(m, value, i, j);
    }

    /**
     * @param i ligne de la case
     * @param j colonne de la case
     * @return les coordonnes du point le plus en haut à gauche de la region contenant le point (i ; j)
     */
    private static int[] region(int i, int j) {
        return new int[] {n * (i / n), n * (j / n)};
    }

    public static void main(String[] args) {
        String grille0 = """
                 000 402 000\s
                 030 000 090\s
                 902 000 105\s
                \s
                 000 010 000\s
                 500 603 002\s
                 020 000 070\s
                \s
                 408 901 507\s
                 090 000 040\s
                 003 705 900\s""";
        int[][] sudoku = aPartirDe(grille0);
        /*print -> resultat attendu*/
        System.out.println(presentLigne(sudoku, 5, 0)); // false
        System.out.println(presentLigne(sudoku, 5, 2)); // true
        System.out.println(presentColonne(sudoku, 8, 0)); // false
        System.out.println(presentColonne(sudoku, 8, 2)); // true
        System.out.println(estPresentRegion(sudoku, 1, 0, 0)); // false
        System.out.println(estPresentRegion(sudoku, 1, 3, 3)); // true
        System.out.println(estPresentRegion(sudoku, 1, 7, 8)); // false
        System.out.println(Arrays.toString(lesPossiblesEn(sudoku, 0, 0))); // [true, false, false, false, false, true, true, true, false]
        System.out.println(Arrays.toString(lesPossiblesEn(sudoku, 6, 1))); // [false, false, false, false, false, true, false, false, false]
        System.out.println(toutSeul(sudoku, 0, 0)); // -1
        System.out.println(toutSeul(sudoku, 6, 1)); // 6
        System.out.println(Arrays.toString(region(0, 0))); // [0, 0]
        System.out.println(Arrays.toString(region(2, 7))); // [0, 6]
        System.out.println(Arrays.toString(region(8, 1))); // [6, 0]

        String grille1 = """
                 075 000 000\s
                 896 000 000\s
                 234 567 890\s
                \s
                 007 000 000\s
                 008 000 000\s
                 009 000 000\s
                \s
                 002 000 000\s
                 003 000 000\s
                 000 000 000\s""";

        essais(grille1); // met un 1 aux positions [0, 0], [2, 8], [8, 2]
    }
}
