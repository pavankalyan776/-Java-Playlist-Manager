package com.lesson.lab.controller;

import com.lesson.lab.model.Song;

public class SinglyLinkedPlaylistManager {
    class Node {
        Song song; //Holds the data for each node, which in this case is a Song object.
        Node next; //A reference to the next node in the list, allowing traversal forward.

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    private Node head;
    private Node current;

    public SinglyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    // Method to add a song to the playlist
    public void addFavoriteSong(Song newSong) {
        if (isDuplicate(newSong)) {
            System.out.println("Song already exists in the playlist.");
        }
        Node newNode  = new Node(newSong);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        //print a confirmation message that the song was added
        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to remove a song from the playlist based on the given index
    public void removeFavoriteSong(int index) {
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }

        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }

        if (index == 1) {
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < index) {
            previous = current;
            current = current.next;
            count ++;
        }

        if (current == null) {
            System.out.println("Invalid index.");
        } else {
            System.out.println(current.song.getTitle() + " removed from the playlist.");
            previous.next = current.next;
        }

    }

    // Method to display all songs with index
    public void displayFavoriteSongs() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;
        }
    }

    // Method to play the next song in the playlist
    public void playNextFavoriteSong() {
        if (current == null || current.next == null) {
            System.out.println("No next song in the playlist.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to play the previous song in the playlist
    public void playPreviousFavoriteSong() {
        if (current == null || current == head) {
            System.out.println("There is no previous song to play.");
        } else {
            Node temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to start playing from the first song in the playlist
    public void setCurrentToFirst() {
        current = head;
        if (current != null) {
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Check if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}

