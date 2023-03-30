package com.batch.batchfirstpgm.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    @Autowired
    private StepBuilderFactory sbf;
    
    @Autowired
    private JobBuilderFactory jbf;
    
    
 
   
//    @Bean
//    public Tasklet myTasklet() {
//       return new Tasklet() {
//
//		@Override
//		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//			System.out.println("HELLLOOOOOOOOOOOOOO,FUCKING HELL ,LETS GET RUN");
//			return RepeatStatus.FINISHED;
//		}
//    	   
//       };
//    }

    @Bean
    public Step myStep() {
        return sbf.get("step1..")
        		.tasklet(new Tasklet() {

					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
							throws Exception {
						System.out.println("EXECUTING HELLO WORLD , FREAKING HELL!!");
						return RepeatStatus.FINISHED;
					}
        			
        			
        		}).build();
    }
	
	@Bean
	public Job myJob() {
		return jbf.get("myfIRST JOB")
				.start(myStep())
				.build();
	}
}
