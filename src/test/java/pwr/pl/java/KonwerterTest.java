package pwr.pl.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KonwerterTest {

    @Test
    public void testDziesietnyNaBinarny() {
        Konwerter konwerter = new Konwerter();
        // 42 w systemie dwójkowym to 101010
        assertEquals("101010", konwerter.konwertuj("42", 10, 2));
    }

    @Test
    public void testDziesietnyNaSzesnastkowy() {
        Konwerter konwerter = new Konwerter();
        // 255 w systemie szesnastkowym to FF
        assertEquals("FF", konwerter.konwertuj("255", 10, 16));
    }

    @Test
    public void testBinarnyNaOsemkowy() {
        Konwerter konwerter = new Konwerter();
        // 1010 (binarnie: 10) w ósemkowym to 12
        assertEquals("12", konwerter.konwertuj("1010", 2, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNieobslugiwanaBazaRzucaWyjatek() {
        Konwerter konwerter = new Konwerter();
        // Podstawa 20 wykracza poza zakres 2-16
        konwerter.konwertuj("10", 10, 20);
    }
}