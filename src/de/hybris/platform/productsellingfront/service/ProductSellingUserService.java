/**
 * 
 */
package de.hybris.platform.productsellingfront.service;

import de.hybris.platform.spring.security.CoreUserDetails;


/**
 * @author VJA
 * 
 */
public interface ProductSellingUserService
{
	CoreUserDetails loadUserByUsername(final String username);
}
