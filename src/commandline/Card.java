package commandline;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Card {
	private String describution;
	private String selectedAttributeString; //this will be changed when selected a category --reflection used
	private int speed;
	private int cargo;
	private int size;
	private int range;
	
	public String getDescribution() {
		return describution;
	}
	public String getSelectedAttributeString() {
		return selectedAttributeString;
	}
	public int getSpeed() {
		return speed;
	}
	public int getCargo() {
		return cargo;
	}
	public int getSize() {
		return size;
	}
	public int getRange() {
		return range;
	}

	public void setSelectedAttributeString(String selectedAttributeString) {
		this.selectedAttributeString = selectedAttributeString;
	}
	
	
	// we need to use reflection to get the attribute and its value from each instance 
	// return a map
	public LinkedHashMap<String, Integer> getClassAttribute() {
		Field[] fields = this.getClass().getDeclaredFields(); // this array will store the instance's attribute in each field.
		
		LinkedHashMap<String, Integer> attributeMap = new LinkedHashMap<String, Integer>();
		//LinkedHashMap can be added by "put" order.
		
		for (Field field : fields) {
			field.setAccessible(true);
			String key = field.getName();
			int value = 0;
			try {
				value = (Integer)field.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			attributeMap.put(key, value);
		}
		
		return attributeMap;
		
	}
    // this function to get selected category value
    
    public int getSelectedCategoryValue() {
    	
    	Map<String, Integer> attributeMap = getClassAttribute();
    	
    	//find the target value of the category 

		for (String key : attributeMap.keySet()) {
			
			if(key.equals(this.selectedAttributeString)) {
				
				return attributeMap.get(key);
			}
		}
		
		return 0;
		 

    }
    
    public String findBiggestCategory() {
    	Map<String, Integer> attributeMap = getClassAttribute();
    	int maxvalue = 0;
    	String categoryName = "";
    		for (String key : attributeMap.keySet()) {
    			if(attributeMap.get(key) > maxvalue) {
    				maxvalue = attributeMap.get(key);
    				categoryName = key;
    			}
    			
				}
    		return categoryName;
    	
    	}
    
    @Override
    public String toString() {
    	 String outcome = "";
    	Map<String, Integer> attributeMap = getClassAttribute();
    	 for (String key : attributeMap.keySet()) {
    		 
             int value = attributeMap.get(key);
             outcome += ">"+ key + ":" + value + "\n";
         }
    	 return outcome;
    	
    	
    	
    }
}
    

	

