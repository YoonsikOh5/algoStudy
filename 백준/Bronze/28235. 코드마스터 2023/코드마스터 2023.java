import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        if (s.equals("SONGDO")) {
            bw.write("HIGHSCHOOL");
        } else if(s.equals("CODE")){
            bw.write("MASTER");
        } else if(s.equals("2023")){
            bw.write("0611");
        } else if(s.equals("ALGORITHM")){
            bw.write("CONTEST");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}