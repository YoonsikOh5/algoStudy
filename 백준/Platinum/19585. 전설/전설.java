import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static HashSet<String> nickSet;
    static int qlen;

    static class TrieNode {
        TrieNode[] children;

        private boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            isEnd = false;
        }

        public void setChildren(char c, TrieNode child) {
            children[c - 'a'] = child;
        }

        public TrieNode getChildren(char c) {
            return children[c - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }


    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode current = root;
            int len = str.length();
            for (int i = 0; i < len; i++) {
                TrieNode children = current.getChildren(str.charAt(i));
                if (children == null) {
                    TrieNode child = new TrieNode();
                    current.setChildren(str.charAt(i), child);
                    current = child;
                } else {
                    current = children;
                }
            }
            current.setEnd();
        }

        public boolean findColor(String query) {
            arr = new int[4001];
            int count = 0;
            TrieNode current = root;
            int len = query.length();
            for (int i = 0; i < len; i++) {
                TrieNode children = current.getChildren(query.charAt(i));
                if (children == null) {
                    break;
                } else {
                    if (children.isEnd) {
                        String nick = query.substring(i+1, query.length());
                        if(nickSet.contains(nick)){
                            return true;
                        }
                    }
                    current = children;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Trie cTrie = new Trie();

        nickSet = new HashSet<String>();

        for (int c = 1; c <= C; c++) {
            String color = br.readLine();
            cTrie.insert(color);
        }

        for (int n = 1; n <= N; n++) {
            String nickname = br.readLine();
            nickSet.add(nickname);
        }

        int Q = Integer.parseInt(br.readLine());


        for (int q = 1; q <= Q; q++) {
            String query = br.readLine();
            qlen = query.length();
            boolean isYes = cTrie.findColor(query);
            if (isYes) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


}