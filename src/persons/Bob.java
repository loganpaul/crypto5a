package persons;

import java.math.BigInteger;
import java.util.List;

import utils.RSA;
import utils.PublicKey;

public class Bob {
	
	public int choice;
	public PublicKey publicKey;
	public List<BigInteger> cryptedAnswers;
	private BigInteger rand;
	
	public Bob(int choice, PublicKey publicKey, List<BigInteger> cryptedAnswers) {
		this.choice = choice;
		this.publicKey = publicKey;
		this.cryptedAnswers = cryptedAnswers;
	}
	
	public BigInteger generateZ() {
		System.out.println("Crypted Answer6 : " + cryptedAnswers.get(choice) );
		rand = new BigInteger( "" + Math.round(Math.random() * Integer.MAX_VALUE) ); // publicKey.getN() + 1
		rand = new BigInteger("808710506");
		System.out.println("Rand : " + rand);
		RSA crypto = new RSA();
		BigInteger Z = crypto.Encrypt(publicKey, rand);
		System.out.println("CryptedRand : " + Z);
		Z = Z.multiply(cryptedAnswers.get(choice));
		Z = Z.mod(publicKey.getN());
		return Z;
	}
	
	public BigInteger readClearAnswer(BigInteger B) {
		BigInteger clearAnswer = B.subtract(rand);
		return clearAnswer;
	}
}
