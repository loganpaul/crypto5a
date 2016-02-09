package main;

import persons.Alice;
import persons.Bob;

public class Main {

	public static void main(String[] args) {
		int p = 5;
		int q = 7;
		int bobsChoice = 6;
		
		Alice alice = new Alice(p,q);
		Bob bob = new Bob(bobsChoice, alice.publicKey, alice.cryptedAnswersList);

		Integer Z = bob.generateZ();
		System.out.println(Z);
		
		Integer B = alice.generateB(Z);
		System.out.println(B);
		
		Integer clearAnswer = bob.readClearAnswer(B);
		System.out.println(clearAnswer);
	}

}
