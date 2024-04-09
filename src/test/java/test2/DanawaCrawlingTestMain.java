package test2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DanawaCrawlingTestMain {

	public static void main(String[] args) {
		
		String query = "마이크로닉스 Classic II 풀체인지 700W 80PLUS BRONZE 230V EU";
		String url = "https://search.danawa.com/dsearch.php?query=" + query;
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
//			System.out.println(doc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Elements ahref = doc.getElementsByClass("product_list");
		
		Elements element = doc.select("ul.product_list > li > div > div > a");
//		System.out.println(element.toString());
//		System.out.println(element.get(0));
		Element e = element.get(0);
//		System.out.println(e.attr("href"));
		
		// 현금최저가 구하기
		url = e.attr("href");
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		Element e1 = doc.id("lowPriceCash");
//		System.out.println(e1.toString());
//		System.out.println(doc.getElementById("lowPriceCash"));
		Element e1 = doc.getElementById("lowPriceCash");
//		System.out.println(e1.getElementsByClass("prc_c").toString());
//		System.out.println(e1.getElementsByClass("prc_c").text());
		
		System.out.println("상품명 : " + query);
		System.out.println("최저가(현금) : " + e1.getElementsByClass("prc_c").text());
		
//
//		//Iterator을 사용하여 하나씩 값 가져오기
//		Iterator<Element> ie1 = element.select("strong.rank").iterator();
//		Iterator<Element> ie2 = element.select("strong.title").iterator();
//		        
//		while (ie1.hasNext()) {
//			System.out.println(ie1.next().text()+"\t"+ie2.next().text());
//		}
	}
}
