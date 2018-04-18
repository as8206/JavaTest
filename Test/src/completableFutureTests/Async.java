package completableFutureTests;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

class ShoppingSite {
	String url;

	public ShoppingSite(String url) {
		this.url = url;
	}
	
	private void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String query(String product) {
		delay((int) (Math.random() * 500 + 500));
		int price = (int) (Math.random() * 500 + 500);
		return url + " gives $" + price;
	}
}

public class Async {
	static String addAwesome(String s) {
		return "AWESOME! " + s;
	}
	
	static String findCoupon(String s) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return s + " with " + (int)(Math.random()* 21) + "% discount.";
	}

	public static void main(String[] args) {
//		List<ShoppingSite> lst = Arrays.asList(new ShoppingSite("http://bestbuy.com"),
//			new ShoppingSite("http://amazon.com"),
//			new ShoppingSite("http://newegg.com"),
//			new ShoppingSite("http://staples.com"));
//		
//		lst.forEach(ss -> System.out.println(ss.query("macbook")));
//		List<CompletableFuture<String>> futures = 
//				lst.stream().map(ss -> CompletableFuture.supplyAsync(() -> ss.query("macbook"))).collect(Collectors.toList());
//		System.out.println("----start thenApply");
//
//		futures = futures.stream().map(future -> future.thenApply(s -> addAwesome(s))).collect(Collectors.toList());
//		System.out.println("----finish thenApply");
//
//		List<String>  prices = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
//		
//		System.out.println(prices);
		
		
		ShoppingSite s = new ShoppingSite("amazon.com");
		CompletableFuture<String> qRes = 
				CompletableFuture.supplyAsync(() -> s.query("macbook"));
		
		System.out.println("Waiting for query() to finish");
		CompletableFuture<String> withCoupon =
				qRes.thenCompose((String ss) -> CompletableFuture.supplyAsync(() -> Async.findCoupon(ss)));
		System.out.println("Waiting for findCoupon to complete");
		System.out.println(withCoupon.join());
	}
}
