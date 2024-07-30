package com.softlond.PrimerTaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class PrimerTallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerTallerApplication.class, args);
		puntos();
	}

	private static void puntos() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Opciones:" +
					"\n1) Mono Transformation" +
					"\n2) Complex Flux Operations" +
					"\n3) Combining Fluxes" +
					"\n4) Advanced Filtering" +
					"\n5) Reducing with a Condition" +
					"\n6) Merging and Distinct Values" +
					"\n7) Flattening Streams" +
					"\n8) Concatenating Fluxes with a Delay" +
					"\n9) Buffering and Transformation" +
					"\n10) Conditional Skipping" +
					"\n11) Combining Data from Different Sources" +
					"\n12) Handling Errors with Fallback Values" +
					"\n13) Windowing and Aggregation" +
					"\n14) Dynamic Data Transformation" +
					"\n15) Combining and Filtering Complex Streams");

			opcion = sc.nextInt();
			switch (opcion) {
				case 0 -> System.out.println("Fin");
				case 1 -> {
					System.out.println("Ingrese la ciudad");
					Ejercicios.primerPunto(sc.next());
				}
				case 2 -> Ejercicios.segundoPunto();
				case 3 -> Ejercicios.tercerPunto();
				case 4 -> Ejercicios.cuartoPunto(1, 20);
				case 5 -> Ejercicios.quintoPunto(1, 10, 5);
				case 6 -> Ejercicios.sextoPunto();
				case 7 -> Ejercicios.septimoPunto();
				case 8 -> Ejercicios.octavoPunto();
				case 9 -> Ejercicios.novenoPunto();
				case 10 -> Ejercicios.decimoPunto(1, 10, 5);
				case 11 -> Ejercicios.onceavoPunto();
				case 12 -> {
					System.out.println("Ingrese el valor del divisor");
					Ejercicios.doceavoPunto(1, 10, sc.nextInt());
				}
				case 13 -> Ejercicios.treceavoPunto(1, 10, 5);
				case 14 -> Ejercicios.catorceavoPunto();
				case 15 -> Ejercicios.quinceavoPunto();
				default -> System.out.println("Opción no válida.");
			}

			System.out.println("Presione cualquier tecla para continuar");
			sc.next();
		} while (opcion != 0);
	}
}
