package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

/**
 * Created by samar ezz on 1/14/2018.
 */
@RunWith(AndroidJUnit4.class)
public class JokesEndPointAsyncTaskTest {

    @Test
    public void testTheJoke() {
        try {
            JokesEndPointAsyncTask task = new JokesEndPointAsyncTask();
            String joke = task.execute().get();
            assertTrue(!joke.isEmpty());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
