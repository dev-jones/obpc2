package com.devjones.obpc.domain;

import com.devjones.obpc.domain.Product;
import com.devjones.obpc.util.LowestPriceCash;

public class ParserThread implements Runnable {

	private String product;
	private Product prod;
	
	public ParserThread(String product, Product prod) {
		this.product = product;
		this.prod = prod;
	}
	
	public void run() {
		LowestPriceCash lpc = new LowestPriceCash();
		
		int rt = lpc.parse(product);
//		result += rt;
		prod.setTotal(rt);
	}

	public Product getProd() {
		return prod;
	}
}
