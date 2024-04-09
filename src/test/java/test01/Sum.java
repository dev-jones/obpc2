package test01;

public class Sum {

    private int sum;

    public int getSum() {
        return sum;
    }

    public synchronized void setSum(int num) {
        System.out.println("num1:" + num);
        this.sum += num;
        System.out.println("sum1: " + sum);
    }
}
