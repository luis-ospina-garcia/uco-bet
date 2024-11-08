package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.services;

import org.owasp.html.Sanitizers;
import org.owasp.html.PolicyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlSanitizerExample {
    private static final Logger logger = LoggerFactory.getLogger(HtmlSanitizerExample.class);

    public static void main(String[] args) {
        String untrustedHTML = "<a href='http://example.com'>Click here</a><script>alert('XSS')</script>";
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String safeHTML = policy.sanitize(untrustedHTML);
        logger.info("Sanitized HTML: {}", safeHTML);
    }
}
