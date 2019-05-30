package br.com.darioprod.ecommerce.controller;

import java.io.File;
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

import br.com.darioprod.ecommerce.dao.ProductDAO;
import br.com.darioprod.ecommerce.model.Product;

@WebServlet("/editarProduto")
public class UpdateProduct extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Product prod = new Product();
		if(ServletFileUpload.isMultipartContent(req)){
			try {				
				Map<String,List<FileItem>> multiparts =	new ServletFileUpload(new DiskFileItemFactory()).parseParameterMap(req);
				
				for(List<FileItem> itens : multiparts.values()){
					
					for(FileItem item : itens){
						if(item.isFormField()){
							if(item.getFieldName().equals("nome")) {
								prod.setNameProduct(item.getString());
							}else if(item.getFieldName().equals("idProduct")){
								prod.setIdProduct(Integer.parseInt(item.getString()));
							}else if(item.getFieldName().equals("valor")){
								prod.setPriceProduct(Double.parseDouble(item.getString()));
							}else if(item.getFieldName().equals("descricaoProduto")){
								prod.setDescribeProduct(item.getString());
							}
						}else{									
							prod.setPhotoProduct("images"+File.separator+item.getName());
							String path = getServletContext().getRealPath("images")+File.separator+item.getName();
							item.write(new File(path));							
							System.out.println(path);
							
						}
					}
					
				}
			
				ProductDAO pDao = new ProductDAO();
				if(pDao.alterar(prod))
					System.out.println("FOI");
				
				resp.sendRedirect("areaADM.jsp");
				
			}catch(Exception e){
				e.printStackTrace();
				req.getRequestDispatcher("areaADM.jsp").forward(req, resp);
			}
		}
	}
	

}
