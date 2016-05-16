package up.work.demoapp2.model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import up.work.demoapp2.model.pojo.Response;
import up.work.demoapp2.presenter.ListPresenter;

/**
 * Created by STT on 16.5.2016.
 */
public class JsonService {

    public  void parseJson(ListPresenter.OnItemsLoadedListener mListener) {
        Gson gson = new GsonBuilder().create();
        Response r = gson.fromJson(FakeRepo.provideJson(), Response.class);

        mListener.OnSuccess(r);
    }


}
