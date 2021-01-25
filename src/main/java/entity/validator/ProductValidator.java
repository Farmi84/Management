package entity.validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.math.BigDecimal;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {
    }

    public static ProductValidator getInstance(){
        if(instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException {
        if(!isPricePositive(product)){
            throw new ProductPriceNoPositiveException();
        }
        if(!isNameNotEmpty(product)){
            throw new ProductNameEmptyException();
        }
        if(!isProductsCountPositive(product)){
            throw new ProductCountNegativeException();
        }
        if(!isWeightPositive(product)){
            throw new ProductWeightNoPositiveException();
        }
        return true;
    }

    private boolean isPricePositive(Product product){
        if((product.getPrice().compareTo(BigDecimal.ZERO))==1){
            return true;
        }
        return false;
    }

    private boolean isNameNotEmpty(Product product){
        return !product.getProductName().equals(null);
    }

    private boolean isProductsCountPositive(Product product){
        return product.getProductCount() > 0;
    }

    private boolean isWeightPositive(Product product){
        if((product.getWeight().compareTo(BigDecimal.ZERO)) == 1){
            return true;
        }
        return false;
    }
}
