/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicus.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.EmployerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Employer service. Represents a row in the &quot;Medicus_Employer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link EmployerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployerImpl
 * @see Employer
 * @see EmployerModel
 * @generated
 */
@ProviderType
public class EmployerModelImpl extends BaseModelImpl<Employer>
	implements EmployerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employer model instance should use the {@link Employer} interface instead.
	 */
	public static final String TABLE_NAME = "Medicus_Employer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "employerId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "employerOrgId", Types.BIGINT },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "zipcode", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "contactPersonName", Types.VARCHAR },
			{ "contactPersonEmail", Types.VARCHAR },
			{ "contactPersonPhoneNumber", Types.VARCHAR },
			{ "websiteLink", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employerOrgId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("address1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipcode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("country", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonPhoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("websiteLink", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Medicus_Employer (employerId LONG not null primary key,userId LONG,employerOrgId LONG,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,zipcode VARCHAR(75) null,state_ VARCHAR(75) null,country VARCHAR(75) null,contactPersonName VARCHAR(75) null,contactPersonEmail VARCHAR(75) null,contactPersonPhoneNumber VARCHAR(75) null,websiteLink VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Medicus_Employer";
	public static final String ORDER_BY_JPQL = " ORDER BY employer.employerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Medicus_Employer.employerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.medicus.common.service.model.Employer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.medicus.common.service.model.Employer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.medicus.common.service.model.Employer"),
			true);
	public static final long USERID_COLUMN_BITMASK = 1L;
	public static final long EMPLOYERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.medicus.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.medicus.common.service.model.Employer"));

	public EmployerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employer.class;
	}

	@Override
	public String getModelClassName() {
		return Employer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employerId", getEmployerId());
		attributes.put("userId", getUserId());
		attributes.put("employerOrgId", getEmployerOrgId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("contactPersonPhoneNumber", getContactPersonPhoneNumber());
		attributes.put("websiteLink", getWebsiteLink());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employerId = (Long)attributes.get("employerId");

		if (employerId != null) {
			setEmployerId(employerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long employerOrgId = (Long)attributes.get("employerOrgId");

		if (employerOrgId != null) {
			setEmployerOrgId(employerOrgId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		String contactPersonPhoneNumber = (String)attributes.get(
				"contactPersonPhoneNumber");

		if (contactPersonPhoneNumber != null) {
			setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		String websiteLink = (String)attributes.get("websiteLink");

		if (websiteLink != null) {
			setWebsiteLink(websiteLink);
		}
	}

	@Override
	public long getEmployerId() {
		return _employerId;
	}

	@Override
	public void setEmployerId(long employerId) {
		_employerId = employerId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getEmployerOrgId() {
		return _employerOrgId;
	}

	@Override
	public void setEmployerOrgId(long employerOrgId) {
		_employerOrgId = employerOrgId;
	}

	@Override
	public String getAddress1() {
		if (_address1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address1;
		}
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;
	}

	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;
	}

	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@Override
	public String getZipcode() {
		if (_zipcode == null) {
			return StringPool.BLANK;
		}
		else {
			return _zipcode;
		}
	}

	@Override
	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	@Override
	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@Override
	public String getContactPersonName() {
		if (_contactPersonName == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonName;
		}
	}

	@Override
	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	@Override
	public String getContactPersonEmail() {
		if (_contactPersonEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonEmail;
		}
	}

	@Override
	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	@Override
	public String getContactPersonPhoneNumber() {
		if (_contactPersonPhoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonPhoneNumber;
		}
	}

	@Override
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		_contactPersonPhoneNumber = contactPersonPhoneNumber;
	}

	@Override
	public String getWebsiteLink() {
		if (_websiteLink == null) {
			return StringPool.BLANK;
		}
		else {
			return _websiteLink;
		}
	}

	@Override
	public void setWebsiteLink(String websiteLink) {
		_websiteLink = websiteLink;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Employer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employer toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Employer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployerImpl employerImpl = new EmployerImpl();

		employerImpl.setEmployerId(getEmployerId());
		employerImpl.setUserId(getUserId());
		employerImpl.setEmployerOrgId(getEmployerOrgId());
		employerImpl.setAddress1(getAddress1());
		employerImpl.setAddress2(getAddress2());
		employerImpl.setCity(getCity());
		employerImpl.setZipcode(getZipcode());
		employerImpl.setState(getState());
		employerImpl.setCountry(getCountry());
		employerImpl.setContactPersonName(getContactPersonName());
		employerImpl.setContactPersonEmail(getContactPersonEmail());
		employerImpl.setContactPersonPhoneNumber(getContactPersonPhoneNumber());
		employerImpl.setWebsiteLink(getWebsiteLink());

		employerImpl.resetOriginalValues();

		return employerImpl;
	}

	@Override
	public int compareTo(Employer employer) {
		long primaryKey = employer.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Employer)) {
			return false;
		}

		Employer employer = (Employer)obj;

		long primaryKey = employer.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		EmployerModelImpl employerModelImpl = this;

		employerModelImpl._originalUserId = employerModelImpl._userId;

		employerModelImpl._setOriginalUserId = false;

		employerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Employer> toCacheModel() {
		EmployerCacheModel employerCacheModel = new EmployerCacheModel();

		employerCacheModel.employerId = getEmployerId();

		employerCacheModel.userId = getUserId();

		employerCacheModel.employerOrgId = getEmployerOrgId();

		employerCacheModel.address1 = getAddress1();

		String address1 = employerCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			employerCacheModel.address1 = null;
		}

		employerCacheModel.address2 = getAddress2();

		String address2 = employerCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			employerCacheModel.address2 = null;
		}

		employerCacheModel.city = getCity();

		String city = employerCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			employerCacheModel.city = null;
		}

		employerCacheModel.zipcode = getZipcode();

		String zipcode = employerCacheModel.zipcode;

		if ((zipcode != null) && (zipcode.length() == 0)) {
			employerCacheModel.zipcode = null;
		}

		employerCacheModel.state = getState();

		String state = employerCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			employerCacheModel.state = null;
		}

		employerCacheModel.country = getCountry();

		String country = employerCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			employerCacheModel.country = null;
		}

		employerCacheModel.contactPersonName = getContactPersonName();

		String contactPersonName = employerCacheModel.contactPersonName;

		if ((contactPersonName != null) && (contactPersonName.length() == 0)) {
			employerCacheModel.contactPersonName = null;
		}

		employerCacheModel.contactPersonEmail = getContactPersonEmail();

		String contactPersonEmail = employerCacheModel.contactPersonEmail;

		if ((contactPersonEmail != null) && (contactPersonEmail.length() == 0)) {
			employerCacheModel.contactPersonEmail = null;
		}

		employerCacheModel.contactPersonPhoneNumber = getContactPersonPhoneNumber();

		String contactPersonPhoneNumber = employerCacheModel.contactPersonPhoneNumber;

		if ((contactPersonPhoneNumber != null) &&
				(contactPersonPhoneNumber.length() == 0)) {
			employerCacheModel.contactPersonPhoneNumber = null;
		}

		employerCacheModel.websiteLink = getWebsiteLink();

		String websiteLink = employerCacheModel.websiteLink;

		if ((websiteLink != null) && (websiteLink.length() == 0)) {
			employerCacheModel.websiteLink = null;
		}

		return employerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employerId=");
		sb.append(getEmployerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", employerOrgId=");
		sb.append(getEmployerOrgId());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zipcode=");
		sb.append(getZipcode());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", contactPersonName=");
		sb.append(getContactPersonName());
		sb.append(", contactPersonEmail=");
		sb.append(getContactPersonEmail());
		sb.append(", contactPersonPhoneNumber=");
		sb.append(getContactPersonPhoneNumber());
		sb.append(", websiteLink=");
		sb.append(getWebsiteLink());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.medicus.common.service.model.Employer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employerId</column-name><column-value><![CDATA[");
		sb.append(getEmployerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employerOrgId</column-name><column-value><![CDATA[");
		sb.append(getEmployerOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipcode</column-name><column-value><![CDATA[");
		sb.append(getZipcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonName</column-name><column-value><![CDATA[");
		sb.append(getContactPersonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonEmail</column-name><column-value><![CDATA[");
		sb.append(getContactPersonEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonPhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getContactPersonPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>websiteLink</column-name><column-value><![CDATA[");
		sb.append(getWebsiteLink());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Employer.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Employer.class
		};
	private long _employerId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _employerOrgId;
	private String _address1;
	private String _address2;
	private String _city;
	private String _zipcode;
	private String _state;
	private String _country;
	private String _contactPersonName;
	private String _contactPersonEmail;
	private String _contactPersonPhoneNumber;
	private String _websiteLink;
	private long _columnBitmask;
	private Employer _escapedModel;
}