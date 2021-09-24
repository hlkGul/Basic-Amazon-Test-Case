import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailPage extends BasePage{
    By addToCartButtonLocator = By.id("add-to-cart-button");
    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public boolean isOnProductDetailPAge() {
        return isDisplayed(addToCartButtonLocator);
    }
}
