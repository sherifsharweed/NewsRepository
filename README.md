# NewsRepository
<img src="Pics/1.jpg" alt="1" height="300"/> <img src="Pics/2.jpg" alt="1" height="300"/>
<img src="Pics/3.jpg" alt="1" height="300"/> <img src="Pics/4.jpg" alt="1" height="300"/>
<img src="Pics/5.jpg" alt="1" height="300"/>


An application for News :

1- First screen is the main screen for highlighted news, has a horizontal scroll view contains items for news.

2- User can click on any item of news, then it'll redirect to the second screen.

3- User can see the details of any new in the second screen (title,content,description,source,author,date,button to hit the website).

4- User can search for news with specific title.

5- If news result is still being loaded, user will see an animation for loading until it's done.

6- If there's error of no result, a message will be seen by user to infrom him that there's something abnormal.


# Application architecture and structure

It is a single module project architecture. And, I'm following the Clean Architecture as a Software Architecture Pattern and MVI as a Presentation Layer Pattern.

# Third-party used

1- Hilt : for dependency injection.

2- Coroutines : for handling the background operations.

3- Coil : for presenting images.

4- Retrofit : for making calls from API.
