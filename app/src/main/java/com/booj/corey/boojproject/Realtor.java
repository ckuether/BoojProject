package com.booj.corey.boojproject;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Realtor {

    private String firstName = "";
    private String lastName = "";
    private String id = "";
    private String rebrand = "";
    private String office = "";
    private boolean isTeam = false;
    private String phoneNumber = "";
    private String photo = "";
    private String title = "";

    public Realtor(JSONObject json){
        firstName = json.optString("first_name");
        lastName = json.optString("last_name");
        id = json.optString("id");
        rebrand = json.optString("rebrand");
        office = json.optString("office");
        isTeam = json.optBoolean("is_team");
        phoneNumber = json.optString("phone_number");
        photo = json.optString("photo");
        title = json.optString("title");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRebrand() {
        return rebrand;
    }

    public void setRebrand(String rebrand) {
        this.rebrand = rebrand;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public boolean isTeam() {
        return isTeam;
    }

    public void setTeam(boolean team) {
        isTeam = team;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
