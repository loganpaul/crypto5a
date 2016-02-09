package persons;

import java.util.List;

import utils.Crypto;
import utils.PublicKey;

public class Bob {
	
	public int choice;
	public PublicKey publicKey;
	public List<Integer> cryptedAnswers;
	private int randZn;
	
	public Bob(int choice, PublicKey publicKey, List<Integer> cryptedAnswers) {
		this.choice = choice;
		this.publicKey = publicKey;
		this.cryptedAnswers = cryptedAnswers;
	}
	
	public Integer generateZ() {
		//nombre aléatoire dans Zn
		randZn = (int) Math.round(Math.random() * (publicKey.getN() + 1));
		Crypto crypto = new Crypto();
		Integer Z = crypto.Encrypt(publicKey, randZn);
		Z *= cryptedAnswers.get(choice);
		return Z;
	}
	
	public Integer readClearAnswer(Integer B) {
		Integer clearAnswer = B - randZn;
		return clearAnswer;
	}
}
