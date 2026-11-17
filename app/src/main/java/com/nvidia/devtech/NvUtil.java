package com.nvidia.devtech;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class NvUtil {
	private static final NvUtil instance = new NvUtil();
	private WeakReference<Activity> activityRef = null;
	private final ConcurrentHashMap<String, String> appLocalValues = new ConcurrentHashMap<>();

	private NvUtil() {
	}

	public static NvUtil getInstance() {
		return instance;
	}

	public String getAppLocalValue(String str) {
		return str != null ? this.appLocalValues.get(str) : null;
	}

	public String getParameter(String str) {
		Activity act = this.activityRef != null ? this.activityRef.get() : null;
		return (act != null && act.getIntent() != null) ? act.getIntent().getStringExtra(str) : null;
	}

	public boolean hasAppLocalValue(String str) {
		return str != null && this.appLocalValues.containsKey(str);
	}

	public void setActivity(Activity activity) {
		this.activityRef = activity != null ? new WeakReference<>(activity) : null;
	}

	public void setAppLocalValue(String str, String str2) {
		if (str != null && str2 != null) {
			this.appLocalValues.put(str, str2);
		}
	}
}
