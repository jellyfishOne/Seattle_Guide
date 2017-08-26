package com.trivia_game.android.seattleguide;

/**
 * Created by JuanRenteria on 8/23/17.
 */

public class Location {
    ////////////////// Instance Variables ////////////////

    //string resource ID for the name of the locaton
    private int mNameID;

    //string resource ID for the address of the location
    private int mAddressID;

    //string resource ID for the telephone of the location
    private int mPhoneNumberID;

    //string resource ID for the latitude and longitude of the location
    private int mGeoLocationID;

    //Image resource ID for the location
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    //Constant value that represents no image was provided for this loation
    private static final int NO_IMAGE_PROVIDED = -1;

    ////////////////// Constructors ////////////////
    /**
     * Create a new Location object
     *
     * @param name is the string resource ID for the name of the location
     * @param address is the string resource ID for the address of the location
     * @param phoneNumber is the string resource ID for the phone number of the location
     * @param geoLocationID is the string resource ID for the latitude and longitude of the location
     */
    public Location(int name, int address, int phoneNumber, int geoLocationID){
        mNameID = name;
        mAddressID = address;
        mPhoneNumberID = phoneNumber;
        mGeoLocationID = geoLocationID;
    }

    /**
     * Create a new Location object
     *
     * @param name is the string resource ID for the name of the location
     * @param address is the string resource ID for the address of the location
     * @param phoneNumber is the string resource ID for the phone number of the location
     * @param geoLocationID is the string resource ID for the latitude and longitude of the location
     * @param image is the image resource ID for the location
     */
    public Location(int name, int address, int phoneNumber, int geoLocationID, int image){
        mNameID = name;
        mAddressID = address;
        mPhoneNumberID = phoneNumber;
        mGeoLocationID = geoLocationID;
        mImageResourceID = image;
    }

    ////////////////// Public Methods ////////////////

    /**
     * Get the string resource ID for the name of the location.
     */
    public int getName(){
        return  mNameID;
    }

    /**
     * Get the string resource ID for the address of the location
     */
    public int getAddress(){
        return mAddressID;
    }

    /**
     * Get the string resource ID for the phone number of the location
     */
    public int getPhoneNumber(){
        return mPhoneNumberID;
    }

    /**
     * Get the string resource ID for the latitude and longitude of the location
     */
    public int getGeoLocation(){
        return mGeoLocationID;
    }


    /**
     * Get the image resource ID for the image of the location
     */
    public int getImage(){
        return mImageResourceID;
    }

    /**
     * Returns whether or not there is an image resource ID for the location
     */
    public boolean hasImage(){
        return mImageResourceID!= NO_IMAGE_PROVIDED;
    }

}
