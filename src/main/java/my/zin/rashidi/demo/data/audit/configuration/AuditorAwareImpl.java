package my.zin.rashidi.demo.data.audit.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Rashidi Zin, GfK
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mr. Auditor");
    }

}
