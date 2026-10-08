package pwr.pl.java;

public class WpisHistorii {
    private final String wejscie;
    private final int bazaZ;
    private final String wyjscie;
    private final int bazaDo;

    public WpisHistorii(String wejscie, int bazaZ, String wyjscie, int bazaDo) {
        this.wejscie = wejscie;
        this.bazaZ = bazaZ;
        this.wyjscie = wyjscie;
        this.bazaDo = bazaDo;
    }

    public String getOpis() {
        return wejscie + " (baza " + bazaZ + ") -> " + wyjscie + " (baza " + bazaDo + ")";
    }
}