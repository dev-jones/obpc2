package test01;

public class MyThread extends Thread{

    private Sum sum;
    private int num;

    public MyThread(Sum sum, int num) {
        this.sum = sum;
        this.num = num;
    }

    @Override
    public void run() {
        sum.setSum(num);
    }
}
