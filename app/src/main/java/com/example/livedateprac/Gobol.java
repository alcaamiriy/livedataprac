package com.example.livedateprac;

import java.util.Date;

public class Gobol {
    private int mId;
    private String mName;
    private Date mCreatedAt;

    public Gobol(int mId, String mName, Date mCreatedAt) {
        this.mId = mId;
        this.mName = mName;
        this.mCreatedAt = mCreatedAt;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }
}
