package fr.warzou.td_2;

/**
 * Use static to not create junit test (flemme de faire les test en vrais)
 */
public class TD_2 {

    public static void main(String[] args) {

    }

    public static String enClaire(boolean[] booleans) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < booleans.length; i++)
            if (booleans[i]) builder.append(i).append(", ");

        return builder.substring(0, builder.length() - 2);
    }

    public static int indiceDuMax(int[] ints) {
        int index = 0;
        for (int i = 0; i < ints.length; i++)
            if (ints[i] > ints[index]) index = i;

        return index;
    }

    public static int[] lePlusGrandALaFin(int[] ints) {
        int index = indiceDuMax(ints);
        int[] newInts = new int[ints.length];
        newInts[index] = ints[ints.length - 1];
        newInts[ints.length - 1] = ints[index];

        for (int i = 0; i < ints.length - 1; i++) {
            if (i == index)
                continue;
            newInts[i] = ints[i];
        }

        return newInts;
    }

    /**
     * @param matrix a square matrix
     * @return matrix is diagonal
     */
    public static boolean estDiagonal(int[] matrix) {
        int size = (int) Math.sqrt(matrix.length);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    continue;
                if (matrix[i + size * j] != 0) return false;
            }
        }
        return true;
    }

    /**
     * @param matrix a square matrix
     * @return matrix transposition
     */
    public static int[] transpose(int[] matrix) {
        int size = (int) Math.sqrt(matrix.length);
        int[] transpose = new int[matrix.length];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) transpose[j + size * i] = matrix[i + size * j];
        }

        return transpose;
    }
}
