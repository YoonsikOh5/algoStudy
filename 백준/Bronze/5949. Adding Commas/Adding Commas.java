import java.io.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(i!=0 && (len-i)%3==0){
                bw.write(",");
            }
            bw.write(cur+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
