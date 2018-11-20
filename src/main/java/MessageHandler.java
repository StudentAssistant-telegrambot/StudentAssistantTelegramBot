class MessageHandler {

    private String startAnswer = "Welcome to the Student assistant bot. Now it can answer to you. Hello world version";

    private String noAnswer = "I can't understand you. Hello!";

    MessageHandler(){

    }

    String textToText(String message){
        if (message.toUpperCase().contentEquals("/START"))
            return startAnswer;


        return noAnswer;
    }
}
