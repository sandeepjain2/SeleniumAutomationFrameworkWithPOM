package com.enums;

import java.util.EnumMap;
import java.util.Map;


public class EnumRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		System.out.println(Severity.CRITICAL);

		Severity sev = Severity.CRITICAL;


		//		switch (sev) {
		//		case CRITICAL:
		//			System.out.println("critical");
		//			break;
		//		case HIGH:
		//			System.out.println("critical");
		//			break;
		//		case MEDIUM:
		//			System.out.println("critical");
		//			break;
		//		case LOW:
		//			System.out.println("critical");
		//			break;
		//		}

		//		Severity a = Severity.valueOf("CRITICAL");
		//		
		//		if(a == Severity.CRITICAL) {
		//			System.out.println("critical");
		//		} else {
		//			System.out.println("Medium");
		//		}
		//		

		//		final Severity[] a =  Severity.values();
		//		for (final Severity severity : a) {
		//			System.out.println(severity);
		//		}

		//		EnumSet<Severity> enumSet = EnumSet.of(Severity.CRITICAL, Severity.HIGH, Severity.MEDIUM, Severity.LOW);
		//		enumSet.forEach(System.out:: println);

		//		Map<Severity, String> map = new EnumMap<>(Severity.class);
		//		map.put(Severity.CRITICAL, "critcal");
		//		map.put(Severity.HIGH, "high");
		//		map.put(Severity.MEDIUM, "medium");	
		//		map.put(Severity.LOW, "low");
		//
		//		map.forEach((k,v)->System.out.println(k));
		
		
		System.out.println(Severity.CRITICAL.getFixingHours());
		System.out.println(Severity.MEDIUM.getFixingHours());
		System.out.println(Severity.HIGH.getFixingHours());
		System.out.println(Severity.LOW.getFixingHours());

	}

}
