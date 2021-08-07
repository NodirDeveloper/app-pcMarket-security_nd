package uz.pdp.apppcmarketsecu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarketsecu.entity.Basket;
import uz.pdp.apppcmarketsecu.entity.Client;
import uz.pdp.apppcmarketsecu.entity.Product;
import uz.pdp.apppcmarketsecu.payload.ApiResponse;
import uz.pdp.apppcmarketsecu.payload.BasketDto;
import uz.pdp.apppcmarketsecu.repository.BasketRepository;
import uz.pdp.apppcmarketsecu.repository.ProductRepository;
import uz.pdp.apppcmarketsecu.repository.projectionRepository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BasketService {
    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<Basket> getBaskets() {
        return basketRepository.findAll();
    }

    public Basket getBasket(Integer id) {
        Optional<Basket> optionalBasket = basketRepository.findById(id);
        return optionalBasket.orElseGet(Basket::new);
    }

    public ApiResponse addBasket(BasketDto basketDto) {
        Basket basket = new Basket();
        List<Product> productList=new ArrayList<>();
        for (Integer product : basketDto.getProductSet()) {
            Optional<Product> optionalProduct = productRepository.findById(product);
            productList.add(optionalProduct.get());
        }
        basket.setProductSet((Set<Product>) productList);
        List<Client> clientList=new ArrayList<>();
        for (Integer customer : basketDto.getClientSet()) {
            Optional<Client> optionalCustomer = clientRepository.findById(customer);
            clientList.add(optionalCustomer.get());
        }
        basket.setClientSet((Set<Client>) clientList);
        basket.setActive(true);
        basketRepository.save(basket);
        return new ApiResponse("Ok", true);
    }

    public ApiResponse editBasket(Integer id, BasketDto basketDto) {
        Optional<Basket> optionalBasket = basketRepository.findById(id);
        if (!optionalBasket.isPresent())
            return new ApiResponse("Basket not found", false);
        Basket basket = optionalBasket.get();
        List<Product> productList=new ArrayList<>();
        for (Integer product : basketDto.getProductSet()) {
            Optional<Product> optionalProduct = productRepository.findById(product);
            productList.add(optionalProduct.get());
        }
        basket.setProductSet((Set<Product>) productList);
        List<Client> clientList=new ArrayList<>();
        for (Integer customer : basketDto.getClientSet()) {
            Optional<Client> optionalCustomer = clientRepository.findById(customer);
            clientList.add(optionalCustomer.get());
        }
        basket.setClientSet((Set<Client>) clientList);
        basket.setActive(basketDto.isActive());
        basketRepository.save(basket);
        return new ApiResponse("Basket edited", true);
    }

    public ApiResponse deleteBasket(Integer id) {
        try {
            basketRepository.deleteById(id);
            return new ApiResponse("Basket deleted", true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

}
