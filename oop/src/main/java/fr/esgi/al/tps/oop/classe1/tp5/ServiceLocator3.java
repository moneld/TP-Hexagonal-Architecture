package fr.esgi.al.tps.oop.classe1.tp5;

import java.util.Map;
import java.util.Optional;

final class ServiceLocator3 {
    private static final Map<Class<? extends Object>, Object> _registry = Map.of(
            MyService1.class, new MyService1(),
            MyService2.class, new MyService2()
    );

    private ServiceLocator3() {
        throw new AssertionError();
    }

    public static <T> Optional<T> get(Class<T> classz) {
        return Optional.ofNullable((T) _registry.get(classz));
    }
}
