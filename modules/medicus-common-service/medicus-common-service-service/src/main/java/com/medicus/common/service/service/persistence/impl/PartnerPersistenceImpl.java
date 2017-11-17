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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.impl.PartnerImpl;
import com.medicus.common.service.model.impl.PartnerModelImpl;
import com.medicus.common.service.service.persistence.PartnerPersistence;

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
 * The persistence implementation for the partner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see PartnerPersistence
 * @see com.medicus.common.service.service.persistence.PartnerUtil
 * @generated
 */
@ProviderType
public class PartnerPersistenceImpl extends BasePersistenceImpl<Partner>
	implements PartnerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PartnerUtil} to access the partner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PartnerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerModelImpl.FINDER_CACHE_ENABLED, PartnerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerModelImpl.FINDER_CACHE_ENABLED, PartnerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerModelImpl.FINDER_CACHE_ENABLED, PartnerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] { Long.class.getName() },
			PartnerModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the partner where userId = &#63; or throws a {@link NoSuchPartnerException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching partner
	 * @throws NoSuchPartnerException if a matching partner could not be found
	 */
	@Override
	public Partner findByuserId(long userId) throws NoSuchPartnerException {
		Partner partner = fetchByuserId(userId);

		if (partner == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPartnerException(msg.toString());
		}

		return partner;
	}

	/**
	 * Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching partner, or <code>null</code> if a matching partner could not be found
	 */
	@Override
	public Partner fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching partner, or <code>null</code> if a matching partner could not be found
	 */
	@Override
	public Partner fetchByuserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Partner) {
			Partner partner = (Partner)result;

			if ((userId != partner.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PARTNER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Partner> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PartnerPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Partner partner = list.get(0);

					result = partner;

					cacheResult(partner);

					if ((partner.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, partner);
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
			return (Partner)result;
		}
	}

	/**
	 * Removes the partner where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the partner that was removed
	 */
	@Override
	public Partner removeByuserId(long userId) throws NoSuchPartnerException {
		Partner partner = findByuserId(userId);

		return remove(partner);
	}

	/**
	 * Returns the number of partners where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching partners
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARTNER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "partner.userId = ?";

	public PartnerPersistenceImpl() {
		setModelClass(Partner.class);
	}

	/**
	 * Caches the partner in the entity cache if it is enabled.
	 *
	 * @param partner the partner
	 */
	@Override
	public void cacheResult(Partner partner) {
		entityCache.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerImpl.class, partner.getPrimaryKey(), partner);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { partner.getUserId() }, partner);

		partner.resetOriginalValues();
	}

	/**
	 * Caches the partners in the entity cache if it is enabled.
	 *
	 * @param partners the partners
	 */
	@Override
	public void cacheResult(List<Partner> partners) {
		for (Partner partner : partners) {
			if (entityCache.getResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
						PartnerImpl.class, partner.getPrimaryKey()) == null) {
				cacheResult(partner);
			}
			else {
				partner.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all partners.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PartnerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the partner.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Partner partner) {
		entityCache.removeResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerImpl.class, partner.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PartnerModelImpl)partner);
	}

	@Override
	public void clearCache(List<Partner> partners) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Partner partner : partners) {
			entityCache.removeResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
				PartnerImpl.class, partner.getPrimaryKey());

			clearUniqueFindersCache((PartnerModelImpl)partner);
		}
	}

	protected void cacheUniqueFindersCache(PartnerModelImpl partnerModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { partnerModelImpl.getUserId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				partnerModelImpl);
		}
		else {
			if ((partnerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { partnerModelImpl.getUserId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					partnerModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(PartnerModelImpl partnerModelImpl) {
		Object[] args = new Object[] { partnerModelImpl.getUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((partnerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { partnerModelImpl.getOriginalUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new partner with the primary key. Does not add the partner to the database.
	 *
	 * @param partnerId the primary key for the new partner
	 * @return the new partner
	 */
	@Override
	public Partner create(long partnerId) {
		Partner partner = new PartnerImpl();

		partner.setNew(true);
		partner.setPrimaryKey(partnerId);

		return partner;
	}

	/**
	 * Removes the partner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param partnerId the primary key of the partner
	 * @return the partner that was removed
	 * @throws NoSuchPartnerException if a partner with the primary key could not be found
	 */
	@Override
	public Partner remove(long partnerId) throws NoSuchPartnerException {
		return remove((Serializable)partnerId);
	}

	/**
	 * Removes the partner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the partner
	 * @return the partner that was removed
	 * @throws NoSuchPartnerException if a partner with the primary key could not be found
	 */
	@Override
	public Partner remove(Serializable primaryKey)
		throws NoSuchPartnerException {
		Session session = null;

		try {
			session = openSession();

			Partner partner = (Partner)session.get(PartnerImpl.class, primaryKey);

			if (partner == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPartnerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(partner);
		}
		catch (NoSuchPartnerException nsee) {
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
	protected Partner removeImpl(Partner partner) {
		partner = toUnwrappedModel(partner);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(partner)) {
				partner = (Partner)session.get(PartnerImpl.class,
						partner.getPrimaryKeyObj());
			}

			if (partner != null) {
				session.delete(partner);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (partner != null) {
			clearCache(partner);
		}

		return partner;
	}

	@Override
	public Partner updateImpl(Partner partner) {
		partner = toUnwrappedModel(partner);

		boolean isNew = partner.isNew();

		PartnerModelImpl partnerModelImpl = (PartnerModelImpl)partner;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (partner.getCreateDate() == null)) {
			if (serviceContext == null) {
				partner.setCreateDate(now);
			}
			else {
				partner.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!partnerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				partner.setModifiedDate(now);
			}
			else {
				partner.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (partner.isNew()) {
				session.save(partner);

				partner.setNew(false);
			}
			else {
				partner = (Partner)session.merge(partner);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PartnerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
			PartnerImpl.class, partner.getPrimaryKey(), partner, false);

		clearUniqueFindersCache(partnerModelImpl);
		cacheUniqueFindersCache(partnerModelImpl, isNew);

		partner.resetOriginalValues();

		return partner;
	}

	protected Partner toUnwrappedModel(Partner partner) {
		if (partner instanceof PartnerImpl) {
			return partner;
		}

		PartnerImpl partnerImpl = new PartnerImpl();

		partnerImpl.setNew(partner.isNew());
		partnerImpl.setPrimaryKey(partner.getPrimaryKey());

		partnerImpl.setPartnerId(partner.getPartnerId());
		partnerImpl.setUserId(partner.getUserId());
		partnerImpl.setPartnerOrgId(partner.getPartnerOrgId());
		partnerImpl.setAddress1(partner.getAddress1());
		partnerImpl.setCity(partner.getCity());
		partnerImpl.setZipcode(partner.getZipcode());
		partnerImpl.setState(partner.getState());
		partnerImpl.setCountry(partner.getCountry());
		partnerImpl.setContactPersonName(partner.getContactPersonName());
		partnerImpl.setContactPersonEmail(partner.getContactPersonEmail());
		partnerImpl.setContactPersonPhoneNumber(partner.getContactPersonPhoneNumber());
		partnerImpl.setWebsiteLink(partner.getWebsiteLink());
		partnerImpl.setCreateDate(partner.getCreateDate());
		partnerImpl.setCreatedBy(partner.getCreatedBy());
		partnerImpl.setModifiedDate(partner.getModifiedDate());
		partnerImpl.setModifiedBy(partner.getModifiedBy());

		return partnerImpl;
	}

	/**
	 * Returns the partner with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the partner
	 * @return the partner
	 * @throws NoSuchPartnerException if a partner with the primary key could not be found
	 */
	@Override
	public Partner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPartnerException {
		Partner partner = fetchByPrimaryKey(primaryKey);

		if (partner == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPartnerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return partner;
	}

	/**
	 * Returns the partner with the primary key or throws a {@link NoSuchPartnerException} if it could not be found.
	 *
	 * @param partnerId the primary key of the partner
	 * @return the partner
	 * @throws NoSuchPartnerException if a partner with the primary key could not be found
	 */
	@Override
	public Partner findByPrimaryKey(long partnerId)
		throws NoSuchPartnerException {
		return findByPrimaryKey((Serializable)partnerId);
	}

	/**
	 * Returns the partner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the partner
	 * @return the partner, or <code>null</code> if a partner with the primary key could not be found
	 */
	@Override
	public Partner fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
				PartnerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Partner partner = (Partner)serializable;

		if (partner == null) {
			Session session = null;

			try {
				session = openSession();

				partner = (Partner)session.get(PartnerImpl.class, primaryKey);

				if (partner != null) {
					cacheResult(partner);
				}
				else {
					entityCache.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
						PartnerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
					PartnerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return partner;
	}

	/**
	 * Returns the partner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param partnerId the primary key of the partner
	 * @return the partner, or <code>null</code> if a partner with the primary key could not be found
	 */
	@Override
	public Partner fetchByPrimaryKey(long partnerId) {
		return fetchByPrimaryKey((Serializable)partnerId);
	}

	@Override
	public Map<Serializable, Partner> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Partner> map = new HashMap<Serializable, Partner>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Partner partner = fetchByPrimaryKey(primaryKey);

			if (partner != null) {
				map.put(primaryKey, partner);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
					PartnerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Partner)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PARTNER_WHERE_PKS_IN);

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

			for (Partner partner : (List<Partner>)q.list()) {
				map.put(partner.getPrimaryKeyObj(), partner);

				cacheResult(partner);

				uncachedPrimaryKeys.remove(partner.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
					PartnerImpl.class, primaryKey, nullModel);
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
	 * Returns all the partners.
	 *
	 * @return the partners
	 */
	@Override
	public List<Partner> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the partners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of partners
	 * @param end the upper bound of the range of partners (not inclusive)
	 * @return the range of partners
	 */
	@Override
	public List<Partner> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the partners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of partners
	 * @param end the upper bound of the range of partners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of partners
	 */
	@Override
	public List<Partner> findAll(int start, int end,
		OrderByComparator<Partner> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the partners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of partners
	 * @param end the upper bound of the range of partners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of partners
	 */
	@Override
	public List<Partner> findAll(int start, int end,
		OrderByComparator<Partner> orderByComparator, boolean retrieveFromCache) {
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

		List<Partner> list = null;

		if (retrieveFromCache) {
			list = (List<Partner>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PARTNER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARTNER;

				if (pagination) {
					sql = sql.concat(PartnerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Partner>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Partner>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the partners from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Partner partner : findAll()) {
			remove(partner);
		}
	}

	/**
	 * Returns the number of partners.
	 *
	 * @return the number of partners
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARTNER);

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
		return PartnerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the partner persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PartnerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PARTNER = "SELECT partner FROM Partner partner";
	private static final String _SQL_SELECT_PARTNER_WHERE_PKS_IN = "SELECT partner FROM Partner partner WHERE partnerId IN (";
	private static final String _SQL_SELECT_PARTNER_WHERE = "SELECT partner FROM Partner partner WHERE ";
	private static final String _SQL_COUNT_PARTNER = "SELECT COUNT(partner) FROM Partner partner";
	private static final String _SQL_COUNT_PARTNER_WHERE = "SELECT COUNT(partner) FROM Partner partner WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "partner.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Partner exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Partner exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PartnerPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}