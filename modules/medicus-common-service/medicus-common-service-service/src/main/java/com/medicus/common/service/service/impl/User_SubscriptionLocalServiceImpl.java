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
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.common.service.exception.NoSuchUser_SubscriptionException;
import com.medicus.common.service.model.User_Subscription;
import com.medicus.common.service.service.User_SubscriptionLocalServiceUtil;
import com.medicus.common.service.service.base.User_SubscriptionLocalServiceBaseImpl;

/**
 * The implementation of the user_ subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.User_SubscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandip.patel
 * @see User_SubscriptionLocalServiceBaseImpl
 * @see com.medicus.common.service.service.User_SubscriptionLocalServiceUtil
 */
@ProviderType
public class User_SubscriptionLocalServiceImpl
	extends User_SubscriptionLocalServiceBaseImpl {
	
	public User_Subscription getUserSubcriptionByUserId(long userId) throws NoSuchUser_SubscriptionException{
		return user_SubscriptionPersistence.findByuserId(userId);
	}
	
	public User_Subscription addUserSubscription(long userId, String txnId, long subscriptionId){
		User_Subscription userSubscription = User_SubscriptionLocalServiceUtil.createUser_Subscription(CounterLocalServiceUtil.increment());
		userSubscription.setUserId(userId);
		userSubscription.setSubscriptionId(subscriptionId);
		userSubscription.setTxnId(txnId);
		userSubscription.setSubscriptionDate(new Date());
		userSubscription = User_SubscriptionLocalServiceUtil.addUser_Subscription(userSubscription);
		return userSubscription;
	}
	
}