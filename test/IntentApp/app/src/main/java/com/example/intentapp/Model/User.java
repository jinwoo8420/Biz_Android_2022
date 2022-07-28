package com.example.intentapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private int age;

    public User() { }

    public User(String name, int age)  {
        this.name = name;
        this.age = age;
    }

    protected User(Parcel in) { // write 순서와 read 순서는 같아야 함
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public int describeContents() { return 0; }
    // 객체 -> 직렬화한 데이터(Parcel)
    @Override
    public void writeToParcel(Parcel dest, int flags) { dest.writeString(name); dest.writeInt(age); }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}