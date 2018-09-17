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

package com.medicus.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Partner. This utility wraps
 * {@link com.medicus.common.service.service.impl.PartnerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sandip.patel
 * @see PartnerLocalService
 * @see com.medicus.common.service.service.base.PartnerLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.PartnerLocalServiceImpl
 * @generated
 */
@ProviderType
public class PartnerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.PartnerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the partner to the database. Also notifies the appropriate model listeners.
	*
	* @param partner the partner
	* @return the partner that was added
	*/
	public static com.medicus.common.service.model.Partner addPartner(
		com.medicus.common.service.model.Partner partner) {
		return getService().addPartner(partner);
	}

	/**
	* Creates a new partner with the primary key. Does not add the partner to the database.
	*
	* @param partnerId the primary key for the new partner
	* @return the new partner
	*/
	public static com.medicus.common.service.model.Partner createPartner(
		long partnerId) {
		return getService().createPartner(partnerId);
	}

	/**
	* Deletes the partner from the database. Also notifies the appropriate model listeners.
	*
	* @param partner the partner
	* @return the partner that was removed
	*/
	public static com.medicus.common.service.model.Partner deletePartner(
		com.medicus.common.service.model.Partner partner) {
		return getService().deletePartner(partner);
	}

	/**
	* Deletes the partner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partnerId the primary key of the partner
	* @return the partner that was removed
	* @throws PortalException if a partner with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Partner deletePartner(
		long partnerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePartner(partnerId);
	}

	public static com.medicus.common.service.model.Partner editPartner(
		long partnerId, java.lang.String fName, java.lang.String address1,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String country,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, java.lang.String password,
		java.lang.String password1, java.io.File profilePic,
		java.lang.String profilePicName, long modifiedUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.io.IOException {
		return getService()
				   .editPartner(partnerId, fName, address1, city, zipcode,
			state, country, contactPersonName, contactPersonEmail,
			contactPersonPhoneNumber, websiteLink, password, password1,
			profilePic, profilePicName, modifiedUserId);
	}

	public static com.medicus.common.service.model.Partner fetchPartner(
		long partnerId) {
		return getService().fetchPartner(partnerId);
	}

	/**
	* Returns the partner with the primary key.
	*
	* @param partnerId the primary key of the partner
	* @return the partner
	* @throws PortalException if a partner with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Partner getPartner(
		long partnerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPartner(partnerId);
	}

	public static com.medicus.common.service.model.Partner getPartnerByUserId(
		long userId)
		throws com.medicus.common.service.exception.NoSuchPartnerException {
		return getService().getPartnerByUserId(userId);
	}

	/**
	* Updates the partner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param partner the partner
	* @return the partner that was updated
	*/
	public static com.medicus.common.service.model.Partner updatePartner(
		com.medicus.common.service.model.Partner partner) {
		return getService().updatePartner(partner);
	}

	/**
	* Returns the number of partners.
	*
	* @return the number of partners
	*/
	public static int getPartnersCount() {
		return getService().getPartnersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the partners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of partners
	* @param end the upper bound of the range of partners (not inclusive)
	* @return the range of partners
	*/
	public static java.util.List<com.medicus.common.service.model.Partner> getPartners(
		int start, int end) {
		return getService().getPartners(start, end);
	}

	public static java.util.List<com.medicus.common.service.model.Partner> getSubscribePartners() {
		return getService().getSubscribePartners();
	}

	public static java.util.List<com.medicus.common.service.model.Partner> getUnSubscribePartners() {
		return getService().getUnSubscribePartners();
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PartnerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PartnerLocalService, PartnerLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PartnerLocalService.class);
}