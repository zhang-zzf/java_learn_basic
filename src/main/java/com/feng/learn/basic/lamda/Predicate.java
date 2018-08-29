package com.feng.learn.basic.lamda;

public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> negate() {
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return !Predicate.this.test(t);
            }
        };
    }

    default Predicate<T> and(Predicate<? super T> other) {
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return Predicate.this.test(t) && other.test(t);
            }
        };
    }

    default Predicate<T> or(Predicate<? super T> other) {
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return Predicate.this.test(t) || other.test(t);
            }
        };
    }
}
