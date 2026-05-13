# JETPACK-COMPOSE ***LEVEL-0***
initially, we may need to have *Java* and the dependency management tool *Gradle*
## JAVA
We navigate to the [Java web page](https://www.java.com/es/download/linux_manual.jsp) and install the Java compressed package 
Next step, we uncompress the _Java Package_ into the path that the system calls Java.
Verificate
```bash
java -v
```
## GRADLE
The next tool for our development is gradle. It is a dependency management and an easy option for installing dependencies in a project to compile our app. This tool is similar to maven, which is a well-known reference in web development.
To install it, we navigate to the [Gradle Web Page](https://gradle.org/releases/) and install the Gradle Version Package.
```bash
# We make folder where gradle will be installed
mkdir -p /opt/gradle
# We uncompress in the folder created (Recommend that we are superusers)
unzip -d /opt/gradle $RUTA/gradle-version.zip
# We create environment variable
export PATH=$PATH:/opt/gradle/gradle-version/bin
# Verificate
gradle -v
```
##  SDK
These are tools used to create mobile apps and compile them with the necessary Android dependencies. The SDK includes tools for debugging, compiling, and other essential tasks needed to work with Android Compose.
So, we go to the [Android command line tools](https://developer.android.com/studio#command-line-tools-only) page and select the  platform compatible with our operating system.
```bash
# Download package
# Create the folder where SDK will be installed
mkdir -p $HOME/Android/Sdk/
# Create environment path for this space
export ANDROID_HOME=$HOME/Android/Sdk/
# Uncompress the dowloaded file and adjust the folder structure
unzip -d $ANDROID_HOME path_of_download/commandlinetools-linux-version_latest.zip
# The folder structure
# ├── cmdline-tools
# │   └── latest
# │       ├── bin
# │       ├── lib
# │       ├── Another files ...
# Create the path
export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
#Verify
sdkmanager --list
```
## PLATFORM_TOOL (**_OPTIONAL_**)
It debugs our application and connects the APK to a device. This is the way and the set of tools used to run the application on a device, allowing us to use and test the software's functionality in our testing environment.
We get this package in the [Android web page](https://developer.android.com/tools/releases/platform-tools) where we select the platform compatible with our operating system.
```bash
# Download package
# Uncompress the package ZIP
unzip -d $ANDROID_HOME ruta-descarga/platform-tools-latest-version.zip
# Create the path
export PATH=$PATH:$ANDROID_HOME/platform-tools
# Verify
adb devices
```
# STRUCT AND INITIALIZATION PROJECT LEVEL-1
## STRUCT
After, that We have the enviroment with the tools, and the dependecy managements necesary for app development. So the next phase is the making of project struct.
```bash
gradle init --type basic
# Gradle Basic Project
# ├── build.gradle.kts
# ├── gradle
# │   ├── libs.versions.toml
# │   └── wrapper
# │       ├── gradle-wrapper.jar
# │       └── gradle-wrapper.properties
# ├── gradle.properties
# ├── gradlew
# ├── gradlew.bat
# └── settings.gradle.kts
```
Next, we will create the app structure necessary for developing a new project, as well as the space for its resources, specifications and configuration.
```bash
# app/ : App folder
# app/src/main/res/ : Resources folder
# app/src/main/kotlin/com/application/app/ : Application source code
# app/src/main/AndroidManifest.xml : App registration snd configuration
├── app/
│   ├── src/main/kotlin/com/application/app/
│   ├── src/main/res/
│   └── src/main/AndroidManifest.xml
```
### ANDROID_MANIFEST
This file describes essential information about our app to the Android build tool, Android operating and Google Play.
#### COMPONENTS
For each app component declares a corresponding XML element in the manifest file:
```xml
<activity> <!--Activities that handle direct user interaction-->
<services> <!--Background operation without a user interface-->
<receiver> <!--Component that receive external events-->
<provider> <!--Component that provide access to data from other apps or from the same app-->
<intent-filter> <!--event ti access to any before components-->
```
#### LABEL ICON
Specify our app's name, descrition and icon, these attributes are used to identify and represent our app to users
```xml
<application android:label="@string/app_name" android:icon="@mipmap/ic_laucher">
</application>
```
@direction is a path into file on res folder
```bash
# @string
├── res/
│   ├── values/
│   │   ├── string.xml
```
```xml
<resources>
	<string name="app_name">Android Demo Name</string>
</resources>
```
```bash
# @mipmap
├── res/
│   ├── mipmap-*/
│   │   ├── ic_laucher.webp
```
#### PERMISSION
These are the action to send options and available parts that app need to any function or operation.
```xml
<manifest>
	<uses-permission android:name="android.permission.FUNTION"/>
</manifest>
```
#### FEATURES
Moviles features are very import when user want an app that meets all the specifications we define. If the enviroment where we develop it isn't compatible with the user devices, the performance may be reduce. Therefore, we need to specify that required mobile features.
```xml
<manifest>
	<uses-feature android:name="android.hardware.FEATURE?" android:required="true"/>
</manifest>
```
#### SDK VERSION
Custom Compiling our app is a requirement that we will need in the future to manage tools versions and ensure compatibility between  actions and specify SDK versions. Therefore, it is necessary to especify the SDK version used in the development process.
```kotlin
// build.gradle.kts
android {
	defaultConfig {
		applicationId = "com.example.myapp" //Direction
		// Defines the minimum API level required to run the app
		minSdkVersion(21)
		// Specifies the SDK version to test the app
		targetSdkVersion(33)
		...
	}
}
// from https://developer.android.com/guide/topics/manifest/manifest-intro#kts
```
#### ATTRIBUTE
All elements and components in the manifest file have several attributes that describe their available function. There are two keys exception to this rule:
1. Alias activity, an alias must follow the **<activity>** tag.
2. the <application> tag must be the last element inside <manifest> tag.
Next, the attribute appear in any tag within <manifest> follow a specific struct, wich uses a prefix such as: 
```xml
// Single value
android:Attribute
// Multiple values
<intent-filter ... >
	<action android:name="android.intent.action.EDIT" />
	<action android:name="android.intent.action.INSERT" />
	<action android:name="android.intent.action.DELETE" />
    ...
</intent-filter>
```
#### MORE ELEMENT REFERENCE INFORMATION
you can see more information in the next [**enlace**](https://developer.android.com/guide/topics/manifest/manifest-intro#reference)
#### MANIFEST STRUCT
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android" xmlns:tools="http://schemas.android.com/tools"
	<uses-permisson android:name="android.permission.SEND_SMS"/>
	<uses-feature android:name="android.hardware.sensor.compass" androis:required="true"/>
	<application
	android:icon="icon path"
	android:label="descripcion global">
		<activity 
		android:name="package_designation"
		android:icon="icon path"
		android:label="description local">
		...	
		</activity>
	...
	</application>
</manifest>
```
