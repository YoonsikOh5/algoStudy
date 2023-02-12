import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if(a<b){
            bw.write("-1");
        } else if(a==b){
            bw.write("0");
        } else if(a>b){
            bw.write("1");
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
