package com.se.fit.controllers;

import com.se.fit.models.Product;
import com.se.fit.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/home")
    public String getProducts(Model model){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        model.addAttribute("products",products);
        return "index";
    }
// Display  insert form
    @GetMapping("/insert-form")
    public String getInsertForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "insert-form";
    }
//    Action insert product
    @PostMapping("/add")
    public String insertProduct(@ModelAttribute("product") Product product){
        productRepository.save(product);
        return "redirect:/home";
    }
//    Delete product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        productRepository.delete(product);
        return "redirect:/home";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditForm(Model model,@PathVariable("id") long id){
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        model.addAttribute("product",product);
        return "edit-form";
    }
    //    Action insert product

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") long id, @Validated Product product, BindingResult result){
        if(result.hasErrors()){
            product.setId(id);
            return "redirect:/edit-form";
        }else {
            productRepository.save(product);
        }
        return "redirect:/home";
    }

}
