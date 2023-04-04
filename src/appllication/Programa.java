package appllication;

import model.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Numero do quarto: ");
        int numero = sc.nextInt();
        System.out.println("Data do Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Data do Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro ao reservar: Data do Check-out anterior a data do Check-in");
        }
        else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira uma data atualizada da reserva");
            System.out.println("Data do Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date agora = new Date();

            if (checkIn.before(agora) || checkOut.before(agora)) {
                System.out.println("Erro ao reservar: Data do Check-in maior que a do Check-out");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Erro ao reservar: Data do Check-out anterior a data do Check-in");
            }
            else {
                reserva.datasAtualizadas(checkIn, checkOut);
                System.out.println("Reserva: " + reserva);
            }
        }
    }
}
