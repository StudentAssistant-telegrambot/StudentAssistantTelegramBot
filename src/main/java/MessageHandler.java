class MessageHandler {

    private String startAnswer = "Darova ot Vitalika";

    private String noAnswer = "Napiwi norm";

    MessageHandler(){

    }

    String textToText(String message){

        if (message.toUpperCase().contentEquals("/STARTED"))
          return "Vitalik";

        
        if (message.toUpperCase().contentEquals("/START")) {

            return startAnswer;
        }

        if (message.toLowerCase().equals("hello!")) {
            return "Good morning!!!";
        }


        return noAnswer;
    }
}
