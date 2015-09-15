package de.hybris.platform.productsellingfront;

import de.hybris.platform.core.Registry;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.util.RedeployUtilities;
import de.hybris.platform.util.Utilities;


public class ProductsellingfrontStandalone
{
	/**
	 * Main class to be able to run it directly as a java program.
	 * 
	 * @param args
	 *           the arguments from commandline
	 */
	public static void main(final String[] args)
	{
		new ProductsellingfrontStandalone().run();
	}

	public void run()
	{
		Registry.activateStandaloneMode();
		Registry.activateMasterTenant();

		final JaloSession jaloSession = JaloSession.getCurrentSession();
		System.out.println("Session ID: " + jaloSession.getSessionID()); //NOPMD
		System.out.println("User: " + jaloSession.getUser()); //NOPMD
		Utilities.printAppInfo();

		RedeployUtilities.shutdown();
	}
}
