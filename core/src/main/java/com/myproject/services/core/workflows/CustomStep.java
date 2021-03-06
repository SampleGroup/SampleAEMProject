package com.myproject.services.core.workflows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
   
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
    
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
    
import javax.jcr.Repository; 
import javax.jcr.SimpleCredentials; 
import javax.jcr.Node; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
     
import org.apache.jackrabbit.commons.JcrUtils;
    
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
    
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import javax.jcr.RepositoryException;
import org.apache.felix.scr.annotations.Reference;
import org.apache.jackrabbit.commons.JcrUtils;
    
import javax.jcr.Session;
import javax.jcr.Node; 
import org.osgi.framework.Constants;
  
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
  
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
   
//Sling Imports
import org.apache.sling.api.resource.ResourceResolverFactory ; 
import org.apache.sling.api.resource.ResourceResolver; 
import org.apache.sling.api.resource.Resource; 
import com.day.cq.wcm.api.Page; 
   
//This is a component so it can provide or consume services
@Component
   
    
@Service
  
@Properties({
    @Property(name = Constants.SERVICE_DESCRIPTION, value = "Test Email workflow process implementation."),
    @Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
    @Property(name = "process.label", value = "##Test Email Workflow Process") })
public class CustomStep implements WorkflowProcess 
{
       
      
/** Default log. */
protected final Logger log = LoggerFactory.getLogger(this.getClass());
      
//Inject a MessageGatewayService 
@Reference
private MessageGatewayService messageGatewayService;
      
public void execute(WorkItem item, WorkflowSession wfsession,MetaDataMap args) throws WorkflowException {
          
try
{
    log.info("Here in execute method");    //ensure that the execute method is invoked    
          
    //Declare a MessageGateway service
    MessageGateway<Email> messageGateway; 
          
    //Set up the Email message
    Email email = new SimpleEmail();
          
    //Set the mail values
    String emailToRecipients = "avinashsanjeeva@gmail.com"; 
    String emailCcRecipients = "hemanth.kumar1802@gmail.com"; 
      
    email.addTo(emailToRecipients);
    email.addCc(emailCcRecipients);
    email.setSubject("AEM Custom Step");
    email.setFrom("swamy.aem5@gmail.com"); 
    email.setMsg("The Worst msg");
      
    //Inject a MessageGateway Service and send the message
    messageGateway = messageGatewayService.getGateway(Email.class);
  
    // Check the logs to see that messageGateway is not null
    messageGateway.send((Email) email);
}
  
    catch (Exception e)
    {
    e.printStackTrace()  ; 
    }
 }
 
}