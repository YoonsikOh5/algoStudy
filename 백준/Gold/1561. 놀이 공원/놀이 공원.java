import java.io.*;
import java.util.*;


public class Main {

    static long N;
    static int M;
    static Map<Long,Long> tm;

    static long[] timearr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

       timearr = new long[M];

        st = new StringTokenizer(br.readLine());

        tm = new TreeMap<>();

        long mintime = Long.MAX_VALUE;

        for (int i = 0; i < M; i++){
            long num = Long.parseLong(st.nextToken());
            timearr[i] = num;
            mintime = Math.min(mintime,num);
            tm.put(num, tm.getOrDefault(num,0L)+1);
        }

        if(N > M){
            Long minTimeLastPerson = bSearch(1L, mintime*N);
//            bw.write(minTimeLastPerson+"\n");
            Integer answer = numofLastPerson(minTimeLastPerson);
            bw.write(answer+"");
        } else {
            bw.write(N+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static int numofLastPerson(Long minTimeLastPerson) {
        List<Integer> nowwaiting = new ArrayList<>();
        long totalVolume = 0;
        for(int i = 0; i  < M; i++){
            long rem = minTimeLastPerson % timearr[i];
            long div = minTimeLastPerson / timearr[i];
            if(rem==0){
                totalVolume += (div-1);
                nowwaiting.add(i);
            } else{
                totalVolume += div;
            }
        }
        Long remain = ((N-M) - totalVolume)-1;
        Integer lastnum = nowwaiting.get(remain.intValue());
        return lastnum+1;
    }

    private static Long bSearch(long left, long right) {

        long answer = -1;

        while(left <= right){
           long mid = (left + right) / 2;
           if(pSearch(mid)){
               answer = mid;
               right = mid-1;
           } else {
               left = mid+1;
           }
//            System.out.println(left+" "+right+" "+mid);

        }

        return answer;
    }

    private static boolean pSearch(long totaltime) {
        long num = 0;
        for (Long waittime : tm.keySet()) {
            num += ((totaltime/waittime)*tm.get(waittime));
           if(num >= (N-M)){
               return true;
           }
        }

        return false;
    }


}
