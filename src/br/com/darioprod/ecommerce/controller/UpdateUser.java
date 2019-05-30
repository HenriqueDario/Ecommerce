package br.com.darioprod.ecommerce.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import br.com.darioprod.ecommerce.dao.UserDAO;
import br.com.darioprod.ecommerce.model.User;

@WebServlet("/editarUsuario")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setCharacterEncoding("UTF-8");
		try {				
			Map<String,List<FileItem>> multiparts =	new ServletFileUpload(new DiskFileItemFactory()).parseParameterMap(request);
			
			for(List<FileItem> itens : multiparts.values()){					
				for(FileItem item : itens){
					if(item.isFormField()){
						if(item.getFieldName().equals("levelUser")) {
							user.setLevelUser(Integer.parseInt(item.getString()));
						}else if(item.getFieldName().equals("idUser")){
							user.setIdUser(Integer.parseInt(item.getString()));
						}else if(item.getFieldName().equals("txtNome")){
							user.setNameUser(item.getString());
						}else if(item.getFieldName().equals("txtCpf")){
							user.setCpfUser(item.getString());
						}else if(item.getFieldName().equals("txtEmail")){
							user.setEmailUser(item.getString());
						}else if(item.getFieldName().equals("senha-cliente")){
							user.setPasswordUser(item.getString());
						}
					}/*else{					
						user.setPhotoUser("images"+File.separator+item.getName());
						String path = getServletContext().getRealPath("images")+File.separator+item.getName();
						item.write(new File(path));							
						System.out.println(path);
						
					}*/
				}
				
			}
			
			User atual = (User) request.getSession().getAttribute("User");
		
			UserDAO uDao = new UserDAO();
			uDao.alterar(user);
			
			if(atual.getId() == user.getId()) {
				request.removeAttribute("User");
				request.setAttribute("User", user);
			}
			response.sendRedirect("index.jsp");
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.getRequestDispatcher("produtos.jsp").forward(request, response);
		 }
	}
}


