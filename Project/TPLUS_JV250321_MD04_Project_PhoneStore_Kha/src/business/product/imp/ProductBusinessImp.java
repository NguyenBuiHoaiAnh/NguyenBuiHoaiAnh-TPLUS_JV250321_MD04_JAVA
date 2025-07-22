package business.product.imp;

import business.product.ProductBusiness;
import dao.product.ProductDAO;
import dao.product.imp.ProductDAOImp;
import model.Product;

import java.util.List;

public class ProductBusinessImp implements ProductBusiness {

    private ProductDAO productDAO;

    public ProductBusinessImp(){
        productDAO = new ProductDAOImp();
    }

    // Find All
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean checkProduct(String name) {
        return productDAO.checkProduct(name);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }


}
