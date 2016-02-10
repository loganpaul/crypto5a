package utils;

import java.math.BigInteger;

public class PublicKey extends Key {
	
	private BigInteger c;
	
	
	public PublicKey() {}
	
	public PublicKey(BigInteger n, BigInteger c) {
		this.c = c;
		this.n = n;
	}
	
	
	
	public BigInteger getC() {
		return c;
	}
	public void setC(BigInteger c) {
		this.c = c;
	}
	public BigInteger getN() {
		return n;
	}
	public void setN(BigInteger n) {
		this.n = n;
	}
}
