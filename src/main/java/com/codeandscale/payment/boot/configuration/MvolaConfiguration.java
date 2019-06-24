package com.codeandscale.payment.boot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mvola")
@Data
public class MvolaConfiguration
{
	private String login;
	private String password;
	private String hash;
}
