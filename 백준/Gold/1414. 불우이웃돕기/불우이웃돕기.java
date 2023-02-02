import java.io.*;
import java.util.*;


public class Main {

    static int N;

    static int[] reps;

    static class Line {
        int left;
        int right;

        int length;

        public Line(int left, int right, int length) {
            this.left = left;
            this.right = right;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Line> pq = new PriorityQueue<>(new Comparator<Line>(){

            @Override
            public int compare(Line o1, Line o2) {
                return o1.length-o2.length;
            }
        });

        for(int r = 0; r < N; r++){
            String str = br.readLine();
            for(int c = 0; c < N; c++){
                char cur = str.charAt(c);
                int curlen = 0;
                int m0 = cur-'0';
                if(m0==0){
                    continue;
                } else if(m0>=49 && m0 <= 74){
                    curlen = m0-48;
                } else if(m0>=17 && m0<=42){
                    curlen = m0+10;
                }
                Line line = new Line(r, c, curlen);
                pq.offer(line);
            }
        }

        reps = new int[N];
        for(int i = 0; i <N; i++){
            reps[i] = i;
        }

        int result = 0;
        int selected = 0;

        while (pq.size()>0){
            Line poll = pq.poll();

            if(!merge(poll.left,poll.right)){
                result += poll.length;
            } else {
                selected++;
            }
        }
        if(selected!=N-1){
            bw.write("-1");
        } else if(selected==N-1){
            bw.write(result+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static boolean merge(int left, int right){
        int leftrep = findrep(left);
        int rightrep = findrep(right);
        if(leftrep == rightrep){
            return false;
        }

        reps[rightrep] = leftrep;
        return true;
    }

    static int findrep(int i){
        if(reps[i] == i){
            return i;
        } else{
            return reps[i] = findrep(reps[i]);
        }
    }

}
