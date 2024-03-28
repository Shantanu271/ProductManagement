package com.ProductManagement.ProductService;

import com.ProductManagement.ProductModels.Product;
import com.ProductManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ServiceProduct {
@Autowired
private ProductRepository productRepository;

    public Product getProduct(int id){
    Optional<Product> optional = productRepository.findById(id);
    if(optional.isPresent()){
        return optional.get();
    }
     Product p = new Product();
    p.setId(0);
    p.setName("");
    p.setCost(0);
    p.setType("");
    return p;

    }
    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }
    public String createProduct(Product product){
        productRepository.save(product);
        return "Product Added !!!!";
    }
    public String updateProduct(Product product, int id){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            Product newProduct = new Product();
            newProduct.setName(product.getName());
            newProduct.setType(product.getType());
            newProduct.setCost(product.getCost());
            productRepository.save(newProduct);
            return "Product Updated Successfully";
        }
        return "Product Not Found !!!!!";
    }
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product removed Successfully";
    }

}
