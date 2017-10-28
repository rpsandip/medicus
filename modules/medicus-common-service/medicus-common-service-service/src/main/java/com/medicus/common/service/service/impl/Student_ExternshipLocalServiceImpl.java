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

package com.medicus.common.service.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
import com.medicus.common.service.service.base.Student_ExternshipLocalServiceBaseImpl;

/**
 * The implementation of the student_ externship local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.Student_ExternshipLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student_ExternshipLocalServiceBaseImpl
 * @see com.medicus.common.service.service.Student_ExternshipLocalServiceUtil
 */
@ProviderType
public class Student_ExternshipLocalServiceImpl
	extends Student_ExternshipLocalServiceBaseImpl {
	
	/*
	 * Add Student Externship detail
	 */
	public Student_Externship addStudentExternship(long studentId, long employerId, Date startDate, Date endDate, int noOfHoursPerWeek,
			Date midPointReview, String midPointReviewComment, Date finalReview, String finalReviewComment, long createdBy){
		Student_Externship studentExternship = Student_ExternshipLocalServiceUtil.createStudent_Externship(CounterLocalServiceUtil.increment());
		studentExternship.setStudentId(studentId);
		studentExternship.setEmployerId(employerId);
		studentExternship.setStartDate(startDate);
		studentExternship.setEndDate(endDate);
		studentExternship.setNoOfHoursPerWeek(noOfHoursPerWeek);
		studentExternship.setMidPointReview(midPointReview);
		studentExternship.setMidPointReviewComment(midPointReviewComment);
		studentExternship.setFinalReview(finalReview);
		studentExternship.setFinalReviewComment(finalReviewComment);
		studentExternship.setCreatedBy(createdBy);
		studentExternship.setCreateDate(new Date());
		studentExternship.setModifiedBy(createdBy);
		studentExternship.setModifiedDate(new Date());
		
		studentExternship = Student_ExternshipLocalServiceUtil.addStudent_Externship(studentExternship);
		
		return studentExternship;
	}
	
	
}