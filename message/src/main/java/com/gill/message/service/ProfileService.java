package com.gill.profile.service;

import com.gill.message.database.DatabaseClass;
import com.gill.message.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private static Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Rashpal", new Profile(1L, "Rashpal","Rashpal", "Gill"));
        profiles.put("Jaspreet", new Profile(2L, "Jaspreet", "Jaspreet","Gill"));

    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty() ){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
