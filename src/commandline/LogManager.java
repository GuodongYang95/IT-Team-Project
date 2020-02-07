package commandline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LogManager {
	
	private String filePathName;
	private String separatedLine = "----------\n";
	private File file;
	private BufferedWriter writer;
	
	public LogManager(String filePathName) {
		
		this.filePathName = filePathName;
		try {
			
			file = new File("./"+filePathName + ".log");
			// create the file if it does not exist
			if(!file.exists()) {
				file.createNewFile();
			}
//			FileOutputStream outputStream = new FileOutputStream(file,true);
//			
//			this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//			// true means this file can be appended
			
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
	}
	
	public void startGame(Model_CardPile cardPile, Model_PlayerManager pm) {
		try {
			//clear the content at first
			FileOutputStream outputStream = new FileOutputStream(file);
			this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			writer.write("");
			
			writer.append("--------------------"+ "\n");
			writer.append("--- Top Trumps   ---" + "\n");
			writer.append("--------------------"+ "\n");
			writer.flush();
			
			// true means this file can be appended
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void roundStart(Model_RoundManager rm) {
		
		try {
			writer.append("==========================Round " + rm.getRoundCount() + "==================== \n");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deckReadConstructed(Model_CardPile cardPile) {	
		
		try {
			writer.append("The Whole cardPile readed" + "\n");
			writer.append(cardPile.detailOfCardPile() + "\n");
			writer.append(separatedLine);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void playerDeck(Model_PlayerManager pm) {
			try {
				writer.append("The Player cardPile: \n");
				writer.append(pm.playersCardPileDetails());
				writer.append(separatedLine);
				writer.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
	public void communalPile(Model_RoundManager rm) {
			
		try {
			//judge it is null or not
			if(rm.getCommonCardPile()!=null) {
				writer.append(separatedLine);
				writer.append("Common Card Pile : "+ "\n\n");
				writer.append(rm.commonPileDetails() + "\n");
				writer.append(separatedLine);
				writer.flush();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void cardInPlay(Model_PlayerManager pm) {
		
		try {
			writer.append("The card in play" + separatedLine);
			for (Model_Player  player : pm.getPlayers()) {
				if(player.isOut() == false) {
						
					writer.append(player.getName() + " : "+player.getOwnedCard().cardDetail()+"\n");	
					}
				}
			writer.append(separatedLine);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void selectedCategory(Model_PlayerManager pm) {
	
		try {
			writer.append("The category of each player selected"+separatedLine);
			writer.append(pm.selectedCategoryDetails());
			writer.append(separatedLine);	
			writer.flush();
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void logRoundWinner(Model_RoundManager rm) {
		try {
			if(rm.getRoundWinPlayer()!=null) {
			writer.append("The winner of this round" + separatedLine);
			writer.append(rm.getRoundWinPlayer().getName()+"\n");
			writer.append(separatedLine);
			writer.flush();
			}
			else {
				writer.append("this round is draw" + "\n");
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logWinner(Model_GameManager gm) {
		try {
			writer.append("The winner: "+separatedLine);
			writer.append(gm.getWinner().getName());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeWriter() {
		try {
			writer.flush();
			this.writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
