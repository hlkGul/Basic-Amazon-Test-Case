import org.jsoup.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestAddProductCart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductsDetailPage productsDetailPage;
    CartPage cartPage;
    @Test
    @Order(1)
    public void searchProduct(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductsPage(),"Not on Products Page");

    }
    @Test
    @Order(2)
    public void selectProduct(){
        productsDetailPage = new ProductsDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productsDetailPage.isOnProductDetailPAge(),"Not on product detail page");

    }
    @Test
    @Order(3)
    public void addProductToCart(){
        productsDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),"Product count did not increase");
    }
    @Test
    @Order(4)
    public void goToCart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product wasn't added to cart");
    }
}
