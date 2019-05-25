package klondike.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klondike.models.builders.CardBuilder;
import klondike.models.builders.EmptyStockBuilder;

public class StockTest {

	protected Stock createStock() {
		return new EmptyStockBuilder().build();
	}
	
	private static final int NUMBER_CARDS = Number.values().length * Suit.values().length;
	
	@Test
	public void testStock() {
		Stock stock = new Stock();
		List<Card> cards = stock.pop(StockTest.NUMBER_CARDS);
		this.assertDifferentCards(cards);
		this.assertNumberTimes(cards);
		this.assertSuitTimes(cards);
		
	}

	private void assertDifferentCards(List<Card> cards) {
		for(int i=0; i<cards.size(); i++) {
			Card card = cards.get(i);
			for(int j=i+1; j<cards.size(); j++) {
				assertNotEquals(card, cards.get(j));
			}
		}
	}

	private void assertSuitTimes(List<Card> cards) {
		int[] suites = new int[Suit.values().length];
		for(Card card : cards) {
			suites[card.getSuit().ordinal()]++;
		}
		for(int cont : suites) {
			assertEquals(Number.values().length, cont);
		}
	}

	private void assertNumberTimes(List<Card> cards) {
		int[] numbers = new int[Number.values().length];
		for(Card card : cards) {
			numbers[card.getNumber().ordinal()]++;
		}
		for(int cont : numbers) {
			assertEquals(Suit.values().length, cont);
		}
	}
	
	@Test
	public void testPopOne(){
		Stock stock = new Stock();
		List<Card> cardList = stock.pop(1);
		assertEquals(1, cardList.size());
	}
	
	@Test
	public void testTakePopAll(){
		Stock stock = new Stock();
		List<Card> cardList = stock.pop(StockTest.NUMBER_CARDS);
		assertEquals(StockTest.NUMBER_CARDS, cardList.size());
		assertTrue(stock.empty());
	}
	
	private List<Card> getCards(){
		List<Card> cards = new ArrayList<Card>();
		cards.add(new CardBuilder().build());
		cards.add(new CardBuilder().build());
		return cards;
	}

	@Test
	public void testEmptyWithEmpty() {
		Stock stock = this.createStock();
		assertTrue(stock.empty());
	}

	@Test
	public void testEmptyWithNotEmpty() {
		Stock stock = this.createStock();
		stock.push(this.getCards().get(0));
		assertFalse(stock.empty());
	}

	@Test
	public void testPushWithEmpty() {
		Stock stock = this.createStock();
		stock.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), stock.peek());
	}

	@Test
	public void testPushWithNotEmpty() {
		Stock stock = this.createStock();
		stock.push(this.getCards().get(0));
		stock.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), stock.peek());
	}

	@Test
	public void testPopEmpty() {
		Stock stock = this.createStock();
		stock.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), stock.pop());
		assertTrue(stock.empty());
	}

	@Test
	public void testPopNotEmpty() {
		Stock stock = this.createStock();
		stock.push(this.getCards().get(0));
		stock.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), stock.pop());
		assertEquals(this.getCards().get(0), stock.peek());
	}

}
