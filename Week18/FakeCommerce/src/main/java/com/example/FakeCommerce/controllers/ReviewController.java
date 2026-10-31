package com.example.FakeCommerce.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.dtos.CreateReviewDTO;
import com.example.FakeCommerce.dtos.GetReviewResponseDTO;
import com.example.FakeCommerce.services.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor 
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping 
    public ResponseEntity<?> getAllReviews(){
        try{
            List<GetReviewResponseDTO> li = reviewService.getAllReviews();
            return ResponseEntity.ok(li);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getReviewsByProductId(@PathVariable Long productId){
        try{
            List<GetReviewResponseDTO> li = reviewService.getReviewsByProductId(productId);
            return ResponseEntity.ok(li);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getReviewsByOrderId(@PathVariable Long orderId){
        try{
            List<GetReviewResponseDTO> li = reviewService.getReviewsByOrderId(orderId);
            return ResponseEntity.ok(li);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PostMapping 
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDTO createReviewDTO){
        try{
            String res = reviewService.createReview(createReviewDTO);
            return ResponseEntity.ok(res);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id){
        try{
            String ans = reviewService.deleteReview(id);
            return ResponseEntity.ok(ans);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(reviewService.getReviewById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
