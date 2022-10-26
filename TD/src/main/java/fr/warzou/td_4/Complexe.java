package fr.warzou.td_4;

import java.util.Scanner;

public class Complexe {

    private final double real;
    private final double imaginary;

    public Complexe(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static double module(Complexe complexe) {
        return complexe.module();
    }

    public double module() {
        return Math.sqrt(square(this.real) + square(this.imaginary));
    }

    public static Complexe add(Complexe complexe0, Complexe complexe1) {
        return complexe0.add(complexe1);
    }

    public Complexe add(Complexe complexe) {
        return new Complexe(this.real + complexe.real, this.imaginary + complexe.imaginary);
    }

    public static Complexe mul(Complexe complexe0, Complexe complexe1) {
        return complexe0.mul(complexe1);
    }

    public Complexe mul(Complexe complexe) {
        return new Complexe(this.real * complexe.real - this.imaginary * complexe.imaginary,
                this.real * complexe.imaginary + this.imaginary * complexe.real);
    }

    public static String enClair(Complexe complexe) {
        return complexe.toString();
    }

    @Override
    public String toString() {
        return "Complexe{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }

    private double square(double d) {
        return d * d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Complexe complexe = new Complexe(x, y);
        Complexe one = new Complexe(1, 0);
        System.out.println(complexe.mul(complexe.add(one)).add(one));
    }
}
