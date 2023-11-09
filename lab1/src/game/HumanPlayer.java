package game;

import java.util.Scanner;

public class HumanPlayer extends Player{

    Scanner scan;

    public HumanPlayer(String userId) {
        super(userId);
        scan = new Scanner(System.in);
    }

    public int takePins(Board b) {
        int amountOfPins = UserInterface.askForInt("Your turn, choose the amount of pins to take (1-2).");

        while(amountOfPins <= 0 || amountOfPins > 2 || (b.getNoPins() - amountOfPins) < 0) {
            if (b.getNoPins() - amountOfPins < 0 && amountOfPins <= 2) {
                UserInterface.printMessage("You can't take more pins than there are left. Retry and choose 1 pin instead. \n");
                // System.out.println("You can't take more pins than there are left. Retry and choose 1 pin instead. \n");
            } else {
                UserInterface.printMessage("Incorrect input! Choose 1 or 2 pins to take!! \n");
                // System.out.println("Incorrect input! Choose 1 or 2 pins to take!! \n");
            }
            // amountOfPins = scan.nextInt();
            amountOfPins = UserInterface.askForInt("Your turn, choose the amount of pins to take (1-2).");
        }

        b.takePins(amountOfPins);
       
        return amountOfPins;
    }
    
}
