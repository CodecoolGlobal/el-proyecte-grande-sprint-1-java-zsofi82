
FROM node:18.13-alpine3.17
WORKDIR /app
COPY package*.json ./
RUN npm ci
RUN npm install http-server
COPY . .
RUN npm run build
EXPOSE 3000
CMD ["npx", "http-server", "-P", "http://springbootapp:8080", "-p", "3000", "./build"]