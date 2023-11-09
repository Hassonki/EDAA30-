package game;

import java.lang.Math;
import java.util.Random;

public class ComputerPlayer extends Player{

    private Random rand;

    public ComputerPlayer(String userId) {
        super(userId);
        rand = new Random();
    }

    public int takePins(Board b) {
        int amountOfPins = rand.nextInt(2) + 1;
        
        if (b.getNoPins()-amountOfPins >= 0) {
            b.takePins(amountOfPins);
        } else {
            b.takePins(1);
        }
        return amountOfPins;
    }
}
