package fr.warzou.tp_1;

public class Exo5 {

    public static void main(String[] args) {
        System.out.println(mirror(21));
    }

    public static int mirror(int n) {
        int base = (int) Math.log10(n);
        int mirror = 0;
        for (int i = 0; i < base + 1; i++) {
            int intAt = (int) (n / (Math.pow(10, base - i)));
            n -= intAt * Math.pow(10, base - i);
            mirror += intAt * Math.pow(10, i);
        }
        return mirror;
    }

}
