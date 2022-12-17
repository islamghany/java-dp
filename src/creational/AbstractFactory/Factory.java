package creational.AbstractFactory;



enum Platform {
    MAC,
    WINDOWS
}
public class Factory {

    public static void main(String[] args) throws Exception {
       Platform platform = Platform.MAC;

        UIFactory elements;

        if (Platform.MAC.equals(platform)) {
            elements = new MacUIFactory();
        } else if (Platform.WINDOWS.equals(platform)) {
            elements = new WindowUIFactory();
        } else {
            throw new Exception("unhandled platform");
        }

        Button button = elements.createButton();
        Checkbox checkbox = elements.createCheckbox();

        button.render();
        button.onClick("clicked from the ui interface");

        checkbox.render();
        checkbox.onClick("clicked from the ui interface");
    }
}


// Abstract Products: declare interfaces for a set of distinct but
// related products which make up a product family, i,g Button, Checkbox.
interface Button{
    public void render();

    public void onClick(Object o);
}

interface Checkbox{
    public void render();

    public void onClick(Object event);
}

// Concrete Products : are various implementations of the abstract Products,
// grouped by variants every abstract product (Button,Checkbox) must be implemented
// in all given variants (WindowsButton, WindowsCheckbox, MacButton, MacCheckbox).

class  WindowsButton implements Button{

    @Override
    public void render(){
        System.out.println("Render Button in windows");
    }
    @Override
    public void onClick(Object event){
        System.out.println("Button Clicked in windows: "+event);
    }
}
class  WindowsCheckbox implements Checkbox{

    @Override
    public void render(){
        System.out.println("Render Checkbox in windows");
    }
    @Override
    public void onClick(Object event){
        System.out.println("Checkbox Clicked in windows: "+event);
    }
}

class  MacButton implements Button{

    @Override
    public void render(){
        System.out.println("Render Button in mac");
    }
    @Override
    public void onClick(Object event){
        System.out.println("Button Clicked in mac: "+event);
    }
}
class  MacCheckbox implements Checkbox{

    @Override
    public void render(){
        System.out.println("Render Checkbox in mac");
    }
    @Override
    public void onClick(Object event){
        System.out.println("Checkbox Clicked in mac: "+event);
    }
}


// Abstract Factory: interface declares a set of methods for creating each of the abstract products

interface UIFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}


// Concrete Factories: implement creation methods of the abstract factory, each concrete factory represent
// one variant, such as MacUIFactor and WindowUIFactory.

class WindowUIFactory implements UIFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox(){
        return new WindowsCheckbox();
    }
}

class MacUIFactory implements UIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}


// Although concrete factories instantiate concrete products, signatures of their creation methods must return corresponding
// abstract products. This way the client code that uses a factory doesn’t get coupled to the specific variant of the product
// it gets from a factory. The Client can work with any concrete factory/product variant, as long as it communicates with their
// objects via abstract interfaces.