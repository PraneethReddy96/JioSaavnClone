package com.example.saavn_app_praneeth;

import androidx.appcompat.app.AppCompatActivity;

public class AccessToken  {


        private String accessToken;
        private String tokenType;

        public String getAccessToken() {
            return accessToken;
        }

        public String getTokenType() {
            // OAuth requires uppercase Authorization HTTP header value for token type
            if (! Character.isUpperCase(tokenType.charAt(0))) {
                tokenType =
                        Character
                                .toString(tokenType.charAt(0))
                                .toUpperCase() + tokenType.substring(1);
            }

            return tokenType;
        }
    }


