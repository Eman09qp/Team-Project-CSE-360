public class Payment {
    private String cardName;
    private String ccNum;
    private String expDate;
    private int secCode;

    public Payment(String newName, String newNum, String newDate, int newCode){
        cardName = newName;
        ccNum = newNum;
        expDate = newDate;
        secCode = newCode;
    }

    public String getPayment() { return cardName + "\n" + ccNum + "\n" + expDate + "\n" + secCode; }

    // Getters and Setters
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String newName) {
        cardName = newName;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String newDate) {
        expDate = newDate;
    }

    public int getSecCode() {
        return secCode;
    }

    public void setSecCode(int secCode) {
        this.secCode = secCode;
    }
}
