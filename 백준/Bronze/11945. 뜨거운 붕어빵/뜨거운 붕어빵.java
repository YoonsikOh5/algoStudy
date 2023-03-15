import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = M-1; j>=0; j--){
                bw.write(s.charAt(j)+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
