package com.example.shanu.toolbar;

import java.util.UUID;

/**
 * Created by SHANU on 03-11-2016.
 */
public class TO_DO {
    private UUID mId;
    private String mTitle;
    private String mDetail;

    public TO_DO() {
      mId= UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }
}
