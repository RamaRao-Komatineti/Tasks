package com.rama.codingassignment.support;

import com.rama.codingassignment.model.Customer;
import com.rama.codingassignment.model.OfferDetails;
import com.rama.codingassignment.model.RewardDetails;
import com.rama.codingassignment.model.RewardMetadata;
import com.rama.codingassignment.model.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;


class RewardPointsSupportTest {

    private final RewardPointsSupport rewardPointsSupport = new RewardPointsSupport();

    @Test
    void getOffers() {
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.valueOf(120));
        transaction.setDateTime(LocalDateTime.of(2022, Month.APRIL, 10, 6, 12));
        transaction.setCustomerId(UUID.randomUUID().toString());
        transactions.add(transaction);
        OfferDetails offers = rewardPointsSupport.getOffers(transactions);
        Assertions.assertThat(offers)
                .isNotNull();
        Set<RewardDetails> rewards = new HashSet<>();
        RewardDetails rewardDetails = new RewardDetails();
        rewardDetails.setTotalPoints(90);
        Customer customer = new Customer();
        customer.setId(transaction.getCustomerId());
        rewardDetails.setCustomer(customer);
        Set<RewardMetadata> rewardMetadatas = new HashSet<>();
        RewardMetadata rewardMetadata = new RewardMetadata();
        rewardMetadata.setMonth(Month.APRIL);
        rewardMetadata.setPoints(90);
        rewardMetadatas.add(rewardMetadata);
        rewardDetails.setRewards(rewardMetadatas);
        rewards.add(rewardDetails);
        Assertions.assertThat(offers.getRewardDetails())
                .isNotEmpty()
                .containsExactlyElementsOf(rewards);
    }

    @ParameterizedTest
    @MethodSource("rewardsTestData")
    void getRewardPoints(int input, int output) {
        Integer rewardPoints = rewardPointsSupport.getRewardPoints(BigDecimal.valueOf(input));
        Assertions.assertThat(rewardPoints).isEqualTo(output);
    }

    private static Stream<Arguments> rewardsTestData() {
        return Stream.of(
                Arguments.of(120, 90),
                Arguments.of(100, 50),
                Arguments.of(220, 290),
                Arguments.of(40, 0),
                Arguments.of(0, 0),
                Arguments.of(101, 52)
        );
    }
}