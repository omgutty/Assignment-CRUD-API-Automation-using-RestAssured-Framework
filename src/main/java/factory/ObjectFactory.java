package factory;

import models.AddObject;
import models.AddObject.productdata;
import models.UpdateObject;

public class ObjectFactory {

		public static  AddObject generateresutfullobjectdata() 
		{
			
			AddObject object= new AddObject("Apple MacBook Pro 16",new AddObject.productdata(2019,1849.99,"Intel Core i9","1 TB",null));
			return object;
		}
		
		public static UpdateObject updaterestfullobjectdata() {
			UpdateObject updateobject= new UpdateObject("Apple MacBook Pro 16",new UpdateObject.data(2019,2049.99,"Intel Core i9","1 TB","silver"));
			return updateobject;
			
		}
		
		

}
