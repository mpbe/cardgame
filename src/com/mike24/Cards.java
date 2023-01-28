package com.mike24;


/* i have no idea what im doing lol. do i have to make 52 objects????
  still going through treehouse videos but havent seen loads on methods yet
  so not sure how to approach making shuffle etc. guess i need to make the cards
  first tho. is this correct in any way or am i way off??

 */


public class Cards {

    final private String cardName;
    final private String cardSuit;
    final private int cardValue;

    public Cards(String cardName, String cardSuit, int cardValue) {
        this.cardName = cardName;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public String getCardName(){

        return cardName;
    }

    public String getCardSuit(){

        return cardSuit;
    }

    public int getCardValue(){

        return cardValue;
    }

    public String cardCheck()
    {
        return("this card is "+ this.getCardName()+
                " of suit " +
                this.getCardSuit()+", its value is " + this.getCardValue());
    }


}
