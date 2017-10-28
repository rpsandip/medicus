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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.CampusModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Campus service. Represents a row in the &quot;Medicus_Campus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CampusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampusImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampusImpl
 * @see Campus
 * @see CampusModel
 * @generated
 */
@ProviderType
public class CampusModelImpl extends BaseModelImpl<Campus>
	implements CampusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campus model instance should use the {@link Campus} interface instead.
	 */
	public static final String TABLE_NAME = "Medicus_Campus";
	public static final Object[][] TABLE_COLUMNS = {
			{ "campusId", Types.BIGINT },
			{ "schoolId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "zipcode", Types.VARCHAR },
			{ "contactNumber", Types.VARCHAR },
			{ "websiteLink", Types.VARCHAR },
			{ "contactPersonName", Types.VARCHAR },
			{ "contactPersonPhoneNumber", Types.VARCHAR },
			{ "contactPersonEmail", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("campusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("schoolId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("country", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipcode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("websiteLink", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonPhoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table Medicus_Campus (campusId LONG not null primary key,schoolId LONG,name VARCHAR(100) null,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(15) null,state_ VARCHAR(15) null,country VARCHAR(15) null,zipcode VARCHAR(6) null,contactNumber VARCHAR(15) null,websiteLink VARCHAR(100) null,contactPersonName VARCHAR(50) null,contactPersonPhoneNumber VARCHAR(15) null,contactPersonEmail VARCHAR(30) null,status INTEGER,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table Medicus_Campus";
	public static final String ORDER_BY_JPQL = " ORDER BY campus.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Medicus_Campus.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.medicus.common.service.model.Campus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.medicus.common.service.model.Campus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.medicus.common.service.model.Campus"),
			true);
	public static final long NAME_COLUMN_BITMASK = 1L;
	public static final long SCHOOLID_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.medicus.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.medicus.common.service.model.Campus"));

	public CampusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _campusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Campus.class;
	}

	@Override
	public String getModelClassName() {
		return Campus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campusId", getCampusId());
		attributes.put("schoolId", getSchoolId());
		attributes.put("name", getName());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("zipcode", getZipcode());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("websiteLink", getWebsiteLink());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonPhoneNumber", getContactPersonPhoneNumber());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campusId = (Long)attributes.get("campusId");

		if (campusId != null) {
			setCampusId(campusId);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String websiteLink = (String)attributes.get("websiteLink");

		if (websiteLink != null) {
			setWebsiteLink(websiteLink);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonPhoneNumber = (String)attributes.get(
				"contactPersonPhoneNumber");

		if (contactPersonPhoneNumber != null) {
			setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public long getCampusId() {
		return _campusId;
	}

	@Override
	public void setCampusId(long campusId) {
		_campusId = campusId;
	}

	@Override
	public long getSchoolId() {
		return _schoolId;
	}

	@Override
	public void setSchoolId(long schoolId) {
		_columnBitmask |= SCHOOLID_COLUMN_BITMASK;

		if (!_setOriginalSchoolId) {
			_setOriginalSchoolId = true;

			_originalSchoolId = _schoolId;
		}

		_schoolId = schoolId;
	}

	public long getOriginalSchoolId() {
		return _originalSchoolId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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
	public String getContactNumber() {
		if (_contactNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactNumber;
		}
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
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
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Campus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Campus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Campus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CampusImpl campusImpl = new CampusImpl();

		campusImpl.setCampusId(getCampusId());
		campusImpl.setSchoolId(getSchoolId());
		campusImpl.setName(getName());
		campusImpl.setAddress1(getAddress1());
		campusImpl.setAddress2(getAddress2());
		campusImpl.setCity(getCity());
		campusImpl.setState(getState());
		campusImpl.setCountry(getCountry());
		campusImpl.setZipcode(getZipcode());
		campusImpl.setContactNumber(getContactNumber());
		campusImpl.setWebsiteLink(getWebsiteLink());
		campusImpl.setContactPersonName(getContactPersonName());
		campusImpl.setContactPersonPhoneNumber(getContactPersonPhoneNumber());
		campusImpl.setContactPersonEmail(getContactPersonEmail());
		campusImpl.setStatus(getStatus());
		campusImpl.setCreateDate(getCreateDate());
		campusImpl.setCreatedBy(getCreatedBy());
		campusImpl.setModifiedDate(getModifiedDate());
		campusImpl.setModifiedBy(getModifiedBy());

		campusImpl.resetOriginalValues();

		return campusImpl;
	}

	@Override
	public int compareTo(Campus campus) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), campus.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Campus)) {
			return false;
		}

		Campus campus = (Campus)obj;

		long primaryKey = campus.getPrimaryKey();

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
		CampusModelImpl campusModelImpl = this;

		campusModelImpl._originalSchoolId = campusModelImpl._schoolId;

		campusModelImpl._setOriginalSchoolId = false;

		campusModelImpl._originalName = campusModelImpl._name;

		campusModelImpl._setModifiedDate = false;

		campusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Campus> toCacheModel() {
		CampusCacheModel campusCacheModel = new CampusCacheModel();

		campusCacheModel.campusId = getCampusId();

		campusCacheModel.schoolId = getSchoolId();

		campusCacheModel.name = getName();

		String name = campusCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			campusCacheModel.name = null;
		}

		campusCacheModel.address1 = getAddress1();

		String address1 = campusCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			campusCacheModel.address1 = null;
		}

		campusCacheModel.address2 = getAddress2();

		String address2 = campusCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			campusCacheModel.address2 = null;
		}

		campusCacheModel.city = getCity();

		String city = campusCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			campusCacheModel.city = null;
		}

		campusCacheModel.state = getState();

		String state = campusCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			campusCacheModel.state = null;
		}

		campusCacheModel.country = getCountry();

		String country = campusCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			campusCacheModel.country = null;
		}

		campusCacheModel.zipcode = getZipcode();

		String zipcode = campusCacheModel.zipcode;

		if ((zipcode != null) && (zipcode.length() == 0)) {
			campusCacheModel.zipcode = null;
		}

		campusCacheModel.contactNumber = getContactNumber();

		String contactNumber = campusCacheModel.contactNumber;

		if ((contactNumber != null) && (contactNumber.length() == 0)) {
			campusCacheModel.contactNumber = null;
		}

		campusCacheModel.websiteLink = getWebsiteLink();

		String websiteLink = campusCacheModel.websiteLink;

		if ((websiteLink != null) && (websiteLink.length() == 0)) {
			campusCacheModel.websiteLink = null;
		}

		campusCacheModel.contactPersonName = getContactPersonName();

		String contactPersonName = campusCacheModel.contactPersonName;

		if ((contactPersonName != null) && (contactPersonName.length() == 0)) {
			campusCacheModel.contactPersonName = null;
		}

		campusCacheModel.contactPersonPhoneNumber = getContactPersonPhoneNumber();

		String contactPersonPhoneNumber = campusCacheModel.contactPersonPhoneNumber;

		if ((contactPersonPhoneNumber != null) &&
				(contactPersonPhoneNumber.length() == 0)) {
			campusCacheModel.contactPersonPhoneNumber = null;
		}

		campusCacheModel.contactPersonEmail = getContactPersonEmail();

		String contactPersonEmail = campusCacheModel.contactPersonEmail;

		if ((contactPersonEmail != null) && (contactPersonEmail.length() == 0)) {
			campusCacheModel.contactPersonEmail = null;
		}

		campusCacheModel.status = getStatus();

		Date createDate = getCreateDate();

		if (createDate != null) {
			campusCacheModel.createDate = createDate.getTime();
		}
		else {
			campusCacheModel.createDate = Long.MIN_VALUE;
		}

		campusCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			campusCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			campusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		campusCacheModel.modifiedBy = getModifiedBy();

		return campusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{campusId=");
		sb.append(getCampusId());
		sb.append(", schoolId=");
		sb.append(getSchoolId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", zipcode=");
		sb.append(getZipcode());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", websiteLink=");
		sb.append(getWebsiteLink());
		sb.append(", contactPersonName=");
		sb.append(getContactPersonName());
		sb.append(", contactPersonPhoneNumber=");
		sb.append(getContactPersonPhoneNumber());
		sb.append(", contactPersonEmail=");
		sb.append(getContactPersonEmail());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.medicus.common.service.model.Campus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campusId</column-name><column-value><![CDATA[");
		sb.append(getCampusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schoolId</column-name><column-value><![CDATA[");
		sb.append(getSchoolId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipcode</column-name><column-value><![CDATA[");
		sb.append(getZipcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>websiteLink</column-name><column-value><![CDATA[");
		sb.append(getWebsiteLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonName</column-name><column-value><![CDATA[");
		sb.append(getContactPersonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonPhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getContactPersonPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonEmail</column-name><column-value><![CDATA[");
		sb.append(getContactPersonEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Campus.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Campus.class
		};
	private long _campusId;
	private long _schoolId;
	private long _originalSchoolId;
	private boolean _setOriginalSchoolId;
	private String _name;
	private String _originalName;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _country;
	private String _zipcode;
	private String _contactNumber;
	private String _websiteLink;
	private String _contactPersonName;
	private String _contactPersonPhoneNumber;
	private String _contactPersonEmail;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _columnBitmask;
	private Campus _escapedModel;
}