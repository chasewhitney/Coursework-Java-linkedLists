package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<Album>();
        LinkedList<Song> playList = new LinkedList<Song>();

        Album album = new Album("Good Songs", "Good Artist");
        album.addSong("Good Title", 4.6);
        album.addSong("Good Deal", 2.6);
        album.addSong("Good Stuff", 3.6);
        album.addSong("Good Times", 6.6);
        albums.add(album);

        album = new Album("Old Songs", "Old Artist");
        album.addSong("Ancient History", 4.6);
        album.addSong("Elder", 2.6);
        album.addSong("Really Old", 3.6);
        album.addSong("From Long Ago", 6.6);
        albums.add(album);

        albums.get(0).addToPlayList("Good Deal", playList);
        albums.get(0).addToPlayList("Good Stuff", playList);
        albums.get(1).addToPlayList("Elder", playList);
        albums.get(1).addToPlayList("From Long Ago", playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().getInfo());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getInfo());
                    } else {
                        System.out.println("You have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().getInfo());
                    } else {
                        System.out.println("You're at the beginning of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().getInfo());
                            forward = false;
                        } else {
                            System.out.println("At the start of the list.");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().getInfo());
                            forward = true;
                        } else {
                            System.out.println("You have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("0 - quit");
        System.out.println("1 - next");
        System.out.println("2 - previous");
        System.out.println("4 - list");
        System.out.println("5 - menu");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getInfo());
        }
        System.out.println("==================");
    }
}
