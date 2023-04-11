# user_registration_and_loging
Spring Boot application for registration and logging users.

LOGIN PAGE

![image](https://user-images.githubusercontent.com/106002453/231106383-19df707a-6421-4a3d-9ccb-d4c2681f7f30.png)

REGISTER PAGE

![image](https://user-images.githubusercontent.com/106002453/231106477-5fb25521-e440-42fc-bf25-27b5433d1ed9.png)

VIEW PAGE

![image](https://user-images.githubusercontent.com/106002453/231106522-f03c53bc-e462-4c85-acd6-32429a2e6ecd.png)


## Getting Started
The following programs must be installed on your computer:
 Java Development Kit (JDK);
 development environment (IDE) such as Eclipse, IntelliJ IDEA or another;
 Apache Maven;
 MySQL database.

Clone this repository to your local computer:

<code>git clone https://github.com/AglayaSukhobskaya/user_registration_and_loging</code>

Open the project in the development environment.
Download all the necessary sources and documentation from Maven.

Create a new MySQL database and implement a connection to the service. All connection settings you can find in ***/resources/application.properties***.
To create the necessary tables in the database execute the SQL queries from file ***/resaurces/db.sql***.

Now the application is ready to running.

## Running the application
Run application: method main() from class ***com.sukhobskaia.TestTask.TestTaskApplication***.

Open any brouser you have and enter the following address: **http://localhost:8080/**

If everything is done correctly, the loging page will open: **http://localhost:8080/auth/login**

## Technology Stack
Spring Boot / Spring Security / Hibernate Validator / MySQL / Thymeleaf
