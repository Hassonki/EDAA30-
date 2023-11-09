package game;

public abstract class Player {

    protected String userId;

    public Player(String userId) { //Constructor
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    protected abstract int takePins(Board b);
    
}
