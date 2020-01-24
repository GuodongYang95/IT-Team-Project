package listener;

public class CMLEvent {
	
	public int getUserChoiceOfMenu(UserChoiceOfMenuListener menuchoice) {
		
		return menuchoice.userChoiceOfMenu();
	}
	
	public int getUserChoiceOfSelectingCategory(UserChoiceofSelectingListener categoryChoice) {
		
		return categoryChoice.userChoiceofSelectingCategoryListener();
		
	}

}
