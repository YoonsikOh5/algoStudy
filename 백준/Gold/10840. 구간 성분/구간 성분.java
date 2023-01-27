import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        HashMap<String, Integer> hm = new HashMap<>();

        int alen = a.length();
        int blen = b.length();

        for(int i = 1; i <= alen; i++){
            for(int j = 0, size = (alen-i+1); j < size; j++){
            int[] arr = new int[27];
                for(int k = j; k < j+i; k++) {
                    arr[(a.charAt(k) - 'a')]++;
                }
            hm.put(Arrays.toString(arr),Integer.valueOf(i));
            }
        }

        int result = 0;

        outloop : for(int i = blen; i >= 1; i--){
            for(int j = 0, size = (blen-i+1); j < size; j++){
                int[] arr = new int[27];
                for(int k = j; k < j+i; k++) {
                    arr[(b.charAt(k) - 'a')]++;
                }
                if(hm.containsKey(Arrays.toString(arr))){
                    result = hm.get(Arrays.toString(arr));
                    break outloop;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
