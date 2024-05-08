package com.example.testingmyentertainment;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.testingmyentertainment.Musics.PlayerActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PlayerActivityUi {

    @Rule
    public ActivityTestRule<PlayerActivity> activityRule = new ActivityTestRule<>(PlayerActivity.class, true, false);

    @Test
    public void testAudioPlayback() {
        Intent startIntent = new Intent();
        String[] songNames = {"Classical"};
        String[] songUrls = {"https://example.com/classical.mp3"};
        startIntent.putExtra("songNames", songNames);
        startIntent.putExtra("songUrls", songUrls);
        startIntent.putExtra("currentIndex", 0);

        activityRule.launchActivity(startIntent);

        // Verify the player has the correct song name displayed
        onView(withId(R.id.idTVCourse)).check(matches(withText("Classical")));
    }
}
