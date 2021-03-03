package Galactic;

public class Sensor {
    Space scanningSpace;
    Signal signal = null;

    public Sensor(Space scanningSpace){
        this.scanningSpace = scanningSpace;
    }

    public boolean scanSpace(){
        Signal signalTemp = scanningSpace.getSignal();
        if (signalTemp != null) signal = signalTemp;
        return signalTemp != null;
    }

    public String decryptSignal(int key) throws CantResolveSignal {
        if (signal==null) throw new CantResolveSignal("No signal");
        if (key + signal.getKey() != signal.getMessage().length()) throw new CantResolveSignal("Key is not right");
        return signal.getMessage();
    }

    public Race decryptOwner(int key) throws CantResolveSignal {
        if (signal==null) throw new CantResolveSignal("No signal");
        if (key+signal.getKey() != signal.getMessage().length()) throw new CantResolveSignal("Key is not right");
        return signal.getOwner();
    }
}
