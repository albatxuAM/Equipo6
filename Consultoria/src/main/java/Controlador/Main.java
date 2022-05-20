package Controlador;

import Modelo.Factory.DatosJornadasXML;
import Modelo.Factory.ReadXmlDomParser;
import Modelo.UML.EntrenadoresEntity;
import Vista.*;
import javax.swing.*;
import javax.swing.border.Border;

import Modelo.BD.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static TemporadasDAO temporada_dao;
    private static JornadasDAO jornada_dao;
    private static PartidosDAO partido_dao;
    private static JugadoresDAO jugador_dao;
    private static EntrenadoresDAO entrenador_dao;
    private static AsistentesDAO asistente_dao;
    private static EquiposDAO equipo_dao;

    private static UsuariosDAO usuario_dao;

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static JFrame VLogin, VRegistrar, VAdmin, VCarga, VUsuario;

    private static ReadXmlDomParser xmlParser;

    public static void main(String[] args) {
        try {
            System.out.println("CONSULTORIA E-SPORTS ");

            //VentanaCarga();

            //generarDAO();

            xmlParser = new ReadXmlDomParser();
            xmlParser.checkXML();

            //VentanaLogin();
            //VentanaRegistrar("test@gmail.com");
            VentanaUsuario(true);
            //VentanaAdmin();

        } catch (Exception e) {
            System.out.println("Problemas " + e.getMessage());
        }

    }

    private static void generarDAO() {
        temporada_dao = new TemporadasDAO();
        jornada_dao = new JornadasDAO();
        partido_dao = new PartidosDAO();
        jugador_dao  = new JugadoresDAO();
        entrenador_dao = new EntrenadoresDAO();
        asistente_dao = new AsistentesDAO();
        equipo_dao = new EquiposDAO();
        usuario_dao = new UsuariosDAO();
    }

    /******************** TEST *************************/
    public static void GenerarTemporadaTest() throws Exception {
        temporada_dao.crearTemporada();
    }
    private static void GenerarJornadasTest() throws Exception {
        jornada_dao.crearJornadas(01,  LocalDate.of(2022, 04, 11));
    }

    private static void GenerarPartidosTest() throws Exception {
        LocalTime now = LocalTime.now();
        partido_dao.crearPartido(now, 01, "Real Horses", "Gasteiz-Goya");
    }

    private static void ResultadosPartidosTest() throws Exception {
        partido_dao.resultadosPartido(01, "3-2");
    }

    private static void GenerarJugadorTest() throws Exception {
        jugador_dao.crearJugador("The_Core", "TOP", "DARCY", "Wuenz",
                LocalDate.of(2001, 05, 14), "Taiwanesa", 20000.0 );
    }

    private static void GenerarEntrenadorTest() throws Exception {
        entrenador_dao.crearEntrenador("Slayo_15", "Andrea", "Birel",
                LocalDate.of(1997, 05, 14), "Espaniola", 1500.0 );
    }

    private static void GenerarAsistenteTest() throws Exception {
        asistente_dao.crearAsistente("Destepo", "Juan", "Antonio",
                LocalDate.of(1997, 05, 14), "Alemana", 1500.0,
                "Slayo_15" );
    }

    private static void GenerarEquiposTest() throws Exception {
        equipo_dao.crearEquipos( "Gasteiz-Goya", LocalDate.of(2021, 01, 23),
                "Vitoria", "Goya", "Eneko Alonso");
    }

    private static void ContratoJugadorTest() throws Exception {
        equipo_dao.contratoJugador(06, 01,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoEntrenadorTest() throws Exception {
        equipo_dao.contratoJugador(12, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    private static void ContratoAsistenteTest() throws Exception {
        equipo_dao.contratoJugador(10, 03,  LocalDate.of(2021, 04, 07),
                LocalDate.of(2023, 06, 30));
    }

    /******************** fin TEST *************************/
    public static void VentanaAdmin() {
        VAdmin = new JFrame("VentanaAdmin");
        VAdmin.setContentPane(new VAdmin().getPanelPrincipal());
        VAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VAdmin.pack();
        VAdmin.setVisible(true);
    }

    public static void CrearCalendario() {
        String[] botones = {"Si", "No"};
        int ventana = JOptionPane.showOptionDialog(null,
                "¿Estás seguro de crear el calendario? No se podrá modificar ni personas ni equipos",
                "Se va a crear el calendario de esta temporada",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        if (ventana == 0){
            System.out.println("Si");}
        else
        if (ventana == 1){
            System.out.println("No");
        }
    }

    public static void VentanaLogin() {
        VLogin = new JFrame("Inicio de sesion");
        VLogin.setContentPane(new VLogin().pPrincipal);
        VLogin.setLocationRelativeTo(null);
        VLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VLogin.pack();
        VLogin.setVisible(true);
    }

    public static void VentanaRegistrar(String email) {
        VRegistrar = new JFrame("VRegistrar");
        VRegistrar.setContentPane(new VRegistrar(email).getpPrincipal());
        VRegistrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VRegistrar.pack();
        VRegistrar.setVisible(true);
    }

    public static void VentanaCarga() {
        VCarga = new JFrame("VCarga");
        VCarga.setContentPane(new VCarga().getPanel1());
        VCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VCarga.setLocationRelativeTo(null);
        VCarga.pack();
        VCarga.setVisible(true);
    }

    public static void VentanaUsuario(boolean admin) {
        //VCarga.dispose();

        VUsuario = new JFrame("VUsuario");
        VUsuario.setContentPane(new VUsuario(admin).getpPrincipal());
        VUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VUsuario.setLocationRelativeTo(null);
        VUsuario.pack();
        VUsuario.setVisible(true);

    }

    public static void getDatosClasificacion(){
        //ClasificacionDAO ?:
    }
    public static void getDatosJornadaFinal(){
        //JornadaDAO where cod_jornada = max(cod_jornada):

    }

    public static void registrarJugador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                        String nacionalidad, String nickname, String rol) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        jugador_dao.crearJugador(nickname, rol, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    public static void registrarEntrenador(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                           String nacionalidad, String nickname) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        entrenador_dao.crearEntrenador(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo));
    }

    public static void registrarAsistente(String nombre, String apellido, String sueldo, String fechaNacimiento,
                                          String nacionalidad, String nickname, String entrenador) throws Exception{
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatoFecha);
        asistente_dao.crearAsistente(nickname, nombre, apellido, fecha, nacionalidad, Double.parseDouble(sueldo), entrenador);
    }

    public static ArrayList<String> getEntrenadores() throws Exception {
        List<EntrenadoresEntity> entrenadores = entrenador_dao.consultarEntrenadores();
        ArrayList<String> nombres = new ArrayList<>(entrenadores.size());
        for (EntrenadoresEntity entrenador : entrenadores) {
             nombres.add(entrenador.getPersonasByCodEntrenador().getNickname());
        }
        return nombres;
    }

    public static void registrarEquipo(String nombre, String creacion, String ciudad, String sponsor, String duenio) throws Exception {
        LocalDate fecha = LocalDate.parse(creacion, formatoFecha);
        equipo_dao.crearEquipos(nombre, fecha, ciudad, sponsor, duenio);
    }

    public static void login(String email, char[] password) {
        int rol = 0;
        try {
            rol = usuario_dao.login(email, password);
            switch (rol)
            {
                case 01:
                    //admin
                    System.out.println("admin");
                    VLogin.dispose();
                    VentanaAdmin();
                    break;
                case 02:
                    //usuario
                    System.out.println("usuario");
                    VLogin.dispose();
                    VentanaUsuario(false);
                    break;
            }
        } catch (Exception e) {
            if(e.getCause().getCause().getMessage().contains("ORA-20054: Err. email o contrasena incorrecta"))
            {
                VLogin.dispose();
                VentanaRegistrar(email);
            }
        }
    }

    public static void registrarUsuario(String nombre, String passwrd, String email, String nacimiento) throws Exception {
        LocalDate fecha = LocalDate.parse(nacimiento, formatoFecha);
        usuario_dao.crearUsuario(nombre, fecha, passwrd, email);

        VRegistrar.dispose();
        Main.VentanaUsuario(false);
    }

    public static void PanelJornada() {

        JFrame frame = new JFrame("Resultados Jornadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(525, 800);


        JPanel pPincipal = new JPanel();
        pPincipal.setBackground(Color.green);
        pPincipal.setBounds(0, 0, 800, 800);
        pPincipal.setLayout(null);
        JScrollPane scroll = new JScrollPane(pPincipal);
        JScrollPane s = new JScrollPane(pPincipal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        Border border = BorderFactory.createLineBorder(Color.PINK, 3);

        int initH_j = 300;
        int offset_j_y = 50;

        int initPos_p_h = 200;

        for (DatosJornadasXML.Jornada jornada : xmlParser.getDatosJornadasXML().getJornadas()) {
            //JORNADA

            int index_j = jornada.getNum_jornada() - 1;
            int n_partidos = jornada.getPartidos().size()-1;

            JPanel pJornada = new JPanel();
            if(index_j%2 == 0)
                pJornada.setBackground(Color.red);
            else
                pJornada.setBackground(Color.orange);

            pJornada.setBounds(25, 25 + (initH_j+offset_j_y)*index_j, 450, initH_j + (initPos_p_h*n_partidos));
            pJornada.setLayout(null);

            {
                JLabel jornada_num = new JLabel();
                jornada_num.setText("JORANADA " + (index_j+1));
                jornada_num.setHorizontalTextPosition(JLabel.CENTER);
                jornada_num.setForeground(Color.GREEN);
                jornada_num.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                jornada_num.setBackground(Color.black);
                jornada_num.setOpaque(true);
                jornada_num.setBorder(border);

                jornada_num.setVerticalAlignment(JLabel.CENTER);
                jornada_num.setHorizontalAlignment(JLabel.CENTER);

                jornada_num.setBounds(25, 25, 200, 50);

                pJornada.add(jornada_num);

                JLabel jornada_fecha = new JLabel();
                jornada_fecha.setText(jornada.getFecha_jornada());
                jornada_fecha.setHorizontalTextPosition(JLabel.CENTER);
                jornada_fecha.setForeground(Color.GREEN);
                jornada_fecha.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                jornada_fecha.setBackground(Color.black);
                jornada_fecha.setOpaque(true);
                jornada_fecha.setBorder(border);

                jornada_fecha.setVerticalAlignment(JLabel.CENTER);
                jornada_fecha.setHorizontalAlignment(JLabel.CENTER);

                jornada_fecha.setBounds(250, 25, 150, 50);

                pJornada.add(jornada_fecha);
            }

            for (DatosJornadasXML.Partido partido : jornada.getPartidos()) {
                // PARTIDO

                int index_p = partido.getCodPartido() - 1;

                JPanel pPartido = new JPanel();
                if(index_p%2 == 0)
                    pPartido.setBackground(Color.blue);
                else
                    pPartido.setBackground(Color.green);
                //pPartido.setBounds(25, 25+50, 400, 200);
                pPartido.setBounds(25, 75 + (initPos_p_h)*index_p, 400, initPos_p_h );
                pPartido.setLayout(null);

                {
                    JLabel partido_num = new JLabel();
                    partido_num.setText("PARTIDO " + (index_p + 1));
                    partido_num.setHorizontalTextPosition(JLabel.CENTER);
                    partido_num.setForeground(Color.GREEN);
                    partido_num.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    partido_num.setBackground(Color.black);
                    partido_num.setOpaque(true);
                    partido_num.setBorder(border);

                    partido_num.setVerticalAlignment(JLabel.CENTER);
                    partido_num.setHorizontalAlignment(JLabel.CENTER);

                    partido_num.setBounds(25, 25, 175, 50);

                    JLabel partido_h = new JLabel();
                    partido_h.setText(partido.getHoraPartido());
                    partido_h.setHorizontalTextPosition(JLabel.CENTER);
                    partido_h.setForeground(Color.GREEN);
                    partido_h.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    partido_h.setBackground(Color.black);
                    partido_h.setOpaque(true);
                    partido_h.setBorder(border);

                    partido_h.setVerticalAlignment(JLabel.CENTER);
                    partido_h.setHorizontalAlignment(JLabel.CENTER);

                    partido_h.setBounds(250, 25, 125, 50);


                    //equipos
                    ArrayList<String> equipos = partido.getEquipos();

                    JLabel equipo1 = new JLabel();
                    equipo1.setText(equipos.get(0));
                    equipo1.setHorizontalTextPosition(JLabel.CENTER);
                    equipo1.setForeground(Color.GREEN);
                    equipo1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

                    equipo1.setBackground(Color.black);
                    equipo1.setOpaque(true);
                    equipo1.setBorder(border);

                    equipo1.setVerticalAlignment(JLabel.CENTER);
                    equipo1.setHorizontalAlignment(JLabel.CENTER);

                    equipo1.setBounds(25, 75, 100, 100);

                    JLabel puntuacion = new JLabel();
                    puntuacion.setText(partido.getResultado());
                    puntuacion.setHorizontalTextPosition(JLabel.CENTER);
                    puntuacion.setForeground(Color.blue);
                    puntuacion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

                    puntuacion.setBackground(Color.black);
                    puntuacion.setOpaque(true);
                    puntuacion.setBorder(border);

                    puntuacion.setVerticalAlignment(JLabel.CENTER);
                    puntuacion.setHorizontalAlignment(JLabel.CENTER);

                    puntuacion.setBounds(150, 75, 100, 100);

                    JLabel equipo2 = new JLabel();
                    equipo2.setText(equipos.get(1));
                    equipo2.setHorizontalTextPosition(JLabel.CENTER);
                    equipo2.setForeground(Color.GREEN);
                    equipo2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

                    equipo2.setBackground(Color.black);
                    equipo2.setOpaque(true);
                    equipo2.setBorder(border);

                    equipo2.setVerticalAlignment(JLabel.CENTER);
                    equipo2.setHorizontalAlignment(JLabel.CENTER);

                    equipo2.setBounds(275, 75, 100, 100);


                    pPartido.add(partido_num);
                    pPartido.add(partido_h);
                    pPartido.add(equipo1);
                    pPartido.add(puntuacion);
                    pPartido.add(equipo2);

                }

                pJornada.add(pPartido);
            }


            pPincipal.add(pJornada);
        }

        frame.setVisible(true);
        frame.setContentPane(s);
    }

    public static void PanelClasificacion() {

     
    }

    public static String getResultadosJornadas() {
        PanelJornada();
        return xmlParser.getDatosJornadas();
    }


    public static String getClasificacion() {
        PanelClasificacion();
        return xmlParser.getClasificacion();
    }
}

