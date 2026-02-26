import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int res = 0;
        for(int i = a; i <= b; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < 4; j++){
                char cur = s.charAt(j);
                if(cur==c){
                    res++;
                }
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
