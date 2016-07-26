package com.dish.zipkin.sampler;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;

import java.util.Random;

public class DishPercentageBasedSampler implements Sampler {
    private final SamplerProperties configuration;

    private Random rand = new Random();

    public DishPercentageBasedSampler(SamplerProperties configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean isSampled(Span currentSpan) {
        // Reads percentage from property spring.sleuth.sampler.percentage
        // Ranges from [0,1)
        return rand.nextDouble() < this.configuration.getPercentage();
    }
}
