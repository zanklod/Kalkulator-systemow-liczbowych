package pwr.pl.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class KonwerterTest {

  @Test
  void testKonwersji() {
    Konwerter konwerter = new Konwerter();
    assertEquals("1010", konwerter.konwertuj("10", 10, 2));
    assertEquals("FF", konwerter.konwertuj("255", 10, 16));
  }

  @Test
  void testWyjatkuDlaZlejBazy() {
    Konwerter konwerter = new Konwerter();
    assertThrows(IllegalArgumentException.class, () -> konwerter.konwertuj("10", 10, 20));
  }
}