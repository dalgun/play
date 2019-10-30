package dalgun.github.io.job;

import dalgun.github.io.Repository.LockTableRepository;
import dalgun.github.io.domain.LockTable;
import dalgun.github.io.model.PayInfo;
import dalgun.github.io.repository.PayInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author dalgun
 * @since 2019-10-30
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    private LockTableRepository lockTableRepository;

    @Autowired
    private PayInfoRepository payInfoRepository;

    @Value("${spring.application.name}")
    private String instanceId;

    @Bean
    public Job job(){
        return jobBuilderFactory.get("job")
                .start(step1())
                .on("FAILED")
                .end()
                .from(step1())
                .on("*")
                .to(step2())
                .next(step3())
                .on("*")
                .end()
                .end()
                .build();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    LockTable lockTable = Optional
                            .ofNullable(lockTableRepository.findOne("play-batch"))
                            .orElse(LockTable
                                    .builder()
                                    .instanceId(instanceId)
                                    .useYn(false)
                                    .checkDataTime(LocalDateTime.now())
                                    .build());
                    if(lockTable.isUseYn()){
                        stepContribution.setExitStatus(ExitStatus.FAILED);
                    }else{
                        lockTable.setUseYn(true);
                        lockTableRepository.save(lockTable);
                    }
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step step2(){
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {

                    List<PayInfo> payInfoList = payInfoRepository.findAllBySuccessYn(false);

                    for(PayInfo payInfo: payInfoList){
                        log.debug("do something before:{}",payInfo);
                        if(true){
                            payInfo.setRequestDateTime(LocalDateTime.now());
                            payInfo.setSuccessYn(true);
                            payInfoRepository.save(payInfo);
                        }
                        log.debug("do something after:{}", payInfo);
                    }
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step step3(){
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    LockTable lockTable = lockTableRepository.findOne(instanceId);
                    lockTable.setUseYn(false);
                    lockTable.setCheckDataTime(LocalDateTime.now());
                    lockTableRepository.save(lockTable);
                    return RepeatStatus.FINISHED;
                }).build();
    }


}
