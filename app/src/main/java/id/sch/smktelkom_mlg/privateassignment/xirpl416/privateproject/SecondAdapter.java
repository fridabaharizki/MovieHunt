package id.sch.smktelkom_mlg.privateassignment.xirpl416.privateproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Lenovo on 13/05/2017.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {
    private List<SecondListItem> secondListItem;
    private Context context;

    public SecondAdapter(List<SecondListItem> SecondListItem, Context context) {
        this.secondListItem = SecondListItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.page_item2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SecondListItem secondListItems = secondListItem.get(position);
        holder.textViewTitle2.setText(secondListItems.getTitle());
        holder.textViewContent2.setText(secondListItems.getContent());

        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + secondListItems.getImageUrl())
                .into(holder.imageViewOtOf2);
    }

    @Override
    public int getItemCount() {
        return secondListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle2;
        public TextView textViewContent2;
        public ImageView imageViewOtOf2;
        public LinearLayout linearLayout2;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle2 = (TextView) itemView.findViewById(R.id.textViewTitle2);
            textViewContent2 = (TextView) itemView.findViewById(R.id.textViewContent2);
            imageViewOtOf2 = (ImageView) itemView.findViewById(R.id.imageViewOtOf2);
            linearLayout2 = (LinearLayout) itemView.findViewById(R.id.linearLayout2);
        }
    }
}
