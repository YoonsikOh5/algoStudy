import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Alpha implements Comparable<Alpha>{
        char alpha;
        int num;

        public Alpha(char alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }

        @Override
        public int compareTo(Alpha o) {
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            int length = str.length();

            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                arr[c-'A'] += Math.pow(10,(length-1)-(j));
            }
        }
        PriorityQueue<Alpha> pq = new PriorityQueue<>();
        for(int i = 0; i < 26; i++){
            if(arr[i]!=0){
                pq.offer(new Alpha((char)('A'+i), arr[i]));
            }
        }

        int sum = 0;
        int curnum = 9;
        while (pq.size()>0){
            Alpha poll = pq.poll();
            sum += (curnum*poll.num);
            curnum--;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}