package straightWithoutBdd.api.services;

import java.util.HashMap;

public class GetCredentials {

    public static HashMap<String, String> getCredentials(){

        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        return credentials;
    }
}
