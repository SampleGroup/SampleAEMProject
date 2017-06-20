package com.myproject.services.core.use;

import org.apache.jackrabbit.spi.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;

public class Naviga  extends WCMUse{
	final Logger log= LoggerFactory.getLogger(Naviga.class);
	String path="content/geometrixx/en";
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	public void AEMApi(Page page)
	{
		log.debug("Parent Path :{}",page.getDepth());
		
		log.debug("Parent Path :{}",page.getPath());
		
	}
}
