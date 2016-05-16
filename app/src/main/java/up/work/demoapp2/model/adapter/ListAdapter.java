package up.work.demoapp2.model.adapter;

import android.content.Intent;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import up.work.demoapp2.R;
import up.work.demoapp2.model.pojo.Result;
import up.work.demoapp2.view.activities.DetailActivity;

/**
 * Created by STT on 16.5.2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {

    public ArrayList<Result> mItems;


    public ListAdapter(ArrayList<Result> mItems) {
        this.mItems = mItems;
    }

    public void setResults(ArrayList<Result> results) {
        for (int i = 0; i < results.size(); i++) {
            mItems.add(results.get(i));
        }
        notifyDataSetChanged();
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.mTitle.setText(mItems.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;

        public ItemHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.text_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_TITLE, mTitle.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
