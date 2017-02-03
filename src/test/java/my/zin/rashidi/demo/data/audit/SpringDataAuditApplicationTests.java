package my.zin.rashidi.demo.data.audit;

import my.zin.rashidi.demo.data.audit.domain.User;
import my.zin.rashidi.demo.data.audit.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

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
    }

    @Test
    public void update() {
        ZonedDateTime created = user.getCreated();
        ZonedDateTime modified = user.getModified();

        userRepository.save(
            new User()
                .setId(user.getId())
                .setName(user.getName())
                .setUsername("rashidi")
        );

        User updatedUser = userRepository.findOne(user.getId());

        assertThat(updatedUser.getUsername())
            .isEqualTo("rashidi");

        assertThat(updatedUser.getCreated())
            .isEqualTo(created);

        assertThat(updatedUser.getModified())
            .isGreaterThan(modified);
    }
}
