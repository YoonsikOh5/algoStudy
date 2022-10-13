import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Class> q = new PriorityQueue<Class>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			q.offer(new Class(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		// 오름차순으로 poll
		PriorityQueue<Integer> room = new PriorityQueue();
		
		// 맨 처음꺼 넣어주기
		Class cur = q.poll();
		// 첫번째 클래스의 끝나는 지점 첫번째 클래스는 시작점이 어차피 가장 빠르니까 신경쓸 필요가 없음
		room.offer(cur.end);
		
		while(q.size()>0) {
			cur = q.poll();
			
			// room.peek은 현재 방들 중에 가장 빠르게 끝나는 방의 끝나는 시간을 보여줌
			// 이러면 한 방에서 계속해서 연속해서 쓰는거
			if(cur.start >= room.peek()) {
				room.poll();
				room.offer(cur.end);
			} else if (cur.start < room.peek()) {
			// 이러면 다른 방 하나 파줘야 됨
				room.offer(cur.end);
			}
			
		}
		
		System.out.println(room.size());

	}

}

class Class implements Comparable {
	int start;
	int end;

	public Class(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Object o) {
		Class o2 = (Class) o;

		return this.start == o2.start ? this.end - o2.end : this.start - o2.start;
	}

}