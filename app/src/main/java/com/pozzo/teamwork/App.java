package com.pozzo.teamwork;

import android.app.Application;
import android.content.Context;

import com.pozzo.teamwork.injection.AppComponent;
import com.pozzo.teamwork.injection.AppModule;
import com.pozzo.teamwork.injection.DaggerAppComponent;

/**
 * @since 27/07/17.
 */
public class App extends Application {
	private AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		initComponent();
	}

	public static App get(Context context) {
		return (App) context.getApplicationContext();
	}

	public AppComponent component() {
		return appComponent;
	}

	protected AppModule getAppModule() {
		return new AppModule(this);
	}

	protected void initComponent() {
		appComponent = DaggerAppComponent.builder()
				.appModule(getAppModule())
				.build();
	}
}
