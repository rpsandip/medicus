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

package com.medicus.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Interview_Request service. Represents a row in the &quot;Medicus_Interview_Request&quot; database table, with each column mapped to a property of this class.
 *
 * @author sandip.patel
 * @see Interview_RequestModel
 * @see com.medicus.common.service.model.impl.Interview_RequestImpl
 * @see com.medicus.common.service.model.impl.Interview_RequestModelImpl
 * @generated
 */
@ImplementationClassName("com.medicus.common.service.model.impl.Interview_RequestImpl")
@ProviderType
public interface Interview_Request extends Interview_RequestModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.medicus.common.service.model.impl.Interview_RequestImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Interview_Request, Long> PARTNER_ID_ACCESSOR = new Accessor<Interview_Request, Long>() {
			@Override
			public Long get(Interview_Request interview_Request) {
				return interview_Request.getPartnerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Interview_Request> getTypeClass() {
				return Interview_Request.class;
			}
		};

	public static final Accessor<Interview_Request, Long> STUDENT_ID_ACCESSOR = new Accessor<Interview_Request, Long>() {
			@Override
			public Long get(Interview_Request interview_Request) {
				return interview_Request.getStudentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Interview_Request> getTypeClass() {
				return Interview_Request.class;
			}
		};
}