/**
 * 
 */
package org.vivektest.appdirect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vivektest.services.NotificationService;
import org.vivektest.vo.NotificationVO;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

/**
 * This is a controller for connection specific stuff.
 * 
 * @version 1.0
 * @since 1.0
 *
 */
@RestController
public class VivekTestCRUDController {

	private static final Logger logger = new LoggerContext()
			.getLogger(VivekTestCRUDController.class);

	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "/create/notification/{notificationName}/{eventUrl}/{user}", method = RequestMethod.GET)
	public @ResponseBody boolean create(@PathVariable("notificationName") String notificationName, @PathVariable("eventUrl") String eventUrl, @PathVariable("user") String user) {
		logger.debug("Creating notification for subscription details");
		NotificationVO notificationVO = new NotificationVO();
		notificationVO.setNotificationName(notificationName);
		notificationVO.setSubscriptionName(eventUrl);
		notificationVO.setCreatedBy(user);
		notificationVO.setUpdatedBy(user);
		
		return notificationService.create(notificationVO);
	}

	@RequestMapping(value = "/read/notification/{eventUrl}", method = RequestMethod.GET)
	public void read(
			@PathVariable("eventUrl") String eventUrl) {
		logger.debug("Fetching notification details");
		notificationService.read(eventUrl);
	}
	
	@RequestMapping(value = "/update/notification/{notificationId}/{notificationName}/{eventUrl}/{user}", method = RequestMethod.GET)
	public void update(@PathVariable("notificationId") int notificationId, @PathVariable("notificationName") String notificationName, @PathVariable("eventUrl") String eventUrl, @PathVariable("user") String user) {
		logger.debug("Updating notification details");
		NotificationVO notificationVO = new NotificationVO();
		notificationVO.setNotificationId(notificationId);
		notificationVO.setNotificationName(notificationName);
		notificationVO.setSubscriptionName(eventUrl);
		notificationVO.setCreatedBy(user);
		notificationVO.setUpdatedBy(user);
		notificationService.update(notificationVO);
	}
	
	@RequestMapping(value = "/delete/notification/{eventUrl}", method = RequestMethod.GET)
	public void delete(
			@PathVariable("eventUrl") final String eventUrl) {
		logger.debug("Deleting notification details of a User");
		notificationService.removeBySubscriptionName(eventUrl);
	}
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public @ResponseBody String health() {
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/info/notification", method = RequestMethod.GET)
	public @ResponseBody String info() {
		return "Notification Service";
	}

}
