package commandline;

import java.util.LinkedHashMap;

public class Model_Card {
	
	
	//Attributes_____________________
	
	private String description;
	
	// This map is a categories map stores category and value for each card
	private LinkedHashMap<String, Integer> categores = new LinkedHashMap<String, Integer>(); 
	
	private String selectedCategoryName; //this will be changed when selected a category
	
	
	
	
	
	//getter and setter________________________
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSelectedCategoryName() {
		return selectedCategoryName;
	}

	// This method set the selected category at each turn.
	public void setSelectedCategoryName(String selectedAttributeString) {
		this.selectedCategoryName = selectedAttributeString;
	}
	
	
	public LinkedHashMap<String, Integer> getCategores() {
		return categores;
	}
	
	// This method will set the categories for each card
	public void giveCategory(String key, int value) {
		
		this.categores.put(key, value);
		
	}
	
	
	
	
	
	
	
	//Method_______________________
    public int getSelectedCategoryValue() {
    	
    	//find the target value of the category 

		for (String key : categores.keySet()) {
			
			if(key.equals(this.selectedCategoryName)) {
				
				return categores.get(key);
			}
		}
		return 0;	 
    }
    
    public String selectedCategoryDetail() {
    	String output = "";
    	output += selectedCategoryName + " : " + getSelectedCategoryValue();
    	return output;
    }
    
    @Override
    public String toString() {
    	 String outcome = "";
    	 
    	 
    	 for (String key : categores.keySet()) {
    		 
             int value = categores.get(key);
             
             outcome += "> "+ key + ": " + value + "\n";
         }
    	 
    	 return outcome;	
    	
    }
    
    public String cardDetail() {
    	String output = "";
    	
    	output += this.description;
    	
    	for (String key : categores.keySet()) {
   		 
            int value = categores.get(key);
            
           output += ","+value ;
           
        }
    	return output;
    }
}
    
//
//
//	// we need to use reflection to get the attribute and its value from each instance 
//	// return a map
//	public LinkedHashMap<String, Integer> getClassAttribute() {
//		Field[] fields = this.getClass().getDeclaredFields(); // this array will store the instance's attribute in each field.
//		
//		LinkedHashMap<String, Integer> attributeMap = new LinkedHashMap<String, Integer>();
//		//LinkedHashMap can be added by "put" order.
//		
//		for (Field field : fields) {
//			field.setAccessible(true);
//			String key = field.getName();
//			int value = 0;
//			try {
//				value = (Integer)field.get(this);
//			} catch (IllegalArgumentException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			attributeMap.put(key, value);
//		}
//		
//		return attributeMap;
//		
//	}


// this function to get selected category value

	

