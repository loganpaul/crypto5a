package Paillier;

import java.math.BigInteger;

public class PaillierPrivateKey extends PaillierKey {
	private BigInteger phi;
	private BigInteger n;
	
	public PaillierPrivateKey() { }
	
	public PaillierPrivateKey(BigInteger phi, BigInteger n) {
		this.phi = phi;
		this.n = n;
	}
	
	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}
	
	
}
