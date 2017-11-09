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

import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.PartnerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Partner service. Represents a row in the &quot;Medicus_Partner&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PartnerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PartnerImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see PartnerImpl
 * @see Partner
 * @see PartnerModel
 * @generated
 */
@ProviderType
public class PartnerModelImpl extends BaseModelImpl<Partner>
	implements PartnerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a partner model instance should use the {@link Partner} interface instead.
	 */
	public static final String TABLE_NAME = "Medicus_Partner";
	public static final Object[][] TABLE_COLUMNS = {
			{ "partnerId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "partnerOrgId", Types.BIGINT },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "zipcode", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "contactPersonName", Types.VARCHAR },
			{ "contactPersonEmail", Types.VARCHAR },
			{ "contactPersonPhoneNumber", Types.VARCHAR },
			{ "websiteLink", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("partnerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("partnerOrgId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table Medicus_Partner (partnerId LONG not null primary key,userId LONG,partnerOrgId LONG,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,zipcode VARCHAR(75) null,state_ VARCHAR(75) null,country VARCHAR(75) null,contactPersonName VARCHAR(75) null,contactPersonEmail VARCHAR(75) null,contactPersonPhoneNumber VARCHAR(75) null,websiteLink VARCHAR(75) null,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table Medicus_Partner";
	public static final String ORDER_BY_JPQL = " ORDER BY partner.partnerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Medicus_Partner.partnerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.medicus.common.service.model.Partner"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.medicus.common.service.model.Partner"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.medicus.common.service.model.Partner"),
			true);
	public static final long USERID_COLUMN_BITMASK = 1L;
	public static final long PARTNERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.medicus.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.medicus.common.service.model.Partner"));

	public PartnerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _partnerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPartnerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _partnerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Partner.class;
	}

	@Override
	public String getModelClassName() {
		return Partner.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partnerId", getPartnerId());
		attributes.put("userId", getUserId());
		attributes.put("partnerOrgId", getPartnerOrgId());
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
		Long partnerId = (Long)attributes.get("partnerId");

		if (partnerId != null) {
			setPartnerId(partnerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long partnerOrgId = (Long)attributes.get("partnerOrgId");

		if (partnerOrgId != null) {
			setPartnerOrgId(partnerOrgId);
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
	public long getPartnerId() {
		return _partnerId;
	}

	@Override
	public void setPartnerId(long partnerId) {
		_partnerId = partnerId;
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
	public long getPartnerOrgId() {
		return _partnerOrgId;
	}

	@Override
	public void setPartnerOrgId(long partnerOrgId) {
		_partnerOrgId = partnerOrgId;
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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
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
			Partner.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Partner toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Partner)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PartnerImpl partnerImpl = new PartnerImpl();

		partnerImpl.setPartnerId(getPartnerId());
		partnerImpl.setUserId(getUserId());
		partnerImpl.setPartnerOrgId(getPartnerOrgId());
		partnerImpl.setAddress1(getAddress1());
		partnerImpl.setAddress2(getAddress2());
		partnerImpl.setCity(getCity());
		partnerImpl.setZipcode(getZipcode());
		partnerImpl.setState(getState());
		partnerImpl.setCountry(getCountry());
		partnerImpl.setContactPersonName(getContactPersonName());
		partnerImpl.setContactPersonEmail(getContactPersonEmail());
		partnerImpl.setContactPersonPhoneNumber(getContactPersonPhoneNumber());
		partnerImpl.setWebsiteLink(getWebsiteLink());
		partnerImpl.setCreateDate(getCreateDate());
		partnerImpl.setCreatedBy(getCreatedBy());
		partnerImpl.setModifiedDate(getModifiedDate());
		partnerImpl.setModifiedBy(getModifiedBy());

		partnerImpl.resetOriginalValues();

		return partnerImpl;
	}

	@Override
	public int compareTo(Partner partner) {
		long primaryKey = partner.getPrimaryKey();

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

		if (!(obj instanceof Partner)) {
			return false;
		}

		Partner partner = (Partner)obj;

		long primaryKey = partner.getPrimaryKey();

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
		PartnerModelImpl partnerModelImpl = this;

		partnerModelImpl._originalUserId = partnerModelImpl._userId;

		partnerModelImpl._setOriginalUserId = false;

		partnerModelImpl._setModifiedDate = false;

		partnerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Partner> toCacheModel() {
		PartnerCacheModel partnerCacheModel = new PartnerCacheModel();

		partnerCacheModel.partnerId = getPartnerId();

		partnerCacheModel.userId = getUserId();

		partnerCacheModel.partnerOrgId = getPartnerOrgId();

		partnerCacheModel.address1 = getAddress1();

		String address1 = partnerCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			partnerCacheModel.address1 = null;
		}

		partnerCacheModel.address2 = getAddress2();

		String address2 = partnerCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			partnerCacheModel.address2 = null;
		}

		partnerCacheModel.city = getCity();

		String city = partnerCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			partnerCacheModel.city = null;
		}

		partnerCacheModel.zipcode = getZipcode();

		String zipcode = partnerCacheModel.zipcode;

		if ((zipcode != null) && (zipcode.length() == 0)) {
			partnerCacheModel.zipcode = null;
		}

		partnerCacheModel.state = getState();

		String state = partnerCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			partnerCacheModel.state = null;
		}

		partnerCacheModel.country = getCountry();

		String country = partnerCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			partnerCacheModel.country = null;
		}

		partnerCacheModel.contactPersonName = getContactPersonName();

		String contactPersonName = partnerCacheModel.contactPersonName;

		if ((contactPersonName != null) && (contactPersonName.length() == 0)) {
			partnerCacheModel.contactPersonName = null;
		}

		partnerCacheModel.contactPersonEmail = getContactPersonEmail();

		String contactPersonEmail = partnerCacheModel.contactPersonEmail;

		if ((contactPersonEmail != null) && (contactPersonEmail.length() == 0)) {
			partnerCacheModel.contactPersonEmail = null;
		}

		partnerCacheModel.contactPersonPhoneNumber = getContactPersonPhoneNumber();

		String contactPersonPhoneNumber = partnerCacheModel.contactPersonPhoneNumber;

		if ((contactPersonPhoneNumber != null) &&
				(contactPersonPhoneNumber.length() == 0)) {
			partnerCacheModel.contactPersonPhoneNumber = null;
		}

		partnerCacheModel.websiteLink = getWebsiteLink();

		String websiteLink = partnerCacheModel.websiteLink;

		if ((websiteLink != null) && (websiteLink.length() == 0)) {
			partnerCacheModel.websiteLink = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			partnerCacheModel.createDate = createDate.getTime();
		}
		else {
			partnerCacheModel.createDate = Long.MIN_VALUE;
		}

		partnerCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			partnerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			partnerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		partnerCacheModel.modifiedBy = getModifiedBy();

		return partnerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{partnerId=");
		sb.append(getPartnerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", partnerOrgId=");
		sb.append(getPartnerOrgId());
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
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.medicus.common.service.model.Partner");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>partnerId</column-name><column-value><![CDATA[");
		sb.append(getPartnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partnerOrgId</column-name><column-value><![CDATA[");
		sb.append(getPartnerOrgId());
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

	private static final ClassLoader _classLoader = Partner.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Partner.class
		};
	private long _partnerId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _partnerOrgId;
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
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _columnBitmask;
	private Partner _escapedModel;
}