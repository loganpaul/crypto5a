package utils;

import java.math.BigInteger;

public class RSAPrivateKey extends RSAKey {
	
	private BigInteger u;
	
	
	public RSAPrivateKey() {}
	
	public RSAPrivateKey(BigInteger u, BigInteger n) {
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
