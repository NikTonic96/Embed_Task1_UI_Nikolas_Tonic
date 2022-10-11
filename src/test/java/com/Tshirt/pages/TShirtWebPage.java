package com.Tshirt.pages;

import com.Tshirt.utility.ConfigurationReader;
import com.Tshirt.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TShirtWebPage {

    @FindBy(xpath = "//span[@class='checkmark']")
    public List<WebElement> filterBySizeBtn;
    @FindBy(xpath = "(//button[@tabindex='-1'])[2]")
    public WebElement secondListedShirt;
    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//div[@class='sc-1h98xa9-2 fGgnoG']")
    public WebElement openCartBtn;
    @FindBy(xpath = "(//button[@class='sc-11uohgb-6 cgtUCJ'])[2]")
    public WebElement increaseQuantityBtn;
    @FindBy(xpath = "//p[@class='sc-11uohgb-3 gKtloF']")
    public WebElement quantityInfo;

    public TShirtWebPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToWebPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webpage.url"));
    }

    public void getSize(String size){
        for (WebElement each : filterBySizeBtn) {
            if (size.contains(each.getText())) {
                each.click();
            }
        }
    }

}
