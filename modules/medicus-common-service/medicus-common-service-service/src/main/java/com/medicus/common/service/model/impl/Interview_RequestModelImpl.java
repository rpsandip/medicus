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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Interview_RequestModel;
import com.medicus.common.service.service.persistence.Interview_RequestPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Interview_Request service. Represents a row in the &quot;Medicus_Interview_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link Interview_RequestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Interview_RequestImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Interview_RequestImpl
 * @see Interview_Request
 * @see Interview_RequestModel
 * @generated
 */
@ProviderType
public class Interview_RequestModelImpl extends BaseModelImpl<Interview_Request>
	implements Interview_RequestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a interview_ request model instance should use the {@link Interview_Request} interface instead.
	 */
	public static final String TABLE_NAME = "Medicus_Interview_Request";
	public static final Object[][] TABLE_COLUMNS = {
			{ "partnerId", Types.BIGINT },
			{ "studentId", Types.BIGINT },
			{ "schoolId", Types.BIGINT },
			{ "campusId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("partnerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("schoolId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("campusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table Medicus_Interview_Request (partnerId LONG not null,studentId LONG not null,schoolId LONG,campusId LONG,status INTEGER,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG,primary key (partnerId, studentId))";
	public static final String TABLE_SQL_DROP = "drop table Medicus_Interview_Request";
	public static final String ORDER_BY_JPQL = " ORDER BY interview_Request.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Medicus_Interview_Request.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.medicus.common.service.model.Interview_Request"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.medicus.common.service.model.Interview_Request"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.medicus.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.medicus.common.service.model.Interview_Request"),
			true);
	public static final long CAMPUSID_COLUMN_BITMASK = 1L;
	public static final long PARTNERID_COLUMN_BITMASK = 2L;
	public static final long STUDENTID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.medicus.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.medicus.common.service.model.Interview_Request"));

	public Interview_RequestModelImpl() {
	}

	@Override
	public Interview_RequestPK getPrimaryKey() {
		return new Interview_RequestPK(_partnerId, _studentId);
	}

	@Override
	public void setPrimaryKey(Interview_RequestPK primaryKey) {
		setPartnerId(primaryKey.partnerId);
		setStudentId(primaryKey.studentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Interview_RequestPK(_partnerId, _studentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Interview_RequestPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Interview_Request.class;
	}

	@Override
	public String getModelClassName() {
		return Interview_Request.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partnerId", getPartnerId());
		attributes.put("studentId", getStudentId());
		attributes.put("schoolId", getSchoolId());
		attributes.put("campusId", getCampusId());
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
		Long partnerId = (Long)attributes.get("partnerId");

		if (partnerId != null) {
			setPartnerId(partnerId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		Long campusId = (Long)attributes.get("campusId");

		if (campusId != null) {
			setCampusId(campusId);
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
	public long getPartnerId() {
		return _partnerId;
	}

	@Override
	public void setPartnerId(long partnerId) {
		_columnBitmask |= PARTNERID_COLUMN_BITMASK;

		if (!_setOriginalPartnerId) {
			_setOriginalPartnerId = true;

			_originalPartnerId = _partnerId;
		}

		_partnerId = partnerId;
	}

	public long getOriginalPartnerId() {
		return _originalPartnerId;
	}

	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_columnBitmask |= STUDENTID_COLUMN_BITMASK;

		if (!_setOriginalStudentId) {
			_setOriginalStudentId = true;

			_originalStudentId = _studentId;
		}

		_studentId = studentId;
	}

	public long getOriginalStudentId() {
		return _originalStudentId;
	}

	@Override
	public long getSchoolId() {
		return _schoolId;
	}

	@Override
	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;
	}

	@Override
	public long getCampusId() {
		return _campusId;
	}

	@Override
	public void setCampusId(long campusId) {
		_columnBitmask |= CAMPUSID_COLUMN_BITMASK;

		if (!_setOriginalCampusId) {
			_setOriginalCampusId = true;

			_originalCampusId = _campusId;
		}

		_campusId = campusId;
	}

	public long getOriginalCampusId() {
		return _originalCampusId;
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
	public Interview_Request toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Interview_Request)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Interview_RequestImpl interview_RequestImpl = new Interview_RequestImpl();

		interview_RequestImpl.setPartnerId(getPartnerId());
		interview_RequestImpl.setStudentId(getStudentId());
		interview_RequestImpl.setSchoolId(getSchoolId());
		interview_RequestImpl.setCampusId(getCampusId());
		interview_RequestImpl.setStatus(getStatus());
		interview_RequestImpl.setCreateDate(getCreateDate());
		interview_RequestImpl.setCreatedBy(getCreatedBy());
		interview_RequestImpl.setModifiedDate(getModifiedDate());
		interview_RequestImpl.setModifiedBy(getModifiedBy());

		interview_RequestImpl.resetOriginalValues();

		return interview_RequestImpl;
	}

	@Override
	public int compareTo(Interview_Request interview_Request) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				interview_Request.getCreateDate());

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

		if (!(obj instanceof Interview_Request)) {
			return false;
		}

		Interview_Request interview_Request = (Interview_Request)obj;

		Interview_RequestPK primaryKey = interview_Request.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		Interview_RequestModelImpl interview_RequestModelImpl = this;

		interview_RequestModelImpl._originalPartnerId = interview_RequestModelImpl._partnerId;

		interview_RequestModelImpl._setOriginalPartnerId = false;

		interview_RequestModelImpl._originalStudentId = interview_RequestModelImpl._studentId;

		interview_RequestModelImpl._setOriginalStudentId = false;

		interview_RequestModelImpl._originalCampusId = interview_RequestModelImpl._campusId;

		interview_RequestModelImpl._setOriginalCampusId = false;

		interview_RequestModelImpl._setModifiedDate = false;

		interview_RequestModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Interview_Request> toCacheModel() {
		Interview_RequestCacheModel interview_RequestCacheModel = new Interview_RequestCacheModel();

		interview_RequestCacheModel.interview_RequestPK = getPrimaryKey();

		interview_RequestCacheModel.partnerId = getPartnerId();

		interview_RequestCacheModel.studentId = getStudentId();

		interview_RequestCacheModel.schoolId = getSchoolId();

		interview_RequestCacheModel.campusId = getCampusId();

		interview_RequestCacheModel.status = getStatus();

		Date createDate = getCreateDate();

		if (createDate != null) {
			interview_RequestCacheModel.createDate = createDate.getTime();
		}
		else {
			interview_RequestCacheModel.createDate = Long.MIN_VALUE;
		}

		interview_RequestCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			interview_RequestCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			interview_RequestCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		interview_RequestCacheModel.modifiedBy = getModifiedBy();

		return interview_RequestCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{partnerId=");
		sb.append(getPartnerId());
		sb.append(", studentId=");
		sb.append(getStudentId());
		sb.append(", schoolId=");
		sb.append(getSchoolId());
		sb.append(", campusId=");
		sb.append(getCampusId());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.medicus.common.service.model.Interview_Request");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>partnerId</column-name><column-value><![CDATA[");
		sb.append(getPartnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schoolId</column-name><column-value><![CDATA[");
		sb.append(getSchoolId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campusId</column-name><column-value><![CDATA[");
		sb.append(getCampusId());
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

	private static final ClassLoader _classLoader = Interview_Request.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Interview_Request.class
		};
	private long _partnerId;
	private long _originalPartnerId;
	private boolean _setOriginalPartnerId;
	private long _studentId;
	private long _originalStudentId;
	private boolean _setOriginalStudentId;
	private long _schoolId;
	private long _campusId;
	private long _originalCampusId;
	private boolean _setOriginalCampusId;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _columnBitmask;
	private Interview_Request _escapedModel;
}