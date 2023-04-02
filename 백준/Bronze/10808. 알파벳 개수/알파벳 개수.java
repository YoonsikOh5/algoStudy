import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }

        for (int i : arr) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}