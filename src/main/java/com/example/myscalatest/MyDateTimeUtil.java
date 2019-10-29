package com.example.myscalatest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class MyDateTimeUtil {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30));
        LocalDateTime end   = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 30));

        System.out.println(LocalDateTime.now().isAfter(start) && LocalDateTime.now().isBefore(end));
        System.out.println(start.toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(end.toEpochSecond(ZoneOffset.of("+8")));


        if (1==2) {

        } else if (1==3) {
            System.out.println("h");
        } else if (2==2) {
            System.out.println("2");
        }
    }
}
