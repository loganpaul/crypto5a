package utils;

import java.math.BigInteger;

public class PaillierPublicKey extends PaillierKey {
	private BigInteger n;
	
	public PaillierPublicKey() { }
	
	public PaillierPublicKey(BigInteger n) {
		this.n = n;
	}
	
	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}
	
}
