import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            int len = s.length();
            int sum = 0;
            int res = 0;
            for(int j = 0; j < len; j++){
                char cur = s.charAt(j);
                if(j % 8 == 7){
                    if(sum % 2 == 0){
                        if (cur == '1') {
                            res++;
                        }
                    } else if(sum % 2 == 1){
                        if(cur == '0'){
                            res++;
                        }
                    }
                    sum = 0;
                } else {
                    if(cur == '1'){
                        sum++;
                    }
                }
            }
            bw.write(res+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
