package gov.virginia.ehhr.commonhelp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class CommonHelpInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	
	@PostConstruct
	public void init(){
		List<HttpMessageConverter<?>> messageConverters = requestMappingHandlerAdapter.getMessageConverters();
		
		for (HttpMessageConverter<?> messageConverter : messageConverters) {
			if (messageConverter instanceof MappingJacksonHttpMessageConverter) {   
				
				MappingJacksonHttpMessageConverter m = (MappingJacksonHttpMessageConverter) messageConverter;
				ObjectMapper om = m.getObjectMapper();
				
                // Only include non-null properties during serializing JSON
                om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
                
                // Do not fail on unknown properties during deserialization of JSON
                om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                
                
                m.setObjectMapper(om);
			}
		}
	}
}
