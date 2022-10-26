package fr.warzou.td_4;

public class Rationnel {

    private final int a;
    private final int b;

    public Rationnel(int a) {
        this(a, 1);
    }

    public Rationnel(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Cannot divide by 0 !");

        this.a = a;
        this.b = b;
    }

    public static Rationnel somme(Rationnel x, Rationnel y) {
        return new Rationnel(x.a * y.b + x.b * y.a, x.b * y.b);
    }

    public static Rationnel produit(Rationnel x, Rationnel y) {
        return new Rationnel(x.a * y.a, x.b * y.b);
    }

    public static Rationnel quotient(Rationnel x, Rationnel  y) {
        return new Rationnel(x.a * y.b, x.b * y.a);
    }

    public static boolean egal(Rationnel x, Rationnel y) {
        return x.a == y.a && x.b == y.b;
    }

    @Override
    public String toString() {
        String string = "";
        if (this.b == -1 || this.b == 1)
            return this.b * this.a + "";
        else {
            int[] simplify = simplify(this.a, this.b);
            int a = simplify[0];
            int b = simplify[1];
            return b == -1 || b == 1 ? b * a + "" : a + "/" + b;
        }
    }

    private int[] simplify(int a, int b) {
        if (gcd(a, b) == 1)
            return new int[] {a, b};

        int gcd = gcd(a, b);
        return simplify(a / gcd, b / gcd);
    }

    private int gcd(int a, int b) {
        int remainder;
        while ((remainder = a % b) != 0) {
            a = b;
            b = remainder;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Rationnel(10, 6));
    }
}
