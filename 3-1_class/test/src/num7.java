interface RemoteControl{
    void turnOn();
    void turnOff();

}

public class num7 {
    public static void main(String[] args) {


        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Turned On");
            }

            @Override
            public void turnOff() {
                System.out.println("Turned Off");
            }
        };
        rc.turnOn();
        rc.turnOff();
    }
}
