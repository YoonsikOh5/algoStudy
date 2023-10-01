import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(s);
        boolean isInc = false;
        boolean isDiv = false;
        if(n%7==0){
            isDiv = true;
        }
        if(s.contains("7")){
            isInc = true;
        }
        if(!isInc && !isDiv){
            bw.write("0");
        } else if(!isInc && isDiv){
            bw.write("1");
        } else if(isInc && !isDiv){
            bw.write("2");
        } else if(isInc && isDiv){
            bw.write("3");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}