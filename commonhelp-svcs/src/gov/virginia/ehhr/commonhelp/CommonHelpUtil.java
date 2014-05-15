package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Address;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonHelpUtil {
	
	static Logger LOGGER = LoggerFactory.getLogger(CommonHelpUtil.class);
	private static final String CLASS_NAME = CommonHelpUtil.class.getCanonicalName();
	
	/**
     * This method merges properties from fromObj to toObj 
     * Only the properties types in the if/else block below are supported. 
     * @param toObj
     * @param fromObj
     */
    public static void merge(Object toObj, Object fromObj){
        if(!toObj.getClass().isAssignableFrom(fromObj.getClass())){
            return;
        }

        Method[] methods = toObj.getClass().getDeclaredMethods();
        for(Method fromMethod: methods){
            if(fromMethod.getDeclaringClass().equals(toObj.getClass())
                    && (fromMethod.getName().matches("^get[A-Z].*$")||fromMethod.getName().matches("^is[A-Z].*$"))){
                String fromName = fromMethod.getName();
                String toName ;
                if(fromName.matches("^get[A-Z].*")){
                    toName = fromName.replace("get", "set");
                }else{
                    toName = fromName.replace("is", "set");
                }

                try {
                    Method toMethod = toObj.getClass().getMethod(toName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(fromObj, (Object[])null);
                    if(value != null){                      
                        if(value instanceof String && !value.toString().trim().isEmpty()){
                            toMethod.invoke(toObj, value);
                        }
                        else if(value instanceof Integer && (Integer)value != -1){
                            toMethod.invoke(toObj, value);
                        }
                        else if(value instanceof Long && (Long)value != -1){
                            toMethod.invoke(toObj, value);
                        }
                        else if(value instanceof Double && (Double)value != -1){
                            toMethod.invoke(toObj, value);
                        }
                        else if(value instanceof Boolean && (Boolean)value){
                            toMethod.invoke(toObj, value);
                        }
                        else if(value instanceof Address){
                            Address fromAddr = (Address) value;
                            Address toAddr = (Address)fromMethod.invoke(toObj, (Object[])null);
                            merge(toAddr, fromAddr);
                        }
                        
                        
                    }
                } catch (Exception e) {                 
                    LOGGER.debug(CLASS_NAME + "::merge - Merge failed - "+e.getMessage());
                } 
            }
        }
    }

}
