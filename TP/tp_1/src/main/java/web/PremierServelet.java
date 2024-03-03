package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class PremierServelet
 */
@WebServlet("/bonjour")
public class PremierServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PremierServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        double poids = Double.parseDouble(poidsStr);
        double taille = Double.parseDouble(tailleStr);

        Imc imcCalculator = new Imc(taille, poids);
        double imc = imcCalculator.calcul();
        
        Cookie poidsCookie = new Cookie("poids", poidsStr);
        Cookie tailleCookie = new Cookie("taille", tailleStr);
        Cookie imcCookie = new Cookie("imc", String.valueOf(imc));

        response.addCookie(poidsCookie);
        response.addCookie(tailleCookie);
        response.addCookie(imcCookie);

        response.setContentType("text/html");
        response.getWriter().append("<!DOCTYPE html>"
                +"<html>"
                +"<head>"
               +"<title>Résultat de l'IMC</title>"
                +"</head>"
                +"<body>"
                +"<h3>Votre IMC est : " + imc + "</h3>"
                +"</body>"
                +"</html>");   
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
/*****    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");
        
        double poids = Double.parseDouble(poidsStr);
        double taille = Double.parseDouble(tailleStr);


        Imc imcCalculator = new Imc(taille, poids);
        /***  utiliser la methode dans la classe Imc **/
   /**     double imc = imcCalculator.calcul();

     
           response.getWriter().append("<!DOCTYPE html>"
                +"<html>"
                +"<head>"
               +"<title>Résultat de l'IMC</title>"
                +"</head>"
                +"<body>"
                +"<h3>Votre IMC est : " + imc + "</h3>"
                +"</body>"
                +"</html>");   
        } 
    
    **/
    /*********************Exercice 1*************/
    
/**	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<!DOCTYPE html>"
				+"<html>"
				+"<head>"
				+"<title>Example</title>"
				+"</head>"
				+"<body >"
				+"<h1> C'est ma première servlet !</h1>"
				+"</body>"
				+"</html>" );
	
		}
		
***/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
