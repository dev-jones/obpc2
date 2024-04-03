package com.devjones.obpc.controller;

import com.devjones.obpc.util.LowestPriceCash;
import com.devjones.obpc.domain.TextParserDto;
import com.devjones.obpc.domain.ParserThread;
import com.devjones.obpc.domain.Product;
import com.o3.codingtest.util.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.o3.codingtest.util.ApiResponseUtil.handleApi;

@Controller
public class TextParserController {

	@GetMapping("/textparser")
	public ResponseEntity<ApiResponseUtil.ApiResponse<Object>> result(
			@RequestBody
			TextParserDto request
	) {
		return handleApi(() -> {
			int result = 0;
			LowestPriceCash lpc = new LowestPriceCash();
			String[] query = request.getData().split("\\n");

			Product prod = new Product();
			// 2. 스레드처리
			for(int i = 0; i < query.length; i++) {
				System.out.println("query["+i + "]: " + query[i]);
				ParserThread pt = new ParserThread(query[i], prod);
				Thread t = new Thread(pt);
				t.start();
				t.join();
				result = pt.getProd().getTotal();
			}


			System.out.println("최저가: " + result);
			return "최저가: " + result;
		});
	}
	}
