package Gold.UsacoGuideGold.StringHashing;

public class StringHashing1 {
    public static void main(String[] args){
        String str1 = "Math";
        String str2 = "Computer Science";
        String str3 = "Mathway";
        String str4 = "moo";
        System.out.println(getHash(str1));
        System.out.println(getHash(str2));
        System.out.println(getHash(str3));
        System.out.println(getHash(str4));
    }
    public static long getHash(String str){
        long A = (long) (1e9+7);
        long B = (long) (1e9+9);
        long[] pow = new long[str.length()];
        pow[0]=1;
        for (int i=1;i<str.length();i++){
            pow[i]=(pow[i-1]*A)%B;
        }
        long hash = 0;
        for (int i=0;i<str.length();i++){
            hash = (hash + pow[str.length()-i-1]*str.charAt(i))%B;
        }
        return hash;
    }
}
