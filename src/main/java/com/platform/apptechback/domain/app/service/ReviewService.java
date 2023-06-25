package com.platform.apptechback.domain.app.service;

import com.platform.apptechback.domain.app.dto.ReviewResponse;
import com.platform.apptechback.domain.app.entity.Review;
import com.platform.apptechback.domain.app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ResponseEntity<List<ReviewResponse>> get2ReviewList(Long appId) {
       List<Review> reviewList = reviewRepository.findTop2ByAppId(appId);
       List<ReviewResponse> reviewResponseList = reviewList.stream()
               .map(m -> new ReviewResponse(m.getId(),
                       m.getApp(),
                       m.getUser(),
                       m.getRate(),
                       m.getReview()))
               .collect(Collectors.toList());

       return new ResponseEntity<>(reviewResponseList, HttpStatus.OK);
    }

    public String getAverageByAppId(Long appId){
        double average = reviewRepository.getAverageByAppId(appId);
        String averageStr = String.format("%.1f", average);
        return averageStr;
    }

    public ResponseEntity<List<ReviewResponse>> getReviewList(Long appId) {
        List<Review> reviewList = reviewRepository.findByAppId(appId);
        List<ReviewResponse> reviewResponseList = reviewList.stream()
                .map(m -> new ReviewResponse(m.getId(),
                        m.getApp(),
                        m.getUser(),
                        m.getRate(),
                        m.getReview()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(reviewResponseList, HttpStatus.OK);
    }
}
