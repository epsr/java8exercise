package com.lwh.java8exercise.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class exercise {
	
	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		
		System.out.println("(1)找出2011年发生的所有交易,并按交易额排序(从低到高)。");
		transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.forEach(System.out::println);

		System.out.println("(2)交易员都在哪些不同的城市工作过?");
		transactions.stream().map(t -> t.getTrader().getCity())
				.distinct().forEach(System.out::println);

		System.out.println("(3) 查找所有来自于剑桥的交易员,并按姓名排序。");
		transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getTrader).distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.forEach(System.out::println);

		System.out.println("(4) 返回所有交易员的姓名字符串,按字母顺序排序。");
		transactions.stream().map(Transaction::getTrader)
				.sorted(Comparator.comparing(Trader::getName))
				.map(Trader::getName).forEach(System.out::println);

		System.out.println("(5) 有没有交易员是在米兰工作的?");
		transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Milan")).findAny()
				.ifPresent(System.out::println);

		System.out.println("(6) 打印生活在剑桥的交易员的所有交易额。");
		transactions.stream().filter(t -> {
			return t.getTrader().getCity() == "Cambridge";
		}).map(Transaction::getValue).forEach(System.out::println);

		System.out.println("(7) 所有交易中,最高的交易额是多少?");
		transactions.stream().map(Transaction::getValue)
				.max((x, y) -> Integer.compare(x, y))
				.ifPresent(System.out::println);

		System.out.println("(8) 找到交易额最小的交易。");
		transactions.stream().min(Comparator.comparing(Transaction::getValue))
				.ifPresent(System.out::println);
	}
}
