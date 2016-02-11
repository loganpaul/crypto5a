package utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSA {

	private BigInteger generatePrime(BigInteger m) {
		// on veut c tel que pgcd(c,m) = 1 et c > 1
		BigInteger c;
		do {
			c = new BigInteger( "" + Math.round(Math.random() * 100 + 3) );
		} while (!c.gcd(m).equals(new BigInteger("1")));
		return c;
	}

	private BigInteger generateU(BigInteger m, BigInteger c) {
		// https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/comment-cree-t-on-nos-cles
		BigInteger u;
		BigInteger[] tmp = extGcd(m, c);
		u = tmp[2];
		return u;
	}

	public List<RSAKey> generateKeys(BigInteger p, BigInteger q) {
		BigInteger n = p.multiply(q);
		System.out.println("N : " + n);
		BigInteger m = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		System.out.println("M : " + m);
		BigInteger c = generatePrime(m);
		System.out.println("C : " + c);
		BigInteger u = generateU(m, c);
		System.out.println("U : " + u);

		RSAKey publicKey = new RSAPublicKey(n, c);
		RSAKey privateKey = new RSAPrivateKey(u, n);
		List<RSAKey> keys = new ArrayList<RSAKey>();

		keys.add(publicKey);
		keys.add(privateKey);

		return keys;
	}

	public BigInteger Encrypt(RSAPublicKey publicKey, BigInteger clearMessage) {
		// voir
		// https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/et-le-chiffrage-comme-ca-se-passe
		BigInteger cryptedMessage = clearMessage.modPow(publicKey.getC(), publicKey.getN());
		return cryptedMessage;
	}

	public BigInteger Decrypt(RSAPrivateKey privateKey, BigInteger cryptedMessage) {
		// voir
		// https://openclassrooms.com/courses/la-cryptographie-asymetrique-rsa/le-dechiffrage
		BigInteger decryptedMessage = cryptedMessage.modPow(privateKey.getU(), privateKey.getN());
		return decryptedMessage;
	}

	
	 /**
     * Computes the GCD and the coefficients of the Bezout equality.
     * @param m the first BigInteger
     * @param n the second BigInteger 
     * @return an array g of 3 BigIntegers.  g[0] is the GCD of m and n.
     *  g[1] and g[2] are two BigIntegers such that g[0] = m g[1] + n g[2].
     */
	public BigInteger[] extGcd(BigInteger m, BigInteger n) {
		// Both arrays ma and na are arrays of 3 integers such that
		// ma[0] = m ma[1] + n ma[2] and na[0] = m na[1] + n na[2]
		BigInteger[] ma = new BigInteger[] { m, new BigInteger("1"), new BigInteger("0") };
		BigInteger[] na = new BigInteger[] { n, new BigInteger("0"), new BigInteger("1") };
		int i; // Loop index
		BigInteger q; // Quotient
		BigInteger r; // Rest

		// Exchange ma and na if m < n
		if (m.compareTo(n) == -1) {
			BigInteger[] ta; // Temporary variable
			ta = na;
			na = ma;
			ma = ta;
		}

		// It can be assumed that m >= n
		while (na[0].compareTo(new BigInteger("0")) == 1) {
			q = ma[0].divide(na[0]); // Quotient
			for (i = 0; i < 3; i++) {
				r = ma[i].subtract( q.multiply(na[i]) );
				ma[i] = na[i];
				na[i] = r;
			}
		}
		return ma;
	}
}
