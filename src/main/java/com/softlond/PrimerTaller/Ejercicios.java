package com.softlond.PrimerTaller;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ejercicios {

    public static void primerPunto(String cityInput) {
        System.out.println("Crea un Mono que contenga el nombre de una ciudad. Utiliza el operador map\n" +
                "para convertir el nombre a mayúsculas y luego suscríbete al Mono resultante\n" +
                "para imprimir el nombre transformado en la consola.");
        Mono<String> city = Mono.just(cityInput);

        city.map(String::toUpperCase)
            .subscribe(System.out::println);
    }

    public static void segundoPunto() {
        System.out.println("Crea un Flux de números del 1 al 20. Utiliza una combinación de los operadores\n" +
                "filter y map para obtener solo los números impares y multiplicarlos por 3.\n" +
                "Suscríbete al Flux resultante e imprime los valores en la consola.");
        Flux<Integer> numeros = Flux.range(1, 20);
        numeros.filter(number -> number % 2 != 0)
                .map(number -> number * 3)
                .subscribe(System.out::println);
    }

    public static void tercerPunto() {

        System.out.println("Crea dos Flux de números del 1 al 5 y del 6 al 10.\n" +
                "Utiliza el operador zip para combinarlos en pares (por ejemplo, (1,6), (2,7), etc.).\n" +
                "Luego, utiliza map para sumar los elementos de cada par.\n" +
                "Suscríbete al Flux resultante e imprime las sumas en la consola.");
        Flux<Integer> primeros = Flux.range(1, 5);
        Flux<Integer> segundos = Flux.range(6, 10);

        primeros.zipWith(segundos)
                .map(numbers -> numbers.getT1() + numbers.getT2())
                .subscribe(System.out::println);
    }

    public static void cuartoPunto(Integer min, Integer max) {
        System.out.println("Crea un Flux de números del 1 al 20. Utiliza el operador filter para obtener\n" +
                "solo los números que sean múltiplos de 3 y 5.\n" +
                "Suscríbete al Flux resultante e imprime los valores en la consola.");
       Flux<Integer> numbers = Flux.range(min, max);
       numbers.filter(number -> number % 3 == 0 && number % 5 == 0)
               .subscribe(System.out::println);
    }

    public static void quintoPunto(Integer min, Integer max, Integer range) {

        System.out.println("Crea un Flux de números del 1 al 10. Utiliza el operador reduce para obtener\n" +
                "la suma de los números que sean mayores a 5. Suscríbete al Mono resultante e\n" +
                "imprime la suma en la consola.");
        Flux<Integer> numbers = Flux.range(min, max);

        numbers
                .filter(number -> number > range)
                .reduce(Integer::sum)
                .subscribe(result -> System.out.println("Suma: " + result));

    }

    public static void sextoPunto() {
        System.out.println("Crea dos Flux de números con algunos valores repetidos (por ejemplo,\n" +
                "Flux.just(1, 2, 3, 4, 5) y Flux.just(3, 4, 5, 6, 7) ).\n" +
                "Utiliza el operador merge para combinarlos y luego distinct para obtener los valores únicos.\n" +
                "Suscríbete al Flux resultante e imprime los valores en la consola.");
        Flux<Integer> primero = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> segundo = Flux.just(3, 4, 5, 6, 7);
        primero.mergeWith(segundo)
                .distinct()
                .subscribe(System.out::println);
    }

    public static void septimoPunto() {
        System.out.println("Crea un Flux de listas de números (por ejemplo, Flux.just(Arrays.asList(1, 2),\n" +
                "Arrays.asList(3, 4), Arrays.asList(5, 6)) ). Utiliza el operador flatMap para\n" +
                "convertir el Flux de listas en un Flux de números. Suscríbete al Flux resultante\n" +
                "e imprime los números en la consola.");
        Flux<List<Integer>> primero = Flux.just(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        primero.flatMap(Flux::fromIterable)
                .subscribe(System.out::println);
    }

    public static void octavoPunto() {
        System.out.println("Crea dos Flux de números del 1 al 3 y del 4 al 6.\n" +
                "Utiliza el operador concat para concatenarlos y añade un retraso de 1 segundo\n" +
                "entre cada emisión utilizando delayElements(Duration.ofSeconds(1)).\n" +
                "Suscríbete al Flux resultante e imprime los valores en la consola.");
        Flux<Integer> primero = Flux.just(1, 2, 3);
        Flux<Integer> segundo = Flux.just(4, 5, 6);
        primero.concatWith(segundo)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);
    }


    public static void novenoPunto() {
        System.out.println("Crea un Flux de números del 1 al 10. Utiliza el operador buffer para agrupar\n" +
                "los números en listas de tamaño 3. Luego, utiliza flatMap para transformar\n" +
                "cada lista en un Flux que emita el producto de los números en cada lista.\n" +
                "Suscríbete al Flux resultante e imprime los productos en la consola.");
            Flux<Integer> numbers = Flux.range(1, 10);
            numbers.buffer(3)
                    .flatMap(list -> Flux.just(list.stream().reduce(1, (a,b) -> a*b)))
                    .subscribe(System.out::println);
    }

    public static void decimoPunto(Integer min, Integer max, Integer range) {
        System.out.println("Crea un Flux de números del 1 al 10. Utiliza el operador skipWhile para omitir los \n" +
                "números hasta que encuentres uno mayor a 5. Suscríbete al Flux resultante e \n" +
                "imprime los números en la consola.");
        Flux<Integer> numeros = Flux.range(min, max);
        numeros.skipWhile(number -> number <= range)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);
    }

    public static void onceavoPunto() {
        System.out.println("Imagina que tienes dos fuentes de datos representadas como Flux , \n" +
                "uno que emite nombres de productos y otro que emite precios de productos. \n" +
                "Utiliza el operador zip para combinar ambos Flux de manera que cada producto \n" +
                "tenga su precio correspondiente. Luego, utiliza map para crear un objeto Producto \n" +
                "con el nombre y precio combinados. Suscríbete al Flux resultante e imprime los \n" +
                "objetos Producto en la consola.");
        Flux<String> nombres = Flux.just("Manzana", "Pera", "Naranja");
        Flux<Double> precios = Flux.just(800.0, 950.0, 500.0);

        nombres.zipWith(precios)
                .map(product -> {
                    return new Producto(product.getT1(), product.getT2());
                })
                .subscribe(response -> System.out.println(response.toString()));
    }

    public static void doceavoPunto(Integer min, Integer max, Integer divisor) {
        Flux<Integer> numeros = Flux.range(min, max);
        numeros.map(valor -> valor / divisor)
                .onErrorResume(error -> Flux.just(-1))
                .subscribe(System.out::println);
    }

    public static void treceavoPunto(Integer min, Integer max, Integer windows) {
        System.out.println("Crea un Flux de números del 1 al 20. Utiliza el operador window" +
                "\npara dividir el Flux en ventanas de tamaño 5. Luego, usa flatMap para " +
                "\nprocesar cada ventana y calcula la suma de los números en cada ventana " +
                "\nutilizando el operador reduce . Suscríbete al Flux resultante e imprime " +
                "\nlas sumas de cada ventana en la consola.");
        Flux<Integer> numeros = Flux.range(min, max);

        numeros.window(windows)
                .flatMap(window -> window.reduce(0, Integer::sum))// Se reduce el valor haciendo una suma de los elementos del flux.
                .subscribe(System.out::println);
    }


    public static  void catorceavoPunto() {
        Flux<Persona> personas = Flux.just(
          new Persona("Agustín Hernández", 23),
          new Persona("Andrés Cépeda", 51),
          new Persona("Juan Subira", 58),
          new Persona("Gustavo Cordera", 62),
          new Persona("Virgil Van Dijk", 30)
        );

        personas.flatMap(
                    persona -> Mono.just(persona)
                                    .delayElement(Duration.ofSeconds(persona.getEdad() / 10))
                )
                .subscribe(System.out::println);
    }

    public static void quinceavoPunto() {
        System.out.println("Crea dos Flux de números del 1 al 5 y del 6 al 10. " +
                "\nUtiliza el operador merge para combinarlos en un solo Flux . " +
                "\nLuego, aplica una secuencia de operadores filter , map , y distinct " +
                "\npara obtener los números que son pares, multiplicarlos por 10, " +
                "\ny eliminar los duplicados. Finalmente, utiliza el operador collectList " +
                "\npara recopilar todos los números en una lista y suscríbete al Mono " +
                "\nresultante para imprimir la lista en la consola.");
        Flux<Integer> primero = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> segundo = Flux.just(6, 7, 8, 9, 10);

        primero.mergeWith(segundo)
                .filter(number -> number % 2 == 0)
                .map(number -> number * 10)
                .distinct()
                .collectList()
                .subscribe(response -> System.out.println(response.toString()));
    }
}
