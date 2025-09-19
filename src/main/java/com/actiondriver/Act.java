package com.actiondriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Act {

	public static void click(WebDriver driver, WebElement moveto) {
		Actions act = new Actions(driver);
		act.moveToElement(moveto).click().build().perform();
	}

	public static boolean findElement(WebDriver drive, WebElement elt) {
		boolean flag = false;
		try {
			elt.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("successfully element found at");
			} else {
				System.out.println("unable to find element");
			}
		}
		return flag;
	}

	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;

		// Step 1: Check if element exists
		flag = findElement(driver, ele); // returns true if element is found

		// Step 2: If element exists, check if it's visible
		if (flag) {
			flag = ele.isDisplayed(); // returns true if element is visible

			// Step 3: Print based on visibility
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			// Step 4: Element not found at all
			System.out.println("Not displayed ");
		}

		return flag;
	}

	public static boolean isEnabled(WebDriver driver, WebElement elt) {
		boolean flag = false;
		flag = findElement(driver, elt);
		if (flag) {
			flag = elt.isEnabled();
			if (flag) {
				System.out.println("element is enabled");
			} else {
				System.out.println("element is not enabled");
			}
		} else {
			System.out.println("not enabled");
		}
		return flag;
	}

	public static boolean isSelected(WebDriver driver, WebElement elt) {
		boolean flag = false;
		flag = findElement(driver, elt);

		if (flag) {
			flag = elt.isSelected();
			if (flag) {
				System.out.println("element is sselected");
			} else {
				System.out.println("element not selected");
			}
		} else {
			System.out.println("not slected");
		}

		return flag;
	}

	public static boolean send(WebElement elt, String text) {
		boolean flag = false;
		try {
			flag = elt.isDisplayed();
			elt.clear();
			elt.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			flag = false;
			System.out.println("LOCATION not found");
		} finally {
			if (flag) {
				System.out.println("successfully entered value");
			} else {
				System.out.println("not entered value");
			}
		}
		return flag;
	}

	public static boolean selectByIndex(WebElement elt, int n) {
		boolean flag = false;

		try {
			Select slt = new Select(elt);
			slt.selectByIndex(n);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("selected by index");
			} else {
				System.out.println("not selected ");
			}
		}

		return flag;
	}

	public static boolean selectByValue(WebElement elt, String s) {
		boolean flag = false;
		try {
			Select slt = new Select(elt);
			slt.selectByValue(s);
			flag = true;

		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("selected by value");
			} else {
				System.out.println("not selected by value");
			}
		}

		return flag;
	}

	public static boolean selectByVisibeText(WebElement elt, String s) {
		boolean flag = false;
		try {
			Select slt = new Select(elt);
			slt.selectByVisibleText(s);
			flag = true;

		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("selected by visibletext");
			} else {
				System.out.println("not selected by vt");
			}
		}

		return flag;
	}

	public static boolean jsclick(WebDriver driver, WebElement elt) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", elt);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("clicked");
			} else {
				System.out.println("not clicked");
			}
		}
		return false;
	}

	public static void implicitwait(WebDriver driver, int timeunits) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeunits));
	}

	public static void explicitwait(WebDriver driver, WebElement elt, int timeunits) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeunits));
		wait.until(ExpectedConditions.visibilityOf(elt));
	}
	
	

	public static void click1(WebElement elt, String locatorName) {
		boolean flag = false;
		try {
			elt.click();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \"" + locatorName + "\"");
			} else {
				System.out.println("Click Unable to click on \"" + locatorName + "\"");
			}

		}
	}

}