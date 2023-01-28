import java.io.*;
import java.util.*;


public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class TrieNode {
        private TreeMap<String, TrieNode> children;

        public TrieNode() {
            children = new TreeMap<String, TrieNode>();
        }


        public void setChild(String str, TrieNode child) {
            children.put(str, child);
        }

        public TrieNode getChild(String str) {
            return children.get(str);
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String words) {
            TrieNode current = root;

            StringTokenizer st = new StringTokenizer(words);

            int n = Integer.parseInt(st.nextToken());
            for(int i = 0; i < n; i++){
                String next = st.nextToken();
                TrieNode child = current.getChild(next);
                if(child == null){
                    child = new TrieNode();
                    current.setChild(next, child);
                }
                current = child;
            }
        }

    }
        public static void print(TreeMap<String, TrieNode> children, int depth) throws IOException {
            while (children.size()>0){
                Map.Entry<String, TrieNode> stringTrieNodeEntry = children.pollFirstEntry();
                for(int i = 0; i < depth; i++){
                    bw.write("--");
                }
                bw.write(stringTrieNodeEntry.getKey()+"\n");
                if(stringTrieNodeEntry.getValue()!=null){
                    print(stringTrieNodeEntry.getValue().children, depth+1);
                }
            }
        }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            trie.insert(str);
        }

        print(trie.root.children,0);

        bw.write("");
        bw.flush();
        bw.close();
        br.close();

    }

}
