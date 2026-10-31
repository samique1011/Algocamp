package com.example.FakeCommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FakeCommerce.dtos.CreateReviewDTO;
import com.example.FakeCommerce.dtos.GetReviewResponseDTO;
import com.example.FakeCommerce.repositories.Order_ProductsRepository;
import com.example.FakeCommerce.repositories.ReviewRepository;
import com.example.FakeCommerce.schema.OrderProducts;
import com.example.FakeCommerce.schema.Review;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final Order_ProductsRepository order_ProductsRepository;
    public List<GetReviewResponseDTO> getAllReviews() {
        try {
            List<Review> reviews = reviewRepository.findAllReviewsWithProductAndOrder();
            List<GetReviewResponseDTO> res = new ArrayList<>();
            for (Review r : reviews) {
                res.add(GetReviewResponseDTO.builder()
                        .id(r.getId())
                        .productId(r.getProduct().getId())
                        .productName(r.getProduct().getName())
                        .orderId(r.getOrder().getId())
                        .ratings(r.getRatings())
                        .createdAt(r.getCreatedAt())
                        .reviewDescription(r.getReviewDescription())
                        .build());
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<GetReviewResponseDTO> getReviewsByProductId(Long productId){
        try{
            List<Review> reviews = reviewRepository.findReviewsByProductId(productId);
            List<GetReviewResponseDTO> res = new ArrayList<>();
            for(Review r : reviews){
                res.add(GetReviewResponseDTO.builder()
                .id(r.getId())
                .productId(r.getProduct().getId())
                .productName(r.getProduct().getName())
                .orderId(r.getOrder().getId())
                .ratings(r.getRatings())
                .createdAt(r.getCreatedAt())
                .reviewDescription(r.getReviewDescription())
                .build());
            }
            return res;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<GetReviewResponseDTO> getReviewsByOrderId(Long orderId){
        try{
            List<Review> reviews = reviewRepository.findReviewsByOrderId(orderId);
            List<GetReviewResponseDTO> res = new ArrayList<>();
            for(Review r : reviews){
                res.add(GetReviewResponseDTO.builder()
                .id(r.getId())
                .productId(r.getProduct().getId())
                .productName(r.getProduct().getName())
                .orderId(r.getOrder().getId())
                .ratings(r.getRatings())
                .createdAt(r.getCreatedAt())
                .reviewDescription(r.getReviewDescription())
                .build());
            }
            return res;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional 
    public String createReview(CreateReviewDTO createReviewDTO){
        try{
            OrderProducts op = order_ProductsRepository.findByProduct_IdAndOrder_Id(createReviewDTO.getProductId(), createReviewDTO.getOrderId())
            .orElseThrow(() -> new RuntimeException("Such order was never created"));
        
            Review r = Review.builder()
            .product(op.getProduct())
            .order(op.getOrders())
            .reviewDescription(createReviewDTO.getReviewDescription())
            .ratings(createReviewDTO.getRatings())
            .build();

            r = reviewRepository.save(r);
            return "Review saved";
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteReview(Long id){
        try{
            reviewRepository.deleteById(id);
            return "Review Deleted";
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public GetReviewResponseDTO getReviewById(Long id){
        try{
            Review r =  reviewRepository.findReviewById(id).
            orElseThrow(() -> new RuntimeException("Such review id doesnt exist"));

            return GetReviewResponseDTO.builder()
            .productId(r.getProduct().getId())
            .id(r.getId())
            .orderId(r.getOrder().getId())
            .productName(r.getProduct().getName())
            .ratings(r.getRatings())
            .reviewDescription(r.getReviewDescription())
            .createdAt(r.getCreatedAt())
            .build();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
