package com.company;
/**
 klasa odpowiedzialna za utworzenie okna dla planszy dla poziomu zaawansowanego, dziedziczy po MainWindow.
 */
public class AdvancedWindow extends MainWindow {
    public AdvancedWindow() {
        super();
        setComponents();
        /* wywolanie metody okreslajacej, co stanie sie po zamknieciu okna poprzez dobranie odpowiedniego parametru, w tym przypadku okno zostanie zamkniete i wykonywanie programu zakonczone*/
        this.setDefaultCloseOperation(3);
    }
    /** wygenerowanie planszy, wykorzystanie obiektu klasy Advanced jako parametru konstruktora klasy Board słuzacemu przekazaniu parametrow planszy dla poziomu*/
    private void setComponents() {
        Advanced advanced = new Advanced();
        /**obiekt klasy Board, ktory wykorzystywany jest do stworzenia zawartosci okna - planszy gry*/
        Board board = new Board(advanced);
        this.setContentPane(board);
    }
}
