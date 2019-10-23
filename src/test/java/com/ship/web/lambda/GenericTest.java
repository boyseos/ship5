package com.ship.web.lambda;

public class GenericTest {
	static class BOX<T>{
		T item;
		void setItem (T item) { this.item = item;}
		T getItem() {return item;}
	}
	public static void main(String[] args) {
		BOX<String> s = new BOX<>();
		BOX<Integer> s2 = new BOX<>();
		s.setItem("asdfasfd");
		System.out.println(s.getItem());
		s2.setItem(1234);
		
	}
}
