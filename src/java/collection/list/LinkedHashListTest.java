package java.collection.list;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashListTest
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		/* ¸´ÖÆHashSet */
		@SuppressWarnings("rawtypes")
		Set h1 = new HashSet<String>();
		h1.add("List");
		h1.add("Queue");
		h1.add("Set");
		h1.add("Map");
		
		System.out.println("HashSet Elements:");
		System.out.print("\t" + h1 + "\n");
		
		@SuppressWarnings("rawtypes")
		Set h2 = copy(h1);
		System.out.println("HashSet Elements After Copy:");
		System.out.print("\t" + h2 + "\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set copy(Set set)
	{
		Set setCopy = new LinkedHashSet(set);
		return setCopy;
	}
	
}
