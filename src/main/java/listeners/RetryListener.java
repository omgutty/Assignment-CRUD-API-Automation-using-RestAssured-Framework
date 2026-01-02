package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class RetryListener implements IAnnotationTransformer
{
	//we are using reflection , so that we can change the method name, constructor name at run time.
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	 }
	
}
