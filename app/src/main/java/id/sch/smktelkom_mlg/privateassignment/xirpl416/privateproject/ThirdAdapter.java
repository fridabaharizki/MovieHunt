package id.sch.smktelkom_mlg.privateassignment.xirpl416.privateproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Lenovo on 13/05/2017.
 */

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.ViewHolder> {
    private List<ThirdListItem> thirdListItem;
    private Context context;

    public ThirdAdapter(List<ThirdListItem> ThirdListItem, Context context) {
        this.thirdListItem = ThirdListItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.page_item3, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ThirdListItem thirdListItems = thirdListItem.get(position);
        holder.textViewTitle3.setText(thirdListItems.getTitle());
        holder.textViewContent3.setText(thirdListItems.getContent());

        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + thirdListItems.getImageUrl())
                .into(holder.imageViewOtOf3);

        holder.linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, thirdListItems.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ThirdDetilPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("blog_id", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return thirdListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle3;
        public TextView textViewContent3;
        public ImageView imageViewOtOf3;
        public LinearLayout linearLayout3;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle3 = (TextView) itemView.findViewById(R.id.textViewTitle3);
            textViewContent3 = (TextView) itemView.findViewById(R.id.textViewContent3);
            imageViewOtOf3 = (ImageView) itemView.findViewById(R.id.imageViewOtOf3);
            linearLayout3 = (LinearLayout) itemView.findViewById(R.id.linearLayout3);
        }
    }
}
