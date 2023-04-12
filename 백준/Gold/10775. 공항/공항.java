import java.io.*;
import java.util.*;

public class Main {

    static int G, P;
    static boolean[] visited;
    static int[] representer;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        visited = new boolean[G+1];
        representer = new int[G+1];

        for(int i = 0; i <= G; i++){
            representer[i] = i;
        }

        int result = P;
        for(int i = 1; i <= P; i++){
            int cur = Integer.parseInt(br.readLine());
            int parent = findParent(cur);
            if(parent==0){
                result = i-1;
                break;
            }
            representer[parent] = parent-1;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findParent(int cur) {
        if(cur==representer[cur]){
            return cur;
        } else {
            representer[cur] = findParent(representer[cur]);
            return representer[cur];
        }
    }


}