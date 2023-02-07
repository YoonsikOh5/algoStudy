import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        if(str.charAt(0)==str.charAt(1)){
            bw.write(1+"");
        } else {
            bw.write(0+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }


}
