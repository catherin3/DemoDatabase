package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> tasks;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;


    public TaskArrayAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource,objects);
        // Store the ArrayList of objects passed to this adapter
        this.tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);

        //Get the TextView object
        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        Task currentID = tasks.get(pos);


        for (int i = 0; i < tasks.size(); i++) {
            tvID.setText(Integer.toString(currentID.getId()));
            tvDesc.setText(currentID.getDescription());
            tvDate.setText(currentID.getDate());
        }
        return rowView;
    }

}
