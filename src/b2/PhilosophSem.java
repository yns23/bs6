package b2;

public class PhilosophSem extends Thread {

    private final int leftFork;
    private final int rightFork;
    private final int num;

    private final SemaphoreGroup semaphoreGroup;

    public PhilosophSem(int i, SemaphoreGroup semaphoreGroup) {
        this.num = i;
        this.semaphoreGroup = semaphoreGroup;
        this.leftFork = i;
        this.rightFork = (i + 1) % 4;

    }

    @Override
    public void run() {
        int[] deltas = new int[semaphoreGroup.getNumberOfMembers()];
        for (int delta : deltas) delta = 0;

        while(true){
            try {
                think(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deltas[leftFork] = -1;
            deltas[rightFork] = -1;

            semaphoreGroup.changeValues(deltas);

            try {
                eat(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            deltas[leftFork] = 1;
            deltas[rightFork] = 1;

            semaphoreGroup.changeValues(deltas);

            System.out.println("Philosoph " + num + " has eaten");
        }
    }


    private void think(PhilosophSem philosophSem) throws InterruptedException {
        System.out.println("Philosoph " + philosophSem.num + " thinks");
        Thread.sleep((long) (Math.random() * 1000 % 2000));
    }

    private void eat(PhilosophSem philosophSem) throws InterruptedException {
        System.out.println("Philosoph " + philosophSem.num + " eats");
        Thread.sleep((long) (Math.random() * 1000 % 2000));
    }

    public int getNumber() {
        return num;
    }
}
