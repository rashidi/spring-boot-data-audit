package my.zin.rashidi.demo.data.audit.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rashidi Zin
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
