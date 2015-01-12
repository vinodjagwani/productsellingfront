/**
 * 
 */
package de.hybris.platform.productsellingfront.service.impl;

import de.hybris.platform.jalo.JaloItemNotFoundException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.productsellingfront.service.ProductSellingUserService;
import de.hybris.platform.spring.security.CoreUserDetails;
import de.hybris.platform.spring.security.CoreUserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * @author VJA
 * 
 */
public class DefaultProductSellingUserService extends CoreUserDetailsService implements ProductSellingUserService
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingfront.service.ProductSellingUserService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public CoreUserDetails loadUserByUsername(final String username)
	{
		if (username == null)
		{
			return null;
		}

		final User user;
		try
		{
			user = UserManager.getInstance().getUserByLogin(username);
		}
		catch (final JaloItemNotFoundException e)
		{
			throw new UsernameNotFoundException("User not found!", e);
		}

		final CoreUserDetails details = super.loadUserByUsername(username);

		final SessionContext ctx = JaloSession.getCurrentSession().createSessionContext();
		ctx.setUser(user);

		//		final Collection<CatalogVersion> allowedVersions = new ArrayList<CatalogVersion>();
		//		if (user.isAdmin())
		//		{
		//			allowedVersions.addAll(CatalogManager.getInstance().getAllCatalogVersions());
		//		}
		//		else
		//		{
		//			allowedVersions.addAll(CatalogManager.getInstance().getAllReadableCatalogVersions(ctx, user));
		//		}
		//
		//		final Collection<CatalogVersion> catalogVersions = CatalogManager.getInstance().getSessionCatalogVersions(ctx);
		//
		//		if (CollectionUtils.isEmpty(catalogVersions))
		//		{
		//			JaloSession.getCurrentSession().setAttribute(CatalogConstants.SESSION_CATALOG_VERSIONS,
		//					Collections.singleton(PK.createFixedUUIDPK(0, 23)));
		//		}

		return details;
	}

}
