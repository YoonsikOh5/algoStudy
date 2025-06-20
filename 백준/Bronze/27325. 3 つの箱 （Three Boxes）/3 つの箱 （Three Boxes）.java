import java.io.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int cidx = 1;
        int cnt = 0;
        for(int i = 0; i < len; i++){
            char cur = str.charAt(i);
            if(cur == 'L'){
                if(cidx != 1){
                    cidx -=1;
                }
            } else if(cur == 'R'){
                if(cidx != 3){
                    cidx += 1;
                }
            }
            if(cidx == 3){
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
