package com.example.a2ndmissionmad;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String name, age, address;

    public User(){
        this.name = "";
        this.address = "";
        this.age = "";
    }

    public User(String name, String age,String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
    protected User(Parcel in) {
        name = in.readString();
        age = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getName(){return name;}
    public void setName (String name) {this.name = name;}

    public String getAge(){return age;}
    public void setAge (String age) {this.age = age;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}
}
