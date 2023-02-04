import java.io.*;
import java.util.*;

public class TheForbiddenPerm {
    static boolean debug = false;
    
    public static void solve(int tcs) throws IOException {
        if (debug) io.println("Case: "+tcs);
        //* parse
        int N = io.nextInt();
        int M = io.nextInt();
        int D = io.nextInt();
        int[] p = new int[N];
        for (int i=0;i<N;i++) p[i]=io.nextInt();
        int[] a = new int[M];
        for (int i=0;i<M;i++) a[i]=io.nextInt();

        //* get pos
        int[] pos = new int[N+1];
        for (int i=0;i<N;i++){
            pos[p[i]]=i;
        }
        if (debug){
            io.println("p:"+Arrays.toString(p));
            io.println("a:"+Arrays.toString(a));
            io.println("pos:"+Arrays.toString(pos));
        }

        //* greed
        int ans = Integer.MAX_VALUE;
        for (int i=1;i<M;i++){
            ans=Math.min(Math.max(0,pos[a[i]]-pos[a[i-1]]),ans);
            if (D+1<N)ans=Math.min(Math.max(0,pos[a[i-1]]+D+1-pos[a[i]]),ans);
        }

        //* ret
        io.println(ans);
    }




















    static IO io;
    public static void main(String[] args) throws IOException {
        io = new IO(debug);
        int T = io.nextInt();
        for (int i=1;i<=T;i++) solve(i);
        io.close();
    }
    private static class IO {
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    boolean debug;
    public IO(boolean dbg)  {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        debug=dbg;
    }
    public IO(String fileName, boolean dbg) throws IOException {
        br = new BufferedReader(new FileReader(fileName+".in"));
        out = new PrintWriter(new FileWriter(fileName+".out"));
        debug=dbg;
    }
    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() {return Double.parseDouble(next());}
    String nextLine() {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    void println(){
        if (debug) System.out.println();
        else out.println();
    }
    void println(Object obj){
        if (debug) System.out.println(obj);
        else out.println(obj);
    }
    void print(Object obj){
        if (debug) System.out.print(obj);
        else out.print(obj);
    }
    public static void print(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                String str = "" + arr[r][c];
                while (str.length() < 5) str += " ";
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println();
    }
    void close(){
        out.close();
    }
};}