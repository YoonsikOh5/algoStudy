import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<String, Integer> hm;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String num1 = br.readLine();
		String num2 = br.readLine();

		hm = new HashMap<>();

		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);
		hm.put("IV", 4);
		hm.put("IX", 9);
		hm.put("XL", 40);
		hm.put("XC", 90);
		hm.put("CD", 400);
		hm.put("CM", 900);

		int result1 = decode(num1) + decode(num2);
		String result2 = incode(result1);

		bw.write(result1 + "\n");
		bw.write(result2+"");
		bw.flush();
		bw.close();
		br.close();
	}

	static int decode(String num) {

		int len = num.length();

		int inum = 0;
		boolean islasttwo = false;
		for (int i = 0; i < len - 1; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(num.charAt(i));
			sb.append(num.charAt(i + 1));

			if (hm.containsKey(sb.toString())) {
				inum += hm.get(sb.toString());
				if(i==len-2) {
					islasttwo = true;
				}
				i++;
			} else {
				sb.deleteCharAt(1);
				inum += hm.get(sb.toString());
			}
		}
		
		if(!islasttwo) {
			StringBuilder sb = new StringBuilder();
			sb.append(num.charAt(len-1));
			inum += hm.get(sb.toString());
		}

		return inum;

	}
	
	static String incode(int num) {

		StringBuilder sb = new StringBuilder();
		
		while(num/1000>0) {
			num -= 1000;
			sb.append("M");
		}
		if(num/900>0) {
			num -= 900;
			sb.append("CM");
		}
		if(num/500>0) {
			num -= 500;
			sb.append("D");
		}
		if(num/400>0) {
			num -= 400;
			sb.append("CD");
		}
		while(num/100>0) {
			num -= 100;
			sb.append("C");
		}
		if(num/90>0) {
			num -= 90;
			sb.append("XC");
		}
		if(num/50>0) {
			num -= 50;
			sb.append("L");
		}
		if(num/40>0) {
			num -= 40;
			sb.append("XL");
		}
		while(num/10>0) {
			num -= 10;
			sb.append("X");
		}
		if(num/9>0) {
			num -= 9;
			sb.append("IX");
		}
		if(num/5>0) {
			num -= 5;
			sb.append("V");
		}
		if(num/4>0) {
			num -= 4;
			sb.append("IV");
		}
		while(num/1>0) {
			num -= 1;
			sb.append("I");
		}

		return sb.toString();
	}

}