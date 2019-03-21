package alphacare;


import java.util.ArrayList;


/**
 *
 * @author Rodrigo
 */
public class hcModel {

    private final ArrayList<String> patientRecords = new ArrayList<>();


    public String[] ListRecords(int patientType, int gender) { 

        String[] AllMale = new String[3];

        AllMale[0] = ("Name: Jeff Burgos Age: 25 PlanType: 0021");
        AllMale[1] = ("Name: Zen Krim Age: 29 PlanType: 0024");
        AllMale[2] = ("Name: Matt Anetok Age: 45 PlanType: 043B");


        String[] AllFemale = new String[3];

        AllFemale[0] = ("Name: Kat Will Age: 32 PlanType: 0041");
        AllFemale[1] = ("Name: Jessica Blimes Age: 27 PlanType: 0024");
        AllFemale[2] = ("Name: Sara Buttons Age: 21 PlanType: 001");


        String[] TodayMale = new String[1];
        
        TodayMale[0] = ("Name: Jeff Burgos Age: 25 PlanType: 0021");


        String[] TodayFemale = new String[1];

        TodayFemale[0] = ("Name: Kat Will Age: 32 PlanType: 0041");


        if (gender == 0 && patientType == 0) {
            return TodayMale;

        } else if (gender == 0 && patientType == 1) {
            return AllMale;
        } else if (gender == 1 && patientType == 1) {
            return AllFemale;
        } else {
            return TodayFemale;
        }

    }

}
