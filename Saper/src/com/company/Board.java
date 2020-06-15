package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
/**dziedziczy po klasie JPanel oraz implementuje interfejs MouseListener, dzieki czemu mozliwe jest zarzadzanie plansza za pomoca klikniec myszki i obsluga zdarzen poprzez zmiane wartosci atrybutow tablicy dwuwymiarowej typu Field, a takze samo utworzenie planszy gry. */
public class Board extends JPanel implements MouseListener {
    /** tablica pól*/
    private Field [][] tile;
    /**zmienna przechowujaca wartosc odpowiadajaca rozmiarowi planszy*/
    private int value;
    /** zmienna przechowujaca liczbe min na planszy*/
    private int minesValue;
    /** zmienna przechowujaca wartosc 0 lub 1, ktore reguluja dzialanie metody paintComponent*/
    private int start;
    /**zmienna przechowujaca liczbe flag*/
    private int flags;
    /**obiekt potrzebny do rysowania liczb na planszy*/
    Integer [][]integer;
    /** zmienna przechowujaca wartoaci 0 lub wyzsze, zlicza kliknięcia na planszy*/
    private int click;
    /**zmienna przechowujaca wartosci od 1 do 3 odpowiednio do poziomow trudnosci*/
    private int difficultyLevel;



    /**parametr to obiekt klasy dziedziczacej po klasie Level*/
    public Board(Level level) {

        start = 0;
        click = 0;

        if (level instanceof Beginner) {
            difficultyLevel = 1;
            value = Beginner.size;
            tile = new Field[value][value];
            minesValue = Beginner.mineNumber;
            flags = minesValue;
            integer = new Integer[value][value];
            for (int i=0;i<value;i++){
                for (int j=0; j<value; j++){

                    integer[i][j] = 0;
                }
            }
        }
        if (level instanceof Medium) {
            difficultyLevel = 2;
            value = Medium.size;
            tile = new Field[value][value];
            minesValue = Medium.mineNumber;
            flags = minesValue;
            integer = new Integer[value][value];
            for (int i=0;i<value;i++){
                for (int j=0; j<value; j++){
                    integer [i][j] = 0;
                }
            }
        }
        if (level instanceof Advanced) {
            difficultyLevel = 3;
            value = Advanced.size;
            tile = new Field[value][value];
            minesValue = Advanced.mineNumber;
            flags = minesValue;
            integer = new Integer[value][value];
            for (int i=0;i<value;i++){
                for (int j=0; j<value; j++){
                    integer [i][j] = 0;
                }
            }
        }
        addMouseListener(this);
    }

    @Override
    /**nadpisana metoda klasy JComponent, rysowanie planszy, zmiana kolorw pol i numerow min wokol*/
    public void paintComponent(Graphics graphics){

        if(start==0) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, 692, 800);
            graphics.setColor(Color.DARK_GRAY);
            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {

                    if(difficultyLevel==1){
                        graphics.fillRect(132 + (54 * j), 200 + (54 * i), 50, 50);
                        tile[i][j] = new Field(132 + (54 * j), 200 + (54 * i), 50, 50);
                    }
                    if(difficultyLevel==2){
                        graphics.fillRect(116+(29 * j), 200 + (29 * i), 25, 25);
                        tile[i][j]=new Field(116+(29 * j), 200 + (29 * i), 25, 25);
                    }
                    if(difficultyLevel==3){
                        graphics.fillRect((29 * j), 50 + (29 * i), 25, 25);
                        tile[i][j]=new Field((29 * j), 50 + (29 * i), 25, 25);
                    }
                }
            }
            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    graphics.setColor(tile[i][j].numberColor);

                    if(difficultyLevel==1){
                        graphics.setFont(new Font("Arial",Font.BOLD,25));
                        graphics.drawString(Integer.toString(integer[i][j]),132 + (54 * j)+19,200 + (54 * i)+33);
                    }
                    if(difficultyLevel==2){
                        graphics.setFont(new Font("Arial",Font.BOLD,15));
                        graphics.drawString(Integer.toString(integer[i][j]),116+(29 * j)+9,200 + (29 * i)+17);
                    }
                    if(difficultyLevel==3){
                        graphics.setFont(new Font("Arial",Font.BOLD,15));
                        graphics.drawString(Integer.toString(integer[i][j]),(29 * j)+9,50 + (29 * i)+17);
                    }
                }
            }
        }
        if(start == 1){

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    graphics.setColor(tile[i][j].rectangleColor);
                    if (difficultyLevel==1) {
                        graphics.fillRect(132 + (54 * j), 200 + (54 * i), 50, 50);
                        if (!tile[i][j].isCovered) {
                            graphics.setColor(tile[i][j].numberColor);
                            graphics.setFont(new Font("Arial", Font.BOLD, 25));
                            graphics.drawString(Integer.toString(integer[i][j]), 132 + (54 * j) + 19, 200 + (54 * i) + 33);
                        }
                    }
                    if (difficultyLevel == 2) {
                            graphics.fillRect(116 + (29 * j), 200 + (29 * i), 25, 25);
                            if(!tile[i][j].isCovered){
                                graphics.setColor(tile[i][j].numberColor);
                                graphics.setFont(new Font("Arial", Font.BOLD, 15));
                                graphics.drawString(Integer.toString(integer[i][j]),116+(29 * j)+9,200 + (29 * i)+17);

                            }
                    }
                    if (difficultyLevel == 3) {
                        graphics.fillRect((29 * j), 50 + (29 * i), 25, 25);
                        if(!tile[i][j].isCovered){
                                graphics.setColor(tile[i][j].numberColor);
                                graphics.setFont(new Font("Arial", Font.BOLD, 15));
                                graphics.drawString(Integer.toString(integer[i][j]),(29 * j)+9,50 + (29 * i)+17);
                        }
                    }
                }
            }
        }
    }


    /**umiejscowienie miny*/
    private void placeMine() {
        int mine = 0;
        while (mine < this.minesValue) {

            int x = generateRandomIndex();
            int y = generateRandomIndex();

            if (!tile[x][y].isMine) {

                tile[x][y].isMine= true;
                mine++;
            }
        }
    }

    /**losowanie indeksow tablicy dwuwymiarowej*/
    private int generateRandomIndex() {
        Random rnd = new Random();
        int numberField = rnd.nextInt(value);
        return numberField;
    }

    /**przyporzadkowywanie wartosci liczbowej elementom tablicy dwuwymiarowej zwiazanej z liczba min wokol*/
    private void fieldMinesNumber() {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                tile[i][j].minesAround = countMinesAround(i, j);
            }
        }
    }

    /**zliczanie liczby min wokol pojedynczego pola*/
    private int countMinesAround(int x, int y) {


        int mine = 0;
        for (int i = x - 1; i < x + 2; i++) {
            if(i>=0 && i<value) {
                for (int j = y - 1; j < y + 2; j++) {
                    if ((j >= 0 && j < value) && tile[i][j].isMine) mine++;
                    else continue;
                }
            }
            else continue;
        }

        return mine;


    }

    /**zmiana atrybutu pola isCovered : boolean na false i koloru pola*/
    private void uncoverField(int x, int y){
        tile[x][y].isCovered=false;
        tile[x][y].rectangleColor = Color.WHITE;
        tile[x][y].numberColor = Color.BLACK;
        integer[x][y]=tile[x][y].minesAround;

        this.repaint();
        uncoverSurroundings(x,y);
        click++;
    }

    /**zmiana wartosci atrybutu pol sasiadujacych isCovered : boolean na false i koloru pola oraz liczby min wokol*/
    private void uncoverSurroundings(int x, int y){

        if(tile[x][y].minesAround==0) {
            for(int k=x-1;k<x+2;k++){
                for(int l=y-1; l<y+2; l++){
                    if((k>=0 && k<value) && (l>=0 && l<value)){
                        if(!tile[k][l].isMine && !tile[k][l].isFlag) {
                            integer[k][l] = tile[k][l].minesAround;
                            tile[k][l].isCovered = false;
                            tile[k][l].rectangleColor = Color.WHITE;
                            tile[k][l].numberColor = Color.BLACK;
                            this.repaint();
                        }
                    }
                    else continue;
                }
            }
        }
    }

    /**zmiana wartosci atrybutu isFlag pola na true*/
    private boolean putFlag() {

        if(flags>0) return true;
        else return false;
    }

    /**gdy w trakcie pierwszego klikniecia trafi sie na minę, metoda znajduje jej inne miejsce na planszy z wylaczeniem pierwszego odsloniętego pola*/
    private void findAnotherPlace(int x, int y){
        if(tile[x][y].isMine) {
            int mine = 0;
            while (mine < 1) {
                int a = generateRandomIndex();
                int b = generateRandomIndex();
                if (!tile[a][b].isMine) {

                    tile[x][y].isMine=false;
                    tile[a][b].isMine = true;
                    mine++;
                }
            }
        }
        fieldMinesNumber();
    }

    /**sprawdzanie stanu pola*/
    private boolean allUncovered(){
        int count = 0;
        for(int i=0; i<value; i++){
            for (int j=0;j<value; j++){
                if(!tile[i][j].isCovered){
                    count++;
                }
            }
        }

        if(count==(value*value)-minesValue) return true;
        else return false;
    }

    /**sprawia, że wokol pierwszego kliknietego pola nie znajduja sie miny*/
    private void freeTiles(int x, int y){
        if(tile[x][y].minesAround!=0) {
            for(int k=x-1;k<x+2;k++){
                for(int l=y-1; l<y+2; l++){
                    if((k>=0 && k<value) && (l>=0 && l<value)){
                        if(tile[k][l].isMine) {
                            findAnotherPlace(k,l);
                            fieldMinesNumber();
                            integer[k][l] = tile[k][l].minesAround;
                        }
                    }
                    else continue;
                }
            }
        }
    }



    @Override
    /**nadpisana metoda z interfejsu MouseListener odpowiedzialna za obslugę zdarzen w przypadku klikniec myszka na plansze*/
    public void mouseClicked(MouseEvent e) {

        if(start == 0){
            placeMine();
            fieldMinesNumber();
        }
        if(SwingUtilities.isLeftMouseButton(e)) {
            start = 1;

            System.out.println(e.getX() + " " + e.getY());
            int clickedX = e.getX();
            int clickedY = e.getY();

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    if (tile[i][j].contains(clickedX, clickedY) && !tile[i][j].isMine && !tile[i][j].isFlag) {

                        if(click==0){
                            freeTiles(i,j);
                            fieldMinesNumber();
                        }
                        uncoverField(i,j);
                        if(allUncovered()){
                            /*zakonczenie rozgrywki w przypadku odkrycia wszystkich pol bez min*/
                            JOptionPane.showMessageDialog(null,"You won", "Victory", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }

                    }
                    if(tile[i][j].contains(clickedX, clickedY) && tile[i][j].isMine && !tile[i][j].isFlag && click != 0){
                        tile[i][j].isCovered=false;
                        tile[i][j].numberColor=Color.RED;
                        tile[i][j].rectangleColor = Color.RED;
                        this.repaint();

                        /*zakonczenie rozgrywki w przypadku odkrycia pola z mina*/
                        JOptionPane.showMessageDialog(null,"Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);


                    }
                    if(tile[i][j].contains(clickedX, clickedY) && tile[i][j].isMine && !tile[i][j].isFlag && click == 0){
                        findAnotherPlace(i,j);
                        freeTiles(i,j);
                        uncoverField(i,j);
                    }
                }
            }
        }
        if(SwingUtilities.isRightMouseButton(e)){
            start = 1;
            System.out.println(e.getX() + " " + e.getY());
            int clickedX = e.getX();
            int clickedY = e.getY();

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    if (tile[i][j].contains(clickedX, clickedY)&&tile[i][j].isCovered && putFlag()) {

                        flags--;
                        tile[i][j].isFlag=true;
                        tile[i][j].rectangleColor = Color.BLUE;
                        this.repaint();
                    }
                }
            }
        }
    }


    @Override
    /**nieuzywana, ale musi byc zaimplementowana*/
    public void mousePressed(MouseEvent e) {

    }

    @Override
    /**nieuzywana, ale musi byc zaimplementowana*/
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    /**nieuzywana, ale musi byc zaimplementowana*/
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    /**nieuzywana, ale musi byc zaimplementowana*/
    public void mouseExited(MouseEvent e) {

    }
}
