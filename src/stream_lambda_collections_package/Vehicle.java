package stream_lambda_collections_package;

public interface Vehicle {
    default void Print()
    {
        System.out.println("I am a Vehicle");
    }
}
