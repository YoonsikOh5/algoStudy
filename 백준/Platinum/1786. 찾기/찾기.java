import java.io.*;
import java.util.ArrayList;

public class Main {

    static int[] getPi(String p){
        int m = p.length();
        int j = 0;

        int[] pi = new int[m];

        for(int i = 1; i < m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(p.charAt(i) == p.charAt(j)){
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static ArrayList<Integer> kmp (String s, String p){
        ArrayList<Integer> answer = new ArrayList<>();

        int[] pi = getPi(p);

        int n = s.length();
        int m = p.length();
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j > 0 && s.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(s.charAt(i) == p.charAt(j)){
                if(j==m-1){
                    answer.add(i-m+1);
                    j = pi[j];
                } else{
                    j++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String P = br.readLine();

        ArrayList<Integer> matched = kmp(T,P);

        bw.write(matched.size() + "\n");

        for(int i = 0, size = matched.size(); i < size; i++){
            bw.write((matched.get(i)+1)+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }


}