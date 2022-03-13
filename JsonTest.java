package json;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class JsonTest {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Name", "iPhone");
		hashMap.put("company", "Apple");
		hashMap.put("OS", "iOS");
		hashMap.put("category", "Phone");
		
		JSONObject jsonObject = new JSONObject(hashMap);
		
		System.out.println(jsonObject.toJSONString());
	}

}
