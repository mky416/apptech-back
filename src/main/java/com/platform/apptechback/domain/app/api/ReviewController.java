package com.platform.apptechback.domain.app.api;

import com.platform.apptechback.domain.app.dto.AppRequest;
import com.platform.apptechback.domain.app.dto.ReviewRequest;
import com.platform.apptechback.domain.app.dto.ReviewResponse;
import com.platform.apptechback.domain.app.entity.App;
import com.platform.apptechback.domain.app.entity.Review;
import com.platform.apptechback.domain.app.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/get2ReviewList")
    public ResponseEntity<List<ReviewResponse>> get2ReviewList(@RequestParam Long appId) {
        return reviewService.get2ReviewList(appId);
    }

    @GetMapping("/getAverageByAppId")
    public String getAverageByAppId(@RequestParam Long appId){
        return reviewService.getAverageByAppId(appId);
    }

    @GetMapping("/getRateByAppIdAndUserId")
    public Long getRateByAppIdAndUserId(@RequestParam Long appId, @RequestParam Long userId){
        return reviewService.getRateByAppIdAndUserId(appId, userId);
    }

    @PostMapping(value ="/addReview")
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(reviewRequest);
    }

    @GetMapping("/getReviewList")
    public ResponseEntity<List<ReviewResponse>> getReviewList(@RequestParam Long appId) {
        return reviewService.getReviewList(appId);
    }
}
