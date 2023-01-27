import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

//        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();

        int alen = a.length();
        int blen = b.length();

        for(int i = 0; i < alen; i++){
            int[] arr = new int[27];
                for(int k = i; k < alen; k++){
                    arr[a.charAt(k)-'a']++;
//                    hm.put(Arrays.toString(arr),Integer.valueOf((k-i+1)));
                    hs.add(Arrays.toString(arr));
                }
        }

//        for(int i = 1; i <= alen; i++){
//            for(int j = 0, size = (alen-i+1); j < size; j++){
//            int[] arr = new int[27];
//                for(int k = j; k < j+i; k++) {
//                    arr[(a.charAt(k) - 'a')]++;
//                }
//            hm.put(Arrays.toString(arr),Integer.valueOf(i));
//            }
//        }

        int result = 0;

        for(int i = 0; i < blen; i++){
            int[] arr = new int[27];
            for(int k = i; k < blen; k++){
                arr[b.charAt(k)-'a']++;
                if(hs.contains(Arrays.toString(arr))){
                    result = Math.max((k-i+1),result);
                }
            }
        }

//        outloop : for(int i = blen; i >= 1; i--){
//            for(int j = 0, size = (blen-i+1); j < size; j++){
//                int[] arr = new int[27];
//                for(int k = j; k < j+i; k++) {
//                    arr[(b.charAt(k) - 'a')]++;
//                }
//                if(hs.contains(Arrays.toString(arr))){
//                    result = i;
//                    break outloop;
//                }
//            }
//        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
