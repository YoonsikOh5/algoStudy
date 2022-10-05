import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//브루트포스
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		min = Math.abs(n - 100);

		int m = sc.nextInt();

		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			ls.add(i);
		}
		for (int i = 0; i < m; i++) {
			ls.remove((Integer)sc.nextInt());
		}
		
		// 첫번째 수정
		if(m != 10) { // m이 10이면 + -로만 이동이 가능하기에 그냥 순열에 들어가면 안됨
		// 누를수 있는 리모컨 숫자들로 중복순열 만들기
		perm(0, ls, 1, 0);
		}
		System.out.println(min);
		
	}

	static int n = 0;
	static int min = Integer.MAX_VALUE;

	public static void perm(int num, List<Integer> ls, int nth, int cnt) {
		// 기저 파트
		if (cnt == 7) {
			return;
		}
		
		// 최소값 확인 파트
		int curcnt = (Math.abs(n - num) + cnt);
		if (min > curcnt) {
			if(cnt != 0) { // 세번째 수정 cnt가 0일땐 그냥 안들어오게 하는게 더 정확할듯
				min = curcnt;
			}
		}

		// 유도 파트
		for (int i = 0; i < ls.size(); i++) {

			perm(num + ls.get(i) * nth, ls, nth * 10, cnt + 1);

		}

	}

}