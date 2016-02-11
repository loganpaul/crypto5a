package utils;

import java.math.BigInteger;

public class PaillierPrivateKey extends PaillierKey {
	private BigInteger phi;
	
	public PaillierPrivateKey() { }
	
	public PaillierPrivateKey(BigInteger phi) {
		this.phi = phi;
	}
	
	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}
	
	
}
