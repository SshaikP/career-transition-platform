#Docker file for frontend service
#Use node image
#Build stage
FROM node:18 AS build

#Set the working directory
WORKDIR /app

#Copy package.json and package-lock.json to the container
COPY package*.json ./

#Install dependencies
RUN npm install

#Copy the rest of the application code to the container
COPY . .

#Build the application
RUN npm run build

#Production stage
FROM nginx:alpine

#Copy the built application from the build stage to the nginx html directory
COPY --from=build /app/build /usr/share/nginx/html

#Expose port 80
EXPOSE 80

#Start nginx server
CMD ["nginx", "-g", "daemon off;"]


