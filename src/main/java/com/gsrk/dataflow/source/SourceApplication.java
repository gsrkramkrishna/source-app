package com.gsrk.dataflow.source;


import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;


/**
 * Hello world!
 *
 */
@EnableBinding(Source.class)
@SpringBootApplication
public class SourceApplication 
{
	private static Logger logger = LoggerFactory.getLogger(SourceApplication.class);

	
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<Long> timeMessageSource() {

		logger.info("Message Generated:",Calendar.getInstance().toString());
		return () -> MessageBuilder.withPayload(new Date().getTime()).build();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(SourceApplication.class, args);
    }
}
