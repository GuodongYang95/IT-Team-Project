package commandline;

import commandline.Model_Player;

public class DB_GameStat {

		private int drawTimes;
		private Model_Player winner;
		private int roundCount;  
		private Model_Player[] players;
		private Model_GameManager gm;
		private Model_RoundManager rm;
		
		public DB_GameStat(Model_PlayerManager pm,Model_RoundManager rm, Model_GameManager gm) {
			winner = gm.getWinner();
			this.players=pm.getPlayers();
			drawTimes=gm.getDrawTimes();
			roundCount = rm.getRoundCount();
			this.gm = gm;
			this.rm = rm;
			
			
		}
		
		public int getNumOfDraws() {
			this.drawTimes=gm.getDrawTimes();
			return drawTimes;
		}

		public Model_Player[] getPlayerArray() {
			return players;
		}
		

		public Model_Player getWinner() {
			return winner=gm.getWinner();
		}

		public void setWinner() {
			this.winner =gm.getWinner();
		}
		
		
		public int getNumOfRounds() {
			this.roundCount=rm.getRoundCount();
			return roundCount;
		}

		
		}

