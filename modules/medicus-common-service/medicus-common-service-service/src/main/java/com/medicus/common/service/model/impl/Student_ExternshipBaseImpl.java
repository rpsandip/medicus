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

import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;

/**
 * The extended model base implementation for the Student_Externship service. Represents a row in the &quot;Medicus_Student_Externship&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Student_ExternshipImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Student_ExternshipImpl
 * @see Student_Externship
 * @generated
 */
@ProviderType
public abstract class Student_ExternshipBaseImpl
	extends Student_ExternshipModelImpl implements Student_Externship {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student_ externship model instance should use the {@link Student_Externship} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			Student_ExternshipLocalServiceUtil.addStudent_Externship(this);
		}
		else {
			Student_ExternshipLocalServiceUtil.updateStudent_Externship(this);
		}
	}
}