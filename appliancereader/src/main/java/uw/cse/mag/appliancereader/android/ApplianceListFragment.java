package uw.cse.mag.appliancereader.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

//import org.uw.cse.mag.ar.data.Appliance;

import java.util.List;

/**
 * Presents a list of appliances to the user. 
 * Allows the user to select the individual appliance to update its state
 *
 * @author Michael Hotan, michael.hotan@gmail.com
 */
public class ApplianceListFragment extends ListFragment {

    // Activity that handles all callbacks
    private ApplianceListListener mListener;

    /**
     * DataSource for supplying appliances.
     *
     * TODO: Make this more generic when we are able to hook into Database
     */
//	private DefaultApplianceDataSource dataSource;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (ApplianceListListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ApplianceListListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        dataSource = mListener.getDataSource();
//        ArrayAdapter<Appliance> adapter = new ApplianceListAdapter(getActivity(), dataSource.getAllAppliances());
//        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (position == 0) {
            // Notify the host activity that the user wants to create a new appliance.
            mListener.onCreateNewAppliance();
        }
    }

    /**
     * Listener that is required for any activity that wishes to present
     * this fragment.
     *
     * @author Michael Hotan, michael.hotan@gmail.com
     */
    public interface ApplianceListListener {

        /**
         * Gets the Data Source for Appliances.  This method is called immediately after
         * the hosting activity is created. The datasource is used to
         *
         * @return The DataSource for obtaining appliances
         */
//        public DefaultApplianceDataSource getDataSource();

        /**
         * Notifies that Activity that an appliance was selected.
         *
         * @param app Appliance that was selected by the user
         */
        public void onApplianceSelected(Appliance app);

        /**
         * Notifies the Activity that a user wants to manage the information
         * that pertains to this appliance.
         *
         * @param app Appliance that users want to be informed in
         */
        public void onApplianceInfoSelected(Appliance app);

        /**
         * This notifies the host activity that the user wishes to register another
         * appliance.
         */
        public void onCreateNewAppliance();

    }

    /**
     * Class that manages the list of appliances for this user.
     *
     *
     * @author Michael Hotan, michael.hotan@gmail.com
     */
    private class ApplianceListAdapter extends ArrayAdapter<Appliance> {

        private final Context mContext;

        /**
         * Creates an empty Appliance array adapter
         *
         * @param context Context that created this adapter
         */
        public ApplianceListAdapter(Context context) {
            super(context, R.layout.appliance_list_item);
            this.mContext = context;
        }

        /**
         * Creates an Appliance List adapter using the argument list reference.
         *
         * @param context Context that created this adapter
         * @param appliances List of appliances to initially build the adapter with.
         */
        public ApplianceListAdapter(Context context, List<Appliance> appliances) {
            super(context, R.layout.appliance_list_item, appliances);
            this.mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // We first need to check if the first item is selected.
            // here we need to provide the option to the user
            // to add another appliance.
            if (position == 0) {
                // If we still have the old view for adding a new appliance we can still use it.
                // Therefore we only need to create when we have to because its contents never change.
                if (convertView == null) {
                    // We have to create the view for the first time.
                    rowView = inflater.inflate(R.layout.add_appliance_list_item, parent, false);
                }
                return rowView;
            }
            if (rowView == null) {
                // Same conservative approach of only inflating it when we need to.
                rowView = inflater.inflate(R.layout.appliance_list_item, parent, false);
            }

            // Label and widget for this item.
            TextView textView = (TextView) rowView.findViewById(R.id.appliance_name_label);
            ImageButton infoButton = (ImageButton) rowView.findViewById(R.id.info_button);
            ImageButton cameraButton = (ImageButton) rowView.findViewById(R.id.camera_button);

            // Set the text of the label to be updated.
            // Make sure we offset for the add appliance button.
            final Appliance current = getItem(position-1);
            textView.setText(current.getNickname());

            // Create Callbacks to notify Activity that appliance was selected.
            infoButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mListener.onApplianceInfoSelected(current);
                }
            });
            cameraButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mListener.onApplianceSelected(current);
                }
            });

            return rowView;
        }

        @Override
        public int getCount() {
            // We want to add an additional item to this adapter.
            // The additional item will represent the list item to add a new appliance.
            return super.getCount() + 1;
        }

    }

}
