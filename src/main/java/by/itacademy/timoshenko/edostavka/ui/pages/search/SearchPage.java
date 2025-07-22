package by.itacademy.timoshenko.edostavka.ui.pages.search;

import by.itacademy.timoshenko.edostavka.ui.driver.Driver;
import org.openqa.selenium.By;

public class SearchPage {

    public static String PRODUCT_SEARCH = "сникерс";

    public void clickInputSearch() {
        Driver.getWebElement(By.xpath(SearchLocators.TITLE_SEARCH)).click();
    }

    public void inputProductInSearch() {
        Driver.getWebElement(By.xpath(SearchLocators.TITLE_SEARCH)).sendKeys(PRODUCT_SEARCH);
    }

    public String getSearchInputTextTitle() {
        return Driver.getWebElement(By.xpath(SearchLocators.TITLE_SEARCH)).getText();
    }

    public String getSearchProductText() {
        return Driver.getWebElement(By.xpath(SearchLocators.PRODUCT_SEARCH)).getText();
    }
}
