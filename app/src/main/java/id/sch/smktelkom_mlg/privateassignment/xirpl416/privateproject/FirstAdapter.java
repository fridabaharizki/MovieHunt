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
 * Created by Lenovo on 12/05/2017.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder> {
    private List<FirstListItem> firstListItem;
    private Context context;

    public FirstAdapter(List<FirstListItem> FirstListItem, Context context) {
        this.firstListItem = FirstListItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.page_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FirstListItem firstListItems = firstListItem.get(position);
        holder.textViewTitle.setText(firstListItems.getTitle());
        holder.textViewContent.setText(firstListItems.getContent());

        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + firstListItems.getImageUrl())
                .into(holder.imageViewOtOf);
    }

    @Override
    public int getItemCount() {
        return firstListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewContent;
        public ImageView imageViewOtOf;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewContent = (TextView) itemView.findViewById(R.id.textViewContent);
            imageViewOtOf = (ImageView) itemView.findViewById(R.id.imageViewOtOf);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
