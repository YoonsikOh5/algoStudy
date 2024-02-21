import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean run = true;

        while (run){
            int N = Integer.parseInt(br.readLine());

            if(N==0) break;

            Stack<Integer> s = new Stack<>();

            for(int i = 0; i < N; i++){
                s.push(Integer.parseInt(br.readLine()));
            }

            while (s.size()>0){
                bw.write(s.pop()+"\n");
            }

            bw.write("0\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}