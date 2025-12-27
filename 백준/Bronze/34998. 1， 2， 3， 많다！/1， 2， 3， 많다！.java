import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            X = (2*X)+1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int res = 0;
            for (int j = 0; j < X; j++) {
                String s = st.nextToken();
                if(j % 2 == 0){
                    if(s.equals("!")){
                        res += 10;
                    } else {
                        int cur = Integer.parseInt(s);
                        res += cur;
                    }
                }
            }
            if(res > 9){
                bw.write("!\n");
            } else {
                bw.write(res+"\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
