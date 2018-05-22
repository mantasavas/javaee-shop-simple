package lt.vu.usecases;


import lt.vu.entities.Author;
import lt.vu.entities.Product;
import lt.vu.persistence.ProductsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Products {
    @Inject
    private ProductsDAO productsDAO;
    private List<Product> allProducts;

    // creating new product object for user input
    private Product newProduct = new Product();


    @PostConstruct
    public void init() {
        this.loadAllProduct();
    }


    @Transactional
    public String createNewProduct() {
        productsDAO.saveProduct(newProduct);
        return "index?faces-redirect=true"; // return seccuss;    before
    }

    private void loadAllProduct() {
        this.allProducts = productsDAO.getAllProducts();
    }


    public List<Product> getAllProducts() {
        return allProducts;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
}
