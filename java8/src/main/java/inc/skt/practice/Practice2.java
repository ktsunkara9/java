package inc.skt.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,6,7,3,2,1,5,2,6,8,2,7,3,7,3,4,5,7));
		
		Map<Integer, List<Integer>> numListGroupByNum= list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));
		numListGroupByNum.entrySet().forEach(entry -> System.out.println( entry.getKey()+" - "+entry.getValue().size()));
		System.out.println("======================");
		numListGroupByNum.forEach((key,value) -> System.out.println(key+" - "+value.size()));
	}

}
