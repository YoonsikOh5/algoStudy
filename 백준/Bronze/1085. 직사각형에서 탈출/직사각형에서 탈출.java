import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int result_min = Integer.MAX_VALUE;
		result_min = Math.min(result_min, w-x);
		result_min = Math.min(result_min, x);
		result_min = Math.min(result_min, h-y);
		result_min = Math.min(result_min, y);
		
		System.out.println(result_min);

	}

}