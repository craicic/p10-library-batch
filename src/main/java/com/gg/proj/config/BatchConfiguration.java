package com.gg.proj.config;

import com.gg.proj.consumer.ProfileConsumer;
import com.gg.proj.tasklet.MailSender;
import com.gg.proj.tasklet.ProfileReader;
import com.gg.proj.tasklet.MailProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobs;

    @Autowired
    public StepBuilderFactory steps;

    @Autowired
    public ProfileConsumer profileConsumer;

    @Bean
    public ProfileReader reader() {
        return new ProfileReader(profileConsumer);
    }

    @Bean
    public MailProcessor processor() {
        return new MailProcessor();
    }

    @Bean
    public MailSender sender() {
        return new MailSender();
    }

    @Bean
    protected Step readItemsFromSoap() {
        return steps
                .get("soapReader")
                .tasklet(reader())
                .build();
    }

    @Bean
    protected Step processMessages() {
        return steps
                .get("messagesProcessor")
                .tasklet(processor())
                .build();
    }

    @Bean
    protected Step sendMails() {
        return steps
                .get("mailsSender")
                .tasklet(sender())
                .build();
    }

    @Bean
    public Job job() {
        return jobs
                .get("taskletsJob")
                .start(readItemsFromSoap())
                .next(processMessages())
                .next(sendMails())
                .build();
    }
}
