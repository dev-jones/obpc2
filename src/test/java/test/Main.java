package test;

public class Main {
    public static void main(String[] args) {
        System.out.println("메인 메소드");

        int count = 0;
        for (int i = 1; i <= 10; i++) {
            SumThread sumThread = new SumThread(i);
            sumThread.start();

            count += sumThread.getSum();
        }

        System.out.println("count: " + count);
    }
}
