package b;

public class Table {

    boolean[] forkUsed = new boolean[5];

    public synchronized void putForks(Philosoph philosoph) {
        System.out.println("Philosoph " + philosoph.getNumber() + " puts Forks back");

        forkUsed[philosoph.getNumber()] = false;
        forkUsed[(philosoph.getNumber() + 1) % 4] = false;

        notifyAll();
    }

    public synchronized void takeForkLeft(Philosoph philosoph) {
        int left = philosoph.getNumber();
        while (forkUsed[left])
            try {
                System.out.println("Philosoph " + philosoph.getNumber() + " waiting for left fork");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println("Philosoph " + philosoph.getNumber() + " takes left fork");
        forkUsed[left] = true;

    }

    public synchronized void takeForkRight(Philosoph philosoph) {
        int right = (philosoph.getNumber() + 1) % 4;
        while (forkUsed[right]) {
            try {
                System.out.println("Philosoph " + philosoph.getNumber() + " waiting for right fork");
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Philosoph " + philosoph.getNumber() + " takes right fork");
        forkUsed[right] = true;
    }


}
