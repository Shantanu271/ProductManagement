package com.ProductManagement.ProductController;


import com.ProductManagement.ProductModels.Product;
import com.ProductManagement.ProductService.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    ServiceProduct Service;

@GetMapping("/getproducts/{id}")
public Product getProduct(@PathVariable("id")int id){
    return Service.getProduct(id);
}

@GetMapping("/getproducts")
    public List<Product> getProducts(){
    return Service.getProducts();
}


@PostMapping("/getproducts")
    public String createProduct(@RequestBody Product product){
        return Service.createProduct(product);
    }

@PutMapping("/getproducts/{id}")
public String updateProduct(@RequestBody Product product, @PathVariable("id") int id){
    return Service.updateProduct(product,id);
}

@DeleteMapping("/getproducts/{id}")
    public String deleteProduct(@PathVariable("id")int id){
        return Service.deleteProduct(id);
    }


}
