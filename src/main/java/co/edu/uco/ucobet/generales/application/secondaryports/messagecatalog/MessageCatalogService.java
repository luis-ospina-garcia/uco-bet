package co.edu.uco.ucobet.generales.application.secondaryports.messagecatalog;

public interface MessageCatalogService {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}