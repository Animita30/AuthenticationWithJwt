//package com.example_ecom.demo5_1.Service.ForProduct;
//
//import com.example_ecom.demo5_1.Dto.ProductDto;
//import com.example_ecom.demo5_1.Model.Product;
//import com.example_ecom.demo5_1.Repository.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductServiceImpl implements ProductService{
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Override
//    public void addProduct(ProductDto productDto){
//        Product product=new Product();
//        product.setName(productDto.getName());
//        product.setPrice(productDto.getPrice());
//        productRepo.save(product);
//    }
//    @Override
//    public List<Product> getAllProducts(){
//        return productRepo.findAll();
//    }
//   @Override
//    public Product updateProduct(Long prodId, ProductDto updatedProductDto){
//        Product existingProduct=productRepo.findById(prodId).orElse(null);
//        if(existingProduct==null){
//            return null;
//        }
//        existingProduct.setName(updatedProductDto.getName());
//        existingProduct.setPrice(updatedProductDto.getPrice());
//        return productRepo.save(existingProduct);
//    }
//
//}
