package up.work.demoapp2.presenter;

import java.util.ArrayList;

import up.work.demoapp2.model.pojo.Result;

/**
 * Created by STT on 16.5.2016.
 */
public interface ListContract {

    interface ListListener {
        void getItems();

        void getDetailedItem();
    }

    interface ListView {
        void showItems(ArrayList<Result> items);

        void showError(String error);

        void showDetailedItem(String itemTitle);
    }

}
