package arg.report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arg.dao.LaunchDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class launchReport
 */
@WebServlet("/launchReport")
public class launchReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LaunchDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public launchReport() {
        super();
        // TODO Auto-generated constructor stub
        dao = new LaunchDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reportPath = "C:\\Users\\Alejandro RG\\eclipse-workspace\\ARG_U3\\src\\arg\\report\\launchReport.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			//data.put("logo_utng", this.getServletContext().getRealPath("/")+"images/logo_utng.jpg");
			data.put("alets", this.getServletContext().getRealPath("/")+"images/alets.jpg");
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","utng","mexico");
			
			
			JasperPrint print = JasperFillManager.fillReport(report, data, connection);
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch(JRException e) {
			
		} catch(ClassNotFoundException e) {
			
		} catch(SQLException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
