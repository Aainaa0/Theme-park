package controller.calculation;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static int calculateAge(LocalDate birthDate) {
    	LocalDate currentDate = LocalDate.now();
    	System.out.println("current date: "+currentDate);
    	System.out.println("date of birth: "+birthDate);
    	
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
