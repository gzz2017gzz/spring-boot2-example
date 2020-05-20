package org.activiti.examples.config;

import java.util.Map;
import org.activiti.api.process.runtime.connector.Connector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {
	@Bean
	public Connector processTextConnector() {
		return integrationContext -> {
			Map<String, Object> inBoundVariables = integrationContext.getInBoundVariables();
			String contentToProcess = (String) inBoundVariables.get("fileContent");
			// Logic Here to decide if content is approved or not
			if (contentToProcess.contains("activiti")) {
				integrationContext.addOutBoundVariable("approved", true);
			} else {
				integrationContext.addOutBoundVariable("approved", false);
			}
			return integrationContext;
		};
	}

	@Bean
	public Connector tagTextConnector() {
		return integrationContext -> {
			String contentToTag = (String) integrationContext.getInBoundVariables().get("fileContent");
			contentToTag += " :) ";
			integrationContext.addOutBoundVariable("fileContent", contentToTag);
			System.out.println("Final Content: " + contentToTag);
			return integrationContext;
		};
	}

	@Bean
	public Connector discardTextConnector() {
		return integrationContext -> {
			String contentToDiscard = (String) integrationContext.getInBoundVariables().get("fileContent");
			contentToDiscard += " :( ";
			integrationContext.addOutBoundVariable("fileContent", contentToDiscard);
			System.out.println("Final Content: " + contentToDiscard);
			return integrationContext;
		};
	}

}
