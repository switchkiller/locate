package brun.com.melocate;

/**
 * Created by switchkiller on 22/2/16.
 */

/* Wrapper class for location coordinates */

public final class mygeolocation {
    public final double longitude;

    public final double latitude;


    public mygeolocation(double longitude, double latitude){
        if (!mygeolocation.coordinatesValid(longitude, latitude)){              //Check the validity of the location. latitude in range [-90,90] and longitude [-180, 180]
            throw new IllegalArgumentException("Not a geo location: " + latitude + ", " + longitude);
        }
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public static boolean coordinatesValid(double longitude, double latitude){
        return (latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180)
    }

    /* Check for equality */

    public boolean equal(Object o){
        if (this == o) return true;

        mygeolocation that = (mygeolocation) o;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;

        return true;
    }

    public String toString(){

        return "GeoLocation(" + latitude + ", " + longitude + ")";
    }
}
