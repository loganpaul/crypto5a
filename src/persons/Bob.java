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
	public List<BigInteger> cryptedAnswers;
	
	public Bob(BigInteger choice, BigInteger p, BigInteger q) {
		this.choice = choice;
		cryptosystem = new Paillier();
		List<PaillierKey> keys = cryptosystem.generateKeys(p, q);
		privateKey = (PaillierPrivateKey) keys.get(1);
		publicKey = (PaillierPublicKey) keys.get(0);
		System.out.println("Private Key (phi) : " + this.privateKey.getPhi());
	}
	
	public BigInteger choiceEncryption() {
		return cryptosystem.Encrypt(publicKey, choice);
	}
	
	public BigInteger DecrypteAnswer(List<BigInteger> maskedAnswersList) {
		BigInteger cryptedAnswer = maskedAnswersList.get(choice.intValueExact());
		System.out.println("Crypted Answer : " + cryptedAnswer);
		return cryptosystem.Decrypt(privateKey, cryptedAnswer);
	}
}
