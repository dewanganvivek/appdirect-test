/**
 * 
 */
package org.vivektest.mapper.impl;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.vivektest.helper.StringHelper;
import org.vivektest.hibernate.model.Notification;
import org.vivektest.hibernate.model.Notification;
import org.vivektest.mapper.BaseMapper;
import org.vivektest.vo.NotificationVO;

/**
 * @author Dewangan
 *
 */
@Component("NotificationMapper")
public class NotificationVOMapper implements BaseMapper<NotificationVO, Notification> {

	public NotificationVOMapper() {
		super();
	}

	@Override
	public NotificationVO map(Notification source) {
		NotificationVO notificationVo = new NotificationVO();
		if (source != null) {
			if (source.getNotificationId() > 0) {
				notificationVo.setNotificationId(source.getNotificationId());
			}
			if (!StringHelper.isEmpty(source.getNotificationName())) {
				notificationVo.setNotificationName(source.getNotificationName());
			}
			if (!StringHelper.isEmpty(source.getSubscriptionName())) {
				notificationVo.setSubscriptionName(source.getSubscriptionName());
			}
			if (!StringHelper.isEmpty(source.getCreatedBy())) {
				notificationVo.setCreatedBy(source.getCreatedBy());
			}
			if (!StringHelper.isEmpty(source.getUpdatedBy())) {
				notificationVo.setUpdatedBy(source.getUpdatedBy());
			}
			if (source.getCreatedTime() != null) {
				notificationVo.setCreatedTime(source.getCreatedTime());
			} 
			if (source.getUpdatedTime() != null) {
				notificationVo.setUpdatedTime(source.getUpdatedTime());
			} 
		}

		return notificationVo;
	}
	
	@Override
	public Notification reverseMap(NotificationVO source) {
		Notification notification = new Notification();
		if (source != null) {
			if (source.getNotificationId() > 0) {
				notification.setNotificationId(source.getNotificationId());
			}
			if (!StringHelper.isEmpty(source.getNotificationName())) {
				notification.setNotificationName(source.getNotificationName());
			}
			if (!StringHelper.isEmpty(source.getSubscriptionName())) {
				notification.setSubscriptionName(source.getSubscriptionName());
			}
			if (!StringHelper.isEmpty(source.getCreatedBy())) {
				notification.setCreatedBy(source.getCreatedBy());
			}
			if (!StringHelper.isEmpty(source.getUpdatedBy())) {
				notification.setUpdatedBy(source.getUpdatedBy());
			}
			if (source.getCreatedTime() != null) {
				notification.setCreatedTime(source.getCreatedTime());
			} else {
				notification.setCreatedTime(new Date());
			}
			if (source.getUpdatedTime() != null) {
				notification.setUpdatedTime(source.getUpdatedTime());
			} else {
				notification.setUpdatedTime(new Date());
			}
		}

		return notification;
	}

}
