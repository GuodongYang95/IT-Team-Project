package test;

import static org.junit.Assert.*;

import org.junit.Before;

import commandline.*;

import org.junit.Test;

public class Model_WinOrOutTest {
	Model_PlayerManager mpm;
	Model_RoundManager mr;
	Model_GameManager mg;
	Model_Card mc;
	Model_CardPile mcp;
	String fileName;
	
	
	@Before
	public void setup() {
		mpm = new Model_PlayerManager(2);
		mr = new Model_RoundManager();
		mg = new Model_GameManager();
		mc = new Model_Card();
		mcp = new Model_CardPile();
	}
	
	@Test
	public void testUserOut() {
		
		for (int i = 0; i < mpm.getPlayers()[0].getCardPile().size(); i++) {
			mpm.getPlayers()[0].getCardPile().remove(i);
		}
		System.out.println("You have " + mpm.getPlayers()[0].getCardPile().size()
							+ " card in your card pile. You Out!");
		mr.winOrOut(mpm, mg);
		assertTrue(mr.userOut(mpm));
	}
	
	
	@Test
	public void testWin() {
		for (int i = 0; i < mcp.getCards().size(); i++) {
			Model_Card card = mcp.getCards().get(i);
			mpm.getPlayers()[0].getCardPile().add(card);
//			System.out.println(mpm.getPlayers()[0].getCardPile().get(i));
//			System.out.println("-----------------");
		}
		System.out.println("You have " + mpm.getPlayers()[0].getCardPile().size()
							+ " cards in your card pile. You Win!");
		
		assertTrue(mr.winOrOut(mpm, mg));
	}

}
