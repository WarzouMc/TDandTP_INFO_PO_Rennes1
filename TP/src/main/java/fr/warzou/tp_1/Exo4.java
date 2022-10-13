package fr.warzou.tp_1;

public class Exo4 {

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                StdDraw.circle(0.05 + 0.1 * i, 0.05 + 0.1 * (9 - j), 0.05);
            }
        }
    }

}
