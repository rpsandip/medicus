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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicus.common.service.model.Interview_Request;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the interview_ request service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.Interview_RequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see Interview_RequestPersistence
 * @see com.medicus.common.service.service.persistence.impl.Interview_RequestPersistenceImpl
 * @generated
 */
@ProviderType
public class Interview_RequestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Interview_Request interview_Request) {
		getPersistence().clearCache(interview_Request);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Interview_Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Interview_Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Interview_Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Interview_Request update(Interview_Request interview_Request) {
		return getPersistence().update(interview_Request);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Interview_Request update(
		Interview_Request interview_Request, ServiceContext serviceContext) {
		return getPersistence().update(interview_Request, serviceContext);
	}

	/**
	* Returns all the interview_ requests where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @return the matching interview_ requests
	*/
	public static List<Interview_Request> findBypartnerId(long partnerId) {
		return getPersistence().findBypartnerId(partnerId);
	}

	/**
	* Returns a range of all the interview_ requests where partnerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partnerId the partner ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @return the range of matching interview_ requests
	*/
	public static List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end) {
		return getPersistence().findBypartnerId(partnerId, start, end);
	}

	/**
	* Returns an ordered range of all the interview_ requests where partnerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partnerId the partner ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .findBypartnerId(partnerId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interview_ requests where partnerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partnerId the partner ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBypartnerId(partnerId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBypartnerId_First(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBypartnerId_First(partnerId, orderByComparator);
	}

	/**
	* Returns the first interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBypartnerId_First(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .fetchBypartnerId_First(partnerId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBypartnerId_Last(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBypartnerId_Last(partnerId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBypartnerId_Last(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .fetchBypartnerId_Last(partnerId, orderByComparator);
	}

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request[] findBypartnerId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBypartnerId_PrevAndNext(interview_RequestPK, partnerId,
			orderByComparator);
	}

	/**
	* Removes all the interview_ requests where partnerId = &#63; from the database.
	*
	* @param partnerId the partner ID
	*/
	public static void removeBypartnerId(long partnerId) {
		getPersistence().removeBypartnerId(partnerId);
	}

	/**
	* Returns the number of interview_ requests where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @return the number of matching interview_ requests
	*/
	public static int countBypartnerId(long partnerId) {
		return getPersistence().countBypartnerId(partnerId);
	}

	/**
	* Returns all the interview_ requests where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @return the matching interview_ requests
	*/
	public static List<Interview_Request> findBycampusId(long campusId) {
		return getPersistence().findBycampusId(campusId);
	}

	/**
	* Returns a range of all the interview_ requests where campusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campusId the campus ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @return the range of matching interview_ requests
	*/
	public static List<Interview_Request> findBycampusId(long campusId,
		int start, int end) {
		return getPersistence().findBycampusId(campusId, start, end);
	}

	/**
	* Returns an ordered range of all the interview_ requests where campusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campusId the campus ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBycampusId(long campusId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .findBycampusId(campusId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interview_ requests where campusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campusId the campus ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBycampusId(long campusId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycampusId(campusId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBycampusId_First(long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence().findBycampusId_First(campusId, orderByComparator);
	}

	/**
	* Returns the first interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBycampusId_First(long campusId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .fetchBycampusId_First(campusId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBycampusId_Last(long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence().findBycampusId_Last(campusId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBycampusId_Last(long campusId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence().fetchBycampusId_Last(campusId, orderByComparator);
	}

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where campusId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request[] findBycampusId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBycampusId_PrevAndNext(interview_RequestPK, campusId,
			orderByComparator);
	}

	/**
	* Removes all the interview_ requests where campusId = &#63; from the database.
	*
	* @param campusId the campus ID
	*/
	public static void removeBycampusId(long campusId) {
		getPersistence().removeBycampusId(campusId);
	}

	/**
	* Returns the number of interview_ requests where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @return the number of matching interview_ requests
	*/
	public static int countBycampusId(long campusId) {
		return getPersistence().countBycampusId(campusId);
	}

	/**
	* Returns all the interview_ requests where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching interview_ requests
	*/
	public static List<Interview_Request> findBystudentId(long studentId) {
		return getPersistence().findBystudentId(studentId);
	}

	/**
	* Returns a range of all the interview_ requests where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @return the range of matching interview_ requests
	*/
	public static List<Interview_Request> findBystudentId(long studentId,
		int start, int end) {
		return getPersistence().findBystudentId(studentId, start, end);
	}

	/**
	* Returns an ordered range of all the interview_ requests where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBystudentId(long studentId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .findBystudentId(studentId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interview_ requests where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interview_ requests
	*/
	public static List<Interview_Request> findBystudentId(long studentId,
		int start, int end,
		OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystudentId(studentId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBystudentId_First(long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBystudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the first interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBystudentId_First(long studentId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .fetchBystudentId_First(studentId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public static Interview_Request findBystudentId_Last(long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBystudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the last interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public static Interview_Request fetchBystudentId_Last(long studentId,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence()
				   .fetchBystudentId_Last(studentId, orderByComparator);
	}

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where studentId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request[] findBystudentId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence()
				   .findBystudentId_PrevAndNext(interview_RequestPK, studentId,
			orderByComparator);
	}

	/**
	* Removes all the interview_ requests where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public static void removeBystudentId(long studentId) {
		getPersistence().removeBystudentId(studentId);
	}

	/**
	* Returns the number of interview_ requests where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching interview_ requests
	*/
	public static int countBystudentId(long studentId) {
		return getPersistence().countBystudentId(studentId);
	}

	/**
	* Caches the interview_ request in the entity cache if it is enabled.
	*
	* @param interview_Request the interview_ request
	*/
	public static void cacheResult(Interview_Request interview_Request) {
		getPersistence().cacheResult(interview_Request);
	}

	/**
	* Caches the interview_ requests in the entity cache if it is enabled.
	*
	* @param interview_Requests the interview_ requests
	*/
	public static void cacheResult(List<Interview_Request> interview_Requests) {
		getPersistence().cacheResult(interview_Requests);
	}

	/**
	* Creates a new interview_ request with the primary key. Does not add the interview_ request to the database.
	*
	* @param interview_RequestPK the primary key for the new interview_ request
	* @return the new interview_ request
	*/
	public static Interview_Request create(
		Interview_RequestPK interview_RequestPK) {
		return getPersistence().create(interview_RequestPK);
	}

	/**
	* Removes the interview_ request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request that was removed
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request remove(
		Interview_RequestPK interview_RequestPK)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence().remove(interview_RequestPK);
	}

	public static Interview_Request updateImpl(
		Interview_Request interview_Request) {
		return getPersistence().updateImpl(interview_Request);
	}

	/**
	* Returns the interview_ request with the primary key or throws a {@link NoSuchInterview_RequestException} if it could not be found.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request findByPrimaryKey(
		Interview_RequestPK interview_RequestPK)
		throws com.medicus.common.service.exception.NoSuchInterview_RequestException {
		return getPersistence().findByPrimaryKey(interview_RequestPK);
	}

	/**
	* Returns the interview_ request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request, or <code>null</code> if a interview_ request with the primary key could not be found
	*/
	public static Interview_Request fetchByPrimaryKey(
		Interview_RequestPK interview_RequestPK) {
		return getPersistence().fetchByPrimaryKey(interview_RequestPK);
	}

	public static java.util.Map<java.io.Serializable, Interview_Request> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the interview_ requests.
	*
	* @return the interview_ requests
	*/
	public static List<Interview_Request> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the interview_ requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @return the range of interview_ requests
	*/
	public static List<Interview_Request> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the interview_ requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of interview_ requests
	*/
	public static List<Interview_Request> findAll(int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interview_ requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview_ requests
	* @param end the upper bound of the range of interview_ requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of interview_ requests
	*/
	public static List<Interview_Request> findAll(int start, int end,
		OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the interview_ requests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of interview_ requests.
	*
	* @return the number of interview_ requests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Interview_RequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Interview_RequestPersistence, Interview_RequestPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Interview_RequestPersistence.class);
}