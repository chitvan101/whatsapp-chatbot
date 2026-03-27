# WhatsApp Chatbot Backend Simulation

A simple WhatsApp chatbot backend built with Java and Spring Boot.

## What it does
- Accepts POST requests at `/webhook`
- Reads an incoming message (from + text)
- Returns a predefined reply based on the message
- Logs all messages to the console

## How to run

### Requirements
- Java 17 or above
- Maven

### Steps
1. Clone this repo
2. Open terminal and go to the project folder
3. Run: `mvn spring-boot:run`
4. The server starts at: `http://localhost:8080`

## How to test

Use Postman or curl to send a POST request.

**Endpoint:** `POST http://localhost:8080/webhook`

**Request Body (JSON):**
```json
{
  "from": "9876543210",
  "text": "Hi"
}
```

**Response:**
```json
{
  "to": "9876543210",
  "reply": "Hello! How can I help you today?"
}
```

## Supported messages

| You send | Bot replies |
|----------|-------------|
| Hi / Hello / Hey | Hello! How can I help you today? |
| Bye / Goodbye | Goodbye! Have a great day! |
| How are you | I am just a bot, but I am doing great! |
| help | Lists what the bot understands |
| Anything else | Sorry message |

## Project Structure

```
src/
└── main/
    └── java/com/example/chatbot/
        ├── ChatbotApplication.java   ← Main class, starts the app
        ├── WebhookController.java    ← Handles POST /webhook
        ├── Message.java              ← Incoming message model
        └── BotResponse.java          ← Reply model
```

## Deploy on Render (Bonus)

1. Push this project to GitHub
2. Go to https://render.com and sign up
3. Click "New Web Service" → connect your GitHub repo
4. Set build command: `mvn clean package -DskipTests`
5. Set start command: `java -jar target/chatbot-0.0.1-SNAPSHOT.jar`
6. Click Deploy!
