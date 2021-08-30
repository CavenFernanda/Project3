package Service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.UserController;
import Entity.User;

/**
 * @email Caven Fernanda
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1;
    private UserController userController;

    public void init() {
    	userController = new UserController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("registration.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone_no = request.getParameter("phone_no");
        String email_address = request.getParameter("email_address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(dob);
        user.setPassword(address);
        user.setPassword(phone_no);
        user.setPassword(email_address);
        user.setPassword(username);
        user.setPassword(password);

        userController.createUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("successful.jsp");
        dispatcher.forward(request, response);
    }
}