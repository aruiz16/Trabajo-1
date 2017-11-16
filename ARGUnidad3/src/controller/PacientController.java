package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacientDAO;
import dao.PacientDAOImpl;
import model.Pacient;



/**
 * Servlet implementation class StudentController
 */
@WebServlet("/PacientController")
public class PacientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pacient pacient;
	private List<Pacient> pacients;
	private PacientDAOImpl pacientDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacientController() {
        super();
        pacient = new Pacient();
        pacients = new ArrayList<Pacient>();
        pacientDAO = new PacientDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if (request.getParameter("btn_save")!= null) {
			
			pacient.setNombre(request.getParameter("nombre"));
			pacient.setApellidos(request.getParameter("apellidos"));
			pacient.setSexo(request.getParameter("sexo"));
			pacient.setRaza(request.getParameter("raza"));
				
				
			if(pacient.getId()==0) {
				pacientDAO.createPacient(pacient);
				}else {
				pacientDAO.updatePacient(pacient);
			}
			
			pacients = pacientDAO.readAllPacients();
			request.setAttribute("pacients", pacients);
			request.getRequestDispatcher("pacient_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			pacient = new Pacient();
			request.getRequestDispatcher("pacient_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				pacient = pacientDAO.readPacient(id);
				
			}catch (Exception e) {
				
				pacient = new Pacient();
			}
			request.setAttribute("pacient", pacient);
			
			request.getRequestDispatcher("pacient_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			pacientDAO.deletePacient(id);
			pacients = pacientDAO.readAllPacients();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("pacients", pacients);
			request.getRequestDispatcher("pacient_list.jsp").forward(request, response);
		}else {
			pacients = pacientDAO.readAllPacients();
			request.setAttribute("pacients", pacients);
			request.getRequestDispatcher("pacient_list.jsp").forward(request, response);
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
