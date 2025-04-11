public class UserData extends User {

    public UserData(String nombre, String pin, double balance) {
        super(nombre, pin, balance);
    }

    @Override
    public String toFile() {
        return nombre + "," + pin + "," + balance;
    }

    public static UserData fromFile(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) throw new IllegalArgumentException("Formato inválido");
        String nombre = partes[0];
        String pin = partes[1];
        double balance = Double.parseDouble(partes[2]);
        return new UserData(nombre, pin, balance);
    }
}
