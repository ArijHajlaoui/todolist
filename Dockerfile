FROM node:14.16.1-alpine

#Docker image creator
MAINTAINER HAJLAOUI Arij "hajlaoui.arij@gmail.com"

#Set working directory
WORKDIR /app

#Add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

#Install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm install --silent
RUN npm install react-scripts@4.0.1 -g --silent

#Add app
COPY . ./

#Expose port
EXPOSE 3000

#start app
CMD ["npm", "start"]

