package arg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arg.dao.LaunchDAO;
import arg.dao.LaunchDAOImpl;
import arg.model.Launch;

/**
 * Servlet implementation class LaunchController
 */
@WebServlet("/LaunchController")
public class LaunchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Launch launch;
	private List<Launch> launches;
	private LaunchDAOImpl launchDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaunchController() {
        super();
        launch = new Launch();
        launches = new ArrayList<Launch>();
        launchDAO = new LaunchDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("btn_save")!= null) {
			launch.setName(request.getParameter("name"));
			launch.setDestination(request.getParameter("destination"));
			try {
			launch.setPassengers(Integer.parseInt(request.getParameter("passengers")));
			} catch (NumberFormatException e) {
				launch.setPassengers(10);
			}
				
				
			if(launch.getId()==0L) {
				launchDAO.createLaunch(launch);
				}else {
				launchDAO.updateLaunch(launch);
			}
			
			launches = launchDAO.readAllLaunches();
			request.setAttribute("launches", launches);
			request.getRequestDispatcher("launch_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			launch = new Launch();
			request.getRequestDispatcher("launch_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				launch = launchDAO.readLaunch(id);
				
			}catch (Exception e) {
				
				launch = new Launch();
			}
			request.setAttribute("launch", launch);
			
			request.getRequestDispatcher("launch_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			launchDAO.deleteLaunch(id);
			launches = launchDAO.readAllLaunches();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("launches", launches);
			request.getRequestDispatcher("launch_list.jsp").forward(request, response);
		}else {
			launches = launchDAO.readAllLaunches();
			request.setAttribute("launches", launches);
			request.getRequestDispatcher("launch_list.jsp").forward(request, response);
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
