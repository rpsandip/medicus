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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchCampusException;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.impl.CampusImpl;
import com.medicus.common.service.model.impl.CampusModelImpl;
import com.medicus.common.service.service.persistence.CampusPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the campus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampusPersistence
 * @see com.medicus.common.service.service.persistence.CampusUtil
 * @generated
 */
@ProviderType
public class CampusPersistenceImpl extends BasePersistenceImpl<Campus>
	implements CampusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampusUtil} to access the campus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CampusPersistenceImpl() {
		setModelClass(Campus.class);
	}

	/**
	 * Caches the campus in the entity cache if it is enabled.
	 *
	 * @param campus the campus
	 */
	@Override
	public void cacheResult(Campus campus) {
		entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey(), campus);

		campus.resetOriginalValues();
	}

	/**
	 * Caches the campuses in the entity cache if it is enabled.
	 *
	 * @param campuses the campuses
	 */
	@Override
	public void cacheResult(List<Campus> campuses) {
		for (Campus campus : campuses) {
			if (entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
						CampusImpl.class, campus.getPrimaryKey()) == null) {
				cacheResult(campus);
			}
			else {
				campus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campuses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CampusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campus.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Campus campus) {
		entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Campus> campuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Campus campus : campuses) {
			entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
				CampusImpl.class, campus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new campus with the primary key. Does not add the campus to the database.
	 *
	 * @param campusId the primary key for the new campus
	 * @return the new campus
	 */
	@Override
	public Campus create(long campusId) {
		Campus campus = new CampusImpl();

		campus.setNew(true);
		campus.setPrimaryKey(campusId);

		return campus;
	}

	/**
	 * Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus that was removed
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus remove(long campusId) throws NoSuchCampusException {
		return remove((Serializable)campusId);
	}

	/**
	 * Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus that was removed
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus remove(Serializable primaryKey) throws NoSuchCampusException {
		Session session = null;

		try {
			session = openSession();

			Campus campus = (Campus)session.get(CampusImpl.class, primaryKey);

			if (campus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campus);
		}
		catch (NoSuchCampusException nsee) {
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
	protected Campus removeImpl(Campus campus) {
		campus = toUnwrappedModel(campus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campus)) {
				campus = (Campus)session.get(CampusImpl.class,
						campus.getPrimaryKeyObj());
			}

			if (campus != null) {
				session.delete(campus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campus != null) {
			clearCache(campus);
		}

		return campus;
	}

	@Override
	public Campus updateImpl(Campus campus) {
		campus = toUnwrappedModel(campus);

		boolean isNew = campus.isNew();

		CampusModelImpl campusModelImpl = (CampusModelImpl)campus;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (campus.getCreateDate() == null)) {
			if (serviceContext == null) {
				campus.setCreateDate(now);
			}
			else {
				campus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!campusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				campus.setModifiedDate(now);
			}
			else {
				campus.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (campus.isNew()) {
				session.save(campus);

				campus.setNew(false);
			}
			else {
				campus = (Campus)session.merge(campus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey(), campus, false);

		campus.resetOriginalValues();

		return campus;
	}

	protected Campus toUnwrappedModel(Campus campus) {
		if (campus instanceof CampusImpl) {
			return campus;
		}

		CampusImpl campusImpl = new CampusImpl();

		campusImpl.setNew(campus.isNew());
		campusImpl.setPrimaryKey(campus.getPrimaryKey());

		campusImpl.setCampusId(campus.getCampusId());
		campusImpl.setSchoolId(campus.getSchoolId());
		campusImpl.setName(campus.getName());
		campusImpl.setAddress1(campus.getAddress1());
		campusImpl.setAddress2(campus.getAddress2());
		campusImpl.setCity(campus.getCity());
		campusImpl.setState(campus.getState());
		campusImpl.setCountry(campus.getCountry());
		campusImpl.setZipcode(campus.getZipcode());
		campusImpl.setContactNumber(campus.getContactNumber());
		campusImpl.setWebsiteLink(campus.getWebsiteLink());
		campusImpl.setContactPersonName(campus.getContactPersonName());
		campusImpl.setContactPersonPhoneNumber(campus.getContactPersonPhoneNumber());
		campusImpl.setContactPersonEmail(campus.getContactPersonEmail());
		campusImpl.setStatus(campus.getStatus());
		campusImpl.setCreateDate(campus.getCreateDate());
		campusImpl.setCreatedBy(campus.getCreatedBy());
		campusImpl.setModifiedDate(campus.getModifiedDate());
		campusImpl.setModifiedBy(campus.getModifiedBy());

		return campusImpl;
	}

	/**
	 * Returns the campus with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampusException {
		Campus campus = fetchByPrimaryKey(primaryKey);

		if (campus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campus;
	}

	/**
	 * Returns the campus with the primary key or throws a {@link NoSuchCampusException} if it could not be found.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus findByPrimaryKey(long campusId) throws NoSuchCampusException {
		return findByPrimaryKey((Serializable)campusId);
	}

	/**
	 * Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus, or <code>null</code> if a campus with the primary key could not be found
	 */
	@Override
	public Campus fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
				CampusImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Campus campus = (Campus)serializable;

		if (campus == null) {
			Session session = null;

			try {
				session = openSession();

				campus = (Campus)session.get(CampusImpl.class, primaryKey);

				if (campus != null) {
					cacheResult(campus);
				}
				else {
					entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
						CampusImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campus;
	}

	/**
	 * Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus, or <code>null</code> if a campus with the primary key could not be found
	 */
	@Override
	public Campus fetchByPrimaryKey(long campusId) {
		return fetchByPrimaryKey((Serializable)campusId);
	}

	@Override
	public Map<Serializable, Campus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Campus> map = new HashMap<Serializable, Campus>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Campus campus = fetchByPrimaryKey(primaryKey);

			if (campus != null) {
				map.put(primaryKey, campus);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Campus)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CAMPUS_WHERE_PKS_IN);

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

			for (Campus campus : (List<Campus>)q.list()) {
				map.put(campus.getPrimaryKeyObj(), campus);

				cacheResult(campus);

				uncachedPrimaryKeys.remove(campus.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey, nullModel);
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
	 * Returns all the campuses.
	 *
	 * @return the campuses
	 */
	@Override
	public List<Campus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @return the range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator, boolean retrieveFromCache) {
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

		List<Campus> list = null;

		if (retrieveFromCache) {
			list = (List<Campus>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CAMPUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPUS;

				if (pagination) {
					sql = sql.concat(CampusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the campuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Campus campus : findAll()) {
			remove(campus);
		}
	}

	/**
	 * Returns the number of campuses.
	 *
	 * @return the number of campuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMPUS);

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
		return CampusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the campus persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CampusImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CAMPUS = "SELECT campus FROM Campus campus";
	private static final String _SQL_SELECT_CAMPUS_WHERE_PKS_IN = "SELECT campus FROM Campus campus WHERE campusId IN (";
	private static final String _SQL_COUNT_CAMPUS = "SELECT COUNT(campus) FROM Campus campus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Campus exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CampusPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}