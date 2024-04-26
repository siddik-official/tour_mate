package com.example.demo;

import javafx.scene.image.Image;

public class Session {
    private static String username;
    private static String first_name;
    private static String last_name;
    private static String fullName;
    private static String emailID;
    private static String birthDate;
    private static String gender;
    private static Image profileImage;
    private static String bio;
    private static String nationality;
    private static String address;



    public static void setUserData(String username, String first_name, String last_name, String fullName, String emailID, String birthDate, String gender, String bio, String nationality, String address) {
        Session.username = username;
        Session.first_name = first_name;
        Session.last_name = last_name;
        Session.fullName = fullName;
        Session.emailID = emailID;
        Session.birthDate = birthDate;
        Session.gender = gender;
        Session.bio = bio;
        Session.nationality = nationality;
        Session.address = address;
    }

    public static UserData getUserData() {
        return new UserData(username, first_name, last_name, fullName, emailID, birthDate, gender, bio, nationality, address);
    }

    static class UserData {
        private final String username;
        private final String first_name;
        private final String last_name;
        private final String fullName;
        private final String emailID;
        private final String birthDate;
        private final String gender;
        private final String bio;
        private final String nationality;
        private final String address;

        public UserData(String username, String first_name, String last_name, String fullName, String emailID, String birthDate, String gender, String bio, String nationality, String address) {
            this.username = username;
            this.first_name = first_name;
            this.last_name = last_name;
            this.fullName = fullName;
            this.emailID = emailID;
            this.birthDate = birthDate;
            this.gender = gender;
            this.bio = bio;
            this.nationality = nationality;
            this.address = address;
        }

        public String getUsername() {

            return this.username;
        }

        public String getFirst_name() {

            return this.first_name;
        }

        public String getLast_name() {

            return this.last_name;
        }

        public String getFullName() {

            return this.fullName;
        }

        public String getEmailID() {

            return this.emailID;
        }

        public String getDateOfBirth() {

            return this.birthDate;
        }

        public String getGender() {

            return this.gender;
        }

        public String getBio() {

            return bio;
        }

        public String getNationality() {

            return this.nationality;
        }

        public String getAddress() {

            return this.address;
        }
    }
}
