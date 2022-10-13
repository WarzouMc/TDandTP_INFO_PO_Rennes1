package fr.warzou.td_1;

import java.util.Scanner;

import static java.lang.Math.abs;

public class TD1 {

    public static void main(String[] args) {
        // 2
        int a = 0;
        int b = 1;
        int temps = a;
        a = b;
        b = temps;
        System.out.println(a + " " + b);

        // 3
        //date();

        // 4
        //nNames();

        // 5
        //vectors();

        // 6
        pin();
    }

    // 3
    public static void date() {
        Scanner scanner = new Scanner(System.in);
        int mount = scanner.nextInt();
        while (mount > 12 || mount < 1)
            mount = scanner.nextInt();

        int day = scanner.nextInt();
        while (day > 31 || day < 1)
            day = scanner.nextInt();

        System.out.println((mount == 9 && day >= 22) || (mount > 9 && mount < 12) || (mount == 12 && day <= 20));
    }

    // 4
    public static void nNames() {
        Scanner scanner = new Scanner(System.in);
        int size;
        String[] names = new String[size = Math.abs(scanner.nextInt())];

        for (int i = size - 1; i >= 0; i--)
            names[i] = scanner.nextLine();

        for (String name : names)
            System.out.println(name);

        StringBuilder builder = new StringBuilder();
        for (String name : names)
            builder.append(name).append(", ");
        System.out.println(builder.substring(0, builder.length() - 2));
    }

    // 5
    public static double vectors() {
        double[] vector0 = new double[100];
        double[] vector1 = new double[100];

        // produit scalaire
        double result = 0.0d;
        for (int i = 0; i < vector0.length; i++)
            result += vector0[i] * vector1[i];

        return result;
    }

    public static void pin() {
        String pinCorrect = "0000";
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = 0;
        while (!line.equals(pinCorrect)) {
            count++;
            if (count == 3)
                throw new RuntimeException("Too many try !");
            line = scanner.nextLine();
        }
    }
}
