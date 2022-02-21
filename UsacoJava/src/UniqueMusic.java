import java.io.*;
import java.util.*;

public class UniqueMusic {
    //io
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static boolean debug = false;
    //param
    static int N;
    static int M;
    static int K;

    static int[] syllable;
    static int[] rhyme;
    static Multiset pattern;
    //dp
    static long[] dpSyllable;
    static long[] dpRhyme;
    //helper
    static final long MOD = (long)1e9+7;
    public static void main(String[] args) throws IOException {
        //parse input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        syllable = new int[N];
        rhyme = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            syllable[i] = Integer.parseInt(st.nextToken());
            rhyme[i] = Integer.parseInt(st.nextToken());
        }
        pattern = new Multiset();
        for (int i=0;i<M;i++){
            pattern.add(br.readLine().charAt(0));
        }
        //logic
        //dpsyllable
        dpSyllable = new long[K+1];
        dpSyllable[0]=1;
        for (int i=0;i<=K;i++){
            for (int j=0;j< syllable.length;j++){
                int search = i+syllable[j];
                if (search <= K) dpSyllable[search]=(dpSyllable[search]+dpSyllable[i])%MOD;
            }
        }
        if (debug) System.out.println(Arrays.toString(dpSyllable));
        if (debug)System.out.println(pattern.ms);
        //dprhyme
        dpRhyme = new long[N+1];
        for (int i=0;i<rhyme.length;i++){
            dpRhyme[rhyme[i]]=(dpRhyme[rhyme[i]]+dpSyllable[K-syllable[i]])%MOD;
        }
        if (debug) System.out.println(Arrays.toString(dpRhyme));

        //get ans
        long[] powerSum = new long[M+1];
        long[] toPower = new long[M+1];
        for (int i=1;i<=N;i++){
            toPower[0]=1;
            for (int p=1;p<=M;p++){
                toPower[p]=(toPower[p-1]*dpRhyme[i])%MOD;
                powerSum[p]=(powerSum[p]+toPower[p])%MOD;
            }
        }
        //if (debug) for (int i=System.out.println(Arrays.toString(toPower));
        if (debug) System.out.println(Arrays.toString(powerSum));

        long ans = 1;
        //turn in answer
        for (Integer val : pattern.ms.values()) {
            ans=(ans*powerSum[val])%MOD;
        }
        out.println(ans);
        out.close();
    }
    private static class Multiset {
        HashMap<Character, Integer> ms = new HashMap<>();
        public void add(Character c){
            if (!ms.containsKey(c)) ms.put(c,0);
            ms.put(c,ms.get(c)+1);
        }
    }
}
