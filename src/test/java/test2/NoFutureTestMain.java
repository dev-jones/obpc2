package test2;

import com.devjones.obpc.domain.LowestPriceCash;

public class NoFutureTestMain {

	public static void main(String[] args) {
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
		
		System.out.println("[작업 처리 요청");
		LowestPriceCash lpc = new LowestPriceCash();
		int result = 0;
		for(int i = 0; i < query.length; i++) {
			int rt = lpc.parse(query[i]);
			result += rt;
		}
		System.out.println("result: " + result);
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
}
