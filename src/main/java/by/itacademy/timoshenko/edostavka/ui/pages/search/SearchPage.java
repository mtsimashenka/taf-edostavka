package by.itacademy.timoshenko.edostavka.ui.pages.search;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchPage {

    public static String PRODUCT_SEARCH = "сникерс";

    public void clickInputSearch() {
        Driver.getWebElement(By.xpath(SearchLocators.INPUT_SEARCH)).click();
    }

    public void inputProductInSearch() {
        Driver.getWebElement(By.xpath(SearchLocators.INPUT_SEARCH)).sendKeys(PRODUCT_SEARCH);
    }

    public void enterProductInSearch() {
        Driver.getWebElement(By.xpath(SearchLocators.INPUT_SEARCH)).sendKeys(Keys.ENTER);
    }

    public String getSearchProductText() {
        return Driver.getWebElement(By.xpath(SearchLocators.PRODUCT_SEARCH_TEXT)).getText();
    }
}
