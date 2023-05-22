# Pick your spot!

Pick your spot is a foosball table reservation system. 

We developed this project over 5 weeks, as our final team project at codecool.

1. API endpoints, Spring boot setup
2. React frontend
3. Database connection with Hibernate Repositories
4. Spring security
5. Docker containerisation  


## Installation

(The following code snippets are for linux/ubuntu) 

Clone repository:
```sh
git clone git@github.com:CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82.git
git checkout c713e983e7599fe1fe7139ea07390f5125b69263
```
Install docker & docker-compose on your system 
```sh
sudo apt-get update
sudo apt install docker 
sudo apt install docker-compose 
```

Start service:

Navigate to repository folder
```sh
sudo docker-compose up -d
```

Shutdown service:
```sh
sudo docker-compose down
```

## Technologies


- React frontend
- Java backend:
  - Spring Boot (dependency injection framework)
  - Spring security (JWT token authentication)
  - Hibernate (database connection)
- Postgresql database
- Docker CI/CD

## Usage


While the service is running, go to "localhost:3000" in your browser to see the main page

Register a new user, then log in. After a succesful login, you can pick your spot and time with the dropdowns. These changes filter the table cards and filter out ones that are already reserved for the hour.

![Login page](https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82/blob/development/screenshots/login.png?raw=true)

To reserve a table click on a table card, and press on the "Reserve".

(Please don't mind the expired API key)
![Main Page](https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82/blob/development/screenshots/MainPage.png?raw=true)
![Reserve](https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82/blob/development/screenshots/Reserving.png?raw=true)

Your can view and delete your Reservations by pressing on "Profile".

![Profile](https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82/blob/development/screenshots/Profile.png?raw=true)

