package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
klasa odpowiedzialna za utworzenie okna menu glownego, dziedziczy po MainWindow.
 */
public class MenuWindow extends MainWindow implements ActionListener{
    /** przycisk do wybrania poziomu poczatkujacego*/
    JButton beginnerButton;
    /** przycisk do wybrania poziomu sredniego*/
    JButton mediumButton;
    /** przycisk do wybrania poziomu zaawansowanego*/
    JButton advancedButton;
    /** przycisk wyjscia*/
    JButton exitButton;
    /**etykieta z nazwa gry*/
    JLabel minesweeperLabel;
    public MenuWindow(){
        super();
        initComponents();
    }

    /**umieszczenie przyciskow, etykiet w oknie*/
    private void initComponents(){

        /* utworzenie obiektow i nadanie nazw przyciskom i etykiecie w parametrze konstruktorow*/
        minesweeperLabel = new JLabel("Minesweeper");
        beginnerButton = new JButton("Beginner");
        mediumButton = new JButton("Medium");
        advancedButton = new JButton("Advanced");
        exitButton = new JButton("Exit");

        /** kontener przechowujacy przyciski i etykiete w oknie*/
        Container container = this.getContentPane();
        container.setLayout(null);

        /*ustalanie lokalizacji, rozmiarow w oknie dla przyciskow i etykiety*/
        minesweeperLabel.setLocation(307,150);
        minesweeperLabel.setSize(100,50);
        beginnerButton.setLocation(296,250);
        beginnerButton.setSize(100,50);
        mediumButton.setLocation(296,350);
        mediumButton.setSize(100,50);
        advancedButton.setLocation(296,450);
        advancedButton.setSize(100,50);
        exitButton.setLocation(296,650);
        exitButton.setSize(100,50);

        /*dodawanie odpowiednich akcji przyciskom po ich wcisnięciu*/
        beginnerButton.addActionListener(this);
        mediumButton.addActionListener(this);
        advancedButton.addActionListener(this);
        exitButton.addActionListener(this);


        /*dodawanie przyciskow i etykiety do kontenera*/
        container.add(minesweeperLabel);
        container.add(beginnerButton);
        container.add(mediumButton);
        container.add(advancedButton);
        container.add(exitButton);
    }

    @Override
    /**nadpisana metoda interfejsu ActionListener, ustala, ze po wcisnicciu przyciskow otwierane sa odpowiednie okna poziomow, a zamykane okno menu glownego*/
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==beginnerButton){
            new BeginnerWindow().setVisible(true);
            this.dispose();
        }
        if (e.getSource()==mediumButton){
            new MediumWindow().setVisible(true);
            this.dispose();
        }
        if(e.getSource()==advancedButton){
            new AdvancedWindow().setVisible(true);
            this.dispose();
        }
        if(e.getSource()==exitButton){

            this.dispose();
        }
    }
}
