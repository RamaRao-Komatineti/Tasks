package com.rama.codingassignment.model;

import java.util.Set;

import lombok.Data;

@Data
public class RewardDetails {
    private Customer customer;
    private Set<RewardMetadata> rewards;
    private int totalPoints;
}
