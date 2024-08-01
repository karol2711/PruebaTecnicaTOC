package pruebaTecnicaToc;

import java.util.Scanner;

public class registroUsuario {

	public static void main(String[] args) {

		String confirmacion;

		// Se utilizara el bucle do while para que el usuario pueda ingresar los datos
		// una vez
		// y se pueda validar que la informacion es correcta de lo contrario entrara en
		// la condicion y preguntara la informacion nuevamente

		do {
			// me permite leer de consola
			Scanner lectura = new Scanner(System.in);

			// Pide al usuario su nombre y lo guarda en la respectiva variable
			System.out.println("Ingrese su nombre: ");
			String nombre = lectura.next();

			// Pide al usuario su apellido y lo guarda en la respectiva variable
			System.out.println("Ingrese su apellido: ");
			String apellidos = lectura.next();

			// Pide al usuario su contraseña y lo guarda en la respectiva variable
			System.out.println("Ingrese su contraseña: ");
			String contraseña = lectura.next();

			// Pide al usuario su contraseña y lo guarda en la respectiva variable
			System.out.println("Ingrese nuevamente la contraseña: ");
			String validacioncontraseña = lectura.next();

			do {

				if (contraseña != validacioncontraseña) {

					System.out.println("las contraseñas no coinciden");
					System.out.println("ingrese la contraseña nuevamente");
					contraseña = lectura.next();
					System.out.println("confime la contraseña");
					validacioncontraseña = lectura.next();
				}
				Boolean validarLonguitud = validarLonguitud(contraseña);

				if (validarLonguitud == false) {

					System.out.println("la contraseña debe contener mas de 12 caracteres");
					System.out.println("ingrese la contraseña nuevamente");
					contraseña = lectura.next();
				}

				Boolean validarMayuscula = validarMayuscula(contraseña);

				if (validarMayuscula == false) {

					System.out.println("la contraseña debe contener almenos una mayuscula");
					System.out.println("ingrese la contraseña nuevamente");
					contraseña = lectura.next();
				}

				Boolean validarNumero = validarNumero(contraseña);
				if (validarNumero == false) {

					System.out.println("la contraseña debe contener almenos un numero");
					System.out.println("ingrese la contraseña nuevamente");
					contraseña = lectura.next();
				}

				if (contraseña.equals(nombre) || contraseña.equals(apellidos)) {

					System.out.println("la contraseña debe ser diferente a su nombre o apellido");
					System.out.println("ingrese la contraseña nuevamente");
					contraseña = lectura.next();
				}

			} while (validarLonguitud(contraseña) == false || validarMayuscula(contraseña) == false
					|| validarNumero(validacioncontraseña) == false);
			// Pide al usuario su correo electronico y lo guarda en la respectiva variable
			System.out.println("Ingrese su Correo electronico: ");
			String correo = lectura.next();

			do {

				boolean validarCorreo = validarArroaYPunto(correo);
				if (validarCorreo == false) {

					System.out.println("el correo debe contener @ y . ");
					System.out.println("ingrese el correo nuevamente");
					correo = lectura.next();
				}

				boolean validarComCoEs = validarComCoEs(correo);
				if (validarCorreo == false) {

					System.out.println("el correo debe contener .com o .co o .es ");
					System.out.println("ingrese el correo nuevamente");
					correo = lectura.next();
				}

			} while (validarArroaYPunto(correo) == false || validarComCoEs(correo) == false);

			// Bloque en el que se valida que la informacion ingresada por el cliente es
			// correcta
			System.out.println("Informacion Ingresada: ");

			System.out.println(nombre);
			System.out.println(apellidos);
			System.out.println(contraseña);
			System.out.println(correo);

			System.out.println(
					"¿La informacion aqui mostrada es correcta? Ingrese S para si y N para Volver a llenar el registro");
			confirmacion = lectura.next();

			do {

				Boolean validarConfirmacion = validarConfirmacion(confirmacion);
				if (validarConfirmacion == false) {

					System.out.println(
							"Ingrese unicamente N o S (S para confirmar o N para llenar el formulario nuevamente");
					confirmacion = lectura.next();
				}

			} while (validarConfirmacion(confirmacion) == false);

		} while (confirmacion.equals("N"));

	}

	// metodo para validar que la letra para confirmar el formulario si sea S o N
	public static boolean validarConfirmacion(String confirmacion) {

		if (confirmacion.equals("S") || confirmacion.equals("N")) {

			return true;

		} else {

			return false;
		}

	}

	public static boolean validarLonguitud(String contraseña) {

		if (contraseña.length() >= 12) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean validarMayuscula(String contraseña) {

		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isUpperCase(contraseña.charAt(i))) {
				return true;
			}

		}
		return false;
	}

	public static boolean validarNumero(String contraseña) {

		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isDigit(contraseña.charAt(i))) {
				return true;
			}

		}
		return false;
	}

	public static boolean validarArroaYPunto(String correo) {

		for (int i = 0; i < correo.length(); i++) {
			if (correo.contains("@") && correo.contains(".")) {
				return true;
			}

		}
		return false;
	}

	public static boolean validarComCoEs(String correo) {

		for (int i = 0; i < correo.length(); i++) {
			if (correo.contains("com") || correo.contains("co") || correo.contains("es")) {
				return true;
			}

		}
		return false;
	}

}
