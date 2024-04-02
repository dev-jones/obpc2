package com.devjones.obpc.domain;

public class Product {

//	private String name;
//	private String lowestPriceCash;
//	private String 배송비;
	private int total;
	
	public int getTotal() {
		return total;
	}
	
	public synchronized void setTotal(int total) {
		this.total += total;
	}
}
