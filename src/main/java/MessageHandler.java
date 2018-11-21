class MessageHandler {

    private String startAnswer = "Darova ot Vitalika";


    private String startseccsessful = "Vasya Privet";
    private String noAnswer = "I can't understand you. Hello!";



    MessageHandler(){

    }

    String textToText(String message){
        
        if (message.toUpperCase().contentEquals("/START")) {

            return startAnswer;
        }
        if (message.toUpperCase().contentEquals("/STARTED"))
            return startseccsessful;
        

        if (message.toLowerCase().equals("hello!")) {
            return "Good morning!!!";
        }



        return noAnswer;
    }
}
