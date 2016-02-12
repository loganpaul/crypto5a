package Paillier;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Paillier {

	private final BigInteger ONE = new BigInteger("1");
	
	public List<PaillierKey> generateKeys(BigInteger p, BigInteger q) {
		
		BigInteger n = p.multiply(q);
		p = p.subtract(ONE);
		q = q.subtract(ONE);
		BigInteger phi = p.multiply(q);
		
		PaillierPublicKey publicKey = new PaillierPublicKey(n);
		PaillierPrivateKey privateKey = new PaillierPrivateKey(phi, n);
		List<PaillierKey> keys = new ArrayList<PaillierKey>();
		keys.add(publicKey);
		keys.add(privateKey);
		
		return keys;
	}
	
	public BigInteger Encrypt(PaillierPublicKey publicKey, BigInteger clearMessage) {
		BigInteger n = publicKey.getN();
		if(clearMessage.compareTo(n) >= 0) {
			return null;
		}

		BigInteger r = new BigInteger( "" + Math.round(Math.random() * 500000) );
		r = r.mod(n.subtract(ONE));
		r = r.add(ONE);

		BigInteger c1 = (n.add(ONE)).modPow(clearMessage, n.pow(2));
		BigInteger c2 = r.modPow(n, n.pow(2));
		BigInteger c = c1.multiply(c2).mod(n.pow(2));
		
		return c;
	}
	
	public BigInteger Decrypt(PaillierPrivateKey privateKey, BigInteger cryptedMessage) {
		
		BigInteger n = privateKey.getN();
		BigInteger r = cryptedMessage.modPow(n.modPow(BigInteger.ONE.negate(), privateKey.getPhi()), n);
        BigInteger clearMessage = ((r.modPow(n, n.pow(2)).modInverse(n.pow(2))).multiply(cryptedMessage).mod(n.pow(2))).subtract(BigInteger.ONE).divide(n);
    
		return clearMessage;
	}
	
}
