package RestAssuredPractice;

import org.testng.annotations.DataProvider;

	public class TestDataParentClass {
	
		@DataProvider(name ="dPost")
		public Object[][] dataForPost(){
		
			return new Object[][] {
				{"Cool","Hot",2},
				{"Summer","Winter",1}
			};
		
		}
	
		@DataProvider(name="dDelete")
		public Object[] dataForDelete() {
			
			return new Object[] {
				9,10
					
			};
		}
}
