/**
 * 
 */
package org.vivektest.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * This is a base class of all the business Value Objects.
 * 
 * @version 1.0
 * @since 1.0
 *
 */
public class BaseVO implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	protected String createdBy;
	protected Date createdTime;
	protected String updatedBy;
	protected Date updatedTime;

	public BaseVO() {
		super();
	}

	public BaseVO(String createdBy, Date createdTime, String updatedBy,
			Date updatedTime) {
		super();
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + createdBy.hashCode();
		result = prime * result
				+ ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + updatedBy.hashCode();
		result = prime * result
				+ ((updatedTime == null) ? 0 : updatedTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseVO other = (BaseVO) obj;
		if (createdBy != other.createdBy)
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (updatedTime == null) {
			if (other.updatedTime != null)
				return false;
		} else if (!updatedTime.equals(other.updatedTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MetadaraBaseVO [createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", updatedBy=" + updatedBy + ", updatedTime="
				+ updatedTime + "]";
	}

}
