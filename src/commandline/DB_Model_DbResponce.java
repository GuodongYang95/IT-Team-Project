package commandline;

public class DB_Model_DbResponce {
	private int GameCount;
	private int MaxRound;
	private int AverageDraw;
	private int NumberOfAIWin;
	private int NumberOfHumanWin;
		
		public DB_Model_DbResponce() {
			GameCount=0;
			MaxRound=0;
			AverageDraw=0;
			NumberOfAIWin=0;
			NumberOfHumanWin=0;
		}

		public int getGameCount() {
			return GameCount;
		}

		public void setGameCount(int gameCount) {
			GameCount++;
		}

		public int getMaxRound() {
			return MaxRound;
		}

		public void setMaxRound(int maxRound) {
			MaxRound = maxRound;
		}

		public int getAverageDraw() {
			return AverageDraw;
		}

		public void setAverageDraw(int averageDraw) {
			AverageDraw = averageDraw;
		}

		public int getNumberOfAIWin() {
			return NumberOfAIWin;
		}

		public void setNumberOfAIWin(int numberOfAIWin) {
			NumberOfAIWin = numberOfAIWin;
		}

		public int getNumberOfHumanWin() {
			return NumberOfHumanWin;
		}

		public void setNumberOfHumanWin(int numberOfHumanWin) {
			NumberOfHumanWin = numberOfHumanWin;
		}

		@Override
		public String toString() {
			return "GameInformation [GameCount=" + GameCount + ", MaxRound=" + MaxRound + ", AverageDraw=" + AverageDraw
					+ ", NumberOfAIWin=" + NumberOfAIWin + ", NumberOfHumanWin=" + NumberOfHumanWin + "]";
		}
		
		
}
