package com.aem.mind.core.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;

@Component(service = Servlet.class)
@SlingServletResourceTypes(methods = { HttpConstants.METHOD_GET,
		HttpConstants.METHOD_POST }, resourceTypes = "Servlets/components/structure/page", selectors = { "shree",
				"ms" }, extensions = { "txt", "xml" })

public class ServletsTestByResourceTypes extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ServletsTestByResourceTypes.class);

	@Override
	protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res)
			throws ServletException, IOException {
		final Resource resource = req.getResource();
		res.setContentType("text/plain");
		res.getWriter().write("Page Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
		res.getWriter().write("Page Title = " + resource.getPath());
	}

	@Override
	protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse res)
			throws ServletException, IOException {
		try {
			LOG.info("\n ------------------------STARTED POST-------------------------");
			List<RequestParameter> requestParameterList = req.getRequestParameterList();
			for (RequestParameter requestParameter : requestParameterList) {
				LOG.info("\n ==PARAMETERS===>  {} : {} ", requestParameter.getName(), requestParameter.getString());
			}
		} catch (Exception e) {
			LOG.info("\n ERROR IN REQUEST {} ", e.getMessage());
		}
		res.getWriter().write("======FORM SUBMITTED========");
		// action="/content/ServletsTest/en/_jcr_content.shree.txt"

	}

}
