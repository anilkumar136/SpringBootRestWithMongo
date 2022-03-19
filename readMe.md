Phone screen- One leetcode
Round 1 - Craft Exersise give for 90 mins----One Engineer was on call with scren sharing. Google was allowed and Engineer on call was juts to see if u need any help. No Questions asked 
Round 2 - 3-4 ppl Discussion on Craft. Tech choices. Scnrios like what if load is doubled..  I mentioned Paging, cahcing, 
Round 3 - 2 ppl ---Asked to add PUT/POST in craft. Oprtional Questions like montering/Alerting/logging frameworks etc
Round 4 - System Design (for Staff--asked Google map desgin)....for senior could be a leetcode (ismorphic strings)
Round 5 - Behviorla

-----------------Craft Exersice---------
Your assignment is to create a microservice which serves the contents of Player.csv through a REST API.

The service should expose two REST endpoints:

    GET /api/players - returns the list of all players.
    GET /api/players/{playerID} - returns a single player by ID.
-------------------------------------------
(Attached player.csv as well here)
This is how i started it------
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


