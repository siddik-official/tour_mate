package com.example.demo;

public class SessionTrip {

    public static String completed_trips;
    public static String interested_trips;
    public static String upcoming_trips;

    public SessionTrip() {
    }

    public static void setTripData(String completed_trips, String interested_trips, String upcoming_trips) {
        SessionTrip.completed_trips = completed_trips;
        SessionTrip.interested_trips = interested_trips;
        SessionTrip.upcoming_trips = upcoming_trips;
    }

    public static TripData getTripData() {
        return new TripData(completed_trips, interested_trips, upcoming_trips);
    }

    static class TripData {
        private final String completed_trips;
        private final String interested_trips;
        private final String upcoming_trips;

        public TripData(String completed_trips, String interested_trips, String upcoming_trips) {
            this.completed_trips = completed_trips;
            this.interested_trips = interested_trips;
            this.upcoming_trips = upcoming_trips;
        }

        public String getCompleted_trips() {

            return this.completed_trips;
        }

        public String getInterested_trips() {

            return interested_trips;
        }

        public String getUpcoming_trips() {

            return upcoming_trips;
        }
    }

}
