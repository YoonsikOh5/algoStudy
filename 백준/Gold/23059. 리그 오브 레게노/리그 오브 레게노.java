import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int T;
    static TreeMap<String, TreeSet<String>> frontMap;
    static TreeMap<String, TreeSet<String>> backMap;
    static List<String> results;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        frontMap = new TreeMap<>();
        backMap = new TreeMap<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();
            if (!frontMap.containsKey(left)) {
                frontMap.put(left, new TreeSet<>());
            }
            if (!frontMap.containsKey(right)) {
                TreeSet<String> strings = new TreeSet<>();
                strings.add(left);
                frontMap.put(right, strings);
            } else {
                frontMap.get(right).add(left);
            }
            if (!backMap.containsKey(right)) {
                backMap.put(right, new TreeSet<>());
            }
            if(!backMap.containsKey(left)){
                TreeSet<String> strings = new TreeSet<>();
                strings.add(right);
                backMap.put(left, strings);
            } else {
                backMap.get(left).add(right);
            }


        }
        T = frontMap.size();
        results = new LinkedList<>();
        topologySort();
        if(results.size()!=T){
            bw.write(-1+"");
        } else {
            for (String result : results) {
                bw.write(result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySort() throws IOException {

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (Map.Entry<String, TreeSet<String>> stringTreeSetEntry : frontMap.entrySet()) {
            if(stringTreeSetEntry.getValue().size()==0){
                pq.offer(stringTreeSetEntry.getKey());
            }
        }

        PriorityQueue<String> nextRoundPQ = new PriorityQueue<>();
        while (pq.size() > 0) {
            String cur = pq.poll();
            results.add(cur);
            TreeSet<String> strings = backMap.get(cur);
            for (String string : strings) {
                frontMap.get(string).remove(cur);
                if(frontMap.get(string).size()==0){
                    nextRoundPQ.offer(string);
                }
            }
            if(pq.size()==0){
                while (nextRoundPQ.size()>0){
                    pq.offer(nextRoundPQ.poll());
                }
            }
        }

    }

}