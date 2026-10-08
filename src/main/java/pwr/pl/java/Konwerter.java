package pwr.pl.java;

public class Konwerter {

    public String konwertuj(String wartosc, int bazaZ, int bazaDo) {
        if (bazaZ < 2 || bazaZ > 16 || bazaDo < 2 || bazaDo > 16) {
            throw new IllegalArgumentException("Obslugiwane sa systemy od 2 do 16.");
        }

        // Krok 1: Przelicz z bazy źródłowej na dziesiętny
        int wartoscDziesietna = Integer.parseInt(wartosc, bazaZ);

        // Krok 2: Przelicz z dziesiętnego na bazę docelową
        return Integer.toString(wartoscDziesietna, bazaDo).toUpperCase();
    }
}