package dalgun.github.io.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import dalgun.github.io.utils.BooleanToYNConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author dalgun
 * @since 2019-10-30
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LockTable {

    @Id
    @Column
    private String instanceId;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime checkDataTime;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean useYn;

}
