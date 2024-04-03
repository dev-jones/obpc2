package com.devjones.obpc.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LowestPriceCash {

	/**
	 * 제품에 대한 최저가 구하기
	 * @param query
	 * @return 최저가
	 */
	public int parse(String query) throws Exception {
		if("".equals(query.trim())) return 0;
		String url = "https://search.danawa.com/dsearch.php?query=" + query;
		Document doc = null;

		doc = Jsoup.connect(url).get();

		Elements element = doc.select("ul.product_list > li > div > div > a");
		Element e = element.get(0);
		url = e.attr("href");

		// 현금최저가 구하기
		doc = Jsoup.connect(url).get();
		Element e1 = doc.getElementById("lowPriceCash");
		
		System.out.println("상품명 : " + query);
		System.out.println("최저가(현금) : " + e1.getElementsByClass("prc_c").text());
		
		String prc= e1.getElementsByClass("prc_c").text();

		return Integer.parseInt(prc.replace(",", ""));

	}
}
