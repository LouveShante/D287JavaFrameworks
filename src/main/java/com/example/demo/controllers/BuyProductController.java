package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BuyProductController {
    @Autowired
    private ProductRepository productRepository;

@GetMapping("/buyProduct")
public String buyProduct(@RequestParam("productId") long productId, Model theModel) {

    Optional<Product> purchaseProd = productRepository.findById(productId);

    if (purchaseProd.isPresent()) {
        Product product = purchaseProd.get();

        if (product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productRepository.save(product);
            return "purchaseconfirmation";
        } else {
            return "outofstock";
        }
    }
    else {
        return "outofstock";
    }
}

@GetMapping("/purchaseconfirmation")
public String purchasesuccessful() {
    return "purchaseconfirmation";
}

@GetMapping("/outofstock")
public String outofstock() {
    return "outofstock";
}


}