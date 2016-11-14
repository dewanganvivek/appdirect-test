/**
 * 
 */
package org.vivektest.services;

import java.util.List;

import org.vivektest.vo.NotificationVO;

/**
 * This represents the user service and support operations CRUD on users.
 *
 */
public interface NotificationService {
	
	public List<NotificationVO> getNotificationsList();
	
	public NotificationVO getNotification(int notificationId);
	
	public boolean create(NotificationVO userVO);
	
	public NotificationVO read(int notificationId);
	
	public NotificationVO read(String eventUrl);
	
	public boolean update(NotificationVO notificationVO);
	
	public NotificationVO getNotification(String notificationName);
	
	public boolean removeBySubscriptionName(String eventUrl);
	
}
