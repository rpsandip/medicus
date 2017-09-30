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

import com.medicus.common.service.exception.NoSuchAddressException;
import com.medicus.common.service.model.Address;
import com.medicus.common.service.model.impl.AddressImpl;
import com.medicus.common.service.model.impl.AddressModelImpl;
import com.medicus.common.service.service.persistence.AddressPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressPersistence
 * @see com.medicus.common.service.service.persistence.AddressUtil
 * @generated
 */
@ProviderType
public class AddressPersistenceImpl extends BasePersistenceImpl<Address>
	implements AddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressModelImpl.FINDER_CACHE_ENABLED, AddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressModelImpl.FINDER_CACHE_ENABLED, AddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressModelImpl.FINDER_CACHE_ENABLED, AddressImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] { Long.class.getName() },
			AddressModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the address where userId = &#63; or throws a {@link NoSuchAddressException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	@Override
	public Address findByuserId(long userId) throws NoSuchAddressException {
		Address address = fetchByuserId(userId);

		if (address == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAddressException(msg.toString());
		}

		return address;
	}

	/**
	 * Returns the address where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the address where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching address, or <code>null</code> if a matching address could not be found
	 */
	@Override
	public Address fetchByuserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Address) {
			Address address = (Address)result;

			if ((userId != address.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ADDRESS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Address> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AddressPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Address address = list.get(0);

					result = address;

					cacheResult(address);

					if ((address.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, address);
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
			return (Address)result;
		}
	}

	/**
	 * Removes the address where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the address that was removed
	 */
	@Override
	public Address removeByuserId(long userId) throws NoSuchAddressException {
		Address address = findByuserId(userId);

		return remove(address);
	}

	/**
	 * Returns the number of addresses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching addresses
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDRESS_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "address.userId = ?";

	public AddressPersistenceImpl() {
		setModelClass(Address.class);
	}

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	@Override
	public void cacheResult(Address address) {
		entityCache.putResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressImpl.class, address.getPrimaryKey(), address);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { address.getUserId() }, address);

		address.resetOriginalValues();
	}

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	@Override
	public void cacheResult(List<Address> addresses) {
		for (Address address : addresses) {
			if (entityCache.getResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
						AddressImpl.class, address.getPrimaryKey()) == null) {
				cacheResult(address);
			}
			else {
				address.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all addresses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddressImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the address.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Address address) {
		entityCache.removeResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressImpl.class, address.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AddressModelImpl)address);
	}

	@Override
	public void clearCache(List<Address> addresses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Address address : addresses) {
			entityCache.removeResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
				AddressImpl.class, address.getPrimaryKey());

			clearUniqueFindersCache((AddressModelImpl)address);
		}
	}

	protected void cacheUniqueFindersCache(AddressModelImpl addressModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { addressModelImpl.getUserId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				addressModelImpl);
		}
		else {
			if ((addressModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { addressModelImpl.getUserId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					addressModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(AddressModelImpl addressModelImpl) {
		Object[] args = new Object[] { addressModelImpl.getUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((addressModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { addressModelImpl.getOriginalUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	@Override
	public Address create(long addressId) {
		Address address = new AddressImpl();

		address.setNew(true);
		address.setPrimaryKey(addressId);

		return address;
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(long addressId) throws NoSuchAddressException {
		return remove((Serializable)addressId);
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address remove(Serializable primaryKey)
		throws NoSuchAddressException {
		Session session = null;

		try {
			session = openSession();

			Address address = (Address)session.get(AddressImpl.class, primaryKey);

			if (address == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(address);
		}
		catch (NoSuchAddressException nsee) {
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
	protected Address removeImpl(Address address) {
		address = toUnwrappedModel(address);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(address)) {
				address = (Address)session.get(AddressImpl.class,
						address.getPrimaryKeyObj());
			}

			if (address != null) {
				session.delete(address);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (address != null) {
			clearCache(address);
		}

		return address;
	}

	@Override
	public Address updateImpl(Address address) {
		address = toUnwrappedModel(address);

		boolean isNew = address.isNew();

		AddressModelImpl addressModelImpl = (AddressModelImpl)address;

		Session session = null;

		try {
			session = openSession();

			if (address.isNew()) {
				session.save(address);

				address.setNew(false);
			}
			else {
				address = (Address)session.merge(address);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AddressModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
			AddressImpl.class, address.getPrimaryKey(), address, false);

		clearUniqueFindersCache(addressModelImpl);
		cacheUniqueFindersCache(addressModelImpl, isNew);

		address.resetOriginalValues();

		return address;
	}

	protected Address toUnwrappedModel(Address address) {
		if (address instanceof AddressImpl) {
			return address;
		}

		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setNew(address.isNew());
		addressImpl.setPrimaryKey(address.getPrimaryKey());

		addressImpl.setAddressId(address.getAddressId());
		addressImpl.setUserId(address.getUserId());
		addressImpl.setAddress1(address.getAddress1());
		addressImpl.setAddress2(address.getAddress2());
		addressImpl.setCity(address.getCity());
		addressImpl.setZipcode(address.getZipcode());
		addressImpl.setState(address.getState());
		addressImpl.setCountry(address.getCountry());

		return addressImpl;
	}

	/**
	 * Returns the address with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressException {
		Address address = fetchByPrimaryKey(primaryKey);

		if (address == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return address;
	}

	/**
	 * Returns the address with the primary key or throws a {@link NoSuchAddressException} if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	@Override
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException {
		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	@Override
	public Address fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
				AddressImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Address address = (Address)serializable;

		if (address == null) {
			Session session = null;

			try {
				session = openSession();

				address = (Address)session.get(AddressImpl.class, primaryKey);

				if (address != null) {
					cacheResult(address);
				}
				else {
					entityCache.putResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
						AddressImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
					AddressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return address;
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	@Override
	public Address fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	@Override
	public Map<Serializable, Address> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Address> map = new HashMap<Serializable, Address>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Address address = fetchByPrimaryKey(primaryKey);

			if (address != null) {
				map.put(primaryKey, address);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
					AddressImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Address)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ADDRESS_WHERE_PKS_IN);

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

			for (Address address : (List<Address>)q.list()) {
				map.put(address.getPrimaryKeyObj(), address);

				cacheResult(address);

				uncachedPrimaryKeys.remove(address.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AddressModelImpl.ENTITY_CACHE_ENABLED,
					AddressImpl.class, primaryKey, nullModel);
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
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	@Override
	public List<Address> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	@Override
	public List<Address> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(int start, int end,
		OrderByComparator<Address> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of addresses
	 */
	@Override
	public List<Address> findAll(int start, int end,
		OrderByComparator<Address> orderByComparator, boolean retrieveFromCache) {
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

		List<Address> list = null;

		if (retrieveFromCache) {
			list = (List<Address>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESS;

				if (pagination) {
					sql = sql.concat(AddressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Address>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Address>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Address address : findAll()) {
			remove(address);
		}
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADDRESS);

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
		return AddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the address persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AddressImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ADDRESS = "SELECT address FROM Address address";
	private static final String _SQL_SELECT_ADDRESS_WHERE_PKS_IN = "SELECT address FROM Address address WHERE addressId IN (";
	private static final String _SQL_SELECT_ADDRESS_WHERE = "SELECT address FROM Address address WHERE ";
	private static final String _SQL_COUNT_ADDRESS = "SELECT COUNT(address) FROM Address address";
	private static final String _SQL_COUNT_ADDRESS_WHERE = "SELECT COUNT(address) FROM Address address WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "address.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Address exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Address exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AddressPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}