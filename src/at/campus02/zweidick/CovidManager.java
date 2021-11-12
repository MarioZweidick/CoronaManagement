package at.campus02.zweidick;

import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.HashMap;

public class CovidManager
{
    public static void main(String[] args)
    {
        Incidence stmk20211111 = new Incidence("Steiermark", "2021-11-11", 1300);
        Incidence stmk20211110 = new Incidence("Steiermark", "2021-11-10", 1200);
        Incidence stmk20211109 = new Incidence("Steiermark", "2021-11-09", 1150);

        Incidence bgld202111111 = new Incidence("Burgenland", "2021-11-11", 500);
        Incidence bgld202111110 = new Incidence("Burgenland", "2021-11-10", 400);
        Incidence bgld202111109 = new Incidence("Burgenland", "2021-11-09", 389);

        Incidence wien202111111 = new Incidence("Wien", "2021-11-11", 3400);
        Incidence wien202111110 = new Incidence("Wien", "2021-11-10", 2900);
        Incidence wien202111109 = new Incidence("Wien", "2021-11-09", 3100);

        Incidence tirol202111111 = new Incidence("Tirol", "2021-11-11", 1600);
        Incidence tirol202111110 = new Incidence("Tirol", "2021-11-10", 1560);
        Incidence tirol202111109 = new Incidence("Tirol", "2021-11-09", 1390);

        ArrayList<Incidence> recordedValues = new ArrayList<>();

        recordedValues.add(stmk20211111);
        recordedValues.add(stmk20211110);
        recordedValues.add(stmk20211109);

        recordedValues.add(bgld202111111);
        recordedValues.add(bgld202111110);
        recordedValues.add(bgld202111109);

        recordedValues.add(tirol202111111);
        recordedValues.add(tirol202111110);
        recordedValues.add(tirol202111109);

        recordedValues.add(wien202111111);
        recordedValues.add(wien202111110);
        recordedValues.add(wien202111109);

        recordedValues.add(new Incidence("Salzburg","2021-11-11", 1854));

        System.out.println("Count of recorded records = " + recordedValues.size());

        int countTotalIncidences = 0;

        for (Incidence recordedValue : recordedValues)
        {
            countTotalIncidences += recordedValue.getNumber();
        }
        System.out.println("Bisher in Österreich:  = " + countTotalIncidences + " Fälle!");

        HashMap<String, Integer> totalIncidencesState = new HashMap<>();

        for (Incidence recordedValue : recordedValues)
        {
            /*1.) Ist mein Key bereits in der Liste?
                2.) Wenn nein, dann muss ich den Key aufnehmen
                3.) Wenn ja, dann muss ich den Wert auslesen, summieren und neu ablegen*/

            if(totalIncidencesState.containsKey(recordedValue.getState()))
            {
                //ja, Fall 3
                int currentValue = totalIncidencesState.get(recordedValue.getState());
                currentValue += recordedValue.getNumber();
                totalIncidencesState.put(recordedValue.getState(), currentValue);
            }
            else
            {
                //nein, Fall 2
                totalIncidencesState.put(recordedValue.getState(), recordedValue.getNumber());
            }
        }

        System.out.println("totalIncidencesState = " + totalIncidencesState);
    }
}
