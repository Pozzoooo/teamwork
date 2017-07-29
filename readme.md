
- Take teamwork colors
- Create a basic theme
- Remove ide commited stuff


#### This is a sample app created for Teamwork, enjoy!

# Timeline

Just a quick explanation on how I went through this project development.
- Initially I took look into the documentation, played a bit with your system and 
requested some of the apis to make sure I got it;
- Then I quickly draw a Use Case, sounded too simple to go ahead to other diagram;
- Git config, new android studio project;
- Basic dependencies and configurations;
- Initial architecture;
- Authorization and api calls;
- Test structure with initial tests;
- First end to end (Projects);

# Design

# Layers

My layer choice has the idea to focus Unit test on Business, integration test on 
Network, threading on Presenter and Ui on Activities.

#### Networking
I have used a very simple approach, where you can directly call a network client that 
is going to have access to the api and the knowledge to translate the resources.  
But I would strongly recommend a more elaborated solution using a bound service 
with and a caching and queue system, which would be able to detach requests from 
the stack.

# Unit Test

I'm using a strategy where I can easily unit test the business layer and use the 
network layer (Client + Api) for the integration tests.  

# What I Missed

#### Persistence
I completely ignored this one on my sample for the sake of simplicity.  
SQLite or RealmDB should be probably one my choices.

#### Reporting system
This is essential thing to me, would not release an app without an error reporting 
system and an analytics.

### What else?
There are a few "todo" around the code with other minor improvements.

# Issues found

- Fields on the services does not follow a very right patter, I have seen some camel 
case and some snake case mixed in the same object.

# Good stuff found

- Your documentation is really sweat, long time since I don't work wiht a so detailed 
and descriptive documentation, really helpful.
- Rest API seems to be in good shape, easy to use and very much logical, liked it.
