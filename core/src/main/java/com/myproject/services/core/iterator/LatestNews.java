
package com.myproject.services.core.iterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

@SlingServlet(paths = "/bin/LatestNewsServlet", methods = "GET")
public class LatestNews extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String sort = request.getParameter("sort");
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(1);
		list.add(20);
		list.add(5);
		list.add(100);
		list.add(9);
		list.add(88);
		if (sort.equalsIgnoreCase("lowhigh")) {
			Collections.sort(list, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});
			for (Integer li : list)
				response.getWriter().write("sorted order " + li);
		} else if (sort.equalsIgnoreCase("highlow")) {
			Collections.sort(list, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			for (Integer li : list)
				response.getWriter().write("sorted order " + li);
		}
	}
}