package com.gg.proj.tasklet;

import com.gg.proj.consumer.ProfileConsumer;
import com.gg.proj.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProfileReader implements Tasklet, StepExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(ProfileReader.class);

    private ProfileConsumer profileConsumer;

    public ProfileReader() {
    }

    @Autowired
    public ProfileReader(ProfileConsumer profileConsumer) {
        this.profileConsumer = profileConsumer;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<UserModel> users = profileConsumer.listLateUser();
        for (UserModel u : users) {
            log.info(u.toString());
        }
        return null;
    }
}
