package game;

import javax.swing.JOptionPane;

public class TakePinsGame {
    public static void main(String[] args) {


        //Create new board-object
        Board b = new Board();

        //Start-variables
        int startPins = 20;
        int count = 0;

        //Creates a board/new game with 20 pins
        b.setUp(startPins); 

        //Computer player
        Player computerPlayer = new ComputerPlayerTwo("Computer");
        int computerPick = 0;

        //Human player
        Player humanPlayer = new HumanPlayer("Eric");
        int humanPick = 0;


        //Initiate game in console
        // gameWithConsole(b, computerPlayer, humanPlayer, count, startPins);

        //Initiate game in GUI
        gamewithGUI(b, computerPlayer, humanPlayer, count, startPins);

    }

    //showMessageDialog //ersätts mot sysout
    //showInputDialog

    //Bägge metoder har två params
    // 1. parentComponent - sätts till null
    // 2. message - meddelande som ska visas i rutan

    public static void gameWithConsole(Board b, Player computerPlayer, Player humanPlayer, int count, int startPins) {
        int computerPick = 0;
        int humanPick = 0;
        int pinsLeft = b.getNoPins();

        while (b.getNoPins() != 0) {

            System.out.println("\n--------"+ "MOVE " + count + " --------" + "\n");


            //Computer move
            System.out.println("Computer's turn!");
            computerPick = computerPlayer.takePins(b);
            System.out.println("Computer took " + computerPick + " PINS");
            
            //PINS LEFT
            pinsLeft = b.getNoPins();
            System.out.println("There are " + pinsLeft + " left.");

            //Om noll pins kvar, så vinner datorn
            if (pinsLeft == 0) {
                System.out.println("Computer wins :(");
                break;
            }
            

            //Player move
            System.out.println("Your turn!");
            humanPick = humanPlayer.takePins(b);
            System.out.println("You took " + humanPick + " PINS");

            pinsLeft = b.getNoPins();

            if (pinsLeft == 0) {
                System.out.println("You win! :D");
                break;
            }

            System.out.println("--------"+ "--------" + "--------\n");


            count ++;
        }
    }


    public static void gamewithGUI(Board b, Player computerPlayer, Player humanPlayer, int count, int startPins) {
        int pinsLeft = b.getNoPins();

        while (b.getNoPins() != 0) { 
            //Computer move
             computerPlayer.takePins(b);

            //PINS LEFT
            pinsLeft = b.getNoPins();
            
            UserInterface.printMessage("Computer just made its turn! There are " + pinsLeft + " pins left");

            //Om noll pins kvar, så vinner datorn
            if (pinsLeft == 0) {
                UserInterface.printMessage("Computer wins! :((");
                break;
            }
            

            //Player move
            //System.out.println("Your turn!");
            humanPlayer.takePins(b);
            //System.out.println("You took " + humanPick + " PINS");

            pinsLeft = b.getNoPins();

            if (pinsLeft == 0) {
                UserInterface.printMessage("You WIN!!! :D");
                break;
            }
        }

        count ++;
    }
}



