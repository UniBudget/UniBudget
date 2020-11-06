# UniBudgett
Original App Design Project - README Template
UniBudget
Table of Contents
Overview
Product Spec
Wireframes
Schema
Overview
Description
An application that assists college/university students with daily (day-to-day, week-to-week, month-to-month) budgeting to help students better utilize funds while going through their matriculation of college/university.

App Evaluation
[Evaluation of your app across the following attributes]

Category:
Mobile:
Story:
Market:
Habit:
Scope:
Product Spec
1. User Stories (Required and Optional)
Required Must-have Stories

-Users can register a new account.
-Users can login.
-Users able to locate nearby banking/credit unions.
-Users can recieve notifications about daily, weekly, and monthly goals.
…
Optional Nice-to-have Stories

-Users can create different type of budgeting accounts (food, entertainment, transportation)

-Budgeting Milestones

…
2. Screen Archetypes
Login screen
-User is able to login
…
Registration screen
-[User is able to sign up for UniBudget]
…
Stream
Home screen
-User is able to view daily, weekly, and monthly budget goals.
-User is able to click on weekly, monthly, and budget goals.
…
Search
Location screen
-User can search nearby banks.
-User can view list of nearby banks.
…
Profile
Profile screen
-User can view their personal profile.
-User is able to update account information.
-User is able to update input/budget nformation.
…
Nice-to-have
-User is able to click on notifcation in the app for more details.

…
3. Navigation
Tab Navigation (Tab to Screen)

[Home View]
[Locate Bank View]
[Profile View]
Flow Navigation (Screen to Screen)

[Login View]
[Home View]
…
[Registration Screen]
[Login View]
[Home View]

[Locate Bank View]
[Maps (Detailed View)]

[Profile View]
Edit Account (Detailed View)]
Edit Budget (Detailed View)]
…
Wireframes
![UniBudget Demo](https://media.giphy.com/media/AiKjHoXYeeeEvJ0HFA/giphy.gif.gif)

Schema
[This section will be completed in Unit 9]

Data Models
| Property      | Type          |   Description             |
| ------------- |-------------- | ------------------------- |         
| dailyBudget  | int           | $50                       |
| weeklyBudget | int           | $400                      |
| monthlyBudget| int           | $800                      |
| failBudget   | string        | "You did not meet budget."|
| madeBudget   | string        | "You made budget! Yay!"   |
| monthStart   | DateTime      | date the month started    |
| monthEnd     | DateTime      | date the month ended      |


Networking
[Add list of network requests by screen ]
Home Feed Screen

(Read/GET) List weekly and monthly budgets. 

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
Profile Screen
@@ -123,13 +123,48 @@ public String getCurrentUserLogin() {
        }
        return login;
        }}

(Update/PUT) Update user budgeting information.
(Update/PUT) Update account information.

Location Screen
(Read/GET) List nearby banks near user.

private void saveCurrentUserLocation() {

 if(ActivityCompat.checkSelfPermission(UsersActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(UsersActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
     ActivityCompat.requestPermissions(UsersActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
 }
 else {
     Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

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


Login Screen 
(Read/GET) Get username and password

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
