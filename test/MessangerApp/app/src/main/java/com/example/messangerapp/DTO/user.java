package com.example.messangerapp.DTO;

public class user {
    private String uid;
    private String name;
    private String profileimageUri;
    private String stateMessage;

    public user() { }

    public user(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public user(String uid, String name, String profileimageUri) {
        this(name ,uid);
        this.profileimageUri = profileimageUri;
    }

    public user(String uid, String name, String profileimageUri, String stateMessage) {
        this(uid, name, profileimageUri);
        this.stateMessage = stateMessage;
    }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getProfileimageUri() { return profileimageUri; }

    public void setProfileimageUri(String profileimageUri) { this.profileimageUri = profileimageUri; }

    public String getStateMessage() { return stateMessage; }

    public void setStateMessage(String stateMessage) { this.stateMessage = stateMessage; }

    @Override
    public String toString() {
        return "user{" + "uid='" + uid + '\'' + ", name='" + name + '\'' + ", profileimageUri='" + profileimageUri + '\'' + ", stateMessage='" + stateMessage + '\'' + '}';
    }
}
