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

package com.medicus.common.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchEmployerException;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.impl.EmployerImpl;
import com.medicus.common.service.model.impl.EmployerModelImpl;
import com.medicus.common.service.service.persistence.EmployerPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the employer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployerPersistence
 * @see com.medicus.common.service.service.persistence.EmployerUtil
 * @generated
 */
@ProviderType
public class EmployerPersistenceImpl extends BasePersistenceImpl<Employer>
	implements EmployerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployerUtil} to access the employer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerModelImpl.FINDER_CACHE_ENABLED, EmployerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerModelImpl.FINDER_CACHE_ENABLED, EmployerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerModelImpl.FINDER_CACHE_ENABLED, EmployerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] { Long.class.getName() },
			EmployerModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the employer where userId = &#63; or throws a {@link NoSuchEmployerException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching employer
	 * @throws NoSuchEmployerException if a matching employer could not be found
	 */
	@Override
	public Employer findByuserId(long userId) throws NoSuchEmployerException {
		Employer employer = fetchByuserId(userId);

		if (employer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmployerException(msg.toString());
		}

		return employer;
	}

	/**
	 * Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching employer, or <code>null</code> if a matching employer could not be found
	 */
	@Override
	public Employer fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching employer, or <code>null</code> if a matching employer could not be found
	 */
	@Override
	public Employer fetchByuserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Employer) {
			Employer employer = (Employer)result;

			if ((userId != employer.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMPLOYER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Employer> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmployerPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Employer employer = list.get(0);

					result = employer;

					cacheResult(employer);

					if ((employer.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, employer);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Employer)result;
		}
	}

	/**
	 * Removes the employer where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the employer that was removed
	 */
	@Override
	public Employer removeByuserId(long userId) throws NoSuchEmployerException {
		Employer employer = findByuserId(userId);

		return remove(employer);
	}

	/**
	 * Returns the number of employers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching employers
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "employer.userId = ?";

	public EmployerPersistenceImpl() {
		setModelClass(Employer.class);
	}

	/**
	 * Caches the employer in the entity cache if it is enabled.
	 *
	 * @param employer the employer
	 */
	@Override
	public void cacheResult(Employer employer) {
		entityCache.putResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerImpl.class, employer.getPrimaryKey(), employer);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { employer.getUserId() }, employer);

		employer.resetOriginalValues();
	}

	/**
	 * Caches the employers in the entity cache if it is enabled.
	 *
	 * @param employers the employers
	 */
	@Override
	public void cacheResult(List<Employer> employers) {
		for (Employer employer : employers) {
			if (entityCache.getResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
						EmployerImpl.class, employer.getPrimaryKey()) == null) {
				cacheResult(employer);
			}
			else {
				employer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employer.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Employer employer) {
		entityCache.removeResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerImpl.class, employer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EmployerModelImpl)employer);
	}

	@Override
	public void clearCache(List<Employer> employers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Employer employer : employers) {
			entityCache.removeResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
				EmployerImpl.class, employer.getPrimaryKey());

			clearUniqueFindersCache((EmployerModelImpl)employer);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployerModelImpl employerModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { employerModelImpl.getUserId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				employerModelImpl);
		}
		else {
			if ((employerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { employerModelImpl.getUserId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					employerModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(EmployerModelImpl employerModelImpl) {
		Object[] args = new Object[] { employerModelImpl.getUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((employerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { employerModelImpl.getOriginalUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new employer with the primary key. Does not add the employer to the database.
	 *
	 * @param employerId the primary key for the new employer
	 * @return the new employer
	 */
	@Override
	public Employer create(long employerId) {
		Employer employer = new EmployerImpl();

		employer.setNew(true);
		employer.setPrimaryKey(employerId);

		return employer;
	}

	/**
	 * Removes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employerId the primary key of the employer
	 * @return the employer that was removed
	 * @throws NoSuchEmployerException if a employer with the primary key could not be found
	 */
	@Override
	public Employer remove(long employerId) throws NoSuchEmployerException {
		return remove((Serializable)employerId);
	}

	/**
	 * Removes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employer
	 * @return the employer that was removed
	 * @throws NoSuchEmployerException if a employer with the primary key could not be found
	 */
	@Override
	public Employer remove(Serializable primaryKey)
		throws NoSuchEmployerException {
		Session session = null;

		try {
			session = openSession();

			Employer employer = (Employer)session.get(EmployerImpl.class,
					primaryKey);

			if (employer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employer);
		}
		catch (NoSuchEmployerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Employer removeImpl(Employer employer) {
		employer = toUnwrappedModel(employer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employer)) {
				employer = (Employer)session.get(EmployerImpl.class,
						employer.getPrimaryKeyObj());
			}

			if (employer != null) {
				session.delete(employer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employer != null) {
			clearCache(employer);
		}

		return employer;
	}

	@Override
	public Employer updateImpl(Employer employer) {
		employer = toUnwrappedModel(employer);

		boolean isNew = employer.isNew();

		EmployerModelImpl employerModelImpl = (EmployerModelImpl)employer;

		Session session = null;

		try {
			session = openSession();

			if (employer.isNew()) {
				session.save(employer);

				employer.setNew(false);
			}
			else {
				employer = (Employer)session.merge(employer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmployerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
			EmployerImpl.class, employer.getPrimaryKey(), employer, false);

		clearUniqueFindersCache(employerModelImpl);
		cacheUniqueFindersCache(employerModelImpl, isNew);

		employer.resetOriginalValues();

		return employer;
	}

	protected Employer toUnwrappedModel(Employer employer) {
		if (employer instanceof EmployerImpl) {
			return employer;
		}

		EmployerImpl employerImpl = new EmployerImpl();

		employerImpl.setNew(employer.isNew());
		employerImpl.setPrimaryKey(employer.getPrimaryKey());

		employerImpl.setEmployerId(employer.getEmployerId());
		employerImpl.setUserId(employer.getUserId());
		employerImpl.setEmployerOrgId(employer.getEmployerOrgId());
		employerImpl.setAddress1(employer.getAddress1());
		employerImpl.setAddress2(employer.getAddress2());
		employerImpl.setCity(employer.getCity());
		employerImpl.setZipcode(employer.getZipcode());
		employerImpl.setState(employer.getState());
		employerImpl.setCountry(employer.getCountry());
		employerImpl.setContactPersonName(employer.getContactPersonName());
		employerImpl.setContactPersonEmail(employer.getContactPersonEmail());
		employerImpl.setContactPersonPhoneNumber(employer.getContactPersonPhoneNumber());
		employerImpl.setWebsiteLink(employer.getWebsiteLink());

		return employerImpl;
	}

	/**
	 * Returns the employer with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employer
	 * @return the employer
	 * @throws NoSuchEmployerException if a employer with the primary key could not be found
	 */
	@Override
	public Employer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployerException {
		Employer employer = fetchByPrimaryKey(primaryKey);

		if (employer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employer;
	}

	/**
	 * Returns the employer with the primary key or throws a {@link NoSuchEmployerException} if it could not be found.
	 *
	 * @param employerId the primary key of the employer
	 * @return the employer
	 * @throws NoSuchEmployerException if a employer with the primary key could not be found
	 */
	@Override
	public Employer findByPrimaryKey(long employerId)
		throws NoSuchEmployerException {
		return findByPrimaryKey((Serializable)employerId);
	}

	/**
	 * Returns the employer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employer
	 * @return the employer, or <code>null</code> if a employer with the primary key could not be found
	 */
	@Override
	public Employer fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
				EmployerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Employer employer = (Employer)serializable;

		if (employer == null) {
			Session session = null;

			try {
				session = openSession();

				employer = (Employer)session.get(EmployerImpl.class, primaryKey);

				if (employer != null) {
					cacheResult(employer);
				}
				else {
					entityCache.putResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
						EmployerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
					EmployerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employer;
	}

	/**
	 * Returns the employer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employerId the primary key of the employer
	 * @return the employer, or <code>null</code> if a employer with the primary key could not be found
	 */
	@Override
	public Employer fetchByPrimaryKey(long employerId) {
		return fetchByPrimaryKey((Serializable)employerId);
	}

	@Override
	public Map<Serializable, Employer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Employer> map = new HashMap<Serializable, Employer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Employer employer = fetchByPrimaryKey(primaryKey);

			if (employer != null) {
				map.put(primaryKey, employer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
					EmployerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Employer)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPLOYER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Employer employer : (List<Employer>)q.list()) {
				map.put(employer.getPrimaryKeyObj(), employer);

				cacheResult(employer);

				uncachedPrimaryKeys.remove(employer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmployerModelImpl.ENTITY_CACHE_ENABLED,
					EmployerImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the employers.
	 *
	 * @return the employers
	 */
	@Override
	public List<Employer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Employer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Employer> findAll(int start, int end,
		OrderByComparator<Employer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Employer> findAll(int start, int end,
		OrderByComparator<Employer> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Employer> list = null;

		if (retrieveFromCache) {
			list = (List<Employer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPLOYER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYER;

				if (pagination) {
					sql = sql.concat(EmployerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Employer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Employer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Employer employer : findAll()) {
			remove(employer);
		}
	}

	/**
	 * Returns the number of employers.
	 *
	 * @return the number of employers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employer persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmployerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMPLOYER = "SELECT employer FROM Employer employer";
	private static final String _SQL_SELECT_EMPLOYER_WHERE_PKS_IN = "SELECT employer FROM Employer employer WHERE employerId IN (";
	private static final String _SQL_SELECT_EMPLOYER_WHERE = "SELECT employer FROM Employer employer WHERE ";
	private static final String _SQL_COUNT_EMPLOYER = "SELECT COUNT(employer) FROM Employer employer";
	private static final String _SQL_COUNT_EMPLOYER_WHERE = "SELECT COUNT(employer) FROM Employer employer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Employer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Employer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmployerPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}