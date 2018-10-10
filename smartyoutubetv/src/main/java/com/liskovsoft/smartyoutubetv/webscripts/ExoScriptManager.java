package com.liskovsoft.smartyoutubetv.webscripts;

import android.content.Context;
import com.liskovsoft.smartyoutubetv.common.helpers.Helpers;
import com.liskovsoft.smartyoutubetv.flavors.common.TwoFragmentsManagerActivity;

import java.io.InputStream;

public class ExoScriptManager implements ScriptManager {
    private final Context mContext;
    private boolean isExo;

    public ExoScriptManager(Context context) {
        mContext = context;

        if (mContext instanceof TwoFragmentsManagerActivity) {
            isExo = true;
        }
    }

    @Override
    public InputStream getOnInitScripts() {
        return null;
    }

    @Override
    public InputStream getOnLoadScripts() {
        if (!isExo)
            return null;
        return Helpers.getAssetJSFilesMerged(mContext, CORE_EXO_DIR);
    }

    @Override
    public InputStream getStyles() {
        if (!isExo)
            return null;
        return Helpers.getAssetCSSFilesMerged(mContext, CORE_EXO_DIR);
    }
}
