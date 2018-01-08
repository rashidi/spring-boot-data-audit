package my.zin.rashidi.demo.data.audit.configuration;

import org.springframework.data.domain.AuditorAware;

/**
 * @author Rashidi Zin, GfK
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Mr. Auditor";
    }

}
