package com.myproject.services.core.use;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.adobe.cq.sightly.WCMUse;
import com.adobe.cq.social.calendar.client.api.Page;




public class ItearatingChildNodes extends WCMUse {

	
	Resource resource; 
	ArrayList<String> l1= new ArrayList<String>();
	String path="content/geometrixx/en";
	public void activate() throws Exception {
		
		
		
		ResourceResolver rr=resource.getResourceResolver();
		Page page=rr.adaptTo(Page.class);
		Iterator<page> childPages=page.listChildren();
		
		
		
		/*
		Node n1=getResourceResolver().resolve("content/geometrixx/en").adaptTo(Node.class);
		
		NodeIterator n2=n1.getNodes();
		while(n2.hasNext())
		{
			Node tmp=n2.nextNode();
			l1.add(tmp.getName());
		}
*/}

		public List getNode()
		{
			return l1;
		}
}
