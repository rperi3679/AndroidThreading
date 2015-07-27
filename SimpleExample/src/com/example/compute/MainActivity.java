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


package com.example.compute;

import android.os.Bundle;
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
    	int i, j, sum=0;

    	for (i=0;i<10000;i++)
    		for (j=0;j<10000;j++)
    			sum+=i;
    	
    	TextView tv = (TextView)findViewById(R.id.textView2);
    	tv.setText(String.valueOf(sum));
    }
    
    public void clearValue(View v) {
       	TextView tv = (TextView)findViewById(R.id.textView2);
       	tv.setText("");
    }
    
}
