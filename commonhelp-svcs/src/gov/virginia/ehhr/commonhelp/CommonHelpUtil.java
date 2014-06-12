package gov.virginia.ehhr.commonhelp;

import gov.virginia.ehhr.commonhelp.domain.Address;
import gov.virginia.ehhr.commonhelp.domain.Income;
import gov.virginia.ehhr.commonhelp.domain.SelfEmployment;
import gov.virginia.ehhr.commonhelp.domain.SelfEmploymentExpense;

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
                    toName = fromName.replaceFirst("get", "set");
                }else{
                    toName = fromName.replaceFirst("is", "set");
                }
                
                try {
                    Method toMethod = toObj.getClass().getMethod(toName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(fromObj, (Object[])null);
                    if(value != null){  
	                    if(value instanceof Address){
	                        Address fromAddr = (Address) value;
	                        Address toAddr = (Address)fromMethod.invoke(toObj, (Object[])null);
	                        if(toAddr == null)
	                        	toAddr =  new Address();
	                        merge(toAddr, fromAddr);
	                        toMethod.invoke(toObj, toAddr);
	                    } else if(value instanceof Income){
	                    	Income fromIncome = (Income) value;
	                    	Income toIncome = (Income)fromMethod.invoke(toObj, (Object[])null);
	                        if(toIncome == null)
	                        	toIncome =  new Income();
	                        merge(toIncome, fromIncome);
	                        toMethod.invoke(toObj, toIncome);
	                    } else if(value instanceof SelfEmployment){
	                    	SelfEmployment fromSelfEmp = (SelfEmployment) value;
	                    	SelfEmployment toSelfEmp = (SelfEmployment)fromMethod.invoke(toObj, (Object[])null);
	                        if(toSelfEmp == null)
	                        	toSelfEmp =  new SelfEmployment();
	                        merge(toSelfEmp, fromSelfEmp);
	                        toMethod.invoke(toObj, toSelfEmp);
	                    } else if(value instanceof SelfEmploymentExpense){
	                    	SelfEmploymentExpense fromSelfEmpExp = (SelfEmploymentExpense) value;
	                    	SelfEmploymentExpense toSelfEmpExp = (SelfEmploymentExpense)fromMethod.invoke(toObj, (Object[])null);
	                        if(toSelfEmpExp == null)
	                        	toSelfEmpExp =  new SelfEmploymentExpense();
	                        merge(toSelfEmpExp, fromSelfEmpExp);
	                        toMethod.invoke(toObj, toSelfEmpExp);
	                    }
	                    else
	                    	toMethod.invoke(toObj, value);
                    }
                } catch (Exception e) {                 
                    LOGGER.error(CLASS_NAME + "::merge - Merge failed - "+e.getMessage());
                } 
            }
        }
    }

}
