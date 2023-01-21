import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int td = Integer.parseInt(st.nextToken())*6;
        int fg = Integer.parseInt(st.nextToken())*3;
        int sf = Integer.parseInt(st.nextToken())*2;
        int pf = Integer.parseInt(st.nextToken());
        int tf = Integer.parseInt(st.nextToken())*2;

        int scorea = td+fg+sf+pf+tf;

        st = new StringTokenizer(br.readLine());

        td = Integer.parseInt(st.nextToken())*6;
        fg = Integer.parseInt(st.nextToken())*3;
        sf = Integer.parseInt(st.nextToken())*2;
        pf = Integer.parseInt(st.nextToken());
        tf = Integer.parseInt(st.nextToken())*2;

        int scoreb = td+fg+sf+pf+tf;
        bw.write(scorea + " " + scoreb);
        bw.flush();
        bw.close();
        br.close();

    }

}
