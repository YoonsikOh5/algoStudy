import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cc = 0;
            int vc = 0;
            while (st.hasMoreTokens()){
                String cur = st.nextToken();
                int length = cur.length();
                for(int j = 0; j < length; j++){
                    char c = cur.charAt(j);
                    if(c == 'A' || c == 'E' ||c == 'I' ||c == 'O' ||c == 'U' ||c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                        vc++;
                    } else {
                        cc++;
                    }
                }
            }
            bw.write(cc+" "+vc+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
