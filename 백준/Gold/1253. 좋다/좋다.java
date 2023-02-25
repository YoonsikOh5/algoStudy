import java.io.*;
import java.util.*;


public class Main {

    static HashMap<Integer, List<Integer[]>> hm;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        hm = new HashMap<>();

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                int sum = arr[i]+arr[j];
                if(hm.containsKey(sum)){
                    Integer[] integers = new Integer[2];
                    integers[0] = i;
                    integers[1] = j;
                    hm.get(sum).add(integers);
                } else{
                    ArrayList<Integer[]> itgs = new ArrayList<>();
                    Integer[] integers = new Integer[2];
                    integers[0] = i;
                    integers[1] = j;
                    itgs.add(integers);
                    hm.put(sum, itgs);
                }
            }
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            if(hm.containsKey(arr[i])){
                List<Integer[]> integers = hm.get(arr[i]);
                for (Integer[] integer : integers) {
                    boolean notincluded = true;
                    for(int j = 0; j < 2; j++){
                        if(integer[j]==i){
                            notincluded = false;
                            break;
                        }
                    }
                    if(notincluded){
                       result++;
                       break;
                    }
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
