package main;

import java.math.BigInteger;
import java.util.List;

import persons.Alice;
import persons.Bob;

public class Main {

	public static void main(String[] args) {
		BigInteger p = new BigInteger("53"); //53
		BigInteger q = new BigInteger("97"); //97
		BigInteger bobsChoice = new BigInteger("6");
		
		Bob bob = new Bob(bobsChoice,p,q);
		BigInteger cryptedBobsChoice = bob.choiceEncryption();
		Alice alice = new Alice(bob.publicKey,cryptedBobsChoice);
		List<BigInteger> maskedAnswersList = alice.maskAnswers();
		BigInteger clearAnswer = bob.DecrypteAnswer(maskedAnswersList);
		
		System.out.println(clearAnswer);
		
		/*System.out.println("P : " + p);
		System.out.println("Q : " + q);
		
		Alice alice = new Alice(p,q);
		Bob bob = new Bob(bobsChoice, alice.publicKey, alice.cryptedAnswersList);

		BigInteger Z = bob.generateZ();
		System.out.println("Z : " + Z);
		
		BigInteger B = alice.generateB(Z);
		System.out.println("B : " + B);
		
		BigInteger clearAnswer = bob.readClearAnswer(B);
		System.out.println("Clear Answer : " + clearAnswer);
		clearAnswer = clearAnswer.mod(p.multiply(q));
		System.out.println("Clear Answer mod N : " + clearAnswer);*/
	}

}
