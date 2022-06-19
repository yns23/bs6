package b2;

public class Main {
    public static void main(String[] args) {
       SemaphoreGroup semaphoreGroup = new SemaphoreGroup(5);

        PhilosophSem philosophSem0 = new PhilosophSem(0, semaphoreGroup);
        PhilosophSem philosophSem1 = new PhilosophSem(1, semaphoreGroup);
        PhilosophSem philosophSem2 = new PhilosophSem(2, semaphoreGroup);
        PhilosophSem philosophSem3 = new PhilosophSem(3, semaphoreGroup);
        PhilosophSem philosophSem4 = new PhilosophSem(4, semaphoreGroup);

        philosophSem0.start();
        philosophSem1.start();
        philosophSem2.start();
        philosophSem3.start();
        philosophSem4.start();
    }
}
