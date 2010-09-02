/*
 * Copyright (C) 2010 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.android.droidlicious.client;

import android.util.Log;

import org.json.JSONObject;

/**
 * Represents a sample SyncAdapter user
 */
public class User {

    private final String mUserName;

    public String getUserName() {
        return mUserName;
    }

    public User(String name) {
        mUserName = name;
    }

    /**
     * Creates and returns an instance of the user from the provided JSON data.
     * 
     * @param user The JSONObject containing user data
     * @return user The new instance of Voiper user created from the JSON data.
     */
    public static User valueOf(JSONObject user) {
        try {
            final String userName = user.getString("user");
            return new User(userName);
        } catch (final Exception ex) {
            Log.i("User", "Error parsing JSON user object" + ex.toString());

        }
        return null;

    }

    /**
     * Represents the User's status messages
     * 
     */
    public static class Status {
        private final String mUserName;
        private final String mStatus;

        public String getUserName() {
            return mUserName;
        }

        public String getStatus() {
            return mStatus;
        }

        public Status(String userName, String status) {
            mUserName = userName;
            mStatus = status;
        }

        public static User.Status valueOf(JSONObject userStatus) {
            try {
                final String userName = userStatus.getString("a");
                final String status = userStatus.getString("d");
                return new User.Status(userName, status);
            } catch (final Exception ex) {
                Log.i("User.Status", "Error parsing JSON user object");
            }
            return null;
        }
    }
    
    /**
     * Represents the User's tags
     * 
     */
    public static class Tag {
        private final String mTagName;
        private final String mCount;

        public String getTagName() {
            return mTagName;
        }

        public String getCount() {
            return mCount;
        }

        public Tag(String tagName, String count) {
            mTagName = tagName;
            mCount = count;
        }


    }

}