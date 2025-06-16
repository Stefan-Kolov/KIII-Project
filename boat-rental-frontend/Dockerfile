# frontend/Dockerfile
FROM node:20 AS build

WORKDIR /app
COPY . .

RUN npm install
RUN npm run build

# Serve the static files with Nginx
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html

# Optional: add custom nginx config
EXPOSE 80
