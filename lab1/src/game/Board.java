package game;

public class Board {

    //Attributes
    private int noPins;

    //No constructor --> Java declares one for us by default
    //This is used here because we don't have any params in our constructor

    //Methods
    public void setUp(int amountOfPins) {
        this.noPins = amountOfPins;
    }

    public void takePins(int amountOfPins) {
        if (noPins != 0 && noPins - amountOfPins >=0 ) {
            noPins -= amountOfPins;
        }
    }

    public int getNoPins() {
        return noPins;
    }

}