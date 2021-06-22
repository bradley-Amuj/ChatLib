# ChatLib
Android chat library implemented using Firebase

# Download
1.Add jitpack to the root build.gradle file of your project at the end of repositories.
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
  ```
2. Add dependancy 
```
dependencies {
	    implementation 'com.github.bradley-Amuj:ChatLib:v1.0.0'
	}

```

# Usage 
1. Make sure firebase is correctly configured in your project 
2. Initialize the MessageUtil object in the onCreate method using your firebase credentials obtained from the your google-services.json file

```java
messageUtil = new MessageUtil([your appid],[your project id],[your apikey],[url to your database],getApplicationContext());
```
3.Sending a message
```java
 messageUtil.sendMessage(message,user.getId(),[recepient id]);
```
4. Displaying previously sent messages 
This should be done on the onCreate method
```java
 messageUtil.showPreviousMessages(adapter,user.getId(),[recepient id]);
```
5. To know how to use the UI components of this library check the following github link:
https://github.com/stfalcon-studio/ChatKit
