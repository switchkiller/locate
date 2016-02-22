package brun.com.melocate;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseException;

import java.util.List;
import java.util.Map;

/**
 * Created by switchkiller on 22/2/16.
 */

public class melocate {

    static mygeolocation getLocation(DataSnapshot dataSnapshot){
        try{
            Map data = dataSnapshot.getValue(Map.class);
            List<?> location = (List<?>) data.get("1");
            Number latitudeobj = (Number) location.get(0);
            Number longitudeobj = (Number) location.get(1);
            double latitude = latitudeobj.doubleValue();
            double longitude = longitudeobj.doubleValue();

            if (location.size() == 2 && mygeolocation.coordinatesValid(longitude, latitude)){
                return new mygeolocation(longitude, latitude);
            }
            else{
                return null;
            }

        }
        catch (FirebaseException e){
            return null;
        }
        catch (NullPointerException e){
            return null;
        }
        catch (ClassCastException e){
            return null;
        }

    }

    private final Firebase firebase;

    public melocate(Firebase firebase){
        return this.firebase;
    }

    public Firebase getfirebase(){
        return this.firebase;
    }

    Firebase firebaseRefForKey(String key){
        return this.firebase.child(key);
    }

    public static interface CompleteListener{

        public void onComplete(String key, Firebase error);

    }

}
