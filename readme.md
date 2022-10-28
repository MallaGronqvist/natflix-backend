# Natflix backend

This is a Spring Boot application that is connected to a MySQL database and acts as a server for the Natflix frontend.
The Natflix frontend can be found in its own repository and run separately on port 3000. 
The backend accepts requests from localhost:3000. 

A docker-compose -file can be found in the frontend -project. 
I have placed it there for the sake of accessing it easily from a terminal in Visual Studio Code, when running the frontend and the backend.
**The docker-compose up -d -command can be used to start the containers that are used for the database (mySQL and adminer)**.
The Spring Boot -app then connects to the dockerized database through port 3300. (I have needed to set the container's
exposed port to 3300 instead of the usual 3306 for MySQL, because I already had that port in use for mySQL Workbench.)


## Import tables and data

I have added example content to the database, and in order for you to be able to use the tables and view the content, I have exported the tables.
**You can import the tables through the adminer -interface, that will run on localhost:8080.**
These tables can be found in the **Tables -folder**. Note that the database user should be "root" and the password needs
to be "example", otherwise you will need to change these in the application.properties -file.

Once the database containers are running, and you have imported the tables. You can run the spring boot app.
After that you can run the frontend.

## Branches

I have worked in two branches. In the **master** -branch you can find a working version of the server that can handle requests
related to the content. 

In the other branch called "**Auth**" I have worked on the sign up and sign in -endpoints.
In the current version a request to sign up can be handled by the server and a user is created in the database.
A request to sign in can be processed in the sense that the server can authorize the credentials, but for some
reason it does not return a response body. I have been trying to solve this issue for three days, but unfortunately I have not been able to find the problem.
I have compared my solution with the example project that we got from the authentication lecture, but I still have not been able to find the issue.
Hence, I have not been able to solve this last part that would have been needed to complete the authentication.

## Project management

In the ProjectManagement -directory you can find **table schemas** that have been used in the planning of the database.
You can also find **a schema over the endpoints** that has been used when building the REST API.
No class diagram has been included because the project follows the usual Spring Boot framework's structure.
Further, you can find a **Project Management -spreadsheet** that has been used to plan the work.

