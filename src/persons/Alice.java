package persons;

import java.util.ArrayList;
import java.util.List;

import utils.Crypto;
import utils.Key;
import utils.PrivateKey;
import utils.PublicKey;

public class Alice {
	
	//public questions
	public final String Q1 = "How many ?";
	public final String Q3 = "How long ?";
	public final String Q2 = "How ??";
	public final String Q4 = "How many ?!";
	public final String Q5 = "How many ???";
	public final String Q6 = "Why ?";
	public final String Q7 = "How long ?!";
	public final String Q8 = "How long ???";
	public final String Q9 = "?";
	public final String Q10 = "Joker ?";
	public final List<String> questionsList = new ArrayList<String>();
	
	//private answers
	private final int A1 = 5;
	private final int A2 = 89;
	private final int A3 = 50;
	private final int A4 = 0;
	private final int A5 = -5;
	private final int A6 = 42;
	private final int A7 = 1000;
	private final int A8 = 777;
	private final int A9 = 123;
	private final int A10 = -23;
	private final List<Integer> answersList = new ArrayList<Integer>();
	public List<Integer> cryptedAnswersList;
	
	public PublicKey publicKey;
	private PrivateKey privateKey;
	private Crypto crypto;
	
	private int p;
	private int q;
	
	public Alice(int p, int q) {
		init(p,q);
		List<Key> keys = crypto.generateKeys(p, q);
		publicKey = (PublicKey) keys.get(0);
		privateKey = (PrivateKey) keys.get(1);
		
		cryptedAnswersList = new ArrayList<Integer>();
		
		for(int i = 0; i < answersList.size(); i++) {
			cryptedAnswersList.add( crypto.Encrypt(publicKey, answersList.get(i)) );
		}
	}
	
	public Integer generateB(Integer Z) {
		Integer B = crypto.Decrypt(privateKey, Z);
		return B;
	}
	
	public void init(int p, int q) {
		crypto = new Crypto();
		this.p = p;
		this.q = q;
		
		questionsList.add(Q1);
		questionsList.add(Q2);
		questionsList.add(Q3);
		questionsList.add(Q4);
		questionsList.add(Q5);
		questionsList.add(Q6);
		questionsList.add(Q7);
		questionsList.add(Q8);
		questionsList.add(Q9);
		questionsList.add(Q10);
		
		answersList.add(A1);
		answersList.add(A2);
		answersList.add(A3);
		answersList.add(A4);
		answersList.add(A5);
		answersList.add(A6);
		answersList.add(A7);
		answersList.add(A8);
		answersList.add(A9);
		answersList.add(A10);
	}
}