package es.grise.upm.profundizacion.subscriptionService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SubscriptionServiceTest {
    private SubscriptionService servicio;


    private User userLocal;
    private User userNoDelivery;

    @BeforeEach
    void setup() {
        servicio = new SubscriptionService();
        userLocal = new User(); 
        userNoDelivery = new User();
        userLocal.delivery = Delivery.LOCAL;
        userNoDelivery.delivery = Delivery.DO_NOT_DELIVER;
    }

    @Test
    void testAñadirUsuarioSinExcepcion() {
        servicio.addSubscriber(userLocal);
        Collection<User> subscribers = servicio.getSubscribers();
        assertTrue(subscribers.contains(userLocal));
    }

    @Test
    void testAñadirUsuarioNull() {
        assertThrows(NullPointerException.class, () -> servicio.addSubscriber(null));
    }

    @Test
    void testAñadirUsuarioDuplicado() {
        servicio.addSubscriber(userLocal);
        assertThrows(IllegalArgumentException.class, () -> servicio.addSubscriber(userLocal));
    }

    @Test
    void testUsuarioLocalSinEmail() {
        assertThrows(LocalUserDoesNotHaveNullMailException.class, () -> servicio.addSubscriber(userLocal));
    }   

    
}