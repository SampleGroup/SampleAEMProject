
package com.adobeaemclub.adobeaemclub.core.services;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.adobe.cq.sightly.WCMUse;
 
public class Developer extends WCMUse {
	Logger logger = LoggerFactory.getLogger(Developer.class);
	protected String detail;
 
	@Override
	  public void activate() {   
 
	    SightlySerivceInterface service = getSlingScriptHelper().getService(SightlySerivceInterface.class);
	    detail = service.getDeveloperData();
	  }
 
	  public String getDetails() {
	    return this.detail;
	  }
}