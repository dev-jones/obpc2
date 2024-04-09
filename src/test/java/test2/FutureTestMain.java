package test2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.devjones.obpc.domain.ParserThread;
import com.devjones.obpc.domain.Product;

public class FutureTestMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		String[] query = {
			"갤럭시 GALAX 지포스 RTX 4060 Ti OC D6 8GB",
			"AMD 라이젠5-5세대 7500F (라파엘) (멀티팩(정품))",
			"ASRock B650M-HDV/M.2 대원씨티에스",
			"삼성전자 DDR5-5600 (16GB) PC5-44800",
			"갤럭시 GALAX 지포스 RTX 4060 Ti OC D6 8GB",
			"AMD 라이젠5-5세대 7500F (라파엘) (멀티팩(정품))",
			"ASRock B650M-HDV/M.2 대원씨티에스",
			"삼성전자 DDR5-5600 (16GB) PC5-44800",
			"갤럭시 GALAX 지포스 RTX 4060 Ti OC D6 8GB",
			"AMD 라이젠5-5세대 7500F (라파엘) (멀티팩(정품))",
			"ASRock B650M-HDV/M.2 대원씨티에스",
			"삼성전자 DDR5-5600 (16GB) PC5-44800",
			"갤럭시 GALAX 지포스 RTX 4060 Ti OC D6 8GB",
			"AMD 라이젠5-5세대 7500F (라파엘) (멀티팩(정품))",
			"ASRock B650M-HDV/M.2 대원씨티에스",
			"삼성전자 DDR5-5600 (16GB) PC5-44800",
			"갤럭시 GALAX 지포스 RTX 4060 Ti OC D6 8GB",
			"AMD 라이젠5-5세대 7500F (라파엘) (멀티팩(정품))",
			"ASRock B650M-HDV/M.2 대원씨티에스",
			"삼성전자 DDR5-5600 (16GB) PC5-44800"
		};

		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		System.out.println("[작업 처리 요청");

		// 공유객체(외부객체)
		Product result = new Product();
		// 두개의 작업을 정의
		for (int i = 0; i < query.length; i++) {
			Runnable task1 = new ParserThread(query[i], result);
			Future<Product> future = executorService.submit(task1, result);
			result = future.get();
		}
//		Runnable task1 = new ParserThread(query[0], result);
//		Future<Product> future1 = executorService.submit(task1, result);
//		result = future1.get();
//		Runnable task2 = new ParserThread(query[1], result);
//		Future<Product> future2 = executorService.submit(task2, result);
//		result = future2.get();
//		Runnable task3 = new ParserThread(query[2], result);
//		Future<Product> future3 = executorService.submit(task3, result);
//		result = future3.get();
//		Runnable task4 = new ParserThread(query[3], result);
//		Future<Product> future4 = executorService.submit(task4, result);
//		result = future4.get();
		System.out.println("[처리 결과]" + result.getTotal());

//        try {
////            result = future1.get();
////            result = future2.get();
//            System.out.println("[작업 처리 완료");
//        }
//        catch (InterruptedException e) {}
//        catch (ExecutionException e) {}
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
}
