public class Generator{


	public static void main(String[] args){
		long l = randLong(LL1,LL2);
		long r = randLong(LL1,l);
		int q = 10000;
		System.out.println(l+" "+r+" "+q);
		for (int i=0;i<q;i++){
			char node = randChar();
			String str = randStr(randInt(3,10));
			System.out.println(node+" "+str);
		}
	}


	static long pow10(int i){
		return (int)Math.pow(10,i);
	}
	static long randLong(long l, long r){
		return (long)(l+Math.random()*(r-l+1));
	}
	static int randInt(int l, int r){
		return (int)(l+Math.random()*(r-l+1));
	}
	static char randChar(){
		return (char)('a'+Math.random()*26);
	}
	static String randStr(int len){
		StringBuilder ret = new StringBuilder();
		for (int i=0;i<len;i++){
			ret.append(randChar());
		}
		return ret.toString();
	}
	static final int I1 =(int)(1e9);
	static final int I2 =(int)(2e9);
	static final long LL1 = (long)(1e18);
	static final long LL2 = (long)(2e18);
}
