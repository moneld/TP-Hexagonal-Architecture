package fr.esgi.al.tps.oop.classe1.tp4;

final class DefaultFormatter implements Formatter {
    @Override
    public String format(String message) {
        return String.format("[LOG] - %s", message);
    }
}
