package com.example.testingmyentertainment;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CourseGVAdapterUi {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void gridViewDisplayTest() {
        // Assuming that the text view and the image view in your grid item have ids 'idTVCourse' and 'idIVcourse'.
        onData(anything())
                .inAdapterView(withId(R.id.idGVcourses1))
                .atPosition(0)
                .onChildView(withId(R.id.idTVCourse))
                .check(matches(withText("Classical")));
    }

    @Test
    public void gridViewItemClickTest() {
        onData(anything())
                .inAdapterView(withId(R.id.idGVcourses1))
                .atPosition(0)
                .perform(click());
        // Assuming you change activity which can be checked by checking if new activity is displayed.
        // This will depend on how your intents and activities are set up.
    }
}
