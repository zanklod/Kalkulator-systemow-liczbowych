package pwr.pl.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KalkulatorSystemow {
    private final Konwerter konwerter;
    private final List<WpisHistorii> historia;

    public KalkulatorSystemow() {
        this.konwerter = new Konwerter();
        this.historia = new ArrayList<>();
    }

    public String przelicz(String wartosc, int bazaZ, int bazaDo) {
        String wynik = konwerter.konwertuj(wartosc, bazaZ, bazaDo);
        historia.add(new WpisHistorii(wartosc, bazaZ, wynik, bazaDo));
        return wynik;
    }

    public void wyswietlHistorie() {
        if (historia.isEmpty()) {
            System.out.println("Historia jest pusta.");
            return;
        }
        System.out.println("\n--- Historia operacji ---");
        for (WpisHistorii wpis : historia) {
            System.out.println(" • " + wpis.getOpis());
        }
    }

    public static void main(String[] args) {
        KalkulatorSystemow kalkulator = new KalkulatorSystemow();

        // Użycie try-with-resources zapobiega ostrzeżeniom PMD o wycieku zasobów (CloseResource)
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("==========================================");
            System.out.println("   Kalkulator Systemów Liczbowych (2-16)  ");
            System.out.println("==========================================");
            System.out.println("Wpisz 'q' w dowolnym momencie, aby wyjść.");
            System.out.println("Wpisz 'h', aby wyświetlić historię.");

            while (true) {
                System.out.print("\nPodaj liczbę do przeliczenia (lub 'q' / 'h'): ");
                String wejscie = scanner.nextLine().trim();

                if (wejscie.equalsIgnoreCase("q")) {
                    System.out.println("Zamykanie programu. Do widzenia!");
                    break;
                }

                if (wejscie.equalsIgnoreCase("h")) {
                    kalkulator.wyswietlHistorie();
                    continue;
                }

                if (wejscie.isEmpty()) {
                    continue;
                }

                try {
                    System.out.print("Podaj bazę źródłową (2-16): ");
                    String bazaZTekst = scanner.nextLine().trim();
                    if (bazaZTekst.equalsIgnoreCase("q")) {
                        break;
                    }
                    int bazaZ = Integer.parseInt(bazaZTekst);

                    System.out.print("Podaj bazę docelową (2-16): ");
                    String bazaDoTekst = scanner.nextLine().trim();
                    if (bazaDoTekst.equalsIgnoreCase("q")) {
                        break;
                    }
                    int bazaDo = Integer.parseInt(bazaDoTekst);

                    String wynik = kalkulator.przelicz(wejscie, bazaZ, bazaDo);
                    System.out.println(">> WYNIK: " + wejscie + " (baza " + bazaZ + ") = " 
                            + wynik + " (baza " + bazaDo + ")");

                } catch (NumberFormatException e) {
                    System.out.println("Błąd: Wprowadzono niepoprawny format liczby lub bazy!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Błąd: " + e.getMessage());
                }
            }
        }
    }
}