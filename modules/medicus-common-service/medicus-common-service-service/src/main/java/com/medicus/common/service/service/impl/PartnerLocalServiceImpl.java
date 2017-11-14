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

import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.base.PartnerLocalServiceBaseImpl;

/**
 * The implementation of the partner local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.PartnerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandip.patel
 * @see PartnerLocalServiceBaseImpl
 * @see com.medicus.common.service.service.PartnerLocalServiceUtil
 */
@ProviderType
public class PartnerLocalServiceImpl extends PartnerLocalServiceBaseImpl {
	public Partner getPartnerByUserId(long userId) throws NoSuchPartnerException{
		return partnerPersistence.findByuserId(userId);
	}
}