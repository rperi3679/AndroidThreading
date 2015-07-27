/*****************************************************************************
 *
 * Copyright 2011 Intel Corporation All Rights Reserved.
 *
 * The source code contained or described herein and all documents related
 * to the source code ("Material") are owned by Intel Corporation or its
 * suppliers or licensors.  Title to the Material remains with Intel
 * Corporation or its suppliers and licensors.  The Material contains
 * trade secrets and proprietary and confidential information of Intel
 * or its suppliers and licensors.  The Material is protected by worldwide
 * copyright and trade secret laws and treaty provisions.  No part of the
 * Material may be used, copied, reproduced, modified, published, uploaded,
 * posted, transmitted, distributed, or disclosed in any way without
 * Intel's prior express written permission.
 *
 * No license under any patent, copyright, trade secret or other
 * intellectual property right is granted to or conferred upon you by
 * disclosure or delivery of the Materials, either expressly, by
 * implication, inducement, estoppel or otherwise.  Any license under such
 * intellectual property rights must be express and approved by Intel in
 * writing.
 *
 ****************************************************************************/

package com.example.Thread5;

import android.os.AsyncTask;

import java.util.concurrent.*;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void showValue(View v) {
        new Thread().execute("");
    }
    
    public void clearValue(View v) {
       	TextView tv = (TextView)findViewById(R.id.textView2);
       	tv.setText("");
    } 
       
    private class Thread extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
        	int sum=0;
            for (int i=0;i<5;i++)
            {
                try {
                    synchronized (this) {
                        wait(3000); // wait for 3sec
                    }
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }          	
            	for (int j=0;j<10000;j++)
            	   for (int k=0;k<10000;k++)
            	      sum+=i;
            }
            return (String.valueOf(sum));
        }  
        
        @Override
        protected void onPostExecute(String result) {          	
            TextView txt = (TextView) findViewById(R.id.textView2);
            txt.setText(result);
        }
    } 
}


