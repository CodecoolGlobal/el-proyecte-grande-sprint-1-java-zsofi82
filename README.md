# Pick your spot!

Pick your spot is a foosball table reservation system.

## Installation
---
(The following code snippets are for linux/ubuntu) 

Clone repository:
```sh
git clone git@github.com:CodecoolGlobal/el-proyecte-grande-sprint-1-java-zsofi82.git
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

## Usage
---

While the service is running, go to "localhost:3000" in your browser to see the main page

Register a new user, then log in. After a succesful login, you can pick your spot and time with the dropdowns. These changes filter the table cards and filter out ones that are already reserved for the hour.

To reserve a table click on a table card, and press on the "Reserve".

Your can view and delete your Reservations by pressing on "Profile".

## Technologies
---

The app is using: 
- React frontend
- Java backend:
  - Spring Boot (dependency injection framework)
  - Spring security (JWT token authentication)
  - Hibernate (database connection)
- Postgresql database



