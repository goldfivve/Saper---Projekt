package com.company;

import javax.swing.*;
import java.awt.*;
/** klasa abstrakcyjna, w ktorej okreslone sa parametry okna (wymiary, polozenie na ekranie, tytul), dzieki dziedziczeniu po klasie JFrame i korzystaniu z jej metod. */
 public abstract class MainWindow extends JFrame {

    protected MainWindow() {
        /*nadanie tytulu*/
        this.setTitle("Minesweeper");
        /*ustalenie wymiarow*/
        this.setSize(692,800);
        /*pobranie wymiarow ekranu*/
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = this.getSize().width;
        int screenHeight = this.getSize().height;
        /*ustalenie lokalizacji okna na ekranie*/
        this.setLocation((width-screenWidth)/2,(height-screenHeight)/2);
        /*wywolanie metody okreslajacej, co stanie sie po zamknięciu okna poprzez dobranie odpowiedniego parametru, w tym przypadku okno zostanie zamkniete i wykonywanie programu zakonczone*/
        this.setDefaultCloseOperation(3);
    }
}
