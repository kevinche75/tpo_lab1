package Galactic;

public class Signal {

    private String message;
    private int key;
    private Aliens owner;

    public Signal(String message, int key, Aliens owner){
        this.message = message;
        this.key = key;
        this.owner = owner;
    }

    public int getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public Race getOwner(){
        return owner.getRace();
    }
}
