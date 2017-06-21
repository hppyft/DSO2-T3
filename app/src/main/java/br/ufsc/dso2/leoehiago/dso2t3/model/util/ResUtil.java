package br.ufsc.dso2.leoehiago.dso2t3.model.util;

import android.app.Application;

public class ResUtil {
    public static int get(Application app, String idConstantName, String defType) {
        return app.getResources().getIdentifier(idConstantName, defType, app.getPackageName());
    }

    public static int getDrawable(Application app, String idConstantName) {
        return get(app, idConstantName, "drawable");
    }
}
