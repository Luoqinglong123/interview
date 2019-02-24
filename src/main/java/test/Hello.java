package test;


import java.time.LocalDateTime;
import java.util.Calendar;

public class Hello {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,-1);
        System.out.println(instance.getTime());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusDays(1);
        LocalDateTime localDateTime1 = now.plusDays(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }

}