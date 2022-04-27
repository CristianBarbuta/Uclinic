package comparator;

import java.util.Comparator;

import model.Appuntamento;

public class AppuntamentoComparatorGiorno implements Comparator<Appuntamento> {
	@Override
	public int compare(Appuntamento a1, Appuntamento a2) {
		int val = 0;
		if (a1.getGiorno()>a2.getGiorno()) 
		{
			
			     val = 1;
			
		} 
		else if (a1.getGiorno()<a2.getGiorno())
		{
			
			val = -1; 
			
		}
		return val;
	}
}
