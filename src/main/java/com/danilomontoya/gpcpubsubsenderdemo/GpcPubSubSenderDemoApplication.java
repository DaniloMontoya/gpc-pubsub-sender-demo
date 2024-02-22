package com.danilomontoya.gpcpubsubsenderdemo;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class GpcPubSubSenderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpcPubSubSenderDemoApplication.class, args);
    }

    @Bean
    @ServiceActivator(inputChannel = "demoOutputChannel")
    public MessageHandler messageSender(PubSubTemplate pubSubTemplate){
        return new PubSubMessageHandler(pubSubTemplate, "scout-topic-demo");
    }

    @MessagingGateway(defaultRequestChannel = "demoOutputChannel")
    public interface PubSubOutboundGateway{
        void sendToPubSub(String text);
    }

}
