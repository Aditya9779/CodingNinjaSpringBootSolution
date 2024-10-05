package com.example.TuneIn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava", date = "11-08-2024")
public class TuneInApplication {

    public static void main(String[] args) {
        // Context initialized
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TuneIn");

        System.out.println("Welcome to Music Playlist Application");

        User user = context.getBean(MyUser.class);
        // Enter User details
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        user.setUserDetail(name, age);
        while (true) {
            System.out.println();
            System.out.println("Do you want to add Songs to the playlist \n1. Yes \n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                break;
            } else {
                System.out.println("Enter name of the song");
                String songName = scanner.nextLine();
                Song song = context.getBean(MySong.class);
                song.setName(songName);
                user.getPlaylist().addSong(song);
            }
        }

        String userRefId = user.toString();
        String userRefIdDisplay = userRefId.length() > 36 ? userRefId.substring(28, 36) : userRefId;
        System.out.println("Your Playlist with reference Id: " + userRefIdDisplay + " is Ready!!");

        for (Song song : user.getPlaylist().getPlaylistSongs()) {
            String songRefId = song.toString();
            String songRefIdDisplay = songRefId.length() > 36 ? songRefId.substring(28, songRefId.length()) : songRefId;
            System.out.println("Song name: " + song.getSongName() + "\t Reference Id: " + songRefIdDisplay);
        }
    }
}
