package com.gg.proj.tasklet;

import com.gg.proj.model.UserModel;
import com.gg.proj.utils.CustomMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * A tasklet, it receives a list of user and send en Email to each one
 */
@Component
public class MailProcessor implements Tasklet, StepExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(MailProcessor.class);
    private List<UserModel> users;
    @Autowired
    private CustomMailService customMailService;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        // We call the ExecutionContext to retrieve data from the previous tasklet
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.users = (List<UserModel>) executionContext.get("users");
        log.debug("============ Mail Processor initialized ============");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        for (UserModel user : users) {
            customMailService.sendSimpleMail(user.getMailAdress(), user.getFirstName(), user.getLastName());
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.debug("============ Mail Processor ended ============");
        return ExitStatus.COMPLETED;
    }
}
