Your assignment is to create a microservice which serves the contents of Player.csv through a REST API.

The service should expose two REST endpoints:

    GET /api/players - returns the list of all players.
    GET /api/players/{playerID} - returns a single player by ID.

-------------------------------------------

Tech:
Application--
Java--Springboot....Will expose Rest end points

DB--
Need to Strore Player deatils and server it rest --JSON
No Need maintian any relationships etc
Assuming Read heavy application---Beacuse only GET and see around 20K records in file---

------Horzaltinal Scalbilty---
MongoDB--
	--Single Wirte---Mutiple reader nodes---
	-- CAP--- chhosing C and P --- availabitly will be lost when my writer goes down(sometime)
	
-----------------------------------------
Tasks ---

1. Docker instance Mongo DB---> load my data    --Done

2. Create Springboot application  -- Done

3. Create user Interfaces -- rest endpoints----Try to do it with TDD
		    --GET /api/players - returns the list of all players.   ///Day2 : Do we return all 20k reord ??
			--GET /api/players/{playerID} - returns a single player by ID.

4. Implemtioning the services.

5. Testing.

6  Deployemnt --Docker


----------------
POST--- Create or Neter a new User
PUT-- If u want to modify a user
-------------------------

PUT  -- >  /api/player/{playerID}/chnageAdress

PUT  -- >  /api/player/{playerID}/chnage ? weight=10, height=10,adress=,

--Heavy---
PUT  --->  /api/player/incWeight


PUT  -- >  /api/player/{playerID}/incWeight
POST -->  /api/players/create














docker run -d --name mongo-on-docker -p 27017:27017 mongo
---This will start mongo image on docker --internal port of mongo inside docker is 27017 and will be exposed outside on 
local host on port 27017
--Connect to this mongo with compass, create collection and document
--Create Docker file in the project structure 
--build docker image of our app with below cmd:
docker build -t app . (Means build docker image as per Docker File present in the . current folder)

--now run our app
docker run --name app -p 8080:8080 app

Special Note::::
As Docker has its own host and internal ports ----In application.properties we have to use 
spring.data.mongodb.host=host.docker.internal  
To tell Spring to use ip address of internal Docker which is runnning on this host. 
As our app is now running in with in Docker contianer which has its own IP, so giving localhost will not work.
from IntelliJ it will work with localhost and above both but in decpker contianer it will only run with above host


