package test02;

public class LastThreadJoinExample {
    private static Thread lastThread = null; // 가장 마지막에 끝난 스레드를 추적하기 위한 변수

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Thread 1"));
        Thread thread2 = new Thread(new MyRunnable("Thread 2"));

        thread1.start();
        thread2.start();

        try {
            // 각 스레드가 종료될 때까지 대기
            thread1.join();
            thread2.join();

            // 가장 마지막에 끝난 스레드를 기다림
            if (lastThread != null) {
                lastThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("모든 스레드의 작업이 완료되었습니다.");
    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " 작업을 시작합니다.");
            try {
                // 각 스레드는 여기서 어떤 작업을 수행합니다.
                Thread.sleep(2000); // 예시로 2초간 잠시 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " 작업을 완료했습니다.");

            // 현재 스레드를 가장 마지막에 끝난 스레드로 업데이트
            lastThread = Thread.currentThread();
        }
    }
}
