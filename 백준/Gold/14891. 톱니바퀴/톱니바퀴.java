import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 14891번 톱니바퀴
public class Main {
	
	static Gear[] gears;
	
	static class Gear{
		
		int gearNum;
		
		LinkedList<Integer> sawList;

		public Gear(int gearNum, LinkedList<Integer> sawList) {
			this.gearNum = gearNum;
			this.sawList = sawList;
		}

		public void rotateInit(int direction) {
			// 오른쪽에 있는 애들 회전
			if(this.gearNum < 4) {
				if(this.sawList.get(2) != gears[this.gearNum+1].sawList.get(6)) {
					rotate(1,-direction);
				}
			}
			// 왼쪽에 있는 톱니들 회전
			if(this.gearNum > 1) {
				if(this.sawList.get(6) != gears[this.gearNum-1].sawList.get(2)) {
					rotate(-1,-direction);
				}
			}
			
			if(direction == 1) {
				this.sawList.offerFirst(this.sawList.pollLast());
			} else if(direction == -1) {				
				this.sawList.offerLast(this.sawList.pollFirst());
			}
		}

		public void rotate(int rl, int direction) {
			// 오른쪽이었으면 rl > 0
			if(rl>0) {
				if(this.gearNum+rl < 4) {
					if(gears[this.gearNum+rl].sawList.get(2) != gears[this.gearNum+rl+1].sawList.get(6)) {
						rotate(rl+1,-direction);
					}
				}
				if(direction == 1) {
					gears[this.gearNum+rl].sawList.offerFirst(gears[this.gearNum+rl].sawList.pollLast());
				} else if(direction == -1) {				
					gears[this.gearNum+rl].sawList.offerLast(gears[this.gearNum+rl].sawList.pollFirst());
				}
			}
			// 왼쪽이었으면 rl < 0
			if(rl<0) {
				if(this.gearNum+rl > 1) {
					if(gears[this.gearNum+rl].sawList.get(6) != gears[this.gearNum+rl-1].sawList.get(2)) {
						rotate(rl-1,-direction);
					}
				}
				if(direction == 1) {
					gears[this.gearNum+rl].sawList.offerFirst(gears[this.gearNum+rl].sawList.pollLast());
				} else if(direction == -1) {				
					gears[this.gearNum+rl].sawList.offerLast(gears[this.gearNum+rl].sawList.pollFirst());
				}
			}
		}
		
		@Override
		public String toString() {
			return this.sawList.toString();
		}
		
		
	}


    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	// 0번 안 씀
    	gears = new Gear[5];
    	
    	for(int i = 1; i <= 4; i++) {
    		LinkedList<Integer> sawList = new LinkedList<>();
    		
    		String sawStr = br.readLine();
    		
    		for(int j = 0; j < 8; j++) {
    			sawList.add((sawStr.charAt(j)-'0'));
    		}
    		
    		Gear gear = new Gear(i, sawList);
    		gears[i] = gear;
    	}
    	
    	int rotCnt = Integer.parseInt(br.readLine());
    	
    	for(int i = 1; i <= rotCnt; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int num = Integer.parseInt(st.nextToken());
    		int direction = Integer.parseInt(st.nextToken());
    		
    		gears[num].rotateInit(direction);
    	}
    	
    	int resultPoint = 0;
    	for(int i = 1; i<=4; i++) {
    		if(gears[i].sawList.get(0)==1) {
    			resultPoint += (1<<(i-1));
    		}
    	}
    	
    	bw.write(resultPoint+"");
    	bw.flush();
        bw.close();
        br.close();
    }
    
 

}
