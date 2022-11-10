package com.motionadsltd.motionadsandroidnahidsoft.Models;

public class QuizModel {
    private String tittle,opOne,opTwo,opThree,opFour,result;
    int id;

    public QuizModel(String tittle, String opOne, String opTwo, String opThree, String opFour, String result, int id) {
        this.tittle = tittle;
        this.opOne = opOne;
        this.opTwo = opTwo;
        this.opThree = opThree;
        this.opFour = opFour;
        this.result = result;
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getOpOne() {
        return opOne;
    }

    public void setOpOne(String opOne) {
        this.opOne = opOne;
    }

    public String getOpTwo() {
        return opTwo;
    }

    public void setOpTwo(String opTwo) {
        this.opTwo = opTwo;
    }

    public String getOpThree() {
        return opThree;
    }

    public void setOpThree(String opThree) {
        this.opThree = opThree;
    }

    public String getOpFour() {
        return opFour;
    }

    public void setOpFour(String opFour) {
        this.opFour = opFour;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
