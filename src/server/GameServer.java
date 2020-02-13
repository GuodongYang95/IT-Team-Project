package server;

import commandline.*;

import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
//the Data will be managed at online mode in this class
public class GameServer {
	
	private Model_GameManager gm; 
	private int numberOfAI;
	
	public void createGameManager() {
		this.gm = new Model_GameManager();
		this.numberOfAI = 4;
	}
//	public static void main(String[] args) {
//		GameServer server = new GameServer();
//		server.createGameManager();
//		System.out.println(server.gameStart());
//	}
	
 // when page first load, it will return a json file str.
	public String gameStart() {
		
		createGameManager();
		
		gm.setGame(true);
		
		gm.whenstart(numberOfAI);
		
		//When game start, the card will be distributed to every player
		gm.getPm().cardDistribute(gm.getRm());
		
		//And then user will see which player is active and owned card
		//select the active player first
		gm.getRm().activePlayerSelector(gm.getPm());
		//get the card from playercardPile
		gm.getPm().playersDrawCard();
		
		//then manage the data, convert them into json string
		String gameDataString = "";
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		//tell user is out or not
		String userIsOut = "userIsOut";
		String userisOutValue = String.valueOf(gm.getPm().getPlayers()[0].isOut());
		map.put(userIsOut, userisOutValue);
		
		//put active player in the map
		String activePlayerKey = "activePlayer";
		String activePlayerValue = gm.getRm().getActivePlayer().getName();
		map.put(activePlayerKey, activePlayerValue);
		
		//owendCardDescription:
		String ownedCardNameKey = "ownedCardDescription";
		String ownedCardValue = gm.getPm().getPlayers()[0].getOwnedCard().getDescription();
		map.put(ownedCardNameKey, ownedCardValue);
		
		//ownedCardCategory
		String ownedCardCategoryKey = "ownedCardCategory";
		String ownedCardCategoryvalue = JSON.toJSONString(gm.getPm().getPlayers()[0].getOwnedCard().getCategores());
		map.put(ownedCardCategoryKey, ownedCardCategoryvalue);
		
		//userCardPileSize
		String userCardPaileSizeKey = "userCardPileSize";
		String userCardPaileValue = ""+ gm.getPm().getPlayers()[0].getCardPile().size();
		map.put(userCardPaileSizeKey, userCardPaileValue);
		
		// round count
		String roundKey = "Rountcount";
		String roundValue = "" +gm.getRm().getRoundCount();
		map.put(roundKey, roundValue);
		
		gameDataString = JSON.toJSONString(map);
		
		
		return gameDataString;
	}
	
	//The Json File might follow this:
	/*
	 {	
	 	"userIsOut":"false",
	 	"activePlayer":"playerName",
	 	"ownedCardDescription":"ownedcardname",
	 	"ownedCardCategory":{
	 							"Size":"1",
	 							"Speed":"2",
	 							"Range":"3",
	 							"Firepower":"4",
	 							"Cargo":"5"
	 							}
	 	"userCardPileSize":"10"

	 
	 }
	 */
	
	public String categorySelection() {
		Model_Player activePlayer = gm.getRm().getActivePlayer();
		//if user is active

		if(activePlayer instanceof Model_User) {
			Map<String, String> selectedMap = new LinkedHashMap<String, String>();
			//means that it will return 0, if user need to select category
			String key = "getSelected";
			String keyValue = "0";
			selectedMap.put(key, keyValue);
			
			return JSON.toJSONString(selectedMap);
			
		}else {
			//if AI is active
			String selectedCategory = "";
			if( activePlayer instanceof Model_AI ) {
				
			selectedCategory = ((Model_AI) activePlayer).selectCategory();
			}
			return otherPlayerSelect(selectedCategory);
		}

	}
			
	
	public String otherPlayerSelect(String categorySelect){
		
		for (Model_Player player : gm.getPm().getPlayers()) {
			
			player.selectCategory(categorySelect);
		}
		
		Map<String, String> detailsMap = new LinkedHashMap<String, String>();
		//means that it will return 1, all player has select their category
		String key = "getSelected";
		String keyValue = "1";
		detailsMap.put(key, keyValue);
		
		String selectedKey = "selectedCategory";
		String selectedValue = categorySelect;
		detailsMap.put(selectedKey, selectedValue);
		
		// get the playerlist
		Model_Player[] players = gm.getPm().getPlayers();
		
		//this playerMap will store each player details
		for (int i = 0; i < players.length; i++) {
			//playerKey
			String playerKey = "player" + i;
			Map<String, String> playerMap = new LinkedHashMap<String, String>();
			
			//player name
			String playerNameKey = "playerName";
			String PlayerNameValue = players[i].getName();
			playerMap.put(playerNameKey, PlayerNameValue);
			
			//tell player is out or not
			String userIsOut = "playerIsOut";
			String userisOutValue = String.valueOf(players[i].isOut());
			playerMap.put(userIsOut, userisOutValue);
			
			//isactive
			String activekey = "isActive";
			String activeValue = "";
			if(gm.getRm().getActivePlayer() != players[i]) {
				activeValue = String.valueOf(false);
			}else {
			     activeValue = String.valueOf(true);
			}
			playerMap.put(activekey, activeValue);
			
			//owendCardDescription:
			String ownedCardNameKey = "ownedCardDescription";
			String ownedCardValue = players[i].getOwnedCard().getDescription();
			playerMap.put(ownedCardNameKey, ownedCardValue);
			
			//ownedCardCategory
			String ownedCardCategoryKey = "ownedCardCategory";
			String ownedCardCategoryvalue = JSON.toJSONString(players[i].getOwnedCard().getCategores());
			playerMap.put(ownedCardCategoryKey, ownedCardCategoryvalue);
			
			//userCardPileSize
			String userCardPaileSizeKey = "playerCardPileSize";
			String userCardPaileValue = ""+ players[i].getCardPile().size();
			playerMap.put(userCardPaileSizeKey, userCardPaileValue);
			
			//playerdetailsMap
			String playerdetailsValue = JSON.toJSONString(playerMap);
			
			detailsMap.put(playerKey, playerdetailsValue);
			
		}
		return JSON.toJSONString(detailsMap);
	}
	//The Json File might follow this:
			/*
			 {	
			 	"getSelected" : "1",
			 	"selectedCategory : "categoryName",
			 	"player1" : {
			 						"playerName" : "player1",
			 						"playerIsOut":"false",
									"isActive" " "true",
			 						"ownedCardDescription":"ownedcardname",
								 	"ownedCardCategory":{
								 							"Size":"1",
								 							"Speed":"2",
								 							"Range":"3",
								 							"Firepower":"4",
								 							"Cargo":"5"
								 							}
			 						"userCardPileSize":"10" 
			 			}
			 	"player2":{
			 		}
			 	}
			 */
	public String showResult() {
		gm.getRm().resetMaxValuePlayerList(gm.getPm());//find the maxvalue player again
		gm.getRm().selectWinner(gm);
		gm.getPm().distributeCardToWinner(gm.getRm());
		
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		String playerKey = "winPlayer";
		String playerName = "";
		if(gm.getRm().getRoundWinPlayer()!= null) {
			playerName = gm.getRm().getRoundWinPlayer().getName();
		}else {
			playerName = "null";
		}
		resultMap.put(playerKey, playerName);
		
		String cardPileKey = "cardPileNumber";
		String cardPileValue = "" + gm.getRm().getCommonCardPile().size();
		
		resultMap.put(cardPileKey, cardPileValue);
		
		String finalWinnerKey = "GameWinner";
		String finalWinnerValue = "";
		if(gm.getRm().winOrOut(gm.getPm(), gm)== false) {
			//false means game will continue, can't know game winner
			finalWinnerValue = "none";
		}else {
			finalWinnerValue = gm.getWinner().getName();
		}
		resultMap.put(finalWinnerKey, finalWinnerValue);
		
		return JSON.toJSONString(resultMap);
		
	}
	
	public String newRound() {
		gm.getRm().winOrOut(gm.getPm(), gm);
		gm.getRm().activePlayerSelector(gm.getPm());
		gm.getPm().playersDrawCard();
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		//tell user is out or not
		String userIsOut = "userIsOut";
		String userisOutValue = String.valueOf(gm.getPm().getPlayers()[0].isOut());
		map.put(userIsOut, userisOutValue);
		
		//put active player in the map
		String activePlayerKey = "activePlayer";
		String activePlayerValue = gm.getRm().getActivePlayer().getName();
		map.put(activePlayerKey, activePlayerValue);
		
		//owendCardDescription:
		String ownedCardNameKey = "ownedCardDescription";
		String ownedCardValue = gm.getPm().getPlayers()[0].getOwnedCard().getDescription();
		map.put(ownedCardNameKey, ownedCardValue);
		
		//ownedCardCategory
		String ownedCardCategoryKey = "ownedCardCategory";
		String ownedCardCategoryvalue = JSON.toJSONString(gm.getPm().getPlayers()[0].getOwnedCard().getCategores());
		map.put(ownedCardCategoryKey, ownedCardCategoryvalue);
		
		//userCardPileSize
		String userCardPaileSizeKey = "userCardPileSize";
		String userCardPaileValue = ""+ gm.getPm().getPlayers()[0].getCardPile().size();
		map.put(userCardPaileSizeKey, userCardPaileValue);
		
		// round count
		String roundKey = "Rountcount";
		String roundValue = "" +gm.getRm().getRoundCount();
		map.put(roundKey, roundValue);
		
		return JSON.toJSONString(map);
	}
	
	public String getStatistics() {
		DB_Model_Database database=new DB_Model_Database();
		Map<String, String> dbMap = new LinkedHashMap<String, String>();
		String numberKey = "numberOfGame";
		String numberValue = "" + database.getGameCount();
		dbMap.put(numberKey, numberValue);
		
		String numberOfHuKey = "numberOfHumanWin";
		String numberOfHuVal = "" + database.getNumberOfHumanWin();
		dbMap.put(numberOfHuKey, numberOfHuVal);
		
		String numberOfAIKey = "numberOfAIWin";
		String numberOfAIVal = "" + database.getNumberOfAIWin();
		dbMap.put(numberOfAIKey, numberOfAIVal);
		
		String avergeDrawKey = "averageDraws";
		String avergeDrawVal = "" + database.getAverageDraw();
		dbMap.put(avergeDrawKey, avergeDrawVal);
		
		String longestTimesKey = "longestRimes";
		String longestTimesVal = "" + database.getMaxRound();
		dbMap.put(longestTimesKey, longestTimesVal);
		
		return JSON.toJSONString(dbMap);
		
		
	}

}
