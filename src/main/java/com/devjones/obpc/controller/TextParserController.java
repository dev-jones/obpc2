package com.devjones.obpc.controller;

import com.devjones.obpc.domain.LowestPriceCash;
import com.devjones.obpc.domain.ParserThread;
import com.devjones.obpc.domain.Product;
import com.devjones.obpc.domain.TextParserDto;
import com.devjones.obpc.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.devjones.obpc.util.ApiResponseUtil.handleApi;

@Controller
public class TextParserController {

	@PostMapping("/textparser")
	public ResponseEntity<ApiResponseUtil.ApiResponse<Object>> result(@RequestBody TextParserDto data) {
		return handleApi(() -> {
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
			System.out.println("최저가: " + result);
			return "최저가: " + result;
		});
	}
}
