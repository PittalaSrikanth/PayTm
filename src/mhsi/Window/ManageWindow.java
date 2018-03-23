package mhsi.Window;

import java.util.Set;

import mhsi.actions.Action;

public class ManageWindow extends Action {

	static Set<String> NoOFWindows = driver.getWindowHandles();

	public static void closeAllChildWindows(String ParentTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ParentTitle);
	}

	public static void onlyparentAndChild(String ParentTitle, String ChildTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {

				if (EachWindow.equals(ChildTitle)) {
					continue;
				}
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ChildTitle);
	}

	public static void navigateToParentWindow(String ParentTitle) {
		driver.switchTo().window(ParentTitle);

	}

	public static void navigateToChildWindow(String ChildTitle) {
		driver.switchTo().window(ChildTitle);
	}
}
