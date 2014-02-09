package org.uw.cse.mag.ar.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class that represents a single
 * @author mhotan
 */
public class Appliance implements Parcelable {

    private static final String TAG = Appliance.class.getSimpleName();

    // TODO Finalize Abstract functions and Representation Invariants
    /**
     * This is a key for storing bundles in intents that represent appliances
     */
    public static final String KEY_BUNDLE_APPLIANCE = "KEY_APPLIANCE_BUNDLE";

    /**
     * Database ID for this appliance
     */
    private long mId;

    /**
     * Nick Name that user can choose for the appliance
     * IE "My Microwave"
     */
    private String mNickName, mType;

    /**
     * Make of the Appliance
     * IE "Samsung"
     * Model name/number for this particular appliance
     * IE "123456" or can also be alphanumeric "ABC-12345"
     */
    private final String mMake, mModel;

    /**
     * Directory where all the files are stored
     */
    private String mDirectory;
//
//    /**
//     * Directory that stores appliance features
//     */
//    private ApplianceFeatures mFeatures;

    /**
     * Creates a bare Appliance with
     *
     * @param make Make of the appliance
     * @param model Model Number of the appliance.
     */
    public Appliance(String make, String model){
        if (make == null || make.isEmpty())
            throw new IllegalArgumentException("Appliance(), Illegal \"make\" argument: " + make );
        if (model == null || model.isEmpty())
            throw new IllegalArgumentException("Appliance(), Illegal \"model\" argument: " + model );


        mId = -1;
        mMake = make;
        mModel = model;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //// Setters or modifiers
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param id
     */
    public void setId(long id){
        this.mId = id;
    }

    public void setNickName(String nickname){
        this.mNickName = nickname;
    }

    public void setType(String type) {
        this.mType = type;
    }

//    public void setApplianceFeatures(ApplianceFeatures af){
//        if (af == null) return;
//        this.mFeatures = af;
//        if (mFileManager.hasAppliance(this)) {
//            try {
//                mFileManager.addXMLFile(this, af);
//            } catch (ApplianceNotExistException e) {
//                Log.e(TAG, "Error with file manager recognizing the appliane exists");
//            }
//        }
//    }

    public void setDirectoryPath(String directoryPath){
        this.mDirectory = directoryPath;
    }

    /**
     * Scales down all the feature point by a particular value
     * Scales down all the features
     * @param scaleFactor int factor to scale points down by
     */
    public void scaleFeatures(float scaleFactor) {
//        if (mFeatures == null) {
//            Log.w(TAG, "No features found to scale");
//        } else {
//            mFeatures.scaleFeatures(scaleFactor);
//        }
    }

//    /**
//     * Rotate each point in the image by a particular point
//     * @param rotMat2by3 center point on which to rotate
//     */
//    public void rotateFeatures(Mat rotMat2by3){
//        if (mFeatures == null) {
//            Log.w(TAG, "No features found to scale");
//        } else {
//            mFeatures.rotateAround(rotMat2by3);
//        }
//    }

	/*
	 * Getters
	 * */

    public long getID(){
        return mId;
    }

    public String getNickname(){
        return mNickName;
    }

    public String getMake(){
        return mMake;
    }

    public String getModel(){
        return mModel;
    }

    public String getType(){
        return mType;
    }

//    public boolean hasApplianceFeatures(){
//        if (mFeatures == null)
//            return false;
//        return !mFeatures.isEmpty();
//    }

//    public ApplianceFeatures getApplianceFeatures(){
//        return mFeatures;
//    }

    public String getDirectoryPath(){
        return mDirectory;
    }

    public String toString(){
        if (mNickName != null)
            return mNickName;
        if (mMake != null && mModel != null )
            return mMake + "_" + mModel;
        if (mType != null)
            return "Unknown " + mType;
        return null;
    }

    private static final String BUNDLE_ID = "APP_BUN_ID";
    private static final String BUNDLE_NICKNAME = "APP_BUN_NICKNAME";
    private static final String BUNDLE_MAKE = "APP_BUN_MAKE";
    private static final String BUNDLE_MODEL = "APP_BUN_MODEL";
    private static final String BUNDLE_TYPE = "APP_BUN_TYPE";
    private static final String BUNDLE_DIR = "APP_BUN_DIRECTORY";

    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putLong(BUNDLE_ID, mId);
        b.putString(BUNDLE_NICKNAME, mNickName);
        b.putString(BUNDLE_MAKE, mMake);
        b.putString(BUNDLE_MODEL, mModel);
        b.putString(BUNDLE_TYPE, mType);
        b.putString(BUNDLE_DIR, mDirectory);
        return b;
    }

//    /**
//     * Creates an Appliance from a Bundle.
//     *
//     * @param Bundle representation of an appliance
//     * @return null if Bundle doesn't represent appliance, Apliance otherwise
//     */
//    public static Appliance toAppliance(Bundle b){
//        if (b == null) return null;
//        long id = b.getLong(BUNDLE_ID, -1);
//        if (id == -1L) return null;
//        Appliance a = new Appliance();
//        a.setId(id);
//        a.setNickName(b.getString(BUNDLE_NICKNAME));
//        a.setMake(b.getString(BUNDLE_MAKE));
//        a.setModel(b.getString(BUNDLE_MODEL));
//        a.setType(b.getString(BUNDLE_TYPE));
//        a.setDirectoryPath(b.getString(BUNDLE_DIR));
//
//        // Attempt to get and reload the appliance features
//        FileManager f = FileManager.getInstance();
//        ApplianceFeatures af = f.getFeatures(a);
//        a.mFeatures = af;
//        return a;
//    }

//    /**
//     * Returns Configuration.ORIENTATION_LANDSCAPE, or Configuration.ORIENTATION_PORTRAIT
//     * @return orientation of image
//     */
//    public int getRefimageOrientation() {
//        String path = mFileManager.getReferenceImage(this);
//        return ImageIO.getOrientationOfImage(path);
//    }
//
//    /**
//     * @return size of reference image
//     */
//    public Size getSizeOfRefImage() {
//        return ImageIO.getSizeOfImage(mFileManager.getReferenceImage(this));
//    }
//
//    /**
//     *
//     * @param actualDimension
//     * @return
//     */
//    public Bitmap getReferenceImage(org.opencv.core.Size actualDimension) {
//        return ImageIO.loadBitmapFromFilePath(mFileManager.getReferenceImage(this), actualDimension);
//    }
//
//    public Mat getReferenceImageMat(){
//        String path = mFileManager.getReferenceImage(this);
//        return Highgui.imread(path);
//    }

    ///////////////////////////////////////////////////////////////////////////
    ////  Parcelable Implementation.
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates an appliance from a Parcel that an appliance was written into.
     *
     * @param p Parcel to create Appliance from
     */
    private Appliance(Parcel p) {
        mId = p.readLong();
        mNickName = getVal(p);
        mMake = getVal(p);
        mModel = getVal(p);
        mType = getVal(p);
        mDirectory = getVal(p);
//        mFileManager = FileManager.getInstance();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        writeVal(dest, mNickName);
        writeVal(dest, mMake);
        writeVal(dest, mModel);
        writeVal(dest, mType);
        writeVal(dest, mDirectory);
    }

    public static final Creator<Appliance> CREATOR = new Creator<Appliance>() {

        @Override
        public Appliance[] newArray(int size) {
            return new Appliance[size];
        }

        @Override
        public Appliance createFromParcel(Parcel source) {
            return new Appliance(source);
        }
    };

    /**
     * Attempts to write the String value.  If the string value is null, the null
     * reference is accounted for.
     *
     * @param dest Destination parcel.
     * @param value The Value to write.
     */
    private static void writeVal(Parcel dest, String value) {
        if (dest == null) throw new NullPointerException("Destination Parcel cannot be null");

        // Write the value prepended by a one.
        if (value != null) {
            dest.writeByte((byte) 1);
            dest.writeString(value);
            return;
        }

        // Write a 0 representing a non existing string.
        dest.writeByte((byte) 0);
    }

    /**
     * Reads the destination parcel for a String value.  If non exists then null
     * is returned.
     *
     * @param dest Parcel to write to.
     * @return Null if no value exist or the string value.
     */
    private static String getVal(Parcel dest) {
        boolean valExist = dest.readByte() == 1;
        if (valExist) {
            return dest.readString();
        }
        return null;
    }

}

