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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.medicus.common.service.exception.NoSuchInterview_RequestException;
import com.medicus.common.service.model.Interview_Request;

/**
 * The persistence interface for the interview_ request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see com.medicus.common.service.service.persistence.impl.Interview_RequestPersistenceImpl
 * @see Interview_RequestUtil
 * @generated
 */
@ProviderType
public interface Interview_RequestPersistence extends BasePersistence<Interview_Request> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Interview_RequestUtil} to access the interview_ request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the interview_ requests where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @return the matching interview_ requests
	*/
	public java.util.List<Interview_Request> findBypartnerId(long partnerId);

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
	public java.util.List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end);

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
	public java.util.List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

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
	public java.util.List<Interview_Request> findBypartnerId(long partnerId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBypartnerId_First(long partnerId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the first interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBypartnerId_First(long partnerId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the last interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBypartnerId_Last(long partnerId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the last interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBypartnerId_Last(long partnerId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where partnerId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param partnerId the partner ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public Interview_Request[] findBypartnerId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long partnerId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Removes all the interview_ requests where partnerId = &#63; from the database.
	*
	* @param partnerId the partner ID
	*/
	public void removeBypartnerId(long partnerId);

	/**
	* Returns the number of interview_ requests where partnerId = &#63;.
	*
	* @param partnerId the partner ID
	* @return the number of matching interview_ requests
	*/
	public int countBypartnerId(long partnerId);

	/**
	* Returns all the interview_ requests where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @return the matching interview_ requests
	*/
	public java.util.List<Interview_Request> findBycampusId(long campusId);

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
	public java.util.List<Interview_Request> findBycampusId(long campusId,
		int start, int end);

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
	public java.util.List<Interview_Request> findBycampusId(long campusId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

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
	public java.util.List<Interview_Request> findBycampusId(long campusId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBycampusId_First(long campusId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the first interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBycampusId_First(long campusId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the last interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBycampusId_Last(long campusId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the last interview_ request in the ordered set where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBycampusId_Last(long campusId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where campusId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param campusId the campus ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public Interview_Request[] findBycampusId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long campusId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Removes all the interview_ requests where campusId = &#63; from the database.
	*
	* @param campusId the campus ID
	*/
	public void removeBycampusId(long campusId);

	/**
	* Returns the number of interview_ requests where campusId = &#63;.
	*
	* @param campusId the campus ID
	* @return the number of matching interview_ requests
	*/
	public int countBycampusId(long campusId);

	/**
	* Returns all the interview_ requests where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching interview_ requests
	*/
	public java.util.List<Interview_Request> findBystudentId(long studentId);

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
	public java.util.List<Interview_Request> findBystudentId(long studentId,
		int start, int end);

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
	public java.util.List<Interview_Request> findBystudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

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
	public java.util.List<Interview_Request> findBystudentId(long studentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBystudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the first interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBystudentId_First(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the last interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request
	* @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	*/
	public Interview_Request findBystudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the last interview_ request in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	*/
	public Interview_Request fetchBystudentId_Last(long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

	/**
	* Returns the interview_ requests before and after the current interview_ request in the ordered set where studentId = &#63;.
	*
	* @param interview_RequestPK the primary key of the current interview_ request
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public Interview_Request[] findBystudentId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException;

	/**
	* Removes all the interview_ requests where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	*/
	public void removeBystudentId(long studentId);

	/**
	* Returns the number of interview_ requests where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching interview_ requests
	*/
	public int countBystudentId(long studentId);

	/**
	* Caches the interview_ request in the entity cache if it is enabled.
	*
	* @param interview_Request the interview_ request
	*/
	public void cacheResult(Interview_Request interview_Request);

	/**
	* Caches the interview_ requests in the entity cache if it is enabled.
	*
	* @param interview_Requests the interview_ requests
	*/
	public void cacheResult(
		java.util.List<Interview_Request> interview_Requests);

	/**
	* Creates a new interview_ request with the primary key. Does not add the interview_ request to the database.
	*
	* @param interview_RequestPK the primary key for the new interview_ request
	* @return the new interview_ request
	*/
	public Interview_Request create(Interview_RequestPK interview_RequestPK);

	/**
	* Removes the interview_ request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request that was removed
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public Interview_Request remove(Interview_RequestPK interview_RequestPK)
		throws NoSuchInterview_RequestException;

	public Interview_Request updateImpl(Interview_Request interview_Request);

	/**
	* Returns the interview_ request with the primary key or throws a {@link NoSuchInterview_RequestException} if it could not be found.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request
	* @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	*/
	public Interview_Request findByPrimaryKey(
		Interview_RequestPK interview_RequestPK)
		throws NoSuchInterview_RequestException;

	/**
	* Returns the interview_ request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interview_RequestPK the primary key of the interview_ request
	* @return the interview_ request, or <code>null</code> if a interview_ request with the primary key could not be found
	*/
	public Interview_Request fetchByPrimaryKey(
		Interview_RequestPK interview_RequestPK);

	@Override
	public java.util.Map<java.io.Serializable, Interview_Request> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the interview_ requests.
	*
	* @return the interview_ requests
	*/
	public java.util.List<Interview_Request> findAll();

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
	public java.util.List<Interview_Request> findAll(int start, int end);

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
	public java.util.List<Interview_Request> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator);

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
	public java.util.List<Interview_Request> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the interview_ requests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of interview_ requests.
	*
	* @return the number of interview_ requests
	*/
	public int countAll();
}