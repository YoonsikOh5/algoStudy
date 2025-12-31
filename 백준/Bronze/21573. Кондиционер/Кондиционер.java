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

        String cur = br.readLine();
        if(cur.equals("heat")){
            if(b > a){
                bw.write(b+"");
            } else {
                bw.write(a+"");
            }
        } else if(cur.equals("freeze")){
            if(b > a){
                bw.write(a+"");
            } else {
                bw.write(b+"");
            }
        } else if(cur.equals("auto")){
            bw.write(b+"");
        } else if(cur.equals("fan")){
            bw.write(a+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
