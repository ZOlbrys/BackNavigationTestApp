# BackNavigationTestApp

Test app for back navigation.  The app is setup using the navigation framework, predictive back behavior enabled, and a `DrawerLayout`. 

To reproduce, do the following:

1. Launch app
2. Click `Go to Fragment B` button
3. Swipe back and/or press the physical back button to navigate to the previous fragment (Fragment A)
4. Click the `Open Drawer Layout` button
5. Click the `Go to Fragment C` menu item
6. Try to swipe back and/or press the physical back button to navigate to the previous fragment

Expected results:
Fragment A should be displayed, as this was the previous fragment displayed before navigating to Fragment C

Actual results:
Swipe gestures and pressing the physical back button does not work anymomre - so you will still be on Fragment C.  Poping the backstack manually does work, and is implemented in Fragments B, C, and D to provide a means to navigate the app while in this broken state.
