package com.regnant.aem.sightly;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import com.adobe.cq.sightly.WCMUse;

public class Iterating_List_Sightly extends WCMUse {

	Session session;
	ResourceResolverFactory resourceResolverFactory;
	ResourceResolver resourceResolver;
	Resource resource;

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub

	}
}
