package creational;

// suppose you want to make generic button that can work on both mobile and on the web

interface Button {
   public void render();
   public void onClick(Object o);
}

class WebButton implements Button {
    /*
        do web button staff here
    */
    @Override
    public void render() {
        System.out.println("render button in web");
    }
    @Override
    public void onClick(Object o){
        System.out.println("Clicking in web: "+o);
    }
}

class MobileButton implements Button {
    /*
        do web button staff here
    */
    @Override
    public void render() {
        System.out.println("render button in mobile");
    }
    @Override
    public void onClick(Object o){
        System.out.println("Clicking in mobile: "+o);
    }
}

abstract class Dialog{

    abstract Button createButton();

    public  void render(){
        Button submitButton = createButton();

        submitButton.onClick("navigate to home");
        submitButton.render();
    }
}

class WebDialog extends Dialog {

    @Override
    public Button createButton(){
        return new WebButton();
    }
}

class MobileDialog extends Dialog {

    @Override
    public Button createButton(){
        return new MobileButton();
    }
}
enum Platform {
    MOBILE,
    WEB
}
public class Factory {

    public  static void main(String[] args) throws Exception {
        Platform platform = Platform.WEB;

        Dialog dialog;

        if (Platform.WEB.equals(platform)){
            dialog = new WebDialog();
        }else if( Platform.MOBILE.equals(platform)){
            dialog = new MobileDialog();
        }else {
            throw new Exception("unhandled platform");
        }

        dialog.render();
    }
}
