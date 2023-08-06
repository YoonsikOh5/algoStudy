import java.io.*;
import java.util.*;

public class Main {

    static class Album {
        // 상위 앨범
        Album upStream;
        // 최상위 앨범 판단용(없어도 됨), 최상위 앨범 isRoot = true
        boolean isRoot;

        int childAlbumCnt;
        int photoCnt;

        String albumName;

        public Album(String albumName) {
            this.albumName = albumName;
        }

        public void setUpStream(Album upStream) {
            this.upStream = upStream;
        }

        // 하위 앨범 사전순
        TreeMap<String, Album> childAlbums = new TreeMap<String, Album>();

        // 사진 사전순
        TreeSet<String> photos = new TreeSet<String>();

        void increaseAlbumCnt(int num) {
            childAlbumCnt += num;
            if (upStream != this) {
                upStream.increaseAlbumCnt(num);
            }
        }

        void increasePhotoCnt(int num) {
            photoCnt += num;
            if (upStream != this) {
                upStream.increasePhotoCnt(num);
            }
        }

        void decreaseAlbumCnt(int num) {
            childAlbumCnt -= num;
            if (upStream != this) {
                upStream.decreaseAlbumCnt(num);
            }
        }

        void decreasePhotoCnt(int num) {
            photoCnt -= num;
            if (upStream != this) {
                upStream.decreasePhotoCnt(num);
            }
        }

        boolean mkalb(String albumName) {
            if (!childAlbums.containsKey(albumName)) {
                Album album = new Album(albumName);
                album.setUpStream(this);
                childAlbums.put(albumName, album);
                increaseAlbumCnt(1);
                return true;
            } else {
                return false;
            }
        }

        boolean insert(String photoName) {
            if (!photos.contains(photoName)) {
                photos.add(photoName);
                increasePhotoCnt(1);
                return true;
            } else {
                return false;
            }
        }

        public Album moveToChild(String param) {
            if(childAlbums.containsKey(param)){
                return childAlbums.get(param);
            } else{
                return this;
            }
        }

        public String rmalbTop() {
            if(childAlbums.size()>0){
                Map.Entry<String, Album> stringAlbumEntry = childAlbums.pollFirstEntry();
                Album topAlbum = stringAlbumEntry.getValue();
                int childAlbumCnt1 = topAlbum.childAlbumCnt + 1;
                int photoCnt1 = topAlbum.photoCnt;
                decreaseAlbumCnt(childAlbumCnt1);
                decreasePhotoCnt(photoCnt1);
                return childAlbumCnt1+" "+photoCnt1;
            } else {
                return "0 0";
            }
        }

        public String rmalbBottom() {
            if(childAlbums.size()>0){
                Map.Entry<String, Album> stringAlbumEntry = childAlbums.pollLastEntry();
                Album bottomAlbum = stringAlbumEntry.getValue();
                int childAlbumCnt1 = bottomAlbum.childAlbumCnt + 1;
                int photoCnt1 = bottomAlbum.photoCnt;
                decreaseAlbumCnt(childAlbumCnt1);
                decreasePhotoCnt(photoCnt1);
                return childAlbumCnt1+" "+photoCnt1;
            } else {
                return "0 0";
            }
        }

        public String rmalbAll() {
            int resultChildAlbumCnt = childAlbums.size();
            int resultPhotoCnt = 0;

            while (childAlbums.size()>0){
                Map.Entry<String, Album> stringAlbumEntry = childAlbums.pollFirstEntry();
                Album pollAlbum = stringAlbumEntry.getValue();
                int childAlbumCnt1 = pollAlbum.childAlbumCnt;
                int photoCnt1 = pollAlbum.photoCnt;
                resultChildAlbumCnt += childAlbumCnt1;
                resultPhotoCnt += photoCnt1;
            }
            decreaseAlbumCnt(resultChildAlbumCnt);
            decreasePhotoCnt(resultPhotoCnt);

            return resultChildAlbumCnt+" "+resultPhotoCnt;
        }

        public String rmalb(String param) {
            if(childAlbums.containsKey(param)){
                Album removed = childAlbums.remove(param);
                int childAlbumCnt1 = removed.childAlbumCnt + 1;
                int photoCnt1 = removed.photoCnt;
                decreaseAlbumCnt(childAlbumCnt1);
                decreasePhotoCnt(photoCnt1);
                return childAlbumCnt1+" "+photoCnt1;
            } else {
                return "0 0";
            }
        }

        public int deleteTop() {
            if(photos.size()>0){
                String s = photos.pollFirst();
                decreasePhotoCnt(1);
                return 1;
            } else {
                return 0;
            }
        }

        public int deleteBottom() {
            if(photos.size()>0){
                String s = photos.pollLast();
                decreasePhotoCnt(1);
                return 1;
            } else {
                return 0;
            }
        }

        public int deleteAll() {
            int size = photos.size();
            decreasePhotoCnt(size);
            photos.clear();
            return size;
        }

        public int delete(String param) {
            if(photos.contains(param)){
                photos.remove(param);
                decreasePhotoCnt(1);
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Album album = new Album("album");
        album.setUpStream(album);
        Album cur = album;
        cur.isRoot = true;

        for (int i = 1; i <= N; i++) {
            String query = br.readLine();

            StringTokenizer st = new StringTokenizer(query);

            String cmd = st.nextToken();
            String param = st.nextToken();

            if (cmd.equals("mkalb")) {
                boolean albumCreated = cur.mkalb(param);
                if (!albumCreated) {
                    bw.write("duplicated album name\n");
                }
            } else if (cmd.equals("rmalb")) {
                String result = "0 0";
                if (param.equals("-1")) {
                    result = cur.rmalbTop();
                } else if (param.equals("0")) {
                    result = cur.rmalbAll();
                } else if (param.equals("1")) {
                    result = cur.rmalbBottom();
                } else {
                    result = cur.rmalb(param);
                }
                bw.write(result+"\n");
            } else if (cmd.equals("insert")) {
                boolean photoInserted = cur.insert(param);
                if (!photoInserted) {
                    bw.write("duplicated photo name\n");
                }
            } else if (cmd.equals("delete")) {
                int result = 0;
                if (param.equals("-1")) {
                    result = cur.deleteTop();
                } else if (param.equals("0")) {
                    result = cur.deleteAll();
                } else if (param.equals("1")) {
                    result = cur.deleteBottom();
                } else {
                    result = cur.delete(param);
                }
                bw.write(result+"\n");
            } else if (cmd.equals("ca")) {
                if (param.equals("..")) {
                    cur = cur.upStream;
                } else if (param.equals("/")) {
                    cur = album;
                } else {
                    cur = cur.moveToChild(param);
                }
                bw.write(cur.albumName + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }


}