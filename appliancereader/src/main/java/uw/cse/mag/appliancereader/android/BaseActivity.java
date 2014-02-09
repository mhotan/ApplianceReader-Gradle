package uw.cse.mag.appliancereader.android;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Base Activity for all activities within this application.
 * <b>Currently handles on the initialization of external libraries if needed.</b>
 *
 * @author - Michael Hotan, michael.hotan@gmail.com
 */
public class BaseActivity extends FragmentActivity {

    /**
     * Logging tag.
     */
    private static final String TAG = BaseActivity.class.getSimpleName();

    /////////////////////////////////////////////////////////////////////////
    ////  Activity LifeCycle Methods
    /////////////////////////////////////////////////////////////////////////

    // Creation and complete Destruction of this Activity.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Create and allocate resources available when the activity is created.
    }


    @Override
    public void onDestroy() {
        // TODO: Save any state that belongs to this activity.
        // TODO: Destroy or close any outstanding resources.

        // Always end with a call to super.
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();

        // Called after onCreate() or onRestart().
        // The should initialize the state of any heavy resources.
        // This is the state where the activity becomes visible to the user but the user can't interact with it.
    }

    @Override
    public void onStop() {
        // Stop any heavy processes so that resources can be allocated else where.
        // Activity is still visible but interaction is not allowed post this method.

        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity will now be interactable
    }

    @Override
    protected void onPause (){
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
