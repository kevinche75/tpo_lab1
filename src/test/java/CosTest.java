import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CosTest {

    private final CosTaylor taylor = new CosTaylor();
    private final double accuracy = 10e-6;
    private double expected;

    @Test
    @DisplayName("Max double")
    void testMethod_0(){
        assertThrows(NoSuchValueException.class, () -> taylor.compCos(Double.MAX_VALUE, accuracy));
    }

    @Test
    @DisplayName("Min double")
    void testMethod_1(){
        assertThrows(NoSuchValueException.class, () -> taylor.compCos(-Double.MAX_VALUE, accuracy));
    }

    @Test
    @DisplayName("Min double value")
    void testMethod_2(){
        assertDoesNotThrow(()->taylor.compCos(Double.MIN_VALUE, accuracy));
    }

    @Test
    @DisplayName("The accuracy below zero")
    void testMethod_3(){
        double value = 2.543;
        assertThrows(UnreachableResultException.class, () -> taylor.compCos(value, -1));
    }

    @Test
    @DisplayName("The accuracy zero")
    void testMethod_4(){
        double value = 2.543;
        assertDoesNotThrow(() -> taylor.compCos(value, 0));
    }

    @Test
    @DisplayName("0 degrees")
    void testMethod_5(){
        double value = 0;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("30 degrees")
    void testMethod_6(){
        double value = Math.PI/6;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("45 degrees")
    void testMethod_7(){
        double value = Math.PI/4;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("60 degrees")
    void testMethod_8(){
        double value = Math.PI/3;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("90 degrees")
    void testMethod_9(){
        double value = Math.PI/2;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("180 degrees")
    void testMethod_10(){
        double value = Math.PI;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("270 degrees")
    void testMethod_11(){
        double value = Math.PI*1.5;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("360 degrees")
    void testMethod_12(){
        double value = Math.PI*2;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Parity")
    void testMethod_13(){
        double value = 2.543;
        try {
            assertEquals(taylor.compCos(value, accuracy), taylor.compCos(-value, accuracy));
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("23 degrees")
    void testMethod_14(){
        double value = 0.401425728;
        try {
            assertEquals(taylor.compCos(value, accuracy), Math.cos(value), accuracy);
        } catch (NoSuchValueException | UnreachableResultException e) {
            e.printStackTrace();
        }
    }
}
