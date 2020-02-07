package commandline;

import commandline.Model_Player;

public class DB_GameStat {

		private int drawTimes;
		private Model_Player winners;
		private int roundCount;  
		private Model_Player[] players;
		private Model_GameManager gm;
		private Model_RoundManager rm;
		
		public DB_GameStat(Model_Player[] players) {
			winners = null;
			this.players=players;
			drawTimes=0;
			roundCount=0;
		}
		
		public int getNumOfDraws() {
			this.drawTimes=gm.getDrawTimes();
			return drawTimes;
		}

		public Model_Player[] getPlayerArray() {
			return players;
		}
		

		public Model_Player getWinner() {
			return winners=gm.getWinner();
		}

		public void setWinner(Model_Player winner) {
			this.winners =winner;
		}
		
		
		public int getNumOfRounds() {
			this.roundCount=rm.getRoundCount();
			return roundCount;
		}

		
		}

