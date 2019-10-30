package dalgun.github.io.Repository;

import dalgun.github.io.domain.LockTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dalgun
 * @since 2019-10-30
 */
@Repository
public interface LockTableRepository extends JpaRepository<LockTable, String> {

}
