package com.example.FakeCommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FakeCommerce.dtos.CreateOrderRequestDTO;
import com.example.FakeCommerce.dtos.GetOrderResponseDTO;
import com.example.FakeCommerce.dtos.OrderItems;
import com.example.FakeCommerce.repositories.OrderRepository;
import com.example.FakeCommerce.repositories.Order_ProductsRepository;
import com.example.FakeCommerce.repositories.ProductRepository;
import com.example.FakeCommerce.schema.OrderProducts;
import com.example.FakeCommerce.schema.Orders;
import com.example.FakeCommerce.schema.Product;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Service 
public class OrderServices {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final Order_ProductsRepository order_ProductsRepository;


    @Transactional 
    public String createOrder(CreateOrderRequestDTO createOrderRequestDTO){
        try{
            List<OrderItems> orderItems = createOrderRequestDTO.getOrderItems();
            for(OrderItems x : orderItems){
                Product p = productRepository.findById(x.getProductId())
                .orElseThrow(() -> new RuntimeException(x.getProductId() + "Doesn't exists"));

                Orders o = Orders.builder().status(x.getOrderStatus()).build();
                o = orderRepository.save(o);
                OrderProducts op = OrderProducts.builder()
                .product(p)
                .orders(o)
                .quantity(x.getQuantity())
                .build();

                op = order_ProductsRepository.save(op);
            }
            return "All orders created";
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional 
    public List<GetOrderResponseDTO> getAllOrders(){
        try{
            List <OrderProducts> response = order_ProductsRepository.findAllWithProductAndOrder();
            List <GetOrderResponseDTO> ans = new ArrayList<>();
            for(OrderProducts x : response){
                GetOrderResponseDTO getOrderResponseDTO = GetOrderResponseDTO.builder()
                .id(x.getId())
                .productId(x.getProduct().getId())
                .productName(x.getProduct().getName())
                .orderId(x.getOrders().getId())
                .orderStatus(x.getOrders().getStatus())
                .quantity(x.getQuantity())
                .build();
                ans.add(getOrderResponseDTO);
            }
            return ans;
        }catch(Exception e){
            throw new RuntimeException("Error in fetching all products with order status");
        }
    }
}
