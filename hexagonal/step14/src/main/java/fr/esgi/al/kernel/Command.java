package fr.esgi.al.kernel;

public interface Command<C> {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
