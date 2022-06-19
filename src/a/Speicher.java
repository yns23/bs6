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
        Thread.sleep((int) (Math.random() * 1000 % 2000));

        schreiberRein();
        this.add(zeile);
        schreiberRaus();
    }

    String readLine(int zeilenNummer) throws InterruptedException {
        leserRein();
        Thread.sleep((int) (Math.random() * 1000 % 2000));
        leserRaus();
        return this.get(zeilenNummer);
    }

    synchronized void schreiberRein() {
        schreibendeThreads++;
        System.out.println("Neue Schreibender-Counter: " + schreibendeThreads);
    }

    synchronized void schreiberRaus() {
        schreibendeThreads--;
        System.out.println("Neue Schreibender-Counter: " + schreibendeThreads);
    }

    synchronized void leserRein() {
        lesendeThreads++;
        System.out.println("Neue Lesender-Counter: " + lesendeThreads);
    }

    synchronized void leserRaus() {
        lesendeThreads--;
        System.out.println("Neue Lesender-Counter: " + lesendeThreads);
    }


}