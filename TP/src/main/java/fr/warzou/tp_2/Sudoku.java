package fr.warzou.tp_2;

import java.util.Arrays;

public class Sudoku {
	/*
	 * 
	 * L2 - PO, TP n 2 
	 * Auteur : XXX
	 * 
	 */
	static final int n = 3 ;		// taille des regions
	/*
	 * Terminologie
	 * 
	 * m est un plateau (de sudoku) si
	 * 	- m est un int [][] ne contenant que des entiers compris entre 0 et 9
	 * 	- m.length = n^2
	 *  - m[i].length = n^2 pour tous les i de 0 a n^2-1
	 *  
	 */

	static String enClair (int [][] m) {
		/*
		 * Prerequis : m est un plateau de sudoku
		 * Resultat : une chaine dont l'affichage permet de visualiser m
		 * 
		 */
		String r = "" ;		
		for (int i = 0; i < n*n ; i++) {
			for (int j = 0; j < n*n ; j++) {
				r = r + m[i][j] + " " ;
				if (j%n == n-1) {r = r + "  ";}
			}
			if (i%n == n-1) {r = r + "\n";}
			r = r + "\n";
		}		
		r = r + " " ;		
		return r ;
	} // enClair
	
	static int [][] aPartirDe (String s) {
		/*
		 * Prerequis : s est une chaine contenant au moins n^4 chiffres decimaux
		 * Resultat : un plateau de sudoku initialise avec les n^4 premiers chiffres
		 * decimaux de s (les chiffres sont consideres comme ranges par lignes).
		 */
		int [][] m = new int [n*n][n*n] ;
		int k = 0 ;
		for (int i = 0; i < m.length ; i++) {
			for (int j = 0; j < m[i].length ; j++) {
				while ("0123456789".indexOf(s.charAt(k))==-1) {k++;}
				m[i][j] = (int) s.charAt(k) - (int) '0' ;
				k++ ;
			}			
		}
		return m ;
		
	} // aPartirDe

	/**
	 * @param m sukodu
	 * @param v valeur
	 * @param i ligne
	 * @return v est present dans la ligne i
	 */
	static boolean presentLigne(int [][] m, int v, int i) {
		/*
		 * Prerequis :
		 *  - m est un plateau de sudoku
		 *  - v est compris entre 1 et n^2
		 *  - i est compris entre 0 et n^2-1
		 * Resultat : dans m, v est present dans la ligne i
		 * 
		 */
		for (int j = 0; j < m[i].length; j++)
			if (m[i][j] == v) return true;
		return false;
	} // presentLigne

	/**
	 * @param m sudoku
	 * @param v valeur
	 * @param j colonne
	 * @return v est present dans la colonne i
	 */
	static boolean presentColonne(int [][] m, int v, int j) {
		/*
		 * Prerequis :
		 *  - m est un plateau de sudoku
		 *  - v est compris entre 1 et n^2
		 *  - j est compris entre 0 et n^2-1
		 * Resultat : dans m, v est present dans la colonne j
		 * 
		 */
		for (int i = 0; i < m[j].length; i++)
			if (m[i][j] == v) return true;
		return false;
	} // presentColonne

	/**
	 * @param m sudoku
	 * @param v value
	 * @param i ligne
	 * @param j colonne
	 * @return v est present dans la region contenant le point (i ; j)
	 */
	static boolean presentRegion(int [][] m, int v, int i, int j) {
		/*
		 * Prerequis :
		 *  - m est un plateau de sudoku
		 *  - v est compris entre 1 et n^2
		 *  - i et j sont compris entre 0 et n^2-1
		 * Resultat : dans m, v est present dans la region contenant la case <i, j>
		 * 
		 */
		int[] region = region(i, j);
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (m[region[0] + x][region[1] + y] == v) return true;
			}
		}
		return false;
	} // presentRegion

	/**
	 * @param m le sudoku
	 * @param i une ligne
	 * @param j une colonne
	 * @return un tableau contenant (l'<code>index + 1</code> est possible au point (i ; j)
	 */
	static boolean [] lesPossiblesEn(int [][] m, int i, int j) {
		/*
		 * Prerequis :
		 *  - m est un plateau de sudoku
		 *  - i et j sont compris entre 0 et n^2-1
		 *  - m[i][j] vaut 0
		 * Resultat : un tableau r de longueur n^2+1 tel que, dans la tranche r[1..n^2]
		 * r[v] indique si v peut etre place en <i, j>
		 * 
		 */
		boolean[] array = new boolean[n * n];
		for (int k = 0; k < array.length; k++) array[k] = estPossible(m, i, j, k + 1);
		return array;
	} // lesPossiblesEn
	
	static String enClair(boolean[] t) {
		/*
		 * Prerequis : t.length != 0
		 * Resultat :
		 * une chaine contenant tous les indices i de la tranche [1..t.length-1] tels
		 * que t[i] soit vrai
		 */
		String r = "{" ;
		for (int i = 1; i < t.length; i++) {
			if (t[i]) {r = r + i + ", " ; }
		}
		if (r.length() != 1) {r = r.substring(0, r.length()-2);}
		return r + "}" ;
	} // enClair

	/**
	 * @param m un sudoku
	 * @param i une ligne
	 * @param j une colonne
	 * @return -1 s'il y a plusieurs possibilitees au point (i ; j) sinon la seul possibilitee en ce point
	 */
	static int toutSeul(int[][] m, int i, int j) {
		/*
		 * Prerequis :
		 *  - m est un plateau de sudoku
		 *  - i et j sont compris entre 0 et n^2-1
		 *  - m[i][j] vaut 0
		 * Resultat :
		 *  - v 	si la seule valeur possible pour <i, j> est v
		 *  - -1 	dans les autres cas
		 * 
		 */
		boolean[] possible = lesPossiblesEn(m, i, j);
		int valeurPossible = 0;
		for (int k = 0; k < possible.length; k++) {
			if (possible[k] && valeurPossible == 0) valeurPossible = k + 1;
			else if (possible[k] && valeurPossible != 0) return -1;
		}
		return valeurPossible == 0 ? -1 : valeurPossible;
	} // toutSeul

	/**
	 * @param grille sudoku en clair
	 */
	static void essais(String grille) {
		/*
		 * Prerequis : grille represente une grille de sudoku
		 * (les chiffres sont consideres comme ranges par lignes)
		 * 
		 * Effet :
		 * 1) affiche en clair la grille
		 * 2) affecte, tant que faire se peut, toutes les cases pour lesquelles il n'y
		 *    a qu'une seule possibilite
		 * 3) affiche en clair le resultat final
		 */
		int[][] m = aPartirDe(grille);
		System.out.println("Probleme\n\n"+enClair(m));

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != 0)
					continue;

				int value;
				if ((value = toutSeul(m, i, j)) != -1)
					m[i][j] = value;
			}
		} // On remarque que les changements precendant influe les changements suivant.
		
		System.out.println("Il se peut qu'on ait avance\n\n"+enClair(m));
	} // essais

	/**
	 * @param m un sudoku
	 * @param i une ligne
	 * @param j une colonne
	 * @param value une valeur
	 * @return <code>value</code> est plaçable au point (i ; j)
	 */
	private static boolean estPossible(int[][] m, int i, int j, int value) {
		return !presentLigne(m, value, i) && !presentColonne(m, value, j) && !presentRegion(m, value, i, j);
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
		String grille1 = 
			"040 001 006 \n" +
			"007 900 800 \n" +
			"190 086 074 \n" +
			"            \n" +
			"200 690 010 \n" +
			"030 405 090 \n" +
			"060 017 003 \n" +
			"            \n" +
			"910 750 042 \n" +
			"008 002 700 \n" +
			"400 300 080   " ;

		int[][] sudoku = aPartirDe(grille1);
		/*print -> resultat attendu*/
		System.out.println(presentLigne(sudoku, 5, 0)); // false
		System.out.println(presentLigne(sudoku, 1, 2)); // true
		System.out.println(presentColonne(sudoku, 8, 0)); // false
		System.out.println(presentColonne(sudoku, 8, 2)); // true
		System.out.println(presentRegion(sudoku, 8, 0, 0)); // false
		System.out.println(presentRegion(sudoku, 1, 3, 3)); // true
		System.out.println(presentRegion(sudoku, 1, 7, 8)); // false
		System.out.println(Arrays.toString(lesPossiblesEn(sudoku, 0, 0))); // [false, false, true, false, true, false, false, true, false]
		System.out.println(Arrays.toString(lesPossiblesEn(sudoku, 6, 1))); // [false, false, false, false, false, false, false, false, false]
		System.out.println(toutSeul(sudoku, 0, 0)); // -1
		System.out.println(toutSeul(sudoku, 6, 1)); // -1
		System.out.println(toutSeul(sudoku, 4, 4)); // 2
		System.out.println(Arrays.toString(region(0, 0))); // [0, 0]
		System.out.println(Arrays.toString(region(2, 7))); // [0, 6]
		System.out.println(Arrays.toString(region(8, 1))); // [6, 0]

		System.out.println("Essai grille à probleme !");
		String grilleAProbleme =
				"""
						040 401 006\s
						407 900 800\s
						190 086 074\s
						           \s
						200 690 010\s
						030 405 090\s
						060 017 003\s
						           \s
						910 750 042\s
						008 002 700\s
						400 300 080  \s""";
		// deux 4 sur la ligne 0 la colonne 0, la region [0, 0]
		essais(grilleAProbleme);
		// Si la grille est fausse au depart il n'y a pas d'erreur.

		String grille2 = 
			"030 000 006 \n" +
			"000 702 300 \n" +
			"104 038 000 \n" +
			"            \n" +
			"300 020 810 \n" +
			"918 000 265 \n" +
			"062 050 007 \n" +
			"            \n" +
			"000 140 708 \n" +
			"001 209 000 \n" +
			"800 000 020   " ;
		
		essais(grille1);
		essais(grille2) ;
	}
		
}