package es.grise.upm.profundizacion.subscriptionService;

public class LocalUserDoesNotHaveNullMailException extends RuntimeException {
    public LocalUserDoesNotHaveNullMailException(String message) {
        super(message);
    }
}
