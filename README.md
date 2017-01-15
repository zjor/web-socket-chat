# web-socket-chat

Sample "hello world" java-based WebSocket application

## How to run

`mvn clean install tomcat7:run -Dmaven.tomcat.port=7001`

## Issues

1. Messages are not transferred to all participants
2. Specify json-based protocol for different commands (login, message, broadcast, logout)
3. Redesign UI, center panel, material design
4. Use standalone message broker to send messages between nodes (RabbitMQ)
5. Create docker file to run 4 nodes (nginx balancing requests, 2 working nodes, RabbitMQ node)
