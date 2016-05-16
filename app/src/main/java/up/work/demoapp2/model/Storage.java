package up.work.demoapp2.model;

import java.util.ArrayList;

import up.work.demoapp2.model.pojo.Result;

/**
 * Created by STT on 16.5.2016.
 */
public class Storage {

    ArrayList<Result> mResults;
    private static Storage ourInstance = new Storage();

    public static Storage getInstance() {
        return ourInstance;
    }

    private Storage() {
        mResults = new ArrayList<>();
    }

    public ArrayList<Result> getResults() {
        return mResults;
    }

    public void setResults(ArrayList<Result> results) {
        for (int i = 0; i < mResults.size(); i++) {
            mResults.add(results.get(i));
        }
    }

    public Result getResult(String resultTitle) {
        for (int i = 0; i < mResults.size(); i++) {
            Result mCurrent = mResults.get(i);
            if (mCurrent.getTitle().equals(resultTitle)) {
                return mCurrent;
            }
        }
        return null;
    }


}
