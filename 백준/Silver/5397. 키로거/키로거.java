import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            List<Character> ls = new LinkedList<>();
            ListIterator<Character> it = ls.listIterator();
            String str = br.readLine();
            for (int idx = 0; idx < str.length(); idx++) {
                char cmd = str.charAt(idx);
                if (cmd == '<') {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                } else if (cmd == '>') {
                    if (it.hasNext()) {
                        it.next();
                    }
                } else if (cmd == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(cmd);
                }
            }
            for (Character c : ls) {
                bw.write(c+ "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }


}