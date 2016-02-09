package utils;

public class PublicKey extends Key {
	
	private int c;
	
	
	public PublicKey() {}
	
	public PublicKey(int n, int c) {
		this.c = c;
		this.n = n;
	}
	
	
	
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
}
