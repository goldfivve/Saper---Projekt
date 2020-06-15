package com.company;
/**
 klasa odpowiedzialna za utworzenie okna dla planszy dla poziomu sredniego, dziedziczy po MainWindow.
 */
public class MediumWindow extends MainWindow {
    public MediumWindow() {
        super();
        setComponents();
        /* wywolanie metody okreslajacej, co stanie sie po zamknieciu okna poprzez dobranie odpowiedniego parametru, w tym przypadku okno zostanie zamkniete i wykonywanie programu zakonczone*/
        this.setDefaultCloseOperation(3);
    }
    /** wygenerowanie planszy, wykorzystanie obiektu klasy Medium jako parametru konstruktora klasy Board sluzacemu przekazaniu parametrow planszy dla poziomu*/
    private void setComponents(){

        Medium medium = new Medium();
        /**obiekt klasy Board, ktory wykorzystywany jest do stworzenia zawartosci okna - planszy gry*/
        Board board = new Board(medium);
        this.setContentPane(board);
    }

}
