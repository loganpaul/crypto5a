package utils;

import java.util.ArrayList;
import java.util.List;

public class Crypto {
	
	private int generatePrime(int m) {
		int c = 1;
		// on veut c tel que pgcd(c,m) = 1 et c > 1
		return c;
	}
	
	private int generateU(int m, int c) {
		int u = 1;
		// voir https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/comment-cree-t-on-nos-cles
		return u;
	}
	
	public List<Key> generateKeys(int p, int q) {
		int n = p * q;
		int m = (p-1) * (q-1);
		int c = generatePrime(m);
		int u = generateU(m,c);
		
		Key publicKey = new PublicKey(n,c);
		Key privateKey = new PrivateKey(u,n);
		List l = new ArrayList<Key>();
		
		l.add(publicKey);
		l.add(privateKey);
		
		return l;
	}
	
	public Integer Encrypt(PublicKey publicKey, Integer clearMessage) {
		// voir https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/et-le-chiffrage-comme-ca-se-passe
		return 0;
	}
	
	public Integer Decrypt(PrivateKey privateKey, Integer cryptedMessage) {
		// voir https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/le-dechiffrage
		return 0;
	}
}
