package b;

public class Main {
    public static void main(String[] args) {

        Table table = new Table();

        Philosoph philosoph0 = new Philosoph(0, table);
        Philosoph philosoph1 = new Philosoph(1, table);
        Philosoph philosoph2 = new Philosoph(2, table);
        Philosoph philosoph3 = new Philosoph(3, table);
        Philosoph philosoph4 = new Philosoph(4, table);

        philosoph0.start();
        philosoph1.start();
        philosoph2.start();
        philosoph3.start();
        philosoph4.start();
    }
}
