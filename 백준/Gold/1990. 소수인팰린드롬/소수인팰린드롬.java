import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] chae = new boolean[b+1];
        int sqrt = ((Double) Math.sqrt(b)).intValue();
        for(int i = 2; i <= sqrt; i++){
            if(chae[i]==true){
                continue;
            }
            int idx = 2;
            while(i*idx <= b){
                chae[i*idx] = true;
                idx++;
            }
        }

        for(int i = a; i <= b; i++){
            if(chae[i]==false){
                if(isPalin(i)){
                    bw.write(i+"\n");
                }
            }
        }
        bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPalin(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String s = sb.toString();
        String s1 = sb.reverse().toString();
        if(s.equals(s1)){
            return true;
        } else{
            return false;
        }
    }
}
