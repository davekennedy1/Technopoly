/**
 * 
 */
package g3.technopoly;

/**
 * @author tgl16
 * ENUM to store the menu options  
 */
public enum MenuOptions {

		PURCHASE ("Purchase startup"),
		HIRE ("Hire staff"),
		TAKEOVER ("Takeover startup"),
		END ("End turn"),
		TERMINATE ("Terminate game");
		
		
		private final String menuOptions;

		/**
		 * @param menuOptions
		 */
		private MenuOptions(String menuOptions) {
			this.menuOptions = menuOptions;
		}

		/**
		 * @return the menuOptions
		 */
		public String getMenuOptions() {
			return menuOptions;
		}

	}

