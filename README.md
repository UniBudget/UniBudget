Original App Design Project 
===

# UniBudget

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An application that assists college/university students with daily (day-to-day, week-to-week, month-to-month) budgeting to help students better utilize funds while going through their matriculation of college/university.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:**
- **Mobile:**
- **Story:**
- **Market:**
- **Habit:**
- **Scope:**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [x]Users can register a new account.
* [x]Users can login.
* [ ]Users able to locate nearby banking/credit unions.
* [x]Users can recieve information about daily, weekly, and monthly goals.

**Optional Nice-to-have Stories**

* [ ]Users can create different type of budgeting accounts (food, entertainment, transportation)
* [ ]User can be notified when Budgeting Milestones are reached. 

### 2. Screen Archetypes

* Login Screen 
   * User is able to login.
  
* Registration Screen 
   * User is able to sign up for UniBudget.

* Stream (Home Screen)
  * User is able to view daily, weekly, and monthly budget goals.
 
* Search (Location Screen)
    * User can search nearby banks.
    * User can view list of nearby banks.

* Profile (Profile Screen)
    * ser can view their personal profile.
    * User is able to update account information.
    * User is able to update input/budget information.

* Nice-to-have 
    * User is able to click on notifcation in the app for more details.
    * User is able to click on weekly, monthly, and budget goals.
       
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home View
* Locate Bank View
* Profile View

**Flow Navigation** (Screen to Screen)

Login View
Home View

* Registration Screen
Login View
Home View

* Locate Bank View
Maps (Detailed View)

* Profile View
Edit Account (Detailed View)]
Edit Budget (Detailed View)]

## Updated Gif - Sprint Cycle 2 

<img src ="https://media.giphy.com/media/AaylnEpvm43LLEnq2e/giphy.gif" width=250>br>

## Gif - Sprint Cycle 1
<img src="https://media.giphy.com/media/XWPbE2Z55Of7zrrEOZ/giphy.gif" width=250><br>


## Digital Wireframes

<img src="https://media.giphy.com/media/AiKjHoXYeeeEvJ0HFA/giphy.gif" width=250><br>


## Schema 

### Models
| Property      | Type          |   Description             |
| ------------- |-------------- | ------------------------- |         
| dailyBudget  | int           | $50                       |
| weeklyBudget | int           | $400                      |
| monthlyBudget| int           | $800                      |
| failBudget   | string        | "You did not meet budget."|
| madeBudget   | string        | "You made budget! Yay!"   |
| monthStart   | DateTime      | date the month started    |
| monthEnd     | DateTime      | date the month ended      |
### Networking
- **Home Feed Screen**

* (Read/GET) List weekly and monthly budgets. 

```
let query = PFQuery(className:"ViewBudget")
let query = PFQuery(className:"dailyBudget")
query.whereKey("user", equalTo: currentUser)
query.order(byDescending: "createdAt")
query.findObjectsInBackground { (viewbudgets: [PFObject]?, error: Error?) in
   if let error = error { 
      print(error.localizedDescription)
   } else if let viewbudgets = viewbudgets {
      print("Successfully retrieved \(viewbudgets.count) viewbudgets.")
   } else if let dailybudgets = dailybudgets {
      print("Successfully retrieved \(dailybudgets.count) dailybudgets.")
   }
}
```
- **Profile Screen**
```
public String getCurrentUserLogin() {
        }
        return login;
        }}
```

   - (Update/PUT) Update user budgeting information.
   - (Update/PUT) Update account information.

- **Location Screen**
- (Read/GET) List nearby banks near user.

```
private void saveCurrentUserLocation() {

 if(ActivityCompat.checkSelfPermission(UsersActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(UsersActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
     ActivityCompat.requestPermissions(UsersActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
 }
 else {
     Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
```

     if(location != null)
         ParseGeoPoint currentUserLocation = new ParseGeoPoint(location.getLatitude(), location.getLongitude());

         ParseUser currentUser = ParseUser.getCurrentUser();

         if (currentUser != null) {
             currentUser.put("Location", currentUserLocation);
             currentUser.saveInBackground();
         } else {
             return LoginActivity;
         }
     }}}


- **Login Screen**
- (Read/GET) Get username and password

```
@IBAction func signUp(_ sender: UIButton) {
     let user = PFUser()
     user.username = signUpUsernameField.text
     user.password = signUpPasswordField.text
     let sv = UIViewController.displaySpinner(onView: self.view)
     user.signUpInBackground { (success, error) in
         UIViewController.removeSpinner(spinner: sv)
         if success{
             self.loadHomeScreen()
         }else{
             if let descrip = error?.localizedDescription{
                 self.displayErrorMessage(message: descrip)
             }
         }
     }
 }
```
- Updates 1
- Created a new repository for application because of technical difficulties between Android Studio and GitHub.
- Font originally chosen for application was not present in Android Studio. So, the group chose to select a font that was similar to the original.
- Updates 2
- Removed showbar from screens
- Created homepage showcasing budgeting goals.
