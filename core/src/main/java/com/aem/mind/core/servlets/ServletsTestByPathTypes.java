package com.aem.mind.core.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/pages", "/shree/pages" })
public class ServletsTestByPathTypes extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ServletsTestByPathTypes.class);

	@Override
	protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res)
			throws ServletException, IOException {
		final ResourceResolver resourceResolver = req.getResourceResolver();
		Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ServletsTest/en");
		JSONArray pagesArray = new JSONArray();
		try {
			Iterator<Page> childPages = page.listChildren();
			while (childPages.hasNext()) {
				Page childPage = childPages.next();
				JSONObject pageObject = new JSONObject();
				pageObject.put(childPage.getTitle(), childPage.getPath().toString());
				pagesArray.put(pageObject);
			}
		} catch (JSONException e) {
			LOG.info("\n ERROR {} ", e.getMessage());
		}

		res.setContentType("application/json");
		res.getWriter().write(pagesArray.toString());
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

		// action="/shree/pages"
	}

}
