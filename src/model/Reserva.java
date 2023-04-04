package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class Reserva {

    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date checkOut;


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }


    public long duracao(){
        long diff = checkIn.getTime() - checkOut.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
    }

    public String datasAtualizadas(Date checkIn, Date checkOut) {

        Date agora = new Date();
        if (checkIn.before(agora) || checkOut.before(agora)) {
            return "Erro ao reservar: Data do Check-in maior que a do Check-out";
        }
        if (!checkOut.after(checkIn)) {
            return "Erro ao reservar: Data do Check-out anterior a data do Check-in";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return "Quarto "
                + numeroDoQuarto
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duracao()
                + " noites";
    }



}
