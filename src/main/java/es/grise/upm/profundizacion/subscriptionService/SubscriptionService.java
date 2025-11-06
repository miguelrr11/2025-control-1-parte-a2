package es.grise.upm.profundizacion.subscriptionService;

import java.util.ArrayList;
import java.util.Collection;

public class SubscriptionService {

	private Collection <User> subscribers;
	private Delivery delivery;
	
	/*
	 * Constructor
	 */
	public SubscriptionService(Delivery delivery) {
        this.delivery = delivery;
        this.subscribers = new ArrayList<>();
    }

	/*
	 * Method to code
	 */
	public void addSubscriber(User user) {
		if (user == null){
            throw new NullPointerException("Error: null user");
		}

        if (subscribers.contains(user)){
            throw new IllegalArgumentException("Error: user already exists");
		}

        if (user.getDelivery() == Delivery.LOCAL && user.getEmail() == null){
            throw new LocalUserDoesNotHaveNullMailException("Local user must have null email");
		}
		
		else subscribers.add(user);
	}
	
	/*
	 * Other setters & getters
	 */
	public Collection <User> getSubscribers() {
		return subscribers;
	}

}
