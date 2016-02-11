package utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Paillier {
	
	public List<PaillierKey> generateKeys(BigInteger p, BigInteger q) {
		
		BigInteger n = p.multiply(q);
		p = p.subtract(new BigInteger("1"));
		q = q.subtract(new BigInteger("1"));
		BigInteger phi = p.multiply(q);
		
		PaillierPublicKey publicKey = new PaillierPublicKey(n);
		PaillierPrivateKey privateKey = new PaillierPrivateKey(phi);
		List<PaillierKey> keys = new ArrayList<PaillierKey>();
		keys.add(publicKey);
		keys.add(privateKey);
		
		return keys;
		
	}
	
	public BigInteger Encrypt(RSAPublicKey publicKey, BigInteger clearMessage) {
		return null;
	}
	
	public BigInteger Decrypt(RSAPrivateKey privateKey, BigInteger cryptedMessage) {
		return null;
	}
}
