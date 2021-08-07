package uz.pdp.apppcmarketsecu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarketsecu.entity.Basket;
import uz.pdp.apppcmarketsecu.payload.ApiResponse;
import uz.pdp.apppcmarketsecu.payload.BasketDto;
import uz.pdp.apppcmarketsecu.service.BasketService;


import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    BasketService basketService;


    @GetMapping
    public HttpEntity<?> getBaskets() {
        List<Basket> baskets = basketService.getBaskets();
        return ResponseEntity.ok(baskets);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBasket(@PathVariable Integer id) {
        Basket basket = basketService.getBasket(id);
        return ResponseEntity.ok(basket);
    }

    @PostMapping
    public HttpEntity<?> addBasket(@RequestBody BasketDto basketDto) {
        ApiResponse apiResponse = basketService.addBasket(basketDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editBasket(@PathVariable Integer id,@RequestBody BasketDto basketDto){
        ApiResponse apiResponse = basketService.editBasket(id, basketDto);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBasket(@PathVariable Integer id){
        ApiResponse apiResponse = basketService.deleteBasket(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:409).body(apiResponse);
    }
}
