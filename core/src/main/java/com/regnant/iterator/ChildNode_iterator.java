/*package com.regnant.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.cq.sightly.WCMUse;
import com.myproject.services.core.use.HeaderNavigation;

public class ChildNode_iterator extends WCMUse {

	Session session;
	ResourceResolverFactory resourceResolverFactory;
	ResourceResolver resourceResolver;
	Resource resource=null;
	Node node=null;
	String path=null;

	List<String> list = new ArrayList<String>();

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub

		final Logger log = LoggerFactory.getLogger(ChildNode_iterator.class);

		//ResourceResolver resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			
		path = "/content/geometrixx-outdoors/en";
		resource= getResourceResolver().resolve(path);
		log.debug("get the Admin session");

		// ResourceResolverFactory.getResourceResolver(Map);
		
		//resource = resourceResolver.getResource(path);
		log.debug("The path is:{}" + path);
		// log.debug("Parent Path :{}", parentPage);
		if (null != resource) {
			node = resource.adaptTo(Node.class);
			NodeIterator iterator = node.getNodes();

			while (iterator.hasNext()) {
				Node temp=iterator.nextNode();
				//list.add(iterator.nextNode().getName());
				list.add(temp.getName());
			}
		}
		//resourceResolver.close();
	}

	public List childIter() throws RepositoryException {
		// TODO Auto-generated method stub
		return list;
	}
}


 * Session session; ResourceResolver rr; 
 * Resource res;
 * 
 * List<String> list = new ArrayList<String>();
 * 
 * @Override public void activate() throws Exception { // TODO Auto-generated
 * method stub final Logger
 * log=LoggerFactory.getLogger(ChildNode_iterator.class); res =
 * rr.getResource("/content/geometrixx/en"); Session session =
 * res.adaptTo(Session.class); Node node=session.getNode(null); log.debug(
 * "Node Name"+node.getName());
 * 
 * session = rr.adaptTo(Session.class); NodeIterator iterator=node.getNodes();
 * while(iterator.hasNext()) { list.add(iterator.nextNode().getName()); } }
 * public List<String> childReturn() { // TODO Auto-generated method stub return
 * list; } }
 
*/