package com.codeandscale.payment.boot;

import com.codeandscale.payment.boot.configuration.MvolaConfiguration;
import com.codeandscale.payment.mvola.v2.ApiAuthentication;
import com.codeandscale.payment.mvola.v2.client.PaymentApiClient;
import com.codeandscale.payment.mvola.v2.client.impl.SoapPaymentApiClientImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MvolaConfiguration.class})
@ConditionalOnClass({PaymentApiClient.class})
public class MvolaSpringBootStarter
{
	@Bean
	@ConditionalOnMissingClass
	public PaymentApiClient getPaymentApiClient(MvolaConfiguration configuration)
	{
		return new SoapPaymentApiClientImpl(new ApiAuthentication(configuration.getLogin(), configuration.getPassword(), configuration.getHash()));
	}
}
