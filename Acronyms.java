package Acronyms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Acronyms {
	private Map<String, String> acronymTable;

	public Acronyms() {
		acronymTable = new TreeMap<String, String>();

	}

	public void putEntry(String entry) {
		String[] list = entry.split(" - ");
		acronymTable.put(list[0], list[1]);
	}

	public String convert(String sent) {
		// Scanner chop = new Scanner(sent);
		String output = "";
		String[] w = sent.split("\n");
		for (int j = 0; j < w.length; j++) {
			String[] list = w[j].split(" ");
			for (int i = 0; i < list.length; i++) {
				if (list[i].contains(".")) {
					list[i] = list[i].replace(".", "").replace(" ", "");
					if (acronymTable.containsKey(list[i]))
						output += acronymTable.get(list[i]) + ". ";
					else
						output += list[i] + ". ";
				} else {
					list[i] = list[i].replace(".", "").replace(" ", "");
					if (acronymTable.containsKey(list[i]))
						output += acronymTable.get(list[i]) + " ";
					else
						output += list[i] + " ";
				}
			}
			output += "\n";
		}
		return output;
	}

	public String encode(String entry) {
		String output = entry;
		// create an ArrayList of values
		ArrayList<String> sortedVals = new ArrayList<String>();
		for (String a : acronymTable.keySet()) {
			sortedVals.add(acronymTable.get(a));
			//System.err.println(a);
		}

		// Sort the ArrayList of values based on number of words
		// descending
		for(int i = 0; i < sortedVals.size(); i++) {
			int tested = sortedVals.get(i).split(" ").length;
			int j = i - 1;
			String asd = sortedVals.get(i);
			while( j >= 0 && tested > sortedVals.get(j).split(" ").length) {
			sortedVals.set(j + 1, sortedVals.get(j));
			j--;
			}
			sortedVals.set(j + 1, asd);
			}

		// Now swap the words with the its acronym in order
		// order(swap acronyms with most number of words first)
		for (int i = 0; i < sortedVals.size(); i++) {
			String acronym = "";
			for (String a : acronymTable.keySet()) {
				if (acronymTable.get(a).toLowerCase().equals(sortedVals.get(i).toLowerCase())) {
					acronym = a;
					//System.err.println(a);
				}
			}
			if (output.contains(sortedVals.get(i))) {
				output = output.replaceAll(sortedVals.get(i), acronym);
			}
			else if(output.contains(sortedVals.get(i).toLowerCase())) {
				output = output.replaceAll(sortedVals.get(i).toLowerCase(), acronym);
			}
			else if(output.contains(sortedVals.get(i).toUpperCase())) {
				output = output.replaceAll(sortedVals.get(i).toUpperCase(), acronym);
			}
		}

		output = output.replace(".", ".\n");
		return output;
	}

	public String toString() {
		String output = "{";
		for (String a : acronymTable.keySet()) {
			output += a + "=" + acronymTable.get(a) + "\n";
		}
		output += "}";
		return output;
	}

	// if you want to use other class types
	private class ValsOrder implements Comparable<String> {
		String s;

		ValsOrder(String a) {
			a = s;
		}

		public String toString() {
			return s;
		}

		public int compareTo(String o) {
			if (s.split(" ").length > o.split(" ").length)
				return 1;
			else if (s.split(" ").length < o.split(" ").length)
				return -1;
			else
				return 0;
		}

	}

}
