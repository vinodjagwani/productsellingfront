/**
 * 
 */
package de.hybris.platform.productsellingfront.controller;

import de.hybris.platform.servicelayer.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author VJA
 * 
 */
@Controller
@RequestMapping(value = "/login")
public class SellingEntryController
{

	private static final Logger LOG = Logger.getLogger(SellingEntryController.class.getName());

	private static final String ENTRY_VIEW = "index.html";
	private static final String REDIRECT_STORE_FINDER = "/webshopstorefront";

	@Autowired
	private UserService userService;


	@RequestMapping(method = RequestMethod.GET)
	public String entryViewSellingFront(final HttpServletRequest request, final HttpServletResponse response)
	{
		return ENTRY_VIEW;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logOut(final HttpServletRequest request, final HttpServletResponse response)
	{
		final String redirectURL = getDomain(request) + REDIRECT_STORE_FINDER;
		request.getSession().invalidate();
		return redirectURL;
	}

	private static String getDomain(final HttpServletRequest request)
	{
		final String domainName = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		return domainName;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

}
