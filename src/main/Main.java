package main;

import java.math.BigInteger;
import java.util.List;

import persons.Alice;
import persons.Bob;

public class Main {

	public static void main(String[] args) {
		BigInteger p = new BigInteger("1000381"); //1000381
		BigInteger q = new BigInteger("1999513"); //1999513
		BigInteger bobsChoice = new BigInteger("7");
		System.out.println("Bob's choice : " + bobsChoice);
		
		Bob bob = new Bob(bobsChoice,p,q);
		System.out.println("Public key (N) : " + bob.publicKey.getN());
		
		BigInteger cryptedBobsChoice = bob.choiceEncryption();
		System.out.println("Bob's choice crypted : " + cryptedBobsChoice);
		
		Alice alice = new Alice(bob.publicKey,cryptedBobsChoice);
		
		List<BigInteger> maskedAnswersList = alice.maskAnswers();
		BigInteger clearAnswer = bob.DecrypteAnswer(maskedAnswersList);
		System.out.println("Clear Answer : " + clearAnswer + " (check the list in the Alice's class to verify)");
	}

}
