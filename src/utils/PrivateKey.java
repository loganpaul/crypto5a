package utils;

public class PrivateKey extends Key {
	
	private int u;
	
	
	public PrivateKey() {}
	
	public PrivateKey(int u, int n) {
		this.u = u;
		this.n = n;
	}
	
	
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
}
