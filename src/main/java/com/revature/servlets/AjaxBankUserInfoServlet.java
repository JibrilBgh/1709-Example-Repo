package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.dto.BankUserDTO;
import com.revature.services.AppService;

/**
 * Servlet implementation class AjaxBankUserInfoServlet
 */
@WebServlet("/URL_is_ajaxGetBankUserInfo")
public class AjaxBankUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBankUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxBankUserServlet -Get");
		
		//Client wants the BankUser Object that at this point should be stored in the session
		HttpSession session = request.getSession();
		
		BankUser clientUser = (BankUser) session.getAttribute("user");
		
		
		//basic null check
		if(clientUser != null) {
			BankAccount account = new AppService().getBankAccountByUsername(clientUser);
			AppService service = new AppService();
			
			//another basic null check
			if(account != null) {
				/*
				 * 		Convert Bean into JSON
				 * 
				 * 	DTO: Data Transfer Object Design for moving objects
				 */
				System.out.println("---------------------------Converting BAnkUser & Account to DTO");
				BankUserDTO bankUserDTO = service.convertToBankUserDTO(clientUser, account);
				
				
				System.out.println("---------------------------JSON Mapping");
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(bankUserDTO);
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				
				out.write(json);
			} else {
				response.setStatus(418);
			}
		}	
	}
}
