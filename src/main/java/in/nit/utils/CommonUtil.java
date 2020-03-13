package in.nit.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	public static Map<Integer,String> conver(List<Object[]> list) {
		Map<Integer,String> map=new HashMap<>();
		for(Object[] arr:list) {
			map.put(Integer.valueOf(arr[0].toString()), arr[1].toString());
		}
		return map;
	}

}
