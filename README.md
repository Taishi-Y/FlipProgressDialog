# FlipProgressDialog
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FlipProgressDialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5054)
[ ![Download](https://api.bintray.com/packages/taishi-y/maven/flipprogressdialog/images/download.svg) ](https://bintray.com/taishi-y/maven/flipprogressdialog/_latestVersion)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Android ProgressDialog with Image Flip Animation like a Airbnb app.

<img src="https://github.com/Taishi-Y/FlipProgressDialog/blob/master/images/flipprogressdialog.gif?raw=true" 
alt="" width="240" border="10" />

Installation
============
Add it in your root build.gradle at the end of repositories:
```gradle
dependencies {
  compile 'com.taishi-y:flipprogressdialog:0.1.0'
}
```

Usage
=====


In Code (Java)
----
```java
// Set imageList
List<Integer> imageList = new ArrayList<Integer>();
imageList.add(R.drawable.ic_favorite_border_white_24dp);
imageList.add(R.drawable.ic_favorite_white_24dp);


FlipProgressDialog fpd = new FlipProgressDialog();

fpd.setImageList(imageList);                              // Set a imageList
fpd.setCanceledOnTouchOutside(true);                      // If true, the dialog will be dismissed when user touch outside of the dialog. If false, the dialog won't be dismissed.
fpd.setDimAmount(0.0f);                                   // Set a dim (How much dark outside of dialog)

// About dialog shape, color
fpd.setBackgroundColor(Color.parseColor("#FF4081"));      // Set a background color of dialog
fpd.setBackgroundAlpha(0.2f);                             // Set a alpha color of dialog
fpd.setBorderStroke(0);                                   // Set a width of border stroke of dialog
fpd.setBorderColor(-1);                                   // Set a border stroke color of dialog
fpd.setCornerRadius(16);                                  // Set a corner radius

// About image 
fpd.setImageSize(200);                                    // Set an image size
fpd.setImageMargin(10);                                   // Set a margin of image

// About rotation
fpd.setOrientation("rotationY");                          // Set a flipping rotation
fpd.setDuration(600);                                     // Set a duration time of flipping ratation
fpd.setStartAngle(0.0f);                                  // Set an angle when flipping ratation start
fpd.setEndAngle(180.0f);                                  // Set an angle when flipping ratation end
fpd.setMinAlpha(0.0f);                                    // Set an alpha when flipping ratation start and end
fpd.setMaxAlpha(1.0f);                                    // Set an alpha while image is flipping


fpd.show(getFragmentManager(),"");                        // Show flip-progress-dialg
fpd.dismiss();                                            // Dismiss flip-progress-dialg
```

Developed By
============
```
Taishi Yamasaki
```
- Website (http://taishi.tech/)
- Twitter (https://twitter.com/taishi0917)
- LinkedIn (https://www.linkedin.com/in/taishi-yamasaki)

# How to Contribute
1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

# License

    Copyright 2017 Taishi Yamasaki

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
