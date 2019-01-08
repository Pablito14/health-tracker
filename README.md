# health-tracker
An Android app that will be the focus of all of the work for this half of the course: a health tracker app.
While we’re starting small, the features that will be built will carry over into the next several labs.

### Day 1

1. Finger Exercises
    * One key part of health is building finger strength and endurance. On the main page, display a number and a button.
    * The number should increase when the button is clicked.

    * Stretch goal: the app should show encouraging messages as the user passes milestones in their button-clicking (perhaps a message at every 10 clicks, and serious props at every 50).

2. Stopwatch
    * Still on the main page, add a stopwatch. 
        * Have a button to [Start/Pause]. The start/pause button should toggle between saying “start” and “pause.”
        * Have a [Reset] button for the clock. You should only be able to reset when the stopwatch is paused.
    * Have the view update as fast as possible while still leaving the buttons responsive.
    * Display the clock as 0:00:00.000 so it should be able to track up to 9 hours, 59 minutes, 59 seconds and 999 milliseconds.
    * You can use System.currentTimeMillis() to track the start and current time at the millisecond-level.    
    
3. Inspiring Image Carousel
    At the top of the main page, I want to inspire the users with images of the type of person they can become. 
    * Display an image with a caption below it. (The caption should NOT be part of the image; it should be text.)
    * Allow users to cycle through images and read the captions
        * Pressing next should go to the next image and its caption, pressing prev should go back.
    * The app should display a (1/N), (2/N) … indicator so users know how many items are in the list.
    * Your app must use a class to model the images and their captions.
    * Use the class to manually instantiate each unique item.
    * Add all of the items to an array.
    * Your app should use the array of image objects to cycle through what it’s showing.