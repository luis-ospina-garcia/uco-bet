package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.services;

import org.owasp.html.Sanitizers;
import org.owasp.html.PolicyFactory;

public class HtmlSanitizerExample {
    public static void main(String[] args) {
        String untrustedHTML = "<a href='http://example.com'>Click here</a><script>alert('XSS')</script>";
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String safeHTML = policy.sanitize(untrustedHTML);
        System.out.println(safeHTML);
    }
}