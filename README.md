# Cinematica - Personalized Movie Streaming Platform

## Introduction

Cinematica is an innovative movie streaming platform designed to provide a seamless and personalized viewing experience. Leveraging advanced algorithms, Cinematica offers personalized recommendations, allowing users to discover films that align with their interests. With a vast library of movies, users can easily search by genre, add movies to their watchlist, and enjoy high-quality streaming across various devices.

## Key Features

- **Wishlist Movie:** Users can add movies to a wishlist for future viewing.
- **Watch Movie:** Seamless streaming with features like play, pause, resume, and adaptive bitrate streaming.
- **Search Movie:** Users can search by name, genre, or language to find movies easily.

## Technology Stack

- **Frontend:** ReactJS
- **Backend:** Java (Spring Boot)
- **Database:** MySQL
- **Cloud Storage:** Amazon S3
- **CI/CD:** GitHub, Maven, Jenkins
- **Containerization:** Docker, Kubernetes
- **Configuration Management:** Ansible
- **Monitoring:** Elasticsearch, Logstash, Kibana (ELK Stack)

## System Requirements

- **Operating System:** Ubuntu 20.04
- **CPU and RAM:** Quadcore processor and 8 GB RAM
- **Java Version:** OpenJDK 17
- **Maven Version:** 3.9.1

## Installation Guide

### Frontend
Frontend
Install NPM:
sudo apt install npm
npm --version

#Install Create-React-App Tool:
sudo npm -g install create-react-app
create-react-app --version

Run the React Application:
npm start

##Backend
Create a Spring Boot Project:
Use Spring Initializr to generate a Spring Boot project.
##Database
Install MySQL Server:
sudo apt install mysql-server
sudo systemctl status mysql

#Secure MySQL Installation:
sudo mysql_secure_installation

#Create a Dedicated MySQL User:
sudo mysql -u root -p

##Docker
Install Docker:
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl status docker

##Build and Run Docker Images:
docker build -t <image_name> .
docker run -i -t <image_name>

##Kubernetes
Start Minikube:
minikube start

##Verify Minikube Status:
minikube status

##Ansible
Install Ansible:
sudo apt install ansible
ansible --version

##Run Ansible Playbook:

##Define tasks in a YAML format playbook and execute.
Source Code Management
Clone Repository:
git clone <repository_url>

##Create New Branch:
git checkout -b <branch_name>

##Add and Commit Changes:
git add .
git commit -m "Commit message"

##Merge and Push Changes:
git checkout master
git pull
git merge <branch_name>
git push

##Build and Testing
Install JDK:
sudo apt-get install openjdk-11-jdk
java --version

##Install Maven:
sudo apt install maven
mvn --version

##Build and Test with Maven:
mvn clean install

##Logging and Monitoring
Logging: Log4j2 for logging various levels of messages.
Monitoring: ELK Stack (Elasticsearch, Logstash, Kibana) for real-time log analysis and visualization.

##Future Scope
Subscription Plans: Implementing subscription plans and payment gateway.
Enhanced User Engagement: Sending OTP via email and phone, and refining recommendation algorithms.

##Conclusion
Cinematica successfully integrates modern technologies to provide a comprehensive and enjoyable movie streaming experience. The platform's robust architecture ensures efficient content management and user engagement, making it a scalable and reliable solution for digital entertainment.

