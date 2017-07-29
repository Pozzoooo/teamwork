
- Take teamwork colors
- Create a basic theme



#### This is a sample app created for Teamwork, enjoy!

# Design

# Layers

#### Networking

I have used a very simple approach, where you can directly call a network client that 
is going to have access to the api and the knowledge to translate the resources.  
But I would strongly recommend a more elaborated solution using a bound service 
with and a caching and queue system, which would be able to detach requests from 
the stack.

# What I Missed

#### Persistence

I completely ignored this one on my sample for the sake of simplicity.  
SQLite or RealmDB should be probably one my choices.
