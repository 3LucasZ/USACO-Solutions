import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OKEA {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            solve();
        }
        out.close();
    }
    public static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K>1 && N%2==1) out.println("NO");
        else {
            out.println("YES");
            for (int r=0;r<N;r++){
                for (int c=0;c<K;c++){
                    if (r%2==0){
                        out.print((r)*K+1+2*c+" ");
                    }
                    else {
                        out.print((r-1)*K+2+2*c+" ");
                    }
                }
                out.println();
            }
        }
    }
}
