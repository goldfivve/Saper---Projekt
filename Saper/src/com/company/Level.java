package com.company;
/** klasa rodzic dla klas Beginner, Medium i Advanced, okresla atrybuty planszy uzaleznione od poziomu (rozmiar, procent min, liczba min ), a klasy dziedziczace odpowiednio je inicjalizuja. */
public class Level {
/** zmienna przechowujaca rozmiar planszy*/
    public static int size;
    /** zmienna przechowujaca liczbe min na planszy */
    public static int mineNumber;
    /** zmienna przechowujaca procent liczby min wzgledem liczby pol na planszy */
    public double percent;

    Level(){
        this.size=size;
        this.percent=percent;
        this.mineNumber= (int)(size*size*percent);
    }
}
