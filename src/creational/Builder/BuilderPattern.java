package creational.Builder;


//The Client must associate one of the builder objects with
//        the director. Usually, it’s done just once, via parameters of
//        the director’s constructor. Then the director uses that builder
//        object for all further construction. However, there’s an alternative approach for when the client passes the builder object to
//        the production method of the director. In this case, you can use
//        a different builder each time you produce something with the
//        director.
public class BuilderPattern {

    // The client code creates a builder object, passes it to the
    // director and then initiates the construction process. The end
    // result is retrieved from the builder object.
    public static void main(String[] args) {

        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getProduct();

        ManualCarBuilder  builder2 = new ManualCarBuilder();
        director.constructSportsCar(builder2);

        Manual manual = builder2.getProduct();
    }
}

// Builder Interface declares product construction steps that are common to all types of builder.
interface Builder{

    public void reset();
    public void setSeat(int seat);
    public void setEngine(Engine engine);
    public void setTripComputer();

    public void setGPS();
}

// Concrete Builder provide different implementations of the construction steps
// concrete Builders may produce products that don't follow the common interface.
class CarBuilder implements Builder {
    private Car car;
    public void reset(){
        this.car = new Car();
    }
    public void setSeat(int seat){
        System.out.println("setting the seat in car");
       //  this.car.seat = seat
    }
    public void setEngine(Engine engine){
        System.out.println("setting the engine in car");
        // this.car.engine = engine
    };
    public void setTripComputer(){
        System.out.println("setting the computer in car");
    }

    public void setGPS(){
        System.out.println("setting the gps in car");
    }

    public Car getProduct(){
        return this.car;
    }
}
class ManualCarBuilder implements Builder {
    private Manual manual;
    public void reset(){
        this.manual = new Manual();
    }
    public void setSeat(int seat){
        System.out.println("setting the seat in manual");
        //  this.manual.seat = seat
    }
    public void setEngine(Engine engine){
        System.out.println("setting the engine in manual");
        // this.manual.engine = engine
    };
    public void setTripComputer(){
        System.out.println("setting the computer in manual");

    }

    public void setGPS(){
        System.out.println("setting the gps in manual");

    }
    public Manual getProduct(){
        return this.manual;
    }
}


// The Products are resulting objects, Products constructed by different builders
// don't have to belong to the same class hierarchy or interface
class Car {

}
class Manual
{}


// Director class defines the order in which to call construction steps,
// so you can create and reuse specific configuration of products.

class Director {
    private Builder builder;

    public void setBuilder(Builder b){
        this.builder = b;
    }

    // The director can construct several product variations
    // using the same building steps.
    public void constructSportsCar(Builder builder){
        builder.reset();
        builder.setSeat(2);
        builder.setEngine(new Engine());
        builder.setTripComputer();
        builder.setGPS();
    }
    public void constructSUV(Builder builder){
        /// build the car here

    }
}

class Engine{}