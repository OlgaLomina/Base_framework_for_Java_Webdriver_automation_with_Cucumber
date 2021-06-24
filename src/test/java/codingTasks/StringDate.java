package codingTasks;

import org.testng.annotations.Test;

public class StringDate {


        @Test
        public void findDate(){
            int dayO = dayOfYear("2020-09-10");
            System.out.println("Day");
        }

        public int dayOfYear(String date) {

            int[] mons ={31,28,31,30,31,30,31,31,30,31,30,31};
            int oPut=0;
            int mmVale=0;


            String[] dateParts =date.split("-");
            int dateVal = Integer.parseInt(dateParts[2]);
            int monVal = Integer.parseInt(dateParts[1]);
            int yearVal = Integer.parseInt(dateParts[0]);

            if (monVal==1){
                return dateVal;
            }
            for (int i=2;i<=monVal;i++){
                mmVale+=mons[i];

            }
            if (yearVal%4==0 && monVal>2){
                oPut++;
            }
            oPut=dateVal+mmVale;

            return oPut;


        }


}
