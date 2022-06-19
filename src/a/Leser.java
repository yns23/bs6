package a;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Leser extends Thread {

    private Speicher speicher;
    private ReentrantReadWriteLock.ReadLock lock;


    Leser(Speicher speicher, ReentrantReadWriteLock.ReadLock lock) {

        this.speicher = speicher;
        this.lock = lock;
    }

    public void run() {


        for (int i = 0; i < 4; ++i) {
            lock.lock();
                try {

                speicher.readLine(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }

    }
}


