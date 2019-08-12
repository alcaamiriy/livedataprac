package com.example.livedateprac;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class GobolViewModel extends AndroidViewModel {
    private List<Gobol> mGobols;
    private MutableLiveData<List<Gobol>> mMutablGobols;

    public GobolViewModel(@NonNull Application application) {
        super(application);
        this.mMutablGobols = new MutableLiveData<>();
    }

    public void setGobols(List<Gobol> gobols) {
        this.mGobols = gobols;
        this.mMutablGobols.setValue(gobols);
    }
    public MutableLiveData<List<Gobol>> getGobolada() {
        return mMutablGobols;
    }
    public void InsertGobol(Gobol gobol) {
        mGobols.add(gobol);
        mMutablGobols.setValue(mGobols);
    }
}
