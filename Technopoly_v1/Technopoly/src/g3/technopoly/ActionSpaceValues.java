package g3.technopoly;

/**
 * ENUM containing all action space properties. (Name, Field, Position in board)
 * 
 * @author Ismael Florit
 * @studentNo 40009944
 */
public enum ActionSpaceValues {

	INVESTNI("Invest NI", "Action", 0), RUNWAY("Runway", "Action", 6);

	private final String spaceName;
	private final String actionType;
	private final int positionInBoard;

	private ActionSpaceValues(String spaceName, String actionType, int positionInBoard) {
		this.spaceName = spaceName;
		this.actionType = actionType;
		this.positionInBoard = positionInBoard;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public String getActionType() {
		return actionType;
	}

	public int getPositionInBoard() {
		return positionInBoard;
	}

}
