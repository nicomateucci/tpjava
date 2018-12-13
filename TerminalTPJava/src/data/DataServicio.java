package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import entities.Butaca;
import entities.Conductor;
import entities.Destino;
import entities.DestinoDirecto;
import entities.Micro;
import entities.MicroCama;
import entities.Servicio;
import entities.Usuario;
import util.AppDataException;

public class DataServicio {


	public double[] getRecaudacionPorMes() throws AppDataException, SQLException {

		double[] datos = new double[7];
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("call getRecaudacionPorMes()");
			// Devuelve "Total ingresos"
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()) {
				int mes = rs.getInt("Mes");
				System.out.println("Mes " + mes + " ingreso" + rs.getDouble("ingresos"));
				if(mes == 12) {
					datos[0] = rs.getDouble("ingresos"); 
				}else {
					datos[mes] = rs.getDouble("ingresos");
				}
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return datos;
	}
	public String[][] getDestinosByMesAno(int mes, int ano) throws AppDataException, SQLException{

		String[][] datos = new String[5][2];
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("call getDestinosByMesAno(?,?)");
			// Devuelve columnas "localidad" y "totalPasajes"
			System.out.println("El año es " + ano);
			stmt.setInt(1, 12);
			stmt.setInt(2, ano);
			rs=stmt.executeQuery();
			int rowcount = 0;
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.first(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			for(int i = 0; i < rowcount && i < 5; i++) {
				datos[i][0] = rs.getString("localidad");
				datos[i][1] = String.valueOf(rs.getInt("totalPasajes"));
				rs.next();
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return datos;

	}


	public void addPasajero(int idSer, String dni, String patente, int numButaca, int origen, int destino, double precio) throws AppDataException {

		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into PersonaServicioMicro (idServicio, dniPersona, patenteMicro, numButaca, origen, destino, precio) values (?,?,?,?,?,?,?)"
							);
			stmt.setInt(1, idSer);
			stmt.setString(2, dni);
			stmt.setString(3, patente);
			stmt.setInt(4, numButaca);
			stmt.setInt(5,origen);
			stmt.setInt(6, destino);
			stmt.setDouble(7, precio);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppDataException(e, "Error ocurrido en el metodo addPasajero(int idSer, String dni, String patente, int numButaca, int origen, int destino, double precio) en la clase DataServicio al conectar a la base de datos");
		}

	}
	public Servicio getServicioParaVenta(int id) throws Exception {
		Servicio ser = this.getById(id);
		//No seria necesario, ya que al momento de vender, el usuario ya definio cual es el recorrido.
		//Podria servir para calcular el precio a sea un destino normal o un destino directo.
		ser.addDestinos(this.getDestinos(ser.getIdServicio()));
		ser.addMicros(this.getMicros(ser));

		return ser;
	}
	public ArrayList<Micro> getMicros(Servicio s) throws Exception{
		ArrayList<Micro> mm=null;
		Micro m = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "select sm.patente, marca, \n" + 
					"porcentajeAumento, fechaUltimoControl, count(b.numButaca) as cantButacas\n" + 
					"from ServicioMicro sm\n" + 
					"inner join Micro m on sm.patente = m.patente\n" + 
					"inner join Butaca b on b.patenteMicro = m.patente\n" + 
					"where sm.idServicio = ?\n" + 
					"group by m.patente");
			stmt.setInt(1, s.getIdServicio());
			rs=stmt.executeQuery();
			mm = new ArrayList<Micro>();
			while(rs!=null && rs.next()){
				double pAumento = rs.getDouble("porcentajeAumento");
				if(pAumento != 0) {
					m = new MicroCama();
					((MicroCama) m).setAumento(pAumento);
				}
				else {
					m = new Micro();
				}	
				m.setMarca(rs.getString("marca"));
				m.setPatente(rs.getString("patente"));
				m.setFechaUltimoCtrl(rs.getDate("fechaUltimoControl"));
				m.setCantidadButacas(rs.getInt("cantButacas"));
				m.setConductores(this.getConductoresMicro(s, m));
				m.setButacas(this.getButacasMicro(s, m));
				mm.add(m);
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return mm;
	}
	public Butaca[] getButacasMicro(Servicio s, Micro m) throws Exception {

		Butaca[] pasajeros = new Butaca[m.getCantidadButacas()];
		for(int i = 0; i < pasajeros.length; i++) {
			pasajeros[i] = new Butaca(i + 1);
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select dniPersona, numButaca from PersonaServicioMicro where patenteMicro = ? and idServicio = ?");
			stmt.setString(1, m.getPatente());
			stmt.setInt(2, s.getIdServicio());
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				int num = rs.getInt("numButaca");
				Usuario u = new Usuario(rs.getString("dniPersona"));
				pasajeros[num - 1].setPasajero(u);
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return pasajeros;

	}
	private ArrayList<Conductor> getConductoresMicro(Servicio s, Micro m) throws AppDataException, SQLException {

		ArrayList<Conductor> cc=null;
		Conductor c = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select distinct p.dni, p.nombre, p.apellido, "
					+ "p.tipoDni, p.fechaNac, p.fechaInicio, p.contacto\n" + 
					"from ServicioMicro sm\n" + 
					"inner join MicroConductor mc on sm.patente = mc.patente\n" + 
					"inner join Persona p on mc.dniConductor = p.dni\n" + 
					"where sm.idServicio = ? and sm.patente = ?");
			stmt.setInt(1, s.getIdServicio());
			stmt.setString(2, m.getPatente());
			rs=stmt.executeQuery();
			cc = new ArrayList<Conductor>();
			while(rs!=null && rs.next()){
				c = new Conductor();
				c.setDni(rs.getString("dni"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setTipoDni(rs.getString("tipoDni") );
				c.setFechaNacimiento(rs.getDate("fechaNac"));
				c.setFechaInicio(rs.getDate("fechaInicio"));
				c.setContacto(rs.getString("contacto"));
				cc.add(c);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return cc;


	}
	public ArrayList<Destino> getDestinos(int idSer) throws AppDataException, SQLException{
		ArrayList<Destino> dd=null;
		Destino d = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select sd.idDestino, localidad, precio, ordenDestinos, porcentajeAumento"
					+ " from ServicioDestino sd"
					+ " inner join Destino d on d.idDestino = sd.idDestino"
					+ " where sd.idServicio = ?");
			stmt.setInt(1, idSer);
			rs=stmt.executeQuery();
			dd = new ArrayList<Destino>();
			while(rs!=null && rs.next()){
				double pAumento = rs.getDouble("porcentajeAumento");
				if(pAumento != 0) {
					d = new DestinoDirecto();
					((DestinoDirecto) d).setPorcentajeAumento(pAumento);
				} else {
					d = new Destino();
				}	
				d.setIdDestino(rs.getInt("idDestino"));
				d.setLocalidad(rs.getString("localidad"));
				d.setOrdenDestino(rs.getInt("ordenDestinos"));
				d.setPrecioDestino(rs.getDouble("precio"));
				dd.add(d);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return dd;
	}
	public void addAll(Servicio s) throws AppDataException, SQLException{

		s.setIdServicio(this.generateIdServicio());
		this.insert(s);
		this.insertAllDestinos(s.getDestinos(), s.getIdServicio());
		this.insertAllMicros(s.getMicros(), s.getIdServicio());
		this.insertAllConductores(s.getMicros(), s.getIdServicio());
	}
	public void insertAllConductores(ArrayList<Micro> mm, int idServicio) throws SQLException, AppDataException {

		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO MicroConductor (patente, dniConductor, idServicio) "
					+ "VALUES (?,?,?)");
			for (Micro m : mm) {
				for(Conductor c: m.getConductores()) {

					stmt.setString(1, m.getPatente());
					stmt.setString(2, c.getDni());
					stmt.setInt(3, idServicio);
					stmt.addBatch();
				}
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void insertAllMicros(ArrayList<Micro> mm, int idServicio) throws SQLException, AppDataException {

		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "INSERT INTO ServicioMicro (idServicio, patente) "
					+ "VALUES (?,?)");
			for (Micro m : mm) {
				stmt.setInt(1, idServicio);
				stmt.setString(2, m.getPatente());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public int generateIdServicio() throws AppDataException, SQLException {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idServicio) as id from Servicio");
			rs = stmt.executeQuery();
			rs.first();
			return (rs.getInt("id") + 1);
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	private static final String SQL_INSERT = "INSERT INTO ServicioDestino (idServicio, idDestino, precio, ordenDestinos) VALUES (?,?, ?, ?)";
	public void insertAllDestinos(ArrayList<Destino> dd, int idServicio) throws SQLException, AppDataException {

		int i = 0;
		PreparedStatement stmt = null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(SQL_INSERT);
			for (Destino d : dd) {
				i++;
				stmt.setInt(1, idServicio);
				stmt.setInt(2, d.getIdDestino());
				stmt.setDouble(3, d.getPrecioDestino());
				stmt.setInt(4, i);
				stmt.addBatch();
			}
			stmt.executeBatch();
		} finally{	
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public ArrayList<Servicio> getDetalles() throws AppDataException, SQLException {

		ArrayList<Servicio> uu= new ArrayList<Servicio>();
		PreparedStatement stmt=null;
		ResultSet rs=null;	
		try {

			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from getDetallesServicios");
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()){
				Micro m = new Micro();
				Conductor c = new Conductor();
				Servicio s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("HoraServicio"));
				s.setRecorrido(rs.getString("Recorrido"));
				//m.setMarca(rs.getString("marca"));
				//m.setPatente(rs.getString("patente"));				
				//c.setNombre(rs.getString("nombresApellidos"));
				//m.addConductor(c);
				//s.addMicro(m);
				uu.add(s);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return uu;
	}
	public ArrayList<Servicio> getAllByDestinos(Destino origen, Destino destino) throws AppDataException, SQLException {

		ArrayList<Servicio> ss=null;
		Servicio s = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("call getServiciosByDestinos(?,?)");
			stmt.setInt(1, origen.getIdDestino());
			stmt.setInt(2, destino.getIdDestino());
			rs=stmt.executeQuery();
			ss = new ArrayList<Servicio>();
			int i = 0;
			while(rs!=null && rs.next()){
				i++;
				s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("horaServicio"));
				ss.add(s);
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return ss;
	}
	public Servicio getById(int idServicio) throws SQLException, AppDataException, NoServiceException{

		Servicio s=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from Servicio where idServicio=?");
			stmt.setInt(1, idServicio);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){

				s = new Servicio();

				s.setIdServicio(rs.getInt("idServicio"));
				s.setFechaServicio(rs.getDate("fechaServicio"));
				s.setHoraServicio(rs.getString("horaServicio"));
				s.addDestinos(this.getDestinos(s.getIdServicio()));
				s.addMicros(this.getMicros(s));
			}
			if(!rs.first()) {
				throw new NoServiceException("No se ha encontrado el servicio indicado");
			}

		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return s;
	}
	public void insert(Servicio s) throws AppDataException{
		PreparedStatement stmt=null;
		try {
			/* Lo borre, porque cuendo tengo que agregar las Foreign Keys a las tabals ServicioDestino, ServicioMicro
			 * ya tengo que conocer cual es el id de servicio que agregue.
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select max(idServicio) as id from Servicio");
			rs = stmt.executeQuery();
			rs.first();
			int idSer = ((rs.getInt("id")) + 1);
			stmt.close();
			stmt = null;
			rs.close();
			 */
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
							"insert into Servicio(idServicio, fechaServicio, horaServicio) values (?,?,?)"
							);
			stmt.setInt(1, s.getIdServicio());
			stmt.setDate(2, s.getFechaServicio());
			stmt.setString(3, s.getHoraServicio());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppDataException(e, "Error ocurrido en el metodo insert(Serivicio s) en la calse DataServicio al conectar a la base de datos");
		}
	}
	public boolean getTieneRefuerzo(Servicio ser) throws AppDataException, SQLException {

		boolean rta = false;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select getTieneRefuerzo(?) as ref");
			stmt.setInt(1, ser.getIdServicio());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				//rta = rs.getBoolean(1);			ANDA BIEN
				rta = rs.getBoolean("ref");
			}
		} catch (SQLException e) {
			throw new AppDataException(e, "Error al conectar a la base da datos");
		} finally{	
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return rta;
	}
	public void update(Servicio elServicio) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update Servicio set "
							+ "fechaServicio=?, horaServicio=? where idServicio=?");
			stmt.setDate(1, elServicio.getFechaServicio());
			stmt.setString(2, elServicio.getHoraServicio());
			stmt.setInt(3,elServicio.getIdServicio());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(stmt != null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}


	public void delete(Servicio elServicio) throws Exception{
		PreparedStatement stmt = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from Servicio WHERE idServicio=?"); 
			stmt.setInt(1,elServicio.getIdServicio());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(stmt != null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

}
