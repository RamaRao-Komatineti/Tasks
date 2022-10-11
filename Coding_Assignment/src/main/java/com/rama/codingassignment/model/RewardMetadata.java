package com.rama.codingassignment.model;

import java.time.Month;

import lombok.Data;

@Data
public class RewardMetadata {
	private Month month;
    private int points;
}
