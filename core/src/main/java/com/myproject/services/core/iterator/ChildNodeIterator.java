package com.myproject.services.core.iterator;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUse;

public class ChildNodeIterator extends WCMUse {

	ResourceResolverFactory rrf;
	ResourceResolver resolver;
	Resource resource;
	Session session;

	List<String> l1 = new ArrayList<String>();

	@Override
	public void activate() throws Exception {

		final Logger log = LoggerFactory.getLogger(ChildNodeIterator.class);

		log.info("activate method");
		// TODO Auto-generated method stub
		Session session = getResourceResolver().adaptTo(Session.class);
		Node node = session.getNode("/content/geometrixx-outdoors/en");
		log.info("activate method"+node.getName());
		NodeIterator iterator = node.getNodes();
		while (iterator.hasNext()) {
			log.info("insidde method");
			l1.add(iterator.nextNode().getName());
			// l1.add(n1.toString());
		}

		
		
	}

	public List<String> childIterator1() {

		return l1;
	}

}
