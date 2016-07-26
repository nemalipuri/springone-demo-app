package com.dish.zipkin;

import com.dish.zipkin.reporter.ZipkinLogReporter;
import com.dish.zipkin.sampler.DishPercentageBasedSampler;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;
import org.springframework.cloud.sleuth.zipkin.ZipkinAutoConfiguration;
import org.springframework.cloud.sleuth.zipkin.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ZipkinProperties.class, SamplerProperties.class})
@ConditionalOnProperty(value = "spring.zipkin.enabled", matchIfMissing = true)
@AutoConfigureBefore(ZipkinAutoConfiguration.class)
public class DishZipkinAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Sampler defaultTraceSampler(SamplerProperties config) {
        return new DishPercentageBasedSampler(config);
    }

    @Bean
    @ConditionalOnMissingBean(ZipkinSpanReporter.class)
    public ZipkinSpanReporter reporter(SpanMetricReporter spanMetricReporter, ZipkinProperties zipkin) {
        return new ZipkinLogReporter();
    }
}
