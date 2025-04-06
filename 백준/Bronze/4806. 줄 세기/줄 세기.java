import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        while (true){
            try{
                sc.nextLine();
                cnt++;
            } catch (Exception e){
                break;
            }
        }

        bw.write(cnt+"");
        sc.close();
        bw.flush();
        bw.close();
        br.close();
    }

}
