package jp.opensquare.sandbox.cxf.jaxws.requestor;


import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class JaxwsDynRequestor {
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/cxf-jaxws/CalculateService?wsdl");
		client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new LoggingOutInterceptor());

		List<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);

		Object[] result = client.invoke("sum", values);
		System.out.println("Sum: " + result[0]);
		System.exit(0);
	}
}
