package test;

public class SumThread extends Thread {

    private int sum;
    private int num;

    public SumThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        this.sum += this.num;
        System.out.println("sum: " + sum);
    }

    public int getSum() {
        return sum;
    }
}
