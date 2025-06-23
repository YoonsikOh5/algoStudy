import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Character> s = new ArrayList<Character>();
        List<Character> r = new ArrayList<Character>();
        List<Character> p = new ArrayList<Character>();

        String str = br.readLine();
        for(int i = 0; i < N; i++){
            char cur = str.charAt(i);
            if(cur == 's'){
                if(s.size() < K){
                    s.add(cur);
                } else if(r.size() < K){
                    r.add(cur);
                } else {
                    p.add(cur);
                }
            }
            if(cur == 'r'){
                if(r.size() < K){
                    r.add(cur);
                } else if(p.size() < K){
                    p.add(cur);
                } else {
                    s.add(cur);
                }
            }
            if(cur == 'p'){
                if(p.size() < K){
                    p.add(cur);
                } else if(s.size() < K){
                    s.add(cur);
                } else {
                    r.add(cur);
                }
            }
        }

        int ss = s.size();
        int rs = r.size();
        int ps = p.size();

        for(int i = 0; i < ss; i++){
            bw.write(s.get(i));
        }
        bw.write("\n");
        for(int i = 0; i < rs; i++){
            bw.write(r.get(i));
        }
        bw.write("\n");
        for(int i = 0; i < ps; i++){
            bw.write(p.get(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
