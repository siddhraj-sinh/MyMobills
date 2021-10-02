# MyMobills

[![License](https://img.shields.io/badge/License-Boost%201.0-lightblue.svg)](https://github.com/siddhraj-sinh/MyMobills/blob/master/LICENSE)

MyMobills is modern invoice generator app. This app lets you create your own customized invoices for your business by providing several invoice templates. it also stored all previously created invoices data. generated invoice can be share as image or pdf file.

## Android Architecture Pattern
In order to keep this android codebase maintainable we have follow <b>MVVM pattern</b>. more on MVVM pattern you can find it <a href="https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide">here.</a>

<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png" width="450" height="450"/>

## Specs/Libraries:

<ul>
  <li><a href="https://github.com/JetBrains/kotlin">Kotlin</a> all new modules starting from 1.5.20 will be written in #Kotlin.</li>
  <li><a href="https://developer.android.com/guide/navigation?gclsrc=aw.ds&gclid=CjwKCAjw49qKBhAoEiwAHQVTox9zfgXsUjUuiKozHBt-XzoUwYfXHRLuBMTnX5NMw1nPgzhD3GNhEhoCfUcQAvD_BwE">Navigation Components</a> helps to implement navigation, from simple button clicks to more complex patterns.</li>
  <li><a href="https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView">Material-BottomNavigation</a> for bottom tabs</li>
  <li><a href="https://developer.android.com/kotlin/coroutines?gclsrc=aw.ds&gclid=CjwKCAjw49qKBhAoEiwAHQVTo_Bpg6T9giWbI1YrGFxTM3n9wLNGjeSUmfaDchgwvGTRijNaQ7rStBoCmD8QAvD_BwE">Kotlin Coroutines</a> and  <a href="https://developer.android.com/topic/libraries/architecture/lifecycle">Lifecycle aware components</a></li>
  <li><a href="https://developer.android.com/topic/libraries/architecture/datastore?gclsrc=aw.ds&gclid=CjwKCAjw49qKBhAoEiwAHQVTo7kKhYVlETxHa3gqTq9J6ZWIvqIJBj3fO4zbo-n4vqx8PBbmeWNwUBoCqEQQAvD_BwE">Data Store</a> is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.</li>
  <li><a href="https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase">Roomdb </a>for storing data mainly generated invoices details in local database</li>
</ul>

## UI Snapshots:
<table>
<thead>
<tr>
<th align="center">Splash Screen</th>
<th align="center">Home Screen</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center"><img src="https://user-images.githubusercontent.com/69664213/135705240-7e9a75ec-554f-4598-bb28-d2ec478464e0.jpg" alt="Splash Screen" width="380" height="640"></td>
<td align="center"><img src="https://user-images.githubusercontent.com/69664213/135705321-b80bf63f-5451-438a-9c5b-afd4999408cf.jpg" alt="HomeFragment"width="380" height="640"></td>
</tr>
</tbody>
  <thead>
<tr>
<th align="center">Profile Screen</th>
<th align="center">Create Invoice Screen</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center"><img src="https://user-images.githubusercontent.com/69664213/135705384-4642e8e1-8434-4ef3-a0a1-deeeac92279d.jpg" alt="Profile Screen" width="380" height="640"></td>
<td align="center"><img src="https://user-images.githubusercontent.com/69664213/135705401-df3dae29-8f14-49e4-8944-f4870a84b2c6.jpg" alt="Create Invoice Screen"width="380" height="640"></td>
</tr>
</tbody>
</table>

## What's to be done?

<ul>
  <li>Home Fragment (at now it only show dummy data of invoices instead of this it is require to show data from local database)</li>
  <li>Report Fragment (completly from scratch)</li>
  <li>Setting Fragment (completly from scratch) implement this <a href="https://www.figma.com/file/VDVL52ChLEEoXcLWUirTre/Setting-Screen-UI?node-id=0%3A1">UI</a></li>
  <li>Profile Fragment (asking permission and take or choose photo from gallery and store URI in database or datastore)</li>
  <li>More Invoice Templates</li>
  <li>Share generated invoice as PDF/IMG on click of Share FAB in PreviewFragmenr</li>
  <li>UI Improvement</li>
  <li>Dark Mode Theme</li>
  <li>Fixing Bugs</li>
  
</ul>

## What do you need to get started?

Latest version of android studio and basic android and googling skills will get you going.


