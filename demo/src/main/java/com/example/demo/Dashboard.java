package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dashboard {
    public Dashboard() {
    }

    public void login(String username) {
        LoginController loginManager = new LoginController();
        if (loginManager.validateLogin()) {
            this.fetchAndSetTripData(username);
        } else {
            System.out.println("Login failed");
        }

    }

    public void fetchAndSetTripData(String username) {
        String tripsQuery = "SELECT SUM(CASE WHEN status = 'completed' THEN 1 ELSE 0 END) AS completed_trips,SUM(CASE WHEN status = 'interested' THEN 1 ELSE 0 END) AS interested_trips,SUM(CASE WHEN status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_trips FROM `trips` WHERE UserName = ?";

        try {
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();
            PreparedStatement tripsStatement = connectDB.prepareStatement(tripsQuery);
            tripsStatement.setString(1, username);
            ResultSet tripsResult = tripsStatement.executeQuery();
            if (tripsResult.next()) {
                String completed_trips = tripsResult.getString("completed_trips");
                String interested_trips = tripsResult.getString("interested_trips");
                String upcoming_trips = tripsResult.getString("upcoming_trips");
                System.out.println("Completed trips: " + completed_trips);
                SessionTrip.setTripData(completed_trips, interested_trips, upcoming_trips);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
