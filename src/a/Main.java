package a;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {

        String[] text1 = {"text 1: Zeile 1", "text 1: Zeile 2"};
        String[] text2 = {"text 2: Zeile 1", "text 2: Zeile 2"};

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Speicher speicher = new Speicher();

        Schreiber schreiber1 = new Schreiber(speicher, text1, 1, lock.writeLock());
        Schreiber schreiber2 = new Schreiber(speicher, text2, 1, lock.writeLock());

        Leser leser1 = new Leser(speicher, lock.readLock());
        Leser leser2 = new Leser(speicher, lock.readLock());

        schreiber1.start();
        schreiber2.start();
        leser1.start();
        leser2.start();

    }
}