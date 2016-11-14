/**
 * 
 */
package org.vivektest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.vivektest.hibernate.model.Notification;

/**
 * @author Dewangan
 *
 */
public interface NotificationRepository extends
		CrudRepository<Notification, Integer> {

	public List<Notification> findAll();

	public Notification findByNotificationName(String notificationName);
	
	public Notification findBySubscriptionName(String subscriptionName);

	public Notification findByNotificationId(Integer notificationId);
	
	public Notification findBy(String NotificationEmail);
	
	@SuppressWarnings("unchecked")
	public Notification save(Notification Notification);
	
	public Long removeByNotificationId(Integer NotificationId);
	
	public Long removeByNotificationName(String NotificationName);
	
	public Long removeBySubscriptionName(String subscriptionName);

}
