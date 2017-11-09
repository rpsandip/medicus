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

package com.medicus.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Partner service. Represents a row in the &quot;Medicus_Partner&quot; database table, with each column mapped to a property of this class.
 *
 * @author sandip.patel
 * @see PartnerModel
 * @see com.medicus.common.service.model.impl.PartnerImpl
 * @see com.medicus.common.service.model.impl.PartnerModelImpl
 * @generated
 */
@ImplementationClassName("com.medicus.common.service.model.impl.PartnerImpl")
@ProviderType
public interface Partner extends PartnerModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.medicus.common.service.model.impl.PartnerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Partner, Long> PARTNER_ID_ACCESSOR = new Accessor<Partner, Long>() {
			@Override
			public Long get(Partner partner) {
				return partner.getPartnerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Partner> getTypeClass() {
				return Partner.class;
			}
		};
}