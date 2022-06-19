package b;

public class Philosoph extends Thread {

    private final int leftFork;
    private final int rightFork;
    private final int num;
    private final Table table;

    public Philosoph(int i, Table table) {
        this.num = i;
        this.table = table;
        this.leftFork = i;
        this.rightFork = i + 1;

    }

    @Override
    public void run() {
        try {
            think(this);
            table.takeForkLeft(this);
            table.takeForkRight(this);
            eat(this);
            table.putForks(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void think(Philosoph philosoph) throws InterruptedException {
        System.out.println("Philosoph " + philosoph.num + " thinks");
        Thread.sleep((long) (Math.random() * 1000 % 2000));
    }

    private void eat(Philosoph philosoph) throws InterruptedException {
        System.out.println("Philosoph " + philosoph.num + " eats");
        Thread.sleep((long) (Math.random() * 1000 % 2000));
    }

    public int getNumber() {
        return num;
    }
}
