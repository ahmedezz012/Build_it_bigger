package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;

/**
 * Created by samar ezz on 1/14/2018.
 */
@RunWith(AndroidJUnit4.class)
public class JokesEndPointAsyncTaskTest {

    @Test
    public void testTheJoke() {

        String joke;
        try {
            JokesEndPointAsyncTask task = new JokesEndPointAsyncTask();
            joke = task.execute().get();
            assertFalse(TextUtils.isEmpty(joke));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
