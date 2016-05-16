package up.work.demoapp2.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.work.demoapp2.R;
import up.work.demoapp2.model.Storage;
import up.work.demoapp2.model.adapter.ListAdapter;
import up.work.demoapp2.model.pojo.Result;
import up.work.demoapp2.presenter.ListContract;
import up.work.demoapp2.presenter.ListPresenter;
import up.work.demoapp2.view.activities.DetailActivity;

/**
 * Created by STT on 16.5.2016.
 */
public class ListFragment extends Fragment implements ListContract.ListView {

    private static final String TAG = "ListFragment";
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    private ListPresenter mPresenter;

    public static ListFragment newInstance() {

        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        mListAdapter = new ListAdapter(Storage.getInstance().getResults());

        mRecyclerView = (RecyclerView) root.findViewById(R.id.list_activity_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mListAdapter);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // If its the first time the activity is created it should be empty and we query the list
        if (Storage.getInstance().getResults().size() == 0) {
            mPresenter.getItems();
            Log.i(TAG, "onActivityCreated: " + "Getting items");
        }
    }

    @Override
    public void showItems(ArrayList<Result> items) {
        mListAdapter.setResults(items);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showDetailedItem(String itemTitle) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);


    }
}
