import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            bw.write(s+" ");
            int cur = Integer.parseInt(st.nextToken());
            if(cur >= 97){
                bw.write("A+\n");
            } else if(cur >= 90){
                bw.write("A\n");
            } else if(cur >= 87){
                bw.write("B+\n");
            } else if(cur >= 80){
                bw.write("B\n");
            } else if(cur >= 77){
                bw.write("C+\n");
            } else if(cur >= 70){
                bw.write("C\n");
            } else if(cur >= 67){
                bw.write("D+\n");
            } else if(cur >= 60){
                bw.write("D\n");
            } else {
                bw.write("F\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
