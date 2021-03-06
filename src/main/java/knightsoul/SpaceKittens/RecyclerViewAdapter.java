package knightsoul.SpaceKittens;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 2/12/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private Context mContext;
    public static boolean levelClick = false;

    public RecyclerViewAdapter(Context context, ArrayList<String> names) {
        mNames = names;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_selection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        if (mNames.get(position).startsWith("Space")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.cat)
                    .into(holder.image);
        } else if (mNames.get(position).startsWith("Earth")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.earth)
                    .into(holder.image);
        }else if (mNames.get(position).startsWith("Mars")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.mars)
                    .into(holder.image);
        }else if (mNames.get(position).startsWith("Jupiter")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.jupiter)
                    .into(holder.image);
        }else if (mNames.get(position).startsWith("Saturn")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.saturn)
                    .into(holder.image);
        }


        holder.name.setText(mNames.get(position));
        if (mNames.get(position).endsWith("30/30")) {
            holder.completed.setVisibility(View.VISIBLE);
        } else {
            holder.completed.setVisibility(View.INVISIBLE);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
                if (level_selection.buttonClick == false && levelClick == false) {

                    Title.levelSelection(mNames.get(position), mContext);
                }

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (level_selection.buttonClick == false && levelClick == false) {

                    Title.levelSelection(mNames.get(position), mContext);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        ImageView completed;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
            completed = itemView.findViewById(R.id.completed);
        }
    }


}
