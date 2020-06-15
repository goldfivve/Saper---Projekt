package com.company;
import java.awt.*;
/**dziedziczy po klasie Rectangle, dzieki czemu kazde pole planszy jako obiekt klasy Field funkcjonuje jako obszar w ksztalcie kwadratow o roznych wlasciwosciach (chociazby kolor), ale takze zawiera inne atrybuty, jak wartosci logiczne, czy pole zostalo odkryte, czy zawiera mine,  czy jest oflagowane, a takze wartosc liczbowa w postaci min wokol.*/
public class Field extends Rectangle {
    /**zmienna logiczna przechowujaca wartosc dla pola, czy jest na nim mina*/
    public boolean isMine;
    /**zmienna logiczna przechowujaca wartosc dla pola, czy jest na nim flaga*/
    public boolean isFlag;
    /**zmienna logiczna przechowujaca wartosc dla pola, czy jest zakryte*/
    public boolean isCovered;
    /**zmienna przechowujaca liczbe min wokol pola*/
    public int minesAround;
    /**zmienna przechowujaca kolor pola*/
    public Color rectangleColor;
    /**zmienna przechowujaca kolor liczby min wokol pola*/
    public Color numberColor;

    /**zawiera parametry takie jak wspolrzedne pola, wysokosc i szerokosc pola*/
    public Field(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.isMine = false;
        this.isFlag = false;
        this.isCovered = true;
        this.minesAround = 0;
        this.rectangleColor = Color.DARK_GRAY;
        this.numberColor = Color.DARK_GRAY;

    }
}
