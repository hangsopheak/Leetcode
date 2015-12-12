/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyft;

/**
 *
 * @author SONGSONG
 */
public class ProgrammingChallenge {

    public static class point {

        double latitude;
        double longitude;

        public point(double lat, double lon) {
            latitude = lat;
            longitude = lon;
        }
    }

    static final double radius = 3959;// in miles or 6371 in Km

    public static double toRadians(double n) {
        return n * Math.PI / 180;
    }

    public static double calculateDistance(point a, point b) {
        double aLat = toRadians(a.latitude);
        double bLat = toRadians(b.latitude);
        double latDiff = aLat - bLat;
        double lonDiff = toRadians(a.longitude) - toRadians(b.longitude);

        // Haversine Formula
        double distance = Math.pow(Math.sin(latDiff / 2), 2) + (Math.cos(aLat) * Math.cos(bLat) * Math.pow(Math.sin(lonDiff / 2), 2));
        distance = 2 * Math.atan2(Math.sqrt(distance), Math.sqrt(distance));

        return distance * radius;
    }

    public static void main(String[] args) {
        point A = new point(5, 5);
        point B = new point(6, 7);
        point C = new point(10, 10);
        point D = new point(11, 12);

        double AB = calculateDistance(A, B);
        double CD = calculateDistance(C, D);

        if (AB > CD) {
            System.out.println("ACDB is shorter");
        } else if (AB == CD) {
            System.out.println("they are same");
        } else {
            System.out.println("CABD is shorter");
        }
    }
}
