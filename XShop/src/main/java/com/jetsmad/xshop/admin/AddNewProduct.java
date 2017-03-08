/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.admin;

import com.jetsmad.xshop.util.beans.Product;
import com.jetsmad.xshop.util.database.DBController;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author markoiti
 */
@WebServlet(name = "AddNewProduct", urlPatterns = {"/AddNewProduct"})
@MultipartConfig
public class AddNewProduct extends HttpServlet {

    private static final String SAVE_DIR = "resources/images";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("admin_name") != null) {
            Product product = new Product();
            DBController dbController = new DBController();
            String productId = UUID.randomUUID().toString().substring(10);
            product.setId(productId);

//        product.setName(request.getParameter("name"));
//        product.setPrice(Float.parseFloat(request.getParameter("price")));
//        product.setStock(Integer.parseInt(request.getParameter("stock")));
//        product.setCategory(request.getParameter("category"));
//        product.setDesc(request.getParameter("desc"));
            product.setActive(true);

            // redirect to products
            try {
                String path = request.getServletContext().getRealPath("");

                // constructs path of the directory to save uploaded file
                String savePath = path + File.separator + SAVE_DIR;

                // creates the save directory if it does not exists
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }

                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField()) {
                        //processFormField(item);
//                    String name = item.getFieldName();
//                    String value = item.getString();
//                    System.out.println(name + "---" + value);
                        if (item.getFieldName().equals("productName")) {
                            product.setName(item.getString());
                            System.out.println(item.getFieldName() + " : " + item.getString());
                        } else if (item.getFieldName().equals("productDescription")) {
                            product.setDesc(item.getString());
                            System.out.println(item.getFieldName() + " : " + item.getString());
                        } else if (item.getFieldName().equals("productPrice")) {
                            product.setPrice(Float.parseFloat(item.getString()));
                            System.out.println(item.getFieldName() + " : " + item.getString());
                        } else if (item.getFieldName().equals("productStock")) {
                            product.setStock(Integer.parseInt(item.getString()));
                            System.out.println(item.getFieldName() + " : " + item.getString());
                        } else if (item.getFieldName().equals("productCategory")) {
                            product.setCategory(item.getString());
                            System.out.println(item.getFieldName() + " : " + item.getString());
                        }
                    } else {
                        // processUploadedFile(item);
                        if (!item.isFormField()) {
                            String extention = item.getName().substring(item.getName().lastIndexOf("."),item.getName().length());
                            System.out.println("Image name : " + item.getName());
                            product.setImg(productId+extention);
                            item.write(new File(path + "/resources/images/" + productId+extention));

                        }
                    }
                }
                System.out.println(product.getName() + " : " + product.getPrice());
                dbController.insertProduct(product);
                request.getRequestDispatcher("GetAllProducts").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            request.setAttribute("error", "Admin not logged in");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            System.out.println(s);
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
