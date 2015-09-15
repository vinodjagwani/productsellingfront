
package de.hybris.platform.productsellingfront;

import org.apache.log4j.Logger;


/**
 * Simple test class to demonstrate how to include utility classes to your webmodule.
 */
public class ProductsellingfrontWebHelper
{
	/** Edit the local|project.properties to change logging behavior (properties log4j.*). */
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ProductsellingfrontWebHelper.class.getName());

	public static final String getTestOutput()
	{
		return "testoutput";
	}
}
