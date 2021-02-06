package com.cybage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet .annotation.MultipartConfig; 

import com.cybage.dao.AdminDaoImplements;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.service.AdminServiceImplements;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController/*")
@MultipartConfig(maxFileSize = 16177215) 
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDaoImplements adao = new AdminDaoImplements();
	private AdminServiceImplements aservice = new AdminServiceImplements(adao);

	/**
	 * Default constructor.
	 */
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		if (request.getPathInfo().equals("/fetch_course")) {
			response.getWriter().append("Fetching data");

			try {
				List<Course> courses = aservice.getCourse();
				List<Category> categories = aservice.getCategory();
				request.setAttribute("courses", courses);
				request.setAttribute("categories", categories);
				request.getRequestDispatcher("/admin/Course.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getPathInfo().equals("/delete_course")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				int deletecount = aservice.deleteCourse(id);
				if (deletecount > 0) {
					response.sendRedirect("fetch_course");
				} else {
					pw.print("not able to delete");
					response.sendRedirect("fetch_course");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getPathInfo().equals("/add_course")) {
			System.out.println("add method");
			String course_name = request.getParameter("cname");
			String course_desc = request.getParameter("cdesc");
			InputStream inputStream = null;
			Part filePart = request.getPart("cimage");
			/*if (filePart != null) {

				// Prints out some information
				// for debugging
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// Obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}*/
			inputStream = filePart.getInputStream();
			Course course = new Course(course_name, course_desc, inputStream);
			try {
				int addCount = aservice.addCourse(course);
				if (addCount > 0) {
					System.out.println("this is added");
					response.sendRedirect("fetch_course");
				}
//				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}