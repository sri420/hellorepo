package com.demo.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyMain {

	
	public static void main(String[] arg){
		List<Apple> inventory=Arrays.asList(
					new Apple(100,"red"),
					new Apple(200,"red")
					);
		List<Apple> result =
				  filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		System.out.println(result);
	}
	
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	interface ApplePredicate{
		public boolean test(Apple a);
	}
}
