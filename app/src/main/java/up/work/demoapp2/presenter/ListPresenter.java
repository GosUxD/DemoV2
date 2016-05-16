package up.work.demoapp2.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import up.work.demoapp2.model.api.FakeRepo;
import up.work.demoapp2.model.api.JsonService;
import up.work.demoapp2.model.pojo.Response;
import up.work.demoapp2.model.pojo.Result;

/**
 * Created by STT on 16.5.2016.
 */
public class ListPresenter implements ListContract.ListListener {

    private static final String TAG = "ListPresenter";
    ListContract.ListView mView;
    JsonService mJsonService;
    OnItemsLoadedListener onItemsLoadedListener;

    public ListPresenter(final ListContract.ListView mView) {
        this.mView = mView;
        onItemsLoadedListener = new OnItemsLoadedListener() {
            @Override
            public void OnSuccess(Response response) {
                mView.showItems((ArrayList<Result>) response.getResults());
            }

            @Override
            public void OnFailure(String error) {

            }
        };
        mJsonService = new JsonService();
    }

    @Override
    public void getItems() {
        mJsonService.parseJson(onItemsLoadedListener);
        Log.i(TAG, "getItems: " + "Parsing Json");
    }

    @Override
    public void getDetailedItem() {

    }


    public interface OnItemsLoadedListener {
        void OnSuccess(Response response);

        void OnFailure(String error);
    }
}
