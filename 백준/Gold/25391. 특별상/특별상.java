import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Score{

        long hostScore;
        long judgeScore;

        public Score(long hostScore, long judgeScore) {
            this.hostScore = hostScore;
            this.judgeScore = judgeScore;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "hostScore=" + hostScore +
                    ", judgeScore=" + judgeScore +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Score> hostpq = new PriorityQueue<Score>(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return (int)(o2.hostScore - o1.hostScore);
            }
        });

        PriorityQueue<Score> judgepq = new PriorityQueue<Score>(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return (int)(o2.judgeScore - o1.judgeScore);
            }
        });

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            long hostScore = Long.parseLong(st.nextToken());
            long judgeScore = Long.parseLong(st.nextToken());

            Score cur = new Score(hostScore,judgeScore);
            hostpq.add(cur);
            judgepq.add(cur);
        }

        long resultsum = 0;
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i = 1; i <= K; i++){
            Score cur = judgepq.poll();
            resultsum += cur.hostScore;
            String key = cur.hostScore+" "+cur.judgeScore;
            hm.put(key,1);
        }
        int selectedHostCnt = 0;
        while(selectedHostCnt < M){
            Score cur = hostpq.poll();
            String key = cur.hostScore+" "+cur.judgeScore;
            if(!hm.containsKey(key)){
                resultsum += cur.hostScore;
                selectedHostCnt++;
            } 
        }

        bw.write(resultsum+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
