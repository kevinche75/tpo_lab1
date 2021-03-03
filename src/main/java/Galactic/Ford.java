package Galactic;

public class Ford {

    Sensor sensor;
    State state = State.SLEEP;
    int key = 3;

     public Ford(Space space){
         sensor = new Sensor(space);
     }

    public Ford(Space space, int key){
        sensor = new Sensor(space);
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String scanSignal() throws CantResolveSignal {
         String message = null;
         if (!sensor.scanSpace()){
             System.out.println("No signal in the space");
             return message;
         }
         state = State.AWAKEN;
        Race aliens = sensor.decryptOwner(key);
        if (aliens == Race.VOGONS) state = State.WORRIED;
        message = sensor.decryptSignal(key);
        return message;
    }

    public State getState() {
         return state;
    }
}
