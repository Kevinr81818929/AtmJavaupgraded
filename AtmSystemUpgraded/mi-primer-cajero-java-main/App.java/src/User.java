public abstract class User {
    protected String nombre;
    protected String pin;
    protected double balance;

    public User(String nombre, String pin, double balance) {
        this.nombre = nombre;
        this.pin = pin;
        this.balance = balance;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean verificarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public void cambiarPin(String nuevoPin) {
        this.pin = nuevoPin;
    }

    public abstract String toFile();
}
