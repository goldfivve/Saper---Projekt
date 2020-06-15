package com.company;

/**
 *odpowiada z uruchomienie programu poprzez wywolanie konstruktora klasy MenuWindow i utworzenie okna za pomoca metody setVisible() : boolean z klasy Window.*/
public class Main {
/** Glowna metoda odpowiadajaca za uczynienie okna widocznym*/
    public static void main(String[] args) {
        new MenuWindow().setVisible(true);
    }
}
