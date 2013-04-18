package br.com.furb.comp.util;

public class Utils {
	public static String espacamento(String aS, int aQtdeCar) {
		while (aS.length() < aQtdeCar) {
			aS += " ";
		}
		return aS;		
	}
}
