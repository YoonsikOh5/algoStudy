import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[][] map;
    static int[] road;
    static int roadCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        roadCnt = 0;

        for (int r = 0; r < N; r++) {
            road = new int[N];
            for (int c = 0; c < N; c++) {
                road[c] = map[r][c];
            }
            if(checkroad()){
                roadCnt++;
            }
        }
        for (int c = 0; c < N; c++) {
            road = new int[N];
            for (int r = 0; r < N; r++) {
                road[r] = map[r][c];
            }
            if(checkroad()){
                roadCnt++;
            }
        }

        bw.write(roadCnt+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static boolean checkroad() {

        // 이전 층의 숫자 관리
        int before = road[0];
        // 이전 층과 같은 층의 연속 출연 횟수
        int streak = 1;

        // 이전 층보다 낮은 경우 낮은 층 연속성 판단하는중인지를 알려주는 boolean
        boolean lowJudging = false;
        // L이 1인 특수한 경우를 처리하기 위한 boolean
        boolean l1special = false;

        for(int i = 1; i < N; i++){
            int current = road[i];

            // 1.이전 층과 같은 경우
            if(before==current){
                if(lowJudging){
                  streak++;
                  if(streak==L){
                      lowJudging = false;
                      streak = 0;
                  }
                } else{
                  streak++;
                }
            }

            // 2. 이전 층보다 높은 경우
            if(before<current){
                // lowJudging 중에 높은 층이 나오면 바로 false
                if(lowJudging || l1special){
                    return false;
                }

                // 1 초과해서 차이나면 false 리턴
                if(current-before>1){
                    return false;
                }

                // streak가 L미만이면 false 리턴
                if(streak < L){
                    return false;
                }

                // 다 통과되면 streak 1로 초기화해주고 넘어감
                streak = 1;
            }

            l1special = false;

            // 3. 이전 층보다 낮은 경우
            if(before>current){
                // lowJudging 중에 낮은 층이 나오면 바로 false
                if(lowJudging){
                    return false;
                }

                // 1 초과해서 차이나면 false 리턴
                if(before-current>1){
                    return false;
                }

                lowJudging = true;
                streak = 1;
                if(L==1){
                    lowJudging = false;
                    l1special = true;
                    streak = 0;
                }
            }

            before = current;
        }

        // 마지막에 lowJudging중에 끝나는 경우는 false로 처리해줘야됨
        if(lowJudging){
            return false;
        }


//        System.out.println(Arrays.toString(road));
        return true;
    }

}