package com.rama.codingassignment.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rama.codingassignment.model.OfferDetails;
import com.rama.codingassignment.model.Transaction;
import com.rama.codingassignment.support.RewardPointsSupport;

import reactor.core.publisher.Mono;

@RestController
public class OfferController {
	private final RewardPointsSupport rewardPointsSupport;

    public OfferController(RewardPointsSupport rewardPointsSupport) {
        this.rewardPointsSupport = rewardPointsSupport;
    }

    @PostMapping(path = "/rewards")
    public Mono<OfferDetails> generateRewardPoints(@RequestBody List<Transaction> transactions) {
        return Mono.just(rewardPointsSupport.getOffers(transactions));
    }
}
