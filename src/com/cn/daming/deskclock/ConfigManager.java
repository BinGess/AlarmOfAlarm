package com.cn.daming.deskclock;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ConfigManager {

	private static final String PREF_NAME = "alarm_prefs";

	private static final String KEY_ENABLEd = "enabled";

	private SharedPreferences mSp;

	private static ConfigManager sIns;

	private ConfigManager(Context context) {
		mSp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
	}

	public static ConfigManager getInstance(Context context) {
		if (sIns == null) {
			sIns = new ConfigManager(context);
		}
		return sIns;
	}

	public boolean getEnabled() {
		return mSp.getBoolean(KEY_ENABLEd, false);
	}

	public void putEnabled(boolean enabled) {
		Editor e = mSp.edit();
		e.putBoolean(KEY_ENABLEd, enabled);
		e.apply();
	}

}
