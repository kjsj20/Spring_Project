package com.jscompany.springproject.common;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

/*날짜, 통화 등 자주사용하는 표기에 대한 처리*/
public class Formatter {
	//숫자를 해당 시스템의 통화로 변환하여 반환하는 메서드, 3자리마다 쉼표처리
	public static String getCurrency(long number) {
		String currency = Currency.getInstance(Locale.KOREA).getSymbol();
		DecimalFormat df = new DecimalFormat("###,###.###");
		String result = currency + "  " + df.format(number) + "원";
		return result;
	}
	
//	/*
//	 * public static void main(String[] args) {
//	 * System.out.println(getCurrency(2000000000)); }
//	 */
}
