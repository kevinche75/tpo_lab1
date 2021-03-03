import Galactic.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GalacticTest {

    Space space = new Space();
    Ford ford = new Ford(space);
    Aliens vogons = new Aliens(Race.VOGONS, space);
    String message = "Привет!";

    @Test
    @DisplayName("Check Scan without Signal")
    void test_0(){
        try {
            assertNull(ford.scanSignal());
        } catch (CantResolveSignal cantResolveSignal) {
            cantResolveSignal.printStackTrace();
        }
    }

    @Test
    @DisplayName("Check existed signal with bad keys")
    void test_1(){
        vogons.setSignal(message);
        assertThrows(CantResolveSignal.class, () -> ford.scanSignal());
    }

    @Test
    @DisplayName("Check existed signal with right keys")
    void test_2(){
        ford.setKey(4);
        vogons.setKey(3);
        vogons.setSignal(message);
        assertDoesNotThrow(() -> ford.scanSignal());
    }

    @Test
    @DisplayName("Test message right")
    void test_3(){
        ford.setKey(4);
        vogons.setKey(3);
        vogons.setSignal(message);
        try {
            assertEquals(message, ford.scanSignal());
        } catch (CantResolveSignal cantResolveSignal) {
            cantResolveSignal.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test ford status awaken")
    void test_4(){
        ford.setKey(4);
        Aliens hooloovoo = new Aliens(Race.HOOLOOVOO, space);
        hooloovoo.setKey(3);
        hooloovoo.setSignal(message);
        try {
            ford.scanSignal();
            assertEquals(State.AWAKEN, ford.getState());
        } catch (CantResolveSignal cantResolveSignal) {
            cantResolveSignal.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test ford status worried")
    void test_5(){
        ford.setKey(4);
        vogons.setKey(3);
        vogons.setSignal(message);
        try {
            ford.scanSignal();
            assertEquals(State.WORRIED, ford.getState());
        } catch (CantResolveSignal cantResolveSignal) {
            cantResolveSignal.printStackTrace();
        }
    }
}
