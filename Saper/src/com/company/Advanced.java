package com.company;
/**klasa dziedziczaca po klasie Level*/
public class Advanced extends Level {
    Advanced() {
        super();
        this.size = 24;
        this.percent = 0.25;
        this.mineNumber = (int) (size*size*percent);
    }
}
