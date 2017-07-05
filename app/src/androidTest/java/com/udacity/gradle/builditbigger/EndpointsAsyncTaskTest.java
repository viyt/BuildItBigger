package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    private String joke = null;

    @Test
    public void testJoke() {
        try {
            CountDownLatch lock = new CountDownLatch(1);
            new EndpointsAsyncTask(new JokeListener() {
                @Override
                public void getJoke(String data) {
                  joke = data;
                }
            }).execute();
            lock.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }
}
