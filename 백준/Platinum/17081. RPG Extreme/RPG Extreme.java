import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] grid;
	static HashMap<String, Monster> monstermap;
	static HashMap<String, Item> itemmap;
	static Player player;
	static boolean gameend;
	static BufferedWriter bw;
	static int passedturn;
	static Monster inBattleMonster;

	public static class Player{
		int curr;
		int curc;
		int startr;
		int startc;
		
		int curhp=20;
		int maxhp=20;
		int atk=2;
		int def=2;
		int level=1;
		int exp=0;
		int expfornextlevel=5;
		
		int weapon=0;
		int armor=0;
		
		// 장신구 리스트
		HashSet<String> acclist = new HashSet<>();

		// 플레이어 생성자
		public Player(int curr, int curc) {
			super();
			this.curr = curr;
			this.curc = curc;
			this.startr = curr;
			this.startc = curc;
		}
		
		
		// 가시 함정
		void spike() throws IOException {
			if(this.acclist.contains("DX")) {
				this.curhp = this.curhp-1;
			} else {
				this.curhp = this.curhp-5;				
			}
			if(this.curhp<=0) {
				this.curhp=0;
				// 게임 끝 메소드
				playerdie(2);
			}
		}
		
		// 아이템 얻기
		void getItem() {
			grid[this.curr][this.curc]='.';
			String key = this.curr+" "+this.curc;
			Item curitem = itemmap.get(key);
			if(curitem.type.equals("W")) {
				this.weapon = Integer.parseInt(curitem.name);
			} else if (curitem.type.equals("A")) {
				this.armor = Integer.parseInt(curitem.name);
			} else if (curitem.type.equals("O")) {
				if(this.acclist.size()<4) {
					acclist.add(curitem.name);
				}
			}
		}
		
		// 레벨 업
		void dolevelup() {
			this.level++;
			this.exp = 0;
			this.expfornextlevel = this.level * 5;
			this.maxhp += 5;
			this.atk += 2;
			this.def += 2;
			this.curhp = this.maxhp;
		}
		
		// 전투 num==1 일반 몬스터 num==2 보스 몬스터
		void dobattle(int num) throws IOException {
			String key = this.curr+" "+this.curc;
			Monster curmon = monstermap.get(key);
			inBattleMonster = curmon;
			if(num==1) {
				// 첫턴 판단용 페이즈
				int phase = 1;
				// 공격권 1이 플레이어 2가 몬스터
				int whosturn = 1;
				boolean inbattle = true;
				while(inbattle) {
					if(whosturn == 1) {
						int finatk = this.atk+this.weapon;
						if(phase==1 && this.acclist.contains("CO")) {
							if(this.acclist.contains("DX")) {
								finatk *= 3;
							} else {
								finatk *= 2;								
							}
						}
						int damage = Math.max(1, finatk-curmon.def);
						curmon.curhp -= damage;
						
						if(curmon.curhp <= 0) {
							int expearn = curmon.expbonus;
							if(this.acclist.contains("EX")) {
								expearn = (int)(expearn * 1.2);
							}
							this.exp += expearn;
							if(this.exp>=this.expfornextlevel) {
								dolevelup();
							}
							
							if(this.acclist.contains("HR")) {
								this.curhp += 3;
								if(curhp > maxhp) {
									curhp = maxhp;
								}
							}
							grid[curr][curc]='.';
							break;
						} else {
							phase++;
							whosturn = 2;
						}
					} else if (whosturn == 2) {
						int finatk = curmon.atk;
						int damage = Math.max(1, finatk-(this.def+this.armor));
						this.curhp -= damage;
						
						if(this.curhp <= 0) {
							curmon.curhp = curmon.originhp;
							this.curhp = 0;
							// 플레이어 사망 메소드
							playerdie(3);
							break;
						} else {
							whosturn = 1;
						}
					}
				}
			} else if(num==2) {
				// 일어나서 할 곳
				// 여기 보스몬스터랑 배틀하기
				// 첫턴 판단용 페이즈
				int phase = 1;
				// 공격권 1이 플레이어 2가 몬스터
				int whosturn = 1;
				boolean inbattle = true;
				if(this.acclist.contains("HU")) {
					this.curhp = this.maxhp;
				}
				while(inbattle) {
					if(whosturn == 1) {
						int finatk = this.atk+this.weapon;
						if(phase==1 && this.acclist.contains("CO")) {
							if(this.acclist.contains("DX")) {
								finatk *= 3;
							} else {
								finatk *= 2;								
							}
						}
						int damage = Math.max(1, finatk-curmon.def);
						curmon.curhp -= damage;
						
						if(curmon.curhp <= 0) {
							int expearn = curmon.expbonus;
							if(this.acclist.contains("EX")) {
								expearn = (int)(expearn * 1.2);
							}
							this.exp += expearn;
							if(this.exp>=this.expfornextlevel) {
								dolevelup();
							}
							
							if(this.acclist.contains("HR")) {
								this.curhp += 3;
								if(curhp > maxhp) {
									curhp = maxhp;
								}
							}
							grid[curr][curc]='.';
							
							//플레이어 승리 후 끝
							gameover(4);
							break;
						} else {
							phase++;
							whosturn = 2;
						}
					} else if (whosturn == 2) {
						if(phase==2 && this.acclist.contains("HU")) {
							whosturn = 1;
							continue;
						}
						int finatk = curmon.atk;
						int damage = Math.max(1, finatk-(this.def+this.armor));
						this.curhp -= damage;
						
						if(this.curhp <= 0) {
							curmon.curhp = curmon.originhp;
							this.curhp = 0;
							// 플레이어 사망 메소드
							playerdie(3);
							break;
						} else {
							phase++;
							whosturn = 1;
						}
					}
				}
			}
		}
		
		
		public void playerdie(int diecase) throws IOException {
			if(this.acclist.contains("RE")) {
				this.acclist.remove("RE");
				this.curhp = this.maxhp;
				this.curr = this.startr;
				this.curc = this.startc;
				return;
			}
			
			gameover(diecase);
			
		}
		
	
	}
	
	public static class Monster {
		int r;
		int c;
		
		String name;
		
		int atk;
		int def;
		int curhp;
		int originhp;
		int expbonus;
		
		public Monster(int r, int c, String name, int atk, int def, int hp, int expbonus) {
			this.r = r;
			this.c = c;
			this.name = name;
			this.atk = atk;
			this.def = def;
			this.curhp = hp;
			this.originhp = hp;
			this.expbonus = expbonus;
		}
		
	}
	
	public static class Item{
		String type;
		String name;
		
		public Item(String type, String name) {
			super();
			this.type = type;
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new char[N+1][M+1];
		int K = 0;
		int L = 0;
		for(int r = 1; r <= N; r++) {
			char[] carr = br.readLine().toCharArray();
			for(int c = 0; c < M; c++) {
				char cur = carr[c];
				grid[r][c+1] = cur;
				if(cur=='&'||cur=='M') {
					K++;
				} else if(cur=='B') {
					L++;
				} else if(cur=='@') {
					player = new Player(r,c+1);
				}
				// 필요정보 넣어주기
			}
		}
		
		String cmdline = br.readLine();
		
		monstermap = new HashMap<String,Monster>();
		// 몬스터 입력 받기
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int curc = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int atk = Integer.parseInt(st.nextToken());
			int def = Integer.parseInt(st.nextToken());
			int hp = Integer.parseInt(st.nextToken());
			int bexp = Integer.parseInt(st.nextToken());
			String keym = curr+" "+curc;
			Monster curmon = new Monster(curr,curc,name,atk,def,hp,bexp);
			monstermap.put(keym,curmon);
		}
		
		itemmap = new HashMap<String, Item>();
		// 아이템 입력 받기
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int curc = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			String name = st.nextToken();
			Item curItem = new Item(type,name);
			String keym = curr+" "+curc;

			itemmap.put(keym,curItem);
		}
		
		gameend = false;
		passedturn = 0;
		for(int i = 0, size = cmdline.length(); i < size; i++) {
			passedturn++;
			char cmd = cmdline.charAt(i);
			// domove 커맨드에 따라 움직이는 메소드
			domove(cmd);
			if(gameend) {
				break;
			}
		}

		// 커맨드 다쓸때까지 아직 보스를 못죽이거나 플레이어가 안죽었을때 
		if(!gameend) {
			gameover(1);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void domove(char cmd) throws IOException {
		int curr = player.curr;
		int curc = player.curc;
		if(cmd=='L') {
			if(inRange(curr,curc-1)) {
				doact(curr,curc-1);
			} else {
				doact(curr,curc);
			}
		} else if(cmd=='R') {
			if(inRange(curr,curc+1)) {
				doact(curr,curc+1);
			} else {
				doact(curr,curc);
			}
		} else if(cmd=='U') {
			if(inRange(curr-1,curc)) {
				doact(curr-1,curc);
			} else {
				doact(curr,curc);
			}
		} else if(cmd=='D') {
			if(inRange(curr+1,curc)) {
				doact(curr+1,curc);
			} else{
				doact(curr,curc);
			}
		}
	}
	
	static boolean inRange(int nr, int nc) {
		// 벽 판단 여기서
		if(nr >= 1 && nr <= N && nc >= 1 && nc <= M && !(grid[nr][nc]=='#')) {
			return true;
		} else {
			return false;
		}
	}
	
	static void doact(int curr, int curc) throws IOException {
		player.curr=curr;
		player.curc=curc;
		switch(grid[curr][curc]) {
		case '@':
		case '.':
			break;
		case '^':
			player.spike();
			break;
		case 'B':
			player.getItem();
			break;
		case '&':
			player.dobattle(1);
			break;
		case 'M':
			player.dobattle(2);
			break;
		}
	}
	
	static void printgrid() throws IOException {
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				bw.write(grid[r][c]);
			}
			bw.write("\n");
		}
	}
	
	static void printstats() throws IOException {
		bw.write("Passed Turns : "+passedturn+"\n");
		bw.write("LV : "+player.level+"\n");
		bw.write("HP : "+player.curhp+"/"+player.maxhp+"\n");
		bw.write("ATT : "+player.atk+"+"+player.weapon+"\n");
		bw.write("DEF : "+player.def+"+"+player.armor+"\n");
		bw.write("EXP : "+player.exp+"/"+player.expfornextlevel+"\n");
	}
	
	static void gameover(int endcase) throws IOException {
		gameend = true;
		// 모든케이스에서 플레이어의 첫번째 위치를 공백으로
		grid[player.startr][player.startc] = '.';
		switch(endcase) {
		// 1 커맨드가 끝난경우
		case 1:
			// 플레이어의 현재 위치를 @로
			grid[player.curr][player.curc] = '@';
			printgrid();
			printstats();
			bw.write("Press any key to continue.");
			break;
		// 2 가시함정에 죽은경우
		case 2:
			// 플레이어 출력 X
			printgrid();
			printstats();
			bw.write("YOU HAVE BEEN KILLED BY SPIKE TRAP..");
			break;
		// 3 몬스터에 죽은 경우
		case 3:
			// 플레이어 출력 X
			printgrid();
			printstats();
			bw.write("YOU HAVE BEEN KILLED BY "+inBattleMonster.name+"..");
			break;
		// 4 보스 몬스터 잡고 승리한 경우
		case 4:
			grid[player.curr][player.curc] = '@';
			printgrid();
			printstats();
			bw.write("YOU WIN!");
			break;
		}
		
	}

}