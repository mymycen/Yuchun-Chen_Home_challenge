FROM node:20-alpine

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

# Start json-server, wait, then run Jest
CMD ["sh","-c","npm run mock & sleep 1 && npm test"]