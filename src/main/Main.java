package main;

import java.math.BigInteger;

import persons.Alice;
import persons.Bob;

public class Main {

	public static void main(String[] args) {
		BigInteger p = new BigInteger("5"); //53
		BigInteger q = new BigInteger("7"); //97
		int bobsChoice = 6;
		System.out.println("P : " + p);
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
		System.out.println("Clear Answer mod N : " + clearAnswer);
	}

}
