package service;

import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts(){
       List<Product> products = new ArrayList<Product>();
       products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
       products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> result = productService.getAllProduct();
        Assert.assertEquals(products, result);
    }

    @Test
    public void testNumberOfProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        int result = productService.numberOfProducts();
        Assert.assertEquals(products.size(), result);
    }

    @Test
    public void testFindProduct(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product result = productService.findProduct("Mleko");
        Assert.assertEquals(products.get(0), result);
    }

    @Test
    public void testIsInStock(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isInStock("Mleko");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsNotInStock(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        products.add(new Product(3, "Wino", 10.50f, 1.56f, "różowy", 0));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isInStock("Wino");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsExistByName(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isExistByName("Mleko");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsNotExistByName(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isExistByName("Woda");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsExistById(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isExistById(1);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsNotExistById(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mleko", 2.65f, 1, "biały", 10));
        products.add(new Product(2, "Piwo", 3.50f, 1.04f, "złoty", 20));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isExistById(3);
        Assert.assertFalse(result);
    }




}
