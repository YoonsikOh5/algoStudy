import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        while (name!=null && !name.equals("")){

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < name.length(); i++){
                char c = name.charAt(i);
                if(c == 'i'){
                    sb.append('e');
                } else if(c == 'e'){
                    sb.append('i');
                } else if(c == 'I'){
                    sb.append('E');
                } else if (c == 'E') {
                    sb.append('I');
                } else {
                    sb.append(c);
                }
            }
            bw.write(sb.toString()+"\n");
            name = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}