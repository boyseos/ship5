package com.ship.web.lambda;

import com.ship.web.cmm.IConsumer;

public class Study {
	public static void main(String[] args) {
		IConsumer<String> xy = x -> System.out.println(x);
		xy.accept("abdc");
	}
}
