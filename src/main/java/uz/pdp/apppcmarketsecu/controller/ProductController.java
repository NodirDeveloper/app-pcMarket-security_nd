package uz.pdp.apppcmarketsecu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarketsecu.entity.Product;
import uz.pdp.apppcmarketsecu.payload.ApiResponse;
import uz.pdp.apppcmarketsecu.payload.ProductDto;
import uz.pdp.apppcmarketsecu.service.ProductService;


import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @PreAuthorize(value = "hasAuthority('READ_ALL_PRODUCT')")
    public HttpEntity<?> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE_PRODUCT')")
    public HttpEntity<?> getProduct(@PathVariable Integer id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @PreAuthorize(value = "hasAuthority('ADD_PRODUCT')")
    public HttpEntity<?> addProduct(@RequestBody ProductDto productDto) {
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('EDIT_PRODUCT')")
    public HttpEntity<?> editProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        ApiResponse apiResponse = productService.editProduct(id, productDto);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('DELETE_PRODUCT')")
    public HttpEntity<?> deleteProduct(@PathVariable Integer id){
        ApiResponse apiResponse = productService.deleteProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:409).body(apiResponse);
    }
}
