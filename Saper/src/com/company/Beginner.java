package com.company;
/**klasa dziedziczaca po klasie Level*/
public class Beginner extends Level {
    Beginner() {
        super();
        this.size=8;
        this.percent =  0.15625;
        this.mineNumber = (int) (size*size*percent);
    }

}
