package lambdatest.locator;

import org.openqa.selenium.By;

public class FindLocator 
{
	public By getLocator_Value(String locator) // name|reg_passwd__
	{
		String locatorName = getLocatorStrategy(locator);
		String locatorValue = getLocatorValue(locator);
		
		By by = getBy(locatorName.toLowerCase(), locatorValue);
		return by;
	}
	
	/***
	 * Get the by class with locator strategy
	 * @param locator Locator name e.g. id, name, css, xpath, tagName, linktext etc.
	 * @param locatorValue locator value
	 * @return Object of By class by setting locator & locator value
	 */
	private By getBy(String locator, String locatorValue)
	{
		By by = null;
		switch (locator.toLowerCase()) {
		case "id":
			by = By.id(locatorValue);
			break;
			
		case "name":
			by = By.name(locatorValue);
			break;

		case "cssselector":
		case "css":
			by = By.cssSelector(locatorValue);
			break;
			
		case "xpath":
			by = By.xpath(locatorValue);
			break;
			
		case "linktext":
			by = By.linkText(locatorValue);
			break;
			
		case "partiallinktext":
			by = By.partialLinkText(locatorValue);
			break;
			
		case "classname":
			by = By.className(locatorValue);
			break;	
		
		case "tagname":
			by = By.tagName(locatorValue);
			break;
			
		default:
			System.out.println("Invalid Locators !!");
			break;
		}
		return by;
	}
	
	
	
	/***
	 * Separate the locator name and return it
	 * @param locator Locator name with Locator Value
	 * @return Return only locator name
	 */
	private String getLocatorStrategy(String locator)
	{
		String[] split = null;
		if(locator != null)
		{
			split = locator.split("\\|");
		}
		return split[0];
	}
	
	/***
	 * Separate the locator value and return it
	 * @param locator Locator name with Locator Value
	 * @return Return only locator name
	 */
	private String getLocatorValue(String locator)
	{
		String[] split = null;
		if(locator != null)
		{
			split = locator.split("\\|");
		}
		return split[1];
	}
}
