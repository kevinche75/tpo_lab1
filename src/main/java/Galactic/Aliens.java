package Galactic;

public class Aliens {

    Race race;
    Space currentSpace;
    int key = 2;

    public Aliens(Race race, Space currentSpace){
        this.race = race;
        this.currentSpace = currentSpace;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setSignal(String message){
        Signal signal = new Signal(message, key, this);
        currentSpace.setSignal(signal);
    }

    public Race getRace(){
        return race;
    }
}
