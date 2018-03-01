package my.zin.rashidi.demo.data.audit;

import my.zin.rashidi.demo.data.audit.domain.User;
import my.zin.rashidi.demo.data.audit.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataAuditApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void create() {
        user = userRepository.save(
            new User().setName("Rashidi Zin").setUsername("rashidi.zin")
        );

        assertThat(user.getCreated())
            .isNotNull();

        assertThat(user.getModified())
            .isNotNull();

        assertThat(user.getCreatedBy())
                .isEqualTo("Mr. Auditor");

        assertThat(user.getModifiedBy())
                .isEqualTo("Mr. Auditor");
    }

    @Test
    public void update() {
        LocalDateTime created = user.getCreated();
        LocalDateTime modified = user.getModified();

        userRepository.save(
                user.setUsername("rashidi")
        );

        userRepository.findById(user.getId())
                .ifPresent(updatedUser -> {

                    assertThat(updatedUser.getUsername())
                            .isEqualTo("rashidi");

                    assertThat(updatedUser.getCreated())
                            .isEqualTo(created);

                    assertThat(updatedUser.getModified())
                            .isAfter(modified);
                });
    }
}
