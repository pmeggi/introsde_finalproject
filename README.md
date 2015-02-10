# IntroSDE FINAL PROJECT - PINKI MEGGI
This is the readme.md file of final Project of Introduction to Service Design and Engineering Course 2014/2015.

## Project Description
This project implements a composed web service application that allows an registered person to track and monitor his/her health and lifestyle measurements (like "weight", "bloodingpressure", "walkingsteps" and "sleepinghours") and define some goals to achieve like:
* Minimum weight to loose by week
* Maximum blood pressure per day
* Minimum walking steps per day
* Minimum sleeping hours per day

The application also allows a person reminders (based on daily, weekly, monthly or specific date type). The "tracking" module of the application also informs the person about his/her daily events as “reminders of the day”, gives some feedback on the progress toward achieving goals and based on that suggests some activities and persuasive strategies.

## Architecture
The application is devolved according to the following architetcure:
![Alt text](architecture.png?raw=true "vLifeCoach Architecture")

## Module Description
The vLifeCoach Architecture is composed by following components:
* **Data Services (implemented using SOAP Technology):**
  <br><br>**1- vLifeCoachPeopleDBService** is a web service that provides access to the local database SQLITE where all      
  information related to the Person profile, health and life measurements, goals and reminders are recorded.
  <br>**2- vLifeCoachExternalService** is a web service that provides access to external datasources and services;
  <br>All these services receive requests and response from/to the **Storage Service - vLifeCoachStorageService**.
  
* **Business Logic Services (implemented using REST Technology):**
  <br><br>**3- vLifeCoachPeopleService** is a web service that serves all requests related to the person profile, person 
          helath and life measurements and measures types;
  <br>**4- vLifeCoachGoalService** is a web service that serves all requests related to the person goals;
  <br>**5- vLifeCoachTaskService** is a web service that serves all requests related to the person reminders;
  <br>**6- vLifeCoachTrackingService** is a web service that serves all requests related to person goals/reminders tracking;
  <br> All these services receive requests from the **Process Centric Service - vLifeCoachService** and get data from the 
      data layer **Storage Service - vLifeCoachStorageService** and processes it to send results back.

* **Process Centric Services (implemented using REST Technology):**
  <br>**7- vLifeCoachService** is a web service that serves all requests coming from console application myVirtualCoachApp and redirects the request to proper **Business Logic Service**.


* **User Interface (Console Java Application):**
  <br>**8- myVirtualCoachApp** is an client console java application which calls the **Process Centric Service - vLifeCoachService** to provide to the users with the application functionalities.



## Link to Documentation
The link to vLifeCoachService can be found [here][1].

## Author Information
This project was developed by:<br><br>
&nbsp;&nbsp;Pinki Meggi<br>
&nbsp;&nbsp;Matricula No. 136133<br>
&nbsp;&nbsp;Email: pinki.meggi@gmail.com<br>

[1]: https://github.com/pmeggi/introsde_finalproject/blob/master/vLifeCoach_Documentation.pdf
