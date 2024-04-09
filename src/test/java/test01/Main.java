package test01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Sum sum = new Sum();

        for (int i = 1; i <= 10; i++) {
            MyThread myThread = new MyThread(sum, i);
            myThread.start();
//            myThread.join();
        }

        System.out.println("sum: " + sum.getSum());

        // 5초 정도면 모든 스레드가 작업돌리기 충분한시간
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("sum2: " + sum.getSum());      // 결과는 55

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);

    }
}
