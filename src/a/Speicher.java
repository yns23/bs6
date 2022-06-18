package a;

import java.util.Collection;
import java.util.LinkedList;

class Speicher extends LinkedList<String> {

    private final LinkedList<String> list;
    private int schreibendeThreads;
    private int lesendeThreads;

    public Speicher() {
        this.list = new LinkedList<>();
        schreibendeThreads = 0;
        lesendeThreads = 0;
    }


    void writeLine(String zeile) throws InterruptedException {
        schreiberRein();
        Thread.sleep((int) (Math.random() * 10000 % 2000));
        this.add(zeile);
        schreiberRaus();
    }
    // in writeLine soll der Thread eine zufällige Zeit
    // zwischen 0 und 2 Sekunden schlafen.

    String readLine(int zeilenNummer) throws InterruptedException {
        leserRein();
        Thread.sleep((int) (Math.random() * 10000 % 2000));
        leserRaus();
        return this.get(zeilenNummer);
    }

    // in readLine soll der Thread eine zufällige Zeit
    // zwischen 0 und 2 Sekunden schlafen.
    synchronized void schreiberRein() {

        schreibendeThreads++;
        System.out.println("Neue Schreibender-Counter: " + schreibendeThreads);


    }

    // soll die Zahl schreibender Threads in Speicher um
    // eins erhöhen, und die neue Zahl auf Bildschirm
    // ausgeben. Soll immer aufgerufen werden, wenn ein
    // Thread die Methode writeLine betritt.
    synchronized void schreiberRaus() {

        schreibendeThreads--;
        System.out.println("Neue Schreibender-Counter: " + schreibendeThreads);


    }

    // soll die Zahl schreibender Thread in Speicher um
    // eins erniedrigen, und die neue Zahl auf Bildschirm
    // ausgeben. Soll immer aufgerufen werden, wenn ein
    // Thread die Methode writeLine verläßt
    synchronized void leserRein() {

        lesendeThreads++;
        System.out.println("Neue Lesender-Counter: " + lesendeThreads);

    }

    // analog zu schreiberRein
    synchronized void leserRaus() {

        lesendeThreads--;
        System.out.println("Neue Lesender-Counter: " + lesendeThreads);

    }
    // analog zu schreiberRaus

}