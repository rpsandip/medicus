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
 * Provides the local service utility for Interview_Request. This utility wraps
 * {@link com.medicus.common.service.service.impl.Interview_RequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sandip.patel
 * @see Interview_RequestLocalService
 * @see com.medicus.common.service.service.base.Interview_RequestLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.Interview_RequestLocalServiceImpl
 * @generated
 */
@ProviderType
public class Interview_RequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.Interview_RequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.medicus.common.service.model.Interview_Request addInterviewRequest(
		long partnerId, long studentId, int status, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.io.IOException, javax.mail.internet.AddressException {
		return getService()
				   .addInterviewRequest(partnerId, studentId, status, createdBy);
	}

	/**
	* Adds the interview_ request to the database. Also notifies the appropriate model listeners.
	*
	* @param interview_Request the interview_ request
	* @return the interview_ request that was added
	*/
	public static com.medicus.common.service.model.Interview_Request addInterview_Request(
		com.medicus.common.service.model.Interview_Request interview_Request) {
		return getService().addInterview_Request(interview_Request);
	}

	/**
	* Creates a new interview_ request with the primary key. Does not add the interview_ request to the database.
	*
	* @param interview_RequestPK the primary key for the new interview_ request
	* @return the new interview_ request
	*/
	public static com.medicus.common.service.model.Interview_Request createInterview_Request(
		com.medicus.common.service.service.persistence.Interview_RequestPK interview_RequestPK) {
		return getService().createInterview_Request(interview_RequestPK);
	}

	/**
	* Deletes the interview_ request from the database. Also notifies the appropriate model listeners.
	*
	* @param interview_Request the interview_ request
	* @return the interview_ request that was removed
	*/
	public static com.medicus.common.service.model.Interview_Request deleteInterview_Request(
		com.medicus.common.service.model.Interview_Request interview_Request) {
		return getService().deleteInterview_Request(interview_Request);
	}

	/**
	* Deletes the interview_ request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request that was removed
	* @throws PortalException if a interview_ request with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Interview_Request deleteInterview_Request(
		com.medicus.common.service.service.persistence.Interview_RequestPK interview_RequestPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteInterview_Request(interview_RequestPK);
	}

	public static com.medicus.common.service.model.Interview_Request fetchInterview_Request(
		com.medicus.common.service.service.persistence.Interview_RequestPK interview_RequestPK) {
		return getService().fetchInterview_Request(interview_RequestPK);
	}

	/**
	* Returns the interview_ request with the primary key.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request
	* @throws PortalException if a interview_ request with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Interview_Request getInterview_Request(
		com.medicus.common.service.service.persistence.Interview_RequestPK interview_RequestPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInterview_Request(interview_RequestPK);
	}

	public static com.medicus.common.service.model.Interview_Request updateInterviewRequest(
		long studentId, long partnerId, int status, long modifiedBy) {
		return getService()
				   .updateInterviewRequest(studentId, partnerId, status,
			modifiedBy);
	}

	/**
	* Updates the interview_ request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interview_Request the interview_ request
	* @return the interview_ request that was updated
	*/
	public static com.medicus.common.service.model.Interview_Request updateInterview_Request(
		com.medicus.common.service.model.Interview_Request interview_Request) {
		return getService().updateInterview_Request(interview_Request);
	}

	/**
	* Returns the number of interview_ requests.
	*
	* @return the number of interview_ requests
	*/
	public static int getInterview_RequestsCount() {
		return getService().getInterview_RequestsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.medicus.common.service.model.Interview_Request> getInterviewReqeustsByPartnerId(
		long partnerId) {
		return getService().getInterviewReqeustsByPartnerId(partnerId);
	}

	public static java.util.List<com.medicus.common.service.model.Interview_Request> getInterviewRequestsByCampusId(
		long campusId) {
		return getService().getInterviewRequestsByCampusId(campusId);
	}

	public static java.util.List<com.medicus.common.service.model.Interview_Request> getInterviewRequestsByStudentId(
		long studentId) {
		return getService().getInterviewRequestsByStudentId(studentId);
	}

	/**
	* Returns a range of all the interview_ requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @return the range of interview_ requests
	*/
	public static java.util.List<com.medicus.common.service.model.Interview_Request> getInterview_Requests(
		int start, int end) {
		return getService().getInterview_Requests(start, end);
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

	public static Interview_RequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Interview_RequestLocalService, Interview_RequestLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Interview_RequestLocalService.class);
}