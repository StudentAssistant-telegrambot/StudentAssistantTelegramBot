class MessageHandler {

    private String startAnswer = "Darova ot Vitalika";

    private String noAnswer = "Napiwi norm";

    MessageHandler(){

    }

    String textToText(String message){
        if (message.toUpperCase().contentEquals("/STARTED"))
            return startAnswer;


        return noAnswer;
    }
}
