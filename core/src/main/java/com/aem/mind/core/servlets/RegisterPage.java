package com.aem.mind.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.mind.core.dao.ServletDao;
import com.aem.mind.core.dao.Impl.ServletDaoImpl;
import com.aem.mind.core.models.JDBCData;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/aemRegisterPagesTwo" })
public class RegisterPage extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ServletDao dao = new ServletDaoImpl();
	private static final Logger LOG = LoggerFactory.getLogger(RegisterPage.class);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Servlet Project");
		LOG.info("Inside doPost");
		String data = request.getParameter("data");
		LOG.info(data);
		JSONParser parser = new JSONParser();
		JSONObject jobj = null;
		try {
			jobj = (JSONObject) parser.parse(data);
			String firstname = (String) jobj.get("firstname");
			String address = (String) jobj.get("address");
			String gender = (String) jobj.get("gender");

			System.out.println(firstname + "-" + address + "-" + gender);
			LOG.info(firstname, address, gender);
			List<JDBCData> mb = new ArrayList<JDBCData>();
			// System.out.println(mb.toString());
			JDBCData jdbcdata = new JDBCData(firstname, address, gender);
			mb.add(jdbcdata);
			try {
				dao.registerData(mb);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
