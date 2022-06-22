package test;

import org.junit.Test;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Scanner;

public class MyTestTest {

    @Test
    public void myTest() {
        Scanner sr = new Scanner(System.in);
        System.out.println("楼的话在此");
        System.out.println((int) 'A');
        final String AA = "AAA";
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String st = formatter.format(LocalDateTime.now());
        System.out.println(st);
        TemporalAccessor parse = formatter.parse("2022-06-13 04:02:18");
        System.out.println(parse);

        String[] arr = {"BB","AA","MM","GG","DD","JJ"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}