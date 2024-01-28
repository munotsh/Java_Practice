package com.example.companies.loblaw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DeckOfCards {

	String[] deck = new String[52];
	String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
	String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	int currentCard;

	public DeckOfCards() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = ranks[i % 13] + suits[i / 13];
		}
	}

	public String deal() {
		if (currentCard < 52) {
			return deck[currentCard++];
		}
		System.out.println("out of cards");
		return null;
	}

	public void dealToAllPlayers(Queue<String> players) {
		while (currentCard < 52) {
			String playerName = players.poll();
			System.out.println(playerName+" : "+deck[currentCard++]);
			players.add(playerName);
		}
	}

	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * deck.length);
			String temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}

	}

	public void printDeck() {
		Arrays.stream(deck).forEach(System.out::println);
	}

	public static void main(String[] args) {
		DeckOfCards deckOfCards = new DeckOfCards();
		deckOfCards.printDeck();
		System.out.println("shuffle cards");
		deckOfCards.shuffle();
		deckOfCards.printDeck();
//		System.out.println("Deal cards");
//		System.out.println(deckOfCards.deal());
		Queue<String> players  = new ArrayDeque<>();
		for(int i=1;i<=4;i++){
		players.add("Player"+i);
		}
		deckOfCards.dealToAllPlayers(players);


	}
}
