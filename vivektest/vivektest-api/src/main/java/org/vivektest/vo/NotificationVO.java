/**
 * 
 */
package org.vivektest.vo;

import java.util.Date;

/**
 * @author Dewangan
 *
 */
public class NotificationVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	protected int notificationId;
	protected String notificationName;
	protected String subscriptionName;

	public NotificationVO() {
		super();
	}

	public NotificationVO(int notificationId, String notificationName,
			String subscriptionName,String createdBy, Date createdTime,
			String updatedBy, Date updatedTime) {
		super(createdBy, createdTime, updatedBy, updatedTime);
		this.notificationId = notificationId;
		this.notificationName = notificationName;
		this.subscriptionName = subscriptionName;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}
	
	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((subscriptionName == null) ? 0 : subscriptionName.hashCode());
		result = prime * result + notificationId;
		result = prime * result + ((notificationName == null) ? 0 : notificationName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationVO other = (NotificationVO) obj;
		if (subscriptionName == null) {
			if (other.subscriptionName != null)
				return false;
		} else if (!subscriptionName.equals(other.subscriptionName))
			return false;
		if (notificationId != other.notificationId)
			return false;
		if (notificationName == null) {
			if (other.notificationName != null)
				return false;
		} else if (!notificationName.equals(other.notificationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserVO [notificationId=" + notificationId + ", notificationName=" + notificationName + ", subscriptionName=" + subscriptionName + "]";
	}

}
