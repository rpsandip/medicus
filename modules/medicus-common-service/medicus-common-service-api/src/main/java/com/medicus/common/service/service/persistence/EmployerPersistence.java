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

import com.medicus.common.service.exception.NoSuchEmployerException;
import com.medicus.common.service.model.Employer;

/**
 * The persistence interface for the employer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicus.common.service.service.persistence.impl.EmployerPersistenceImpl
 * @see EmployerUtil
 * @generated
 */
@ProviderType
public interface EmployerPersistence extends BasePersistence<Employer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployerUtil} to access the employer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the employer where userId = &#63; or throws a {@link NoSuchEmployerException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching employer
	* @throws NoSuchEmployerException if a matching employer could not be found
	*/
	public Employer findByuserId(long userId) throws NoSuchEmployerException;

	/**
	* Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching employer, or <code>null</code> if a matching employer could not be found
	*/
	public Employer fetchByuserId(long userId);

	/**
	* Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employer, or <code>null</code> if a matching employer could not be found
	*/
	public Employer fetchByuserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the employer where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the employer that was removed
	*/
	public Employer removeByuserId(long userId) throws NoSuchEmployerException;

	/**
	* Returns the number of employers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employers
	*/
	public int countByuserId(long userId);

	/**
	* Caches the employer in the entity cache if it is enabled.
	*
	* @param employer the employer
	*/
	public void cacheResult(Employer employer);

	/**
	* Caches the employers in the entity cache if it is enabled.
	*
	* @param employers the employers
	*/
	public void cacheResult(java.util.List<Employer> employers);

	/**
	* Creates a new employer with the primary key. Does not add the employer to the database.
	*
	* @param employerId the primary key for the new employer
	* @return the new employer
	*/
	public Employer create(long employerId);

	/**
	* Removes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employerId the primary key of the employer
	* @return the employer that was removed
	* @throws NoSuchEmployerException if a employer with the primary key could not be found
	*/
	public Employer remove(long employerId) throws NoSuchEmployerException;

	public Employer updateImpl(Employer employer);

	/**
	* Returns the employer with the primary key or throws a {@link NoSuchEmployerException} if it could not be found.
	*
	* @param employerId the primary key of the employer
	* @return the employer
	* @throws NoSuchEmployerException if a employer with the primary key could not be found
	*/
	public Employer findByPrimaryKey(long employerId)
		throws NoSuchEmployerException;

	/**
	* Returns the employer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employerId the primary key of the employer
	* @return the employer, or <code>null</code> if a employer with the primary key could not be found
	*/
	public Employer fetchByPrimaryKey(long employerId);

	@Override
	public java.util.Map<java.io.Serializable, Employer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employers.
	*
	* @return the employers
	*/
	public java.util.List<Employer> findAll();

	/**
	* Returns a range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @return the range of employers
	*/
	public java.util.List<Employer> findAll(int start, int end);

	/**
	* Returns an ordered range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employers
	*/
	public java.util.List<Employer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employer> orderByComparator);

	/**
	* Returns an ordered range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employers
	*/
	public java.util.List<Employer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employers.
	*
	* @return the number of employers
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}