package business.product;

import model.Product;

import java.util.List;

public interface ProductBusiness {

    // Find All
    List<Product> findAll();

    // Add Product
    boolean checkProduct(String name);

    boolean addProduct(Product product);

    //
}
