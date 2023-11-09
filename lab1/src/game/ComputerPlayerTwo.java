package game;

public class ComputerPlayerTwo extends Player {

    public ComputerPlayerTwo(String userId) {
        super(userId);
    }

    public int takePins(Board b) {
        // if ((b.getNoPins()-2)%3 != 0) {
        //     b.takePins(2);
        // } else {
        //     b.takePins(1);
        // }

        if (b.getNoPins() > 0) {
            if (b.getNoPins()%2 == 0) {
                b.takePins(2);
                return 2;
            } else {
                b.takePins(1);
                return 1;
            }
        }
        return 0;
    }
}
