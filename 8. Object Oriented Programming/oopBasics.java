public class oopBasics {
    public static void main(String[] args) {
        PEN p1 = new PEN();
        p1.color = "red";
        p1.tip = 5;
        System.out.println("Pen Color = " + p1.color + " Tip = " + p1.tip);
        p1.setColor("blue");
        p1.setTip(10);
        System.out.println("Pen Color = " + p1.color + " Tip = " + p1.tip);

        Bank myAcc = new Bank();
        myAcc.userName = "VishavGupta";
        //myAcc.password = "abcdefgh"; Error : The field Bank.password is not visibleJava(33554503)
        myAcc.setPass("abcdefgh");

        PEN1 p2 = new PEN1();
        p2.setColor("Yellow");
        p2.setTip(5);
        System.out.println(p2.getColor());
        System.out.println(p2.getTip());
    }
}

class PEN {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

//Access Modifiers
class Bank {
    public String userName;
    private String password;
    void setPass(String newPass) {
        password = newPass;
    }
}

//Getters & Setters
class PEN1 {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}