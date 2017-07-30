todo:
- more documentation;
- final code review.
- missing details activity presenter!?

#### This is a sample app created for Teamwork, enjoy!

# Timeline

Quick explanation on how I went through this project development.
- Initially I took a look into the documentation, played a bit with your system and 
requested some of the apis to make sure I got it;
- Then I quickly draw a Use Case, sounded too simple to go ahead to other diagram;
- Git config, new android studio project;
- Basic dependencies and configurations;
- Initial architecture;
- Authorization and api calls;
- Test structure with initial tests;
- First end to end (Projects);
- Minimum viable project list;
- Minimum viable project details;
- Communication between activities;
- Design improvements;
- Code review;
- Documentation review;
- Release.

# Design

I haven't spent too much time on design (noticeable I know), but I have tried to make 
it as much independent from the implementation as possible, so it can be adaptable 
by the ui layer.  

# Layers

My layer choice has the idea to focus Unit test on Business, integration test on 
Network, threading and flow on Presenter and Ui on Activities and Views.
Main packages are separated by functionalities with extra shared packages. 

#### View
UI layer is being used exclusively for layout manipulation and receive user input.  
Using Fragments when it seems to have a good fit.  
View interfaces are what really define what the view is capable of doing.

#### Presenter
Presenter will be handling all user input and controlling what flow it should take, 
as well as deciding when to give feedback to the user and handling threading.

#### Model
Kotlin data classes, with optional implementations of Parcelable and Serializable.  
Some very minor logic can be add to it if it makes sense.

#### Business
Any actual business logic and objects transformations should be handled here.  
Database access and networking should be requested to business, but they are going to 
be request for a third layer, either database or network, and they can be 
manipulated before returning to the requester, caching strategy should start here as 
well.

#### Networking
I have used a very simple approach, where you can directly call a network client that 
is going to have access to the api and the knowledge to translate the resources.  
But I would strongly recommend a more elaborated solution using a bound service 
with and a caching and queue system, which would be able to detach requests from 
the stack.

# Unit Test

I'm using a strategy where I can easily unit test the business layer and use the 
network layer (Client + Api) for the integration tests.  

# Things that I would have done if I had more time 

#### Design
- Find the exact Teamwork colors to use;
- Start checkbox on project list;
- Grid view option for the project list;
- Dynamic design (colors and styles).

#### Persistence
I completely ignored this one on my sample for time constraints.  
SQLite or RealmDB should be probably one my choices.  
A new layer would be required, a caching strategy that could take database advantage.  
A sync adapter would probably be useful for this project as well.

#### Reporting system
This is essential thing to me, would not release an app without an error reporting 
system and an analytics.

#### Login
I have also ignored the login flow, credentials are hardcoded in the app.

#### What else?
There are a few "todo" around the code with other minor improvements.

# Issues found

- Fields on the services does not follow a very right patter, I have seen some camel 
case and some snake case mixed in the same object.

# Good stuff found

- Your documentation is really nice, long time since I don't work with a so detailed 
and descriptive documentation, really helpful.
- Rest API seems to be in good shape, easy to use and very much logical, liked it.
