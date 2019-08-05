package com.example.testtask.base.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Extends {@link ru.terrakok.cicerone.android.SupportFragmentNavigator} to allow
 * open new or replace current activity.
 * <p>
 * This navigator DOESN'T provide full featured Activity navigation,
 * but can ease Activity start or replace from current navigator.
 * </p>
 */
public abstract class SupportAppNavigator extends SupportFragmentNavigator {

    private Activity activity;

    public SupportAppNavigator(FragmentActivity activity, int containerId) {
        super(activity.getSupportFragmentManager(), containerId);
        this.activity = activity;
    }

    public SupportAppNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        this.activity = activity;
    }

    /**
     * Override this method to create option for start activity
     *
     * @param command        current navigation command. Will be only {@link Forward} or {@link Replace}
     * @param activityIntent activity intent
     * @return transition options
     */
    protected Bundle createStartActivityOptions(Command command, Intent activityIntent) {
        return null;
    }

    @Override
    protected void forward(Forward command) {
        Intent activityIntent = createActivityIntent(activity, command.getScreenKey(), command.getTransitionData());

        // Start activity
        if (activityIntent != null) {
            Bundle options = createStartActivityOptions(command, activityIntent);
            checkAndStartActivity(command.getScreenKey(), activityIntent, options);
        } else {
            super.forward(command);
        }
    }

    @Override
    protected void replace(Replace command) {
        Intent activityIntent = createActivityIntent(activity, command.getScreenKey(), command.getTransitionData());

        // Replace activity
        if (activityIntent != null) {
            Bundle options = createStartActivityOptions(command, activityIntent);
            checkAndStartActivity(command.getScreenKey(), activityIntent, options);
            activity.finish();
        } else {
            super.replace(command);
        }
    }

    private void checkAndStartActivity(String screenKey, Intent activityIntent, Bundle options) {
        // Check if we can start activity
        if (activityIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(activityIntent, options);
        } else {
            unexistingActivity(screenKey, activityIntent);
        }
    }

    /**
     * Called when there is no activity to open {@code screenKey}.
     *
     * @param screenKey screen key
     * @param activityIntent intent passed to start Activity for the {@code screenKey}
     */
    protected void unexistingActivity(String screenKey, Intent activityIntent) {
        // Do nothing by default
    }

    /**
     * Creates Intent to start Activity for {@code screenKey}.
     * <p>
     * <b>Warning:</b> This method does not work with {@link BackTo} command.
     * </p>
     *
     * @param screenKey screen key
     * @param data      initialization data, can be null
     * @return intent to start Activity for the passed screen key
     */
    protected abstract Intent createActivityIntent(Context context, String screenKey, Object data);

    @Override
    protected void showSystemMessage(String message) {
        // Toast by default
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void exit() {
        // Finish by default
        activity.finish();
    }
}