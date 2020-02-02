package commandline;

import commandline.Model_Player;

public class Model_GameStat {

		private int numOfDraws;
		private Model_Player winner;
		private int numOfRounds;
		private Model_Player[] players;
		
		public Model_GameStat(Model_Player[] players) {
			numOfDraws = 0;
			winner = null;
			numOfRounds = 0;
			this.players = players;
		}
		
		public int getNumOfDraws() {
			return numOfDraws;
		}
		public void increDrawCounter() {
			numOfDraws++;
		}
		

		public Model_Player[] getPlayerArray() {
			return players;
		}
		

		public Model_Player getWinner() {
			return winner;
		}
		public void setWinner(Model_Player winner) {
			this.winner = winner;
		}
		
		public int getNumOfRounds() {
			return numOfRounds;
		}
		public void incremRoundCounter() {
			numOfRounds++;
		}

	}
