/**
 * 
 */
package org.vivektest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vivektest.hibernate.model.Notification;
import org.vivektest.mapper.BaseMapper;
import org.vivektest.repositories.NotificationRepository;
import org.vivektest.services.NotificationService;
import org.vivektest.vo.NotificationVO;

/**
 * This is actual implementation of Notification Service.
 * 
 * @version 1.0
 * @since 1.0
 *
 */
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	@Qualifier("NotificationMapper")
	private BaseMapper<NotificationVO, Notification> notificationMapper;

	public NotificationServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.vivektest.services.NotificationService#getNotificationsList()
	 */
	@Override
	public List<NotificationVO> getNotificationsList() {
		List<Notification> NotificationList = notificationRepository.findAll();
		List<NotificationVO> NotificationVos = new ArrayList<NotificationVO>();
		for (Notification Notification : NotificationList) {
			NotificationVos.add(notificationMapper.map(Notification));
		}
		return NotificationVos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.vivektest.services.NotificationService#getNotification(int)
	 */
	@Override
	public NotificationVO getNotification(int NotificationId) {
		return notificationMapper.map(notificationRepository.findByNotificationId(NotificationId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.vivektest.services.NotificationService#getNotification(java.lang.String)
	 */
	@Override
	public NotificationVO read(String eventUrl) {
		return notificationMapper.map(notificationRepository.findBySubscriptionName(eventUrl));
	}

	@Override
	public boolean create(NotificationVO NotificationVO) {
		Notification notification = notificationRepository.save(notificationMapper.reverseMap(NotificationVO));
		if (notification != null)
			return true;
		return false;
	}

	@Override
	public NotificationVO read(int NotificationId) {
		return notificationMapper.map(notificationRepository.findByNotificationId(NotificationId));
	}

	@Override
	public boolean update(NotificationVO NotificationVO) {
		Notification notification = notificationRepository.save(notificationMapper.reverseMap(NotificationVO));
		if (notification != null)
			return true;
		return false;
	}

	@Override
	public NotificationVO getNotification(String NotificationName) {
		return notificationMapper.map(notificationRepository.findByNotificationName(NotificationName));
	}

	@Override
	public boolean removeBySubscriptionName(String eventUrl) {
		Long count = notificationRepository.removeBySubscriptionName(eventUrl);
		return true;
	}
	
	


	
}
