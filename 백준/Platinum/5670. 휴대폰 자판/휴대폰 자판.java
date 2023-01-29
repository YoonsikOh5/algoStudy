import java.io.*;
import java.util.*;


public class Main {


    static class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setChild(char c, TrieNode child) {
            children[c - 'a'] = child;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode current = root;

            int len = str.length();

            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                TrieNode child = current.getChild(c);
                if (child == null) {
                    child = new TrieNode();
                    current.setChild(c, child);
                }
                current = child;
            }
            current.setEnd();
        }

        public long search(String str) {
            TrieNode current = root;
            long num = 1;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (i > 0) {
                    long count = 0;
                    for(int j = 0; j < 26; j++){
                       if(current.children[j]!=null){
                           count++;
                       }
                    }
                    if (count > 1 || current.isEnd) {
                        num++;
                    }
                }
                TrieNode child = current.getChild(c);
                current = child;
            }
            return num;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String input = "";
        while (((input = br.readLine()) != null) && (input.length() > 0)) {
            int N = Integer.parseInt(input);
            Trie trie = new Trie();
            List<String> ls = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String cur = br.readLine();
                ls.add(cur);
                trie.insert(cur);
            }
            long sum = 0;
            for (int i = 0; i < N; i++) {
                String cur = ls.get(i);
                long curnum = trie.search(cur);
//                System.out.println("cur "+ cur+" : "+curnum+"초 ");
                sum += curnum;
            }
            double div = (double) sum / N;
            bw.write(String.format("%.2f",div)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
