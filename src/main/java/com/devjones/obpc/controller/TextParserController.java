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

//	@GetMapping("/textparser")
	@PostMapping("/textparser")
	public ResponseEntity<ApiResponseUtil.ApiResponse<Object>> result(@RequestBody TextParserDto data) {
		return handleApi(() -> {
			int result = 0;
			LowestPriceCash lpc = new LowestPriceCash();
			String[] query = data.getData().split("\\n");

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


//	@GetMapping("/textparser")
//	@ResponseBody
//	public String result(HttpServletRequest request) {
//		int result = 0;
//		LowestPriceCash lpc = new LowestPriceCash();
//		String[] query = request.getParameter("data").split("\\n");
//
////		for(int i = 0; i < query.length; i++) {
////			int rt = lpc.parse(query[i]);
////			result += rt;
////		}
//
//		Product prod = new Product();
//		// 2. 스레드처리
//		for(int i = 0; i < query.length; i++) {
//			System.out.println("query["+i + "]: " + query[i]);
//			ParserThread pt = new ParserThread(query[i], prod);
//			Thread t = new Thread(pt);
//			t.start();
////			try {
////				t.join();
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
//
//			result = pt.getProd().getTotal();
//		}
//
//		System.out.println("최저가: " + result);
//		return "최저가: " + result;
//	}
}
