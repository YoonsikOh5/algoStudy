import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        int min = 201;
        String res = "";
        while ( (str = br.readLine()) != null && !(str.isEmpty()) ) {
            StringTokenizer st = new StringTokenizer(str);
            String city = st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            if(min > cur){
                min = cur;
                res = city;
            }
        }
        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
