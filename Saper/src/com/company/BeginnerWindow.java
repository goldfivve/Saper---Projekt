package com.company;
/**
 klasa odpowiedzialna za utworzenie okna dla planszy dla poziomu poczatkujacego, dziedziczy po MainWindow.
 */
public class BeginnerWindow extends MainWindow {


    BeginnerWindow(){
        super();
        setComponents();
        /* wywolanie metody okreslajacej, co stanie sie po zamknięciu okna poprzez dobranie odpowiedniego parametru, w tym przypadku okno zostanie zamkniete i wykonywanie programu zakonczone*/
        this.setDefaultCloseOperation(3);
    }
/** wygenerowanie planszy, wykorzystanie obiektu klasy Beginner jako parametru konstruktora klasy Board sluzącemu przekazaniu parametrow planszy dla poziomu*/
    private void setComponents(){
        Beginner beginner = new Beginner();
        /**obiekt klasy Board, ktory wykorzystywany jest do stworzenia zawartosci okna - planszy gry*/
        Board board = new Board(beginner);
        this.setContentPane(board);

    }

}
