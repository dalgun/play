package dalgun.github.io;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author dalgun
 * @since 2019-10-30
 */
@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class PlayBatchApplication {
    public static void main(String[] args) { SpringApplication.run(PlayBatchApplication.class, args); }

}
