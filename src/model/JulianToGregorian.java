package model;

/**
* A class that makes a conversion from the Julian Calender to the Gregorian Calender
*/
public class JulianToGregorian {

   /**
    *
    * @param julianDate the desired julianDate
    * @return to Gregorian date in european date format
    */
   public static String convert(double julianDate){

       double Q = julianDate + 0.5;
       int Z = (int) Q;
       int W = (int) ((Z - 1867216.25)/36524.25);
       double X = W / 4;
       double A = Z + 1 + W - X;
       double B = A + 1524;
       int C = (int) ((B - 122.1)/365.25);
       int D = (int) (365.25*C);
       int E = (int) ((B - D) / 30.6001);
       int F = (int) (30.6001 * E);

       int day = (int) (B - D - F + (Q - Z));
       int month = E==13?12:(E - 1) % 12;
       int year =  C - (month<=2 ? 4715 : 4716);

       return day + " / " + month + " - " + year;
   }

}
