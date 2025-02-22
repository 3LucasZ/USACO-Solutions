package Helpers.PURS;

public class BestSubarraySum {
    private static class SegTree {
        //1-indexed
        //range is []
        int size;

        long[] tree;
        long[] pref;
        long[] suf;
        long[] seg;

        public SegTree(int n){
            init(n);
        }
        public SegTree(int n, int[] arr){
            init(n);
            for (int i=1;i<=n;i++){
                tree[i+size-1]=arr[i];
                pref[i+size-1]=Math.max(0,arr[i]);
                suf[i+size-1]=Math.max(0,arr[i]);
                seg[i+size-1]=Math.max(0,arr[i]);
            }
            for (int i=size-1;i>=1;i--){
                tree[i]=tree[i*2]+tree[i*2+1];
                pref[i]=Math.max(pref[i*2],tree[i*2]+pref[i*2+1]);
                suf[i]=Math.max(suf[i*2+1],tree[i*2+1]+suf[i*2]);
                seg[i]=Math.max(suf[i*2]+pref[i*2+1],Math.max(seg[i*2],seg[i*2+1]));
            }
        }
        public void init(int n){
            size = 1;
            while (size < n) size *= 2;
            tree = new long[2*size+1];
            pref = new long[2*size+1];
            suf = new long[2*size+1];
            seg = new long[2*size+1];
        }
        void add (int i, int x){
            set(i,tree[i+size-1]+x);
        }
        void set(int i, long x){
            i+=size-1;
            tree[i]=x;
            pref[i]=Math.max(0,x);
            suf[i]=Math.max(0,x);
            seg[i]=Math.max(0,x);
            for (i/=2;i>=1;i/=2){
                tree[i]=tree[i*2]+tree[i*2+1];
                pref[i]=Math.max(pref[i*2],tree[i*2]+pref[i*2+1]);
                suf[i]=Math.max(suf[i*2+1],tree[i*2+1]+suf[i*2]);
                seg[i]=Math.max(suf[i*2]+pref[i*2+1],Math.max(seg[i*2],seg[i*2+1]));
            }
        }
        long bestSubarraySum(int a, int b) {
            a+=size-1;
            b+=size-1;
            long ret = 0;
            while (a<=b){
                if (a%2==1) ret=Math.max(seg[a++],ret);
                if (b%2==0) ret=Math.max(seg[b--],ret);
                a/=2;
                b/=2;
            }
            return ret;
        }
    }
}