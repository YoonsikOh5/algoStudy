import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int N;

    static int[] reps;

    static Planet[] px;
    static Planet[] py;
    static Planet[] pz;

    static class Planet implements Comparable<Planet>{
        int num;
        long xyz;

        public Planet(int num, int xyz) {
            this.num = num;
            this.xyz = xyz;
        }

        @Override
        public int compareTo(Planet o) {
            Long l = (Long) this.xyz - o.xyz;
            return l.intValue();
        }
    }

    static class Tunnel {
        int left;
        int right;

        long length;

        public Tunnel(int left, int right, long length) {
            this.left = left;
            this.right = right;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        reps = new int[N];
        for(int i = 0; i < N; i++){
            reps[i] = i;
        }

        px = new Planet[N];
        py = new Planet[N];
        pz = new Planet[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            px[i] = new Planet(i,Integer.parseInt(st.nextToken()));
            py[i] = new Planet(i,Integer.parseInt(st.nextToken()));
            pz[i] = new Planet(i,Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(px);
        Arrays.sort(py);
        Arrays.sort(pz);

        PriorityQueue<Tunnel> pq = new PriorityQueue(new Comparator<Tunnel>(){

            @Override
            public int compare(Tunnel o1, Tunnel o2) {
                Long l = (Long) o1.length - o2.length;
                return l.intValue();
            }
        });

        for(int i = 0; i < N-1; i++){
            long xlen = Math.abs(px[i].xyz - px[i + 1].xyz);
            pq.offer(new Tunnel(px[i].num,px[i+1].num,xlen));
            long ylen = Math.abs(py[i].xyz - py[i + 1].xyz);
            pq.offer(new Tunnel(py[i].num,py[i+1].num,ylen));
            long zlen = Math.abs(pz[i].xyz - pz[i + 1].xyz);
            pq.offer(new Tunnel(pz[i].num,pz[i+1].num,zlen));
        }

        long result = 0;
        int selected = 0;

        while (pq.size()>0 && selected<N-1){
            Tunnel poll = pq.poll();


            if(merge(poll.left,poll.right)){
                result += poll.length;
                selected++;
            }

        }
        bw.write(result+"");
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
