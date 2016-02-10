package utils;

import java.math.BigInteger;

public class PrivateKey extends Key {
	
	private BigInteger u;
	
	
	public PrivateKey() {}
	
	public PrivateKey(BigInteger u, BigInteger n) {
		this.u = u;
		this.n = n;
	}
	
	
	public BigInteger getU() {
		return u;
	}
	public void setU(BigInteger u) {
		this.u = u;
	}
	public BigInteger getN() {
		return n;
	}
	public void setN(BigInteger n) {
		this.n = n;
	}
}
