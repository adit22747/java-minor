package com.cybage.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.servlet.annotation.MultipartConfig;

import com.cybage.dao.AdminDaoImplements;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;
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
				for (Course course : courses) {
					if (course.getCourse_image() != null) {
						byte[] bytes = IOUtils.toByteArray(course.getCourse_image());
						String encode = Base64.getEncoder().encodeToString(bytes);

						course.setEncode(encode);
						
					}

				}
				request.setAttribute("courses", courses);
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
			/*
			 * if (filePart != null) {
			 * 
			 * // Prints out some information // for debugging
			 * System.out.println(filePart.getName());
			 * System.out.println(filePart.getSize());
			 * System.out.println(filePart.getContentType());
			 * 
			 * // Obtains input stream of the upload file inputStream =
			 * filePart.getInputStream(); }
			 */
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
		
		
		
		
		if (request.getPathInfo().equals("/add_video")) {
			
			System.out.println("add video method");
			boolean isMultipart;
			String filePath,path = null;
			int maxfilesize = 100000 * 1024;
			int maxMemSize = 4 * 1024;
			File file;
			filePath = getServletContext().getInitParameter("file-upload");

			isMultipart = ServletFileUpload.isMultipartContent(request);
			PrintWriter out = response.getWriter();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxfilesize);
			
			
			try {
				// Parse the request to get file items.
				List<?> fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator<?> i = fileItems.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						String fileName = fi.getName();
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fi.write(file);
						
						path = filePath + fileName;
						System.out.println(path);
						
					}
				}
				

			} catch (Exception ex) {
				System.out.println(ex);
			}
			
			
			String video_name = request.getParameter("vname");
			System.out.println(video_name);
			String video_duration = request.getParameter("duration");
			Video video = new Video(video_name, video_duration, path);
			System.out.println(video_duration);
			
			try {
				int addCount = aservice.addVideo(video);
				if (addCount > 0) {
					System.out.println("video is added");
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