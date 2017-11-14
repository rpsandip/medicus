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

package com.medicus.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author sandip.patel
 * @generated
 */
@ProviderType
public class Interview_RequestPK implements Comparable<Interview_RequestPK>,
	Serializable {
	public long partnerId;
	public long studentId;

	public Interview_RequestPK() {
	}

	public Interview_RequestPK(long partnerId, long studentId) {
		this.partnerId = partnerId;
		this.studentId = studentId;
	}

	public long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Override
	public int compareTo(Interview_RequestPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (partnerId < pk.partnerId) {
			value = -1;
		}
		else if (partnerId > pk.partnerId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (studentId < pk.studentId) {
			value = -1;
		}
		else if (studentId > pk.studentId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof Interview_RequestPK)) {
			return false;
		}

		Interview_RequestPK pk = (Interview_RequestPK)obj;

		if ((partnerId == pk.partnerId) && (studentId == pk.studentId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, partnerId);
		hashCode = HashUtil.hash(hashCode, studentId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("partnerId");
		sb.append(StringPool.EQUAL);
		sb.append(partnerId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("studentId");
		sb.append(StringPool.EQUAL);
		sb.append(studentId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}