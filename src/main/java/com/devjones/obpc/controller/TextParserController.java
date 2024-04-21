package com.devjones.obpc.controller;

import com.devjones.obpc.domain.LowestPriceCash;
import com.devjones.obpc.domain.ParserThread;
import com.devjones.obpc.domain.Product;
import com.devjones.obpc.domain.TextParserDto;
import com.devjones.obpc.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.devjones.obpc.util.ApiResponseUtil.handleApi;

@Controller
@Slf4j
public class TextParserController {

	@PostMapping("/textparser")
	public ResponseEntity<ApiResponseUtil.ApiResponse<Object>> result(@RequestBody TextParserDto data) {
		return handleApi(() -> {
			long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

			log.info("rawData: " + data.getData());

			int result = 0;
			Product prod = new Product();
			String[] query = data.getData().split("\\n");
			Thread[] threads = new Thread[query.length];

			for (int i = 0; i < query.length; i++) {
				threads[i] = new Thread(new ParserThread(query[i], prod));
				threads[i].start();
			}

			for (Thread thread : threads) {
				thread.join();
			}

			result = prod.getTotal();
//			System.out.println("최저가: " + result);
			log.info("최저가: {}", result);

			long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
			long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
			log.info("시간차이(m) : {}", secDiffTime);

			/**
			 * 최저가: 3650000
			 * 시간차이(m) : 1521
			 *
			 * 멀티스레드 없었으면..
			 * 25370 ms 걸렸음
			 */

			return "최저가: " + result;
		});
	}
}
