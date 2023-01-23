import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if(str.length()==2){
            sb1.append(str.charAt(0));
            sb2.append(str.charAt(1));
        } else if(str.length()==4){
            sb1.append(str.charAt(0));
            sb1.append(str.charAt(1));
            sb2.append(str.charAt(2));
            sb2.append(str.charAt(3));
        } else if(str.length()==3){
            if(str.charAt(1)=='0'){
                sb1.append(str.charAt(0));
                sb1.append(str.charAt(1));
                sb2.append(str.charAt(2));
            } else {
                sb1.append(str.charAt(0));
                sb2.append(str.charAt(1));
                sb2.append(str.charAt(2));
            }
        }

        int a = Integer.parseInt(sb1.toString());
        int b = Integer.parseInt(sb2.toString());

        int result = a+b;
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
