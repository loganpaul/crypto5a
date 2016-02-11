package persons;

import java.math.BigInteger;
import java.util.List;

import Paillier.*;
import RSA.RSA;
import RSA.RSAPublicKey;

public class Bob {
	
	public PaillierPublicKey publicKey;
	private PaillierPrivateKey privateKey;
	private BigInteger choice;
	private Paillier cryptosystem;
	//public RSAPublicKey publicKey;
	public List<BigInteger> cryptedAnswers;
	//private BigInteger rand;
	
	public Bob(BigInteger choice, BigInteger p, BigInteger q) {
		this.choice = choice;
		cryptosystem = new Paillier();
		List<PaillierKey> keys = cryptosystem.generateKeys(p, q);
		privateKey = (PaillierPrivateKey) keys.get(1);
		publicKey = (PaillierPublicKey) keys.get(0);
	}
	
	public BigInteger choiceEncryption() {
		return cryptosystem.Encrypt(publicKey, choice);
	}
	
	public BigInteger DecrypteAnswer(List<BigInteger> maskedAnswersList) {
		BigInteger cryptedAnswer = maskedAnswersList.get(choice.intValueExact());
		return cryptosystem.Decrypt(privateKey, cryptedAnswer);
	}
	
	/*public Bob(int choice, RSAPublicKey publicKey, List<BigInteger> cryptedAnswers) {
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
	*/
}
