import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        HashMap<String, String> hm = new HashMap<>();

        hm.put("CU", "see you");
        hm.put(":-)", "I’m happy");
        hm.put(":-(", "I’m unhappy");
        hm.put(";-)", "wink");
        hm.put(":-P", "stick out my tongue");
        hm.put("(~.~)", "sleepy");
        hm.put("TA", "totally awesome");
        hm.put("CCC", "Canadian Computing Competition");
        hm.put("CUZ", "because");
        hm.put("TY", "thank-you");
        hm.put("YW", "you’re welcome");
        hm.put("TTYL", "talk to you later");


        String str = br.readLine();
        while (!str.equals("TTYL")) {
            if (hm.containsKey(str)) {
                bw.write(hm.get(str) + "\n");
            } else {
                bw.write(str + "\n");
            }
            str = br.readLine();
        }
        bw.write(hm.get(str) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}
