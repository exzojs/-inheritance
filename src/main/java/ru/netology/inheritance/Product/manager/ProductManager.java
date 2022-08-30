package ru.netology.inheritance.Product.manager;

import ru.netology.inheritance.Product.Product;
import ru.netology.inheritance.Product.repository.Repository;

public class ProductManager {

    private Repository repository;


    public ProductManager(Repository repository) {
        this.repository = repository;
    }
    public Product[] findAll(){
        return repository.findAll();
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] results = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[results.length + 1];
               System.arraycopy(results, 0, tmp, 0, results.length);
                tmp[results.length] = product;
                results = tmp;
            }
        }
        return results;
    }


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

}