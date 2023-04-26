/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionadorHora;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author JUAN_DAVID
 */
public class Horario {
    //private static String formato="yyyy/MM/dd HH:mm:ss";
    //private static DateTimeFormatter formato_hora=DateTimeFormatter.ofPattern(formato);
    public static String setFechaHora(){
        String formato="yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formato_hora=DateTimeFormatter.ofPattern(formato);
        LocalDateTime hora=LocalDateTime.now();
        return formato_hora.format(hora);
    }
    public static String setFecha(){
        String formato="dd/MM/yyyy";
        DateTimeFormatter formato_hora=DateTimeFormatter.ofPattern(formato);
        LocalDateTime hora=LocalDateTime.now();
        return formato_hora.format(hora);
    }
    
    public static String DatetoSring(Date date){
        String formato="yyyy/MM/dd";
        SimpleDateFormat formato_fecha=new SimpleDateFormat(formato);
        return formato_fecha.format(date);
    }
    
    public static Date StringtoDate(String fecha){
        String formato="yyyy/MM/dd";
        Date date=null;
        try{
            date=new SimpleDateFormat(formato).parse(fecha);
        }catch(ParseException ex){
            ex.getMessage();
        }
        return date;
    }
    /*public static void main(String []args){
        System.out.println(setFechaHora());
    }*/
    /*public static String calcular_tiempotrans(String fecha_inicio, String fecha_fin){
        LocalDateTime inicio=LocalDateTime.of(0, 0, 0, 0, 0, 0);
    }*/
}
