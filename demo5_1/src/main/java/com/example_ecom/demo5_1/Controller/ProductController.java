//package com.example_ecom.demo5_1.Controller;
//
//import com.example_ecom.demo5_1.Dto.ProductDto;
//import com.example_ecom.demo5_1.Model.Product;
//import com.example_ecom.demo5_1.Service.ForProduct.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/product")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//    @PostMapping("/add-product")
////    public void addProduct(@RequestBody ProductDto productDto){
////        productService.addProduct(productDto);
////    }
//    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto){
//
//            productService.addProduct(productDto);
//            return ResponseEntity.ok("Product Added successfully");
//    }
//
//    @GetMapping("/all")
//    public List<Product> getAllProducts() {
//
//        return productService.getAllProducts();
//    }
//
//    @PutMapping("/update/{productId}")
//    public Product updateProduct(@PathVariable Long productId, @RequestBody ProductDto updatedProductDto){
//        return productService.updateProduct(productId,updatedProductDto);
//    }
//}
