package com.cn.hotel;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Author(name = "Aditya Srivastava", date = "14-10-2024")
public class HotelApplication {

    public static void main(String[] args) {
        //   SpringApplication.run(HotelApplication.class, args);
        String str = "abkhkjdsjajksdfgnajdadsfjlk;afdslkajlgkasda";
        String ans = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
                for (int j = 0; j < count; j++) {
                    ans += "*";
                }
            } else {
                ans += str.charAt(i);
            }
        }
        System.out.println(ans);

    }

}
