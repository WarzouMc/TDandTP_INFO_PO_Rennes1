package fr.warzou.tp_1;

public class Exo2 {

    public static void main(String[] args) {
        System.out.println(contain(1, "test", "e"));
        System.out.println(indexOf("test", "t"));
    }

    public static boolean contain(int k, String string, String sequence) {
        if ((k = Math.abs(k)) >= string.length() || k + sequence.length() >= string.length())
            return false;
        return string.startsWith(sequence, k);
    }

    public static int indexOf(String string, String sequence) {
        int index = 0;
        while (index < string.length() && !contain(index, string, sequence)) index++;
        return index == string.length() ? -1 : index;
    }

}
