package lt.vu.usecases;

import lt.vu.entities.*;
import lt.vu.persistence.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.ConsoleHandler;

@Model
public class ManufacturProducts {

    @Inject
    private ProductsDAO productsDAO;
    @Inject
    private ManufacturerDAO manufacturerDAO;
    private Manufacturer findedManufacturer;
    private Product newProduct = new Product();

    @Inject
    private OrderDAO orderDAO;

    @PostConstruct
    @Transactional
    public void init() {
        try {
            Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            Integer manufacturerID = Integer.parseInt(requestParameters.get("manufacturerId"));
            findedManufacturer = manufacturerDAO.findManufacturer(manufacturerID);

        }catch (Exception ex)
        {
            System.out.println("Didn't found any parameters");
        }
    }


    // Sends all find manufacturers from to db to view
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDAO.getAllManufacturers();
    }

    @Transactional
    public String creatProduct() {

        //Veikiantyis

        Set<Product> products = new HashSet<>();
        Product product = new Product();
        product.setTitle(newProduct.getTitle());
        product.setDescription(newProduct.getDescription());
        product.setBarcode(newProduct.getBarcode());
        product.setCost(newProduct.getCost());
        product.addManufacturer(findedManufacturer);
        products.add(product);


        findedManufacturer.addProduct(product);

        manufacturerDAO.saveManufacturer(findedManufacturer);

        return "welcome";
    }


    // Loads all data to db
    @Transactional
    public String loadManufacturersAndProducts() {

        // Storing references of Manufacturers for a product
        Set<Manufacturer> chairManufacturers = new HashSet<Manufacturer>();
        Set<Manufacturer> keyboardManufacturers = new HashSet<Manufacturer>();
        Set<Manufacturer> guitarManufacturers = new HashSet<Manufacturer>();

        // Storing references of Products that have been made by manufacturers
        Set<Product> flamencoProducts = new HashSet<Product>();
        Set<Product> teslaProducts = new HashSet<Product>();

        // Rows in Manufacturer table, it's owner so needs to be saved
        Manufacturer flamenco = new Manufacturer();
        Manufacturer tesla = new Manufacturer();

        Product chair = new Product();
        Product keyboard = new Product();
        Product guitar = new Product();


        // Creating flamenco with manufacturer information
        flamenco.setId(111);
        flamenco.setName("Flamenco");
        flamenco.setDescription("Guitar manufacturer founded in 2012");
        flamenco.setLocation("Canada, Torronto");

        // Creating tesla with manufacturer information
        tesla.setId(222);
        tesla.setName("Tesla");
        tesla.setDescription("Electromobile private manufacturer company founded in 2002");
        tesla.setLocation("USA, New York");

        // Creating products
        chair.setTitle("Wooden chair for comfort");
        chair.setBarcode(1234);
        chair.setDescription("Made in chine, with special design");
        chair.setCost(BigDecimal.valueOf(25.30));
        //chair.setOrder(jonasOrder);

        // Creating products
        keyboard.setTitle("Metalic keyboard with special visual effects");
        keyboard.setBarcode(1547);
        keyboard.setDescription("Made in germany, assembled in chinna");
        keyboard.setCost(BigDecimal.valueOf(10.99));
        //keyboard.setOrder(petrasOrder);

        // Creating products
        guitar.setTitle("With high quality wood, made in Italy");
        guitar.setBarcode(9851);
        guitar.setDescription("Made by proffesional guitaris handcraft");
        guitar.setCost(BigDecimal.valueOf(200.85));


        // Storing references of Manufacturers for a product (Connections what product by which manufacturer was made, foreign keys)
        chairManufacturers.add(flamenco);
        keyboardManufacturers.add(tesla);
        guitarManufacturers.add(flamenco);
        guitarManufacturers.add(tesla);

        // Storing references of Products and manifacuters who made it (Connections what product by which manufacturer was made (foreign keys))
        flamencoProducts.add(chair);
        flamencoProducts.add(guitar);
        teslaProducts.add(keyboard);
        teslaProducts.add(guitar);

        flamenco.setProducts(flamencoProducts);
        tesla.setProducts(teslaProducts);

        chair.setManufacturers(chairManufacturers);
        keyboard.setManufacturers(keyboardManufacturers);
        guitar.setManufacturers(guitarManufacturers);

        manufacturerDAO.saveManufacturer(flamenco);
        manufacturerDAO.saveManufacturer(tesla);


        return "First time run, sample data loaded!";
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }


    public void setProductsDAO(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }

    public void setManufacturerDAO(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    public Manufacturer getFindedManufacturer() {
        return findedManufacturer;
    }

    public void setFindedManufacturer(Manufacturer findedManufacturer) {
        this.findedManufacturer = findedManufacturer;
    }

    public ProductsDAO getProductsDAO() {
        return productsDAO;
    }


}
