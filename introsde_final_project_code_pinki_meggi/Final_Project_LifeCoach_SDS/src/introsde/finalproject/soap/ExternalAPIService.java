
package introsde.finalproject.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ExternalAPIService", targetNamespace = "http://soap.finalproject.introsde/", wsdlLocation = "http://localhost:778/soap/externalapi?wsdl")
public class ExternalAPIService
    extends Service
{

    private final static URL EXTERNALAPISERVICE_WSDL_LOCATION;
    private final static WebServiceException EXTERNALAPISERVICE_EXCEPTION;
    private final static QName EXTERNALAPISERVICE_QNAME = new QName("http://soap.finalproject.introsde/", "ExternalAPIService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:778/soap/externalapi?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EXTERNALAPISERVICE_WSDL_LOCATION = url;
        EXTERNALAPISERVICE_EXCEPTION = e;
    }

    public ExternalAPIService() {
        super(__getWsdlLocation(), EXTERNALAPISERVICE_QNAME);
    }

    public ExternalAPIService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EXTERNALAPISERVICE_QNAME, features);
    }

    public ExternalAPIService(URL wsdlLocation) {
        super(wsdlLocation, EXTERNALAPISERVICE_QNAME);
    }

    public ExternalAPIService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EXTERNALAPISERVICE_QNAME, features);
    }

    public ExternalAPIService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ExternalAPIService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ExternalAPI
     */
    @WebEndpoint(name = "ExternalAPIImplPort")
    public ExternalAPI getExternalAPIImplPort() {
        return super.getPort(new QName("http://soap.finalproject.introsde/", "ExternalAPIImplPort"), ExternalAPI.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ExternalAPI
     */
    @WebEndpoint(name = "ExternalAPIImplPort")
    public ExternalAPI getExternalAPIImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.finalproject.introsde/", "ExternalAPIImplPort"), ExternalAPI.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EXTERNALAPISERVICE_EXCEPTION!= null) {
            throw EXTERNALAPISERVICE_EXCEPTION;
        }
        return EXTERNALAPISERVICE_WSDL_LOCATION;
    }

}
