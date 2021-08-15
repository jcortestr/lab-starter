package reto5app.view;

import java.sql.SQLException;
import java.util.ArrayList;
import reto5app.Controller.ControllerRequerimientos;
import reto5app.model.vo.Requerimiento_1;
import reto5app.model.vo.Requerimiento_2;
import reto5app.model.vo.Requerimiento_3;


public class ViewRequerimientos {
    public static final ControllerRequerimientos controlador = new ControllerRequerimientos();

    public static void requerimiento1() {
        try {
            ArrayList<Requerimiento_1> listarRequerimiento_1;

            listarRequerimiento_1 = controlador.consultaRequerimiento1();

            for (Requerimiento_1 rq : listarRequerimiento_1) {
                System.out.println(rq.getFechaCompra() + " " + rq.getCodCompra() + " " + rq.getNombreProveedor() + " "
                        + rq.getPagado());
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static void requerimiento2() {
        try {
            ArrayList<Requerimiento_2> listaRequerimiento_2;

            listaRequerimiento_2 = controlador.consultaRequerimiento2();

            for (Requerimiento_2 r : listaRequerimiento_2) {
                System.out.println(
                        r.getFecIni() + " "
                        + r.getNombreCiudad() + " "
                        + r.getNomConstructora() + " "
                        + r.getNombreLider() + " "
                        + r.getCodigoTipo() + " "
                        + r.getEstrato()
                );
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3() {
        try {
            ArrayList<Requerimiento_3> listaRequerimiento_3;

            listaRequerimiento_3 = controlador.consultaRequerimiento3();

            for (Requerimiento_3 r : listaRequerimiento_3) {
                System.out.println(
                        r.getAbrev()
                );
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}