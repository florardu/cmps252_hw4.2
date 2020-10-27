package cmps252.HW4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

	public static List<Customer> getCustomers( String FileName ) throws FileNotFoundException {
		
		List<Customer> lst = new ArrayList<Customer>();
		
		Scanner sc = new Scanner( new File( FileName ) );
		
		int lineCount = 0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if( lineCount++ == 0 ) continue;
			
			String[] fields =  line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			
			Customer c = new Customer( 
				clean(fields[0]),
				clean(fields[1]),
				clean(fields[2]),
				clean(fields[3]),
				clean(fields[4]),
				clean(fields[5]),
				clean(fields[6]),
				clean(fields[7]),
				clean(fields[8]),
				clean(fields[9]),
				clean(fields[10]),
				clean(fields[11])
			);
			
			lst.add(c);
			
		}
		
		return lst;
		
	}
	
	private static String clean(String s) {
		return s.substring(1, s.length()-1);
	}

}