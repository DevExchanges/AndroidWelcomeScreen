package info.devexchanges.welcomescreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
    private SharedPreferences pref;
    private Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "WelcomeApp";
    private static final String IS_FIRST = "isFistUse";

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsFirst(boolean userName) {
        editor.putBoolean(IS_FIRST, userName);
        editor.commit();
    }

    public boolean isFirstUse() {
        return pref.getBoolean(IS_FIRST, true);
    }
}
