package kr.or.ddit.basic.stream;

import java.io.FileWriter;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", "강정인");
			obj.put("mine", "GN");
			obj.put("year", 2021);

			FileWriter file = new FileWriter("c:/mine_data/mine.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj);
	}

}
